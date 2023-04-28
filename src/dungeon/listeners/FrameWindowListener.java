package dungeon.listeners;
import classes.*;
import dungeon.Dungeon;
import dungeon.StartingGame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * listener que extiende WindowAdapter
 */
public class FrameWindowListener extends WindowAdapter{
JFrame frame;


    public FrameWindowListener(JFrame frame) {
        this.frame = frame;
    }


    /**
     * evento con la apertura de ventana
     * @param e the event to be processed
     */
    @Override
    public void windowOpened(WindowEvent e) {
        super.windowOpened(e);


        frame.setVisible(false);
        //dentro de este JDialog se decide el personaje que llevará el jugador
        JDialog starting = new StartingGame();
        starting.setVisible(true);
        frame.setVisible(true);

        Labels.showLabelHearts(Dungeon.character.getLives());





        //establecemos el panel de stats como visible
        Panels.panelStats.setVisible(true);

        Panels.panelGaming.setVisible(true);
    }


    /**
     * evento para el cierre de la ventana
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);

        int confirmado = JOptionPane.showConfirmDialog(null,
                "Seguro del cierre?",
                "mensaje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmado == JOptionPane.YES_OPTION){

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }else{

            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }

    }


}
