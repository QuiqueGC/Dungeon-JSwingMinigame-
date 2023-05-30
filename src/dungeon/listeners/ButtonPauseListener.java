package dungeon.listeners;
import classes.Labels;
import classes.characters.Character;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


/**
 * listener que extiende MouseAdapter para el botón de pausa
 */
public class ButtonPauseListener extends MouseAdapter {

    ArrayList<Character> rankingList = new ArrayList<>();
    Timer[] timers = new Timer [12];


    JPanel panel;


    //pasamos los timer por parámetros para poder usar los del Main
    public ButtonPauseListener(Timer[] timers, JPanel panel) {


        for (int i = 0; i < 10; i++) {

            this.timers[i] = timers[i];
        }

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

            for (int i = 0; i < 10; i++) {

                timers[i].stop();
            }

            //FilesRW.rankingListCreator(rankingList);

           // JDialog rankingPlayer = new RankingPlayer();
           // rankingPlayer.setVisible(true);

            Labels.buttonPause.setText("Reanudar");

        } else {

            for (int i = 0; i < 10; i++) {

                timers[i].start();
            }

            Labels.buttonPause.setText("Pausa");

            //con el requestFocus recuperas el foco en el objeto al que se lo aplicas
            panel.requestFocus();

        }

    }

}
