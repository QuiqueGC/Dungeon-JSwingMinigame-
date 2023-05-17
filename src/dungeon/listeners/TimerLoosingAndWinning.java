package dungeon.listeners;

import classes.ConnectionDB;
import classes.Labels;
import dungeon.Dungeon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * chequea las condiciones de victoria/derrota mediante un timer que implementa ActionListener
 */
public class TimerLoosingAndWinning implements ActionListener {

    JFrame frame;

    JPanel panelMain;

    Timer[] timers = new Timer [12];


    public TimerLoosingAndWinning(JFrame frame, JPanel panelMain,Timer[] timers) {

        this.frame = frame;

        this.panelMain = panelMain;

        for (int i = 0; i < 12; i++) {

            this.timers[i] = timers[i];
        }

    }

    /**
     * el chequeo de victoria y/o derrota
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        ConnectionDB con = new ConnectionDB("jdbc:mysql://localhost:3306/dungeon","dungeonMaster","1234");


        if (Dungeon.character != null){

        if (Dungeon.character.isDead()){

            addingScore();

            con.insertIntoRankingTable(Dungeon.character);

            Dungeon.character.setDead(false);

            stopTimers();


            JOptionPane.showMessageDialog(null, "Has sido humillado", "GAME OVER", JOptionPane.WARNING_MESSAGE);


            askingRematch();
            }

        if(Dungeon.character.isWin()){

            addingScore();

            con.insertIntoRankingTable(Dungeon.character);

            Dungeon.character.setWin(false);

            stopTimers();

            JOptionPane.showMessageDialog(null,"Tú ganas!","GAME OVER",JOptionPane.WARNING_MESSAGE);

            askingRematch();
        }

    }}


    private void addingScore() {

        Path path = Paths.get("src/resources/scores.txt");

        try {
            Files.writeString(path, Dungeon.character.toFile()+System.lineSeparator(), StandardOpenOption.APPEND);

        } catch (IOException e) {

            System.out.println("ERROR EN LA ESCRITURA DEL FICHERO");
        }
    }


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

            Labels.labelDragon.setVisible(false);
            Labels.labelDragon.setBounds(1, 1, 1, 1);
            Labels.labelDragon.setLocation(0, 0);
            Labels.labelHitBoxDragon.setBounds(1,1,1,1);
            Labels.labelHitBoxDragon.setLocation(0, 0);

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

        for (int i = 0; i < 12; i++) {
            timers[i].stop();
        }
    }
}
