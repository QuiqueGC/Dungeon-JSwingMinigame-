package dungeon.listeners;
import classes.Labels;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * listener que extiende MouseAdapter para el botón de pausa
 */
public class ButtonPauseListener extends MouseAdapter {

    Timer timer2;
    Timer timer3;
    Timer timer4;
    Timer timer5;
    Timer timer6;
    Timer timer7;
    Timer timer8;
    Timer timer9;
    Timer timer10;
    Timer timer11;

    Timer timerDragon;
    //pongo panel pero, en principio, es el panelMain (al no ser public tengo que pasarlo por parámetros)
    JPanel panel;

    //pasamos los timer por parámetros para poder usar los del Main
    public ButtonPauseListener(Timer timer2, Timer timer3, Timer timer4, Timer timer5,
                               Timer timer6, Timer timer7, Timer timer8, Timer timer9,Timer timer10,Timer timer11, Timer timerDragon, JPanel panel) {

        this.timer2 = timer2;
        this.timer3 = timer3;
        this.timer4 = timer4;
        this.timer5 = timer5;
        this.timer6 = timer6;
        this.timer7 = timer7;
        this.timer8 = timer8;
        this.timer9 = timer9;
        this.timer10 = timer10;
        this.timer11 = timer11;
        this.timerDragon = timerDragon;

        this.panel = panel;


    }

    /**
     * lo que ocurre al clicar el botón (pausa/reanudar)
     * @param e the event to be processed
     */
    //creación de evento de ratón
    @Override
    public void mouseClicked(MouseEvent e) {
        //  super.mouseClicked(e);
        if (Labels.buttonPause.getText().equals("Pausa")) {
            timer2.stop();
            timer3.stop();
            timer4.stop();
            timer5.stop();
            timer6.stop();
            timer7.stop();
            timer8.stop();
            timer9.stop();
            timer10.stop();
            timer11.stop();
            timerDragon.stop();
            Labels.buttonPause.setText("Reanudar");
        } else {
            timer2.start();
            timer3.start();
            timer4.start();
            timer5.start();
            timer6.start();
            timer7.start();
            timer8.start();
            timer9.start();
            timer10.start();
            timer11.start();
            timerDragon.start();
            Labels.buttonPause.setText("Pausa");
            //con el requestFocus recuperas el foco en el objeto al que se lo aplicas
            panel.requestFocus();

        }

    }
}
