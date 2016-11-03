/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiorelogio;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import radiorelogio.Jlayer;
import radiorelogio.Horario;

/**
 *
 * @author Jefferson
 */
public class InterfaceRR extends javax.swing.JFrame {

    public static DefaultTableModel modelo = new DefaultTableModel();
    public static Jlayer musicas;
    public static boolean tocando, parar;

    /**
     * Creates new form InterfaceRR
     */
    public InterfaceRR() {
        initComponents();
        setLocationRelativeTo(this);
        init();

    }

    private void init() {
        // Iniciando o relógio
        Horario relogio = new Horario();
        Thread tst = new Thread(relogio);
        tst.start();

        // Definindo o modelo da tabela
        jTable1.setModel(modelo);
        modelo.addColumn("Título");
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);

        // Criando o objeto que irá controlar as musicas
        musicas = new Jlayer();

        // Definindo a flag de controle de tocando a playlist
        tocando = false;
        parar = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jRR = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnTocar = new javax.swing.JButton();
        BtnAbrir = new javax.swing.JButton();
        BtnRemover = new javax.swing.JButton();
        BtnLimpar = new javax.swing.JButton();
        jTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRR.setFont(new java.awt.Font("Berlin Sans FB", 0, 52)); // NOI18N
        jRR.setForeground(new java.awt.Color(102, 102, 102));
        jRR.setText("00:00:00");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Música"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnTocar.setText("Tocar");
        BtnTocar.setToolTipText("");
        BtnTocar.setBorderPainted(false);
        BtnTocar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnTocarMouseClicked(evt);
            }
        });
        BtnTocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTocarActionPerformed(evt);
            }
        });

        BtnAbrir.setText("Selecionar Músicas");
        BtnAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAbrirMouseClicked(evt);
            }
        });
        BtnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbrirActionPerformed(evt);
            }
        });

        BtnRemover.setText("Remover Música");
        BtnRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRemoverMouseClicked(evt);
            }
        });
        BtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemoverActionPerformed(evt);
            }
        });

        BtnLimpar.setText("Limpar Lista");
        BtnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnLimparMouseClicked(evt);
            }
        });
        BtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparActionPerformed(evt);
            }
        });

        jTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAbrir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnTocar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addComponent(BtnLimpar)
                        .addGap(143, 143, 143)
                        .addComponent(BtnRemover))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jRR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jRR, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAbrir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLimpar)
                    .addComponent(BtnRemover)
                    .addComponent(BtnTocar))
                .addContainerGap())
        );

        BtnTocar.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (BtnTocar.isEnabled()) {
            BtnTocar.setText("Tocar");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void BtnTocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTocarActionPerformed
    }//GEN-LAST:event_BtnTocarActionPerformed

    private void BtnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbrirActionPerformed
    }//GEN-LAST:event_BtnAbrirActionPerformed

    private void BtnAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAbrirMouseClicked
        try {
            musicas.OpenFile();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceRR.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (BtnTocar.isEnabled()) {
            BtnTocar.setText("Tocar");
        }
    }//GEN-LAST:event_BtnAbrirMouseClicked

    private void BtnRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRemoverMouseClicked
        int[] linha = jTable1.getSelectedRows();

        if (linha.length > 0) {
            for (int i = (linha.length - 1); i >= 0; i--) {
                InterfaceRR.modelo.removeRow(linha[i]);
                musicas.removerMusica(linha[i]);
            }
        }
        if (BtnTocar.isEnabled()) {
            BtnTocar.setText("Tocar");
        }
    }//GEN-LAST:event_BtnRemoverMouseClicked

    private void BtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRemoverActionPerformed

    private void BtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparActionPerformed

    }//GEN-LAST:event_BtnLimparActionPerformed
    private void BtnLimparMouseClicked(java.awt.event.MouseEvent evt) {
        modelo.setNumRows(0);
        musicas.limparLista();
        if (BtnTocar.isEnabled()) {
            BtnTocar.setText("Tocar");
        }
    }
    private void BtnTocarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTocarMouseClicked
        musicas.play(jTable1.getSelectedRow());
        if (BtnTocar.isEnabled()) {
            BtnTocar.setText("Parar");
        }

    }//GEN-LAST:event_BtnTocarMouseClicked

    private void jTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceRR.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceRR.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceRR.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceRR.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InterfaceRR().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAbrir;
    private javax.swing.JButton BtnLimpar;
    private javax.swing.JButton BtnRemover;
    public javax.swing.JButton BtnTocar;
    private javax.swing.JFileChooser jFileChooser1;
    public static javax.swing.JLabel jRR;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTxt;
    // End of variables declaration//GEN-END:variables

}