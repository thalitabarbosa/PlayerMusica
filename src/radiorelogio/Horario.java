/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiorelogio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1502549
 */
public class Horario implements Runnable {
    @Override
    public void run() {
        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Calendar calendar = new GregorianCalendar();
            try {
                String a = sdf.format(calendar.getTime());
                InterfaceRR.jRR.setText(a);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Horario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
