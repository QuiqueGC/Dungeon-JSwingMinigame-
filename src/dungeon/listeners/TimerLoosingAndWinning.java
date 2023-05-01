package dungeon.listeners;

import classes.Labels;
import dungeon.Dungeon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * chequea las condiciones de victoria/derrota mediante un timer que implementa ActionListener
 */
public class TimerLoosingAndWinning implements ActionListener {

    JFrame frame;

    JPanel panelMain;


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

    public TimerLoosingAndWinning(JFrame frame, JPanel panelMain, Timer timer2, Timer timer3, Timer timer4, Timer timer5,
                                  Timer timer6, Timer timer7, Timer timer8, Timer timer9,Timer timer10,Timer timer11, Timer timerDragon) {
        this.frame = frame;
        this.panelMain = panelMain;
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
    }

    /**
     * el chequeo de victoria y/o derrota
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (Dungeon.character != null){

        if (Dungeon.character.isDead()){
            Dungeon.character.setDead(false);

            stopTimers();

            JOptionPane.showMessageDialog(null, "Has sido humillado", "GAME OVER", JOptionPane.WARNING_MESSAGE);


            askingRematch();
            }

        if(Dungeon.character.isWin()){
            Dungeon.character.setWin(false);

            stopTimers();

            JOptionPane.showMessageDialog(null,"Tú ganas!","GAME OVER",JOptionPane.WARNING_MESSAGE);
            askingRematch();
        }

    }}


    /**
     * pregunta si el jugador quiere volver a jugar
     */
    private void askingRematch(){
        int confirmado;
        confirmado = JOptionPane.showConfirmDialog(null,
                "Volver a intentarlo",
                "revancha",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmado == JOptionPane.YES_OPTION){

            //Tengo que hacer esta chapuza para que no estén las cosas en el rematch

            for (JLabel label :
                    Labels.labelsSkels) {
                label.setVisible(false);
                label.setBounds(1, 1, 1, 1);
                label.setLocation(0, 0);
            }
            for (JLabel label :
                    Labels.labelsHitBoxMonsters) {
                label.setVisible(false);
                label.setBounds(1, 1, 1, 1);
                label.setLocation(0, 0);
            }

            Labels.labelSword.setVisible(false);
            Labels.labelSword.setBounds(1, 1, 1, 1);
            Labels.labelSword.setLocation(0, 0);

            Labels.labelMagicStaff.setVisible(false);
            Labels.labelMagicStaff.setBounds(1, 1, 1, 1);
            Labels.labelMagicStaff.setLocation(0, 0);

            Labels.labelMedallion.setVisible(false);
            Labels.labelMedallion.setBounds(1, 1, 1, 1);
            Labels.labelMedallion.setLocation(0, 0);

            frame.removeAll();
            panelMain.removeAll();
            frame.repaint();
            panelMain.repaint();
            frame.setVisible(false);
            Dungeon.main(null);

        }else{

            //sale del programa a lo bestia
            System.exit(-1);
        }
    }

    /**
     * detiene todos los timers
     */
    private void stopTimers(){
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
    }
}
