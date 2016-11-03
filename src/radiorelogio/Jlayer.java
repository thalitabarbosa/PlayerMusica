/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiorelogio;

/**
 *
 * @author a1502549
 */
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.player.Player;
import radiorelogio.Musica;
import radiorelogio.InterfaceRR;
import static radiorelogio.InterfaceRR.modelo;
import static radiorelogio.InterfaceRR.musicas;

public class Jlayer {

    private ArrayList<Musica> listaMusicas;
    private Player player;
    private int index;

    public void OpenFile() throws IOException {
        JFileChooser fileWindow = new javax.swing.JFileChooser();
        fileWindow.setFileFilter(new FileNameExtensionFilter("Arquivos MP3", "mp3"));
        fileWindow.setMultiSelectionEnabled(true);

        int returnFileVal = fileWindow.showOpenDialog(fileWindow);

        if (returnFileVal == JFileChooser.APPROVE_OPTION) {

            File[] files = fileWindow.getSelectedFiles();

            for (File file : files) {
                Musica musica = new Musica();
                try {
                    Mp3File mp3file = new Mp3File(file.getAbsolutePath());
                    
                    musica.setEnderecoMusica(file.getAbsolutePath());
                    musica.setNomeMusica(file.getName());
                    listaMusicas.add(musica);
                    InterfaceRR.modelo.addRow(new Object[]{musica.getNomeMusica()});
                } catch (UnsupportedTagException | InvalidDataException ex) {
                    Logger.getLogger(Jlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Jlayer() {
        listaMusicas = new ArrayList<>();
        index = -1;
    }

    public void limparLista() {
        listaMusicas = null;
    }

    public void removerMusica(int i) {
        listaMusicas.remove(i);
        if (i == index) {
            InterfaceRR.jTxt.setText("");
            this.play(i++);
        }
    }

//    public void stop() {
//        if (InterfaceRR.tocando) {
//            player.close();
//            InterfaceRR.parar = true;
//            InterfaceRR.tocando = false;
//        }
//    }

    public Musica getMusica(int i) {
        return listaMusicas.get(i);
    }

    private void iniciarThread() {
        Thread TMusica = new Thread(new Runnable() {
            @Override
            public void run() {
                tocar();
            }
        });

        TMusica.start();
    }

    private void tocar() {
        InterfaceRR.tocando = true;
        if (!InterfaceRR.parar) {
            if (index < InterfaceRR.modelo.getRowCount()) {
                Musica music = InterfaceRR.musicas.getMusica(index);

                if (index > -1) {
                    InterfaceRR.jTxt.setText(musicas.getMusica(index).getNomeMusica());
                } else {
                    InterfaceRR.jTxt.setText(musicas.getMusica(0).getNomeMusica());
                }

                try {
                    FileInputStream stream = new FileInputStream(new File(music.getEnderecoMusica()));
                    BufferedInputStream buffer = new BufferedInputStream(stream);
                    player = new Player(buffer);
                    player.play();
                } catch (Exception ex) {
                }
            }
        }
    }

    public void play(int i) {
        if (!InterfaceRR.tocando) {
            InterfaceRR.parar = false;

            if (i == -1) {
                i = 0;
            }

            if (index != i) {
                if (modelo.getRowCount() > 0) {
                    index = i;
                    iniciarThread();
                } else {
                    JOptionPane.showMessageDialog(null, "A lista de música esta vazia. Inclua pelo menos uma música");
                }
            }
        } else {
            InterfaceRR.tocando = false;
            player.close();
          //play(i);
        }
    }

}
