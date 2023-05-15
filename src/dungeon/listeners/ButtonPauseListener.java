package dungeon.listeners;
import classes.Labels;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * listener que extiende MouseAdapter para el botón de pausa
 */
public class ButtonPauseListener extends MouseAdapter {

    Timer[] timers = new Timer [12];


    JPanel panel;

    //pasamos los timer por parámetros para poder usar los del Main
    public ButtonPauseListener(Timer[] timers, JPanel panel) {


        for (int i = 0; i < 12; i++) {

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

            for (int i = 0; i < 12; i++) {

                timers[i].stop();
            }

            showRanking();

            Labels.buttonPause.setText("Reanudar");

        } else {

            for (int i = 0; i < 12; i++) {

                timers[i].start();
            }

            Labels.buttonPause.setText("Pausa");

            //con el requestFocus recuperas el foco en el objeto al que se lo aplicas
            panel.requestFocus();

        }

    }

    private void showRanking() {

        ArrayList<String> ranking = new ArrayList<>();
        String arrayInOne =null;


        keepingInformationInArray(ranking);


        for (String s :
                ranking) {
            if(arrayInOne == null){
                arrayInOne = s + "\n";
            }else{
            arrayInOne = arrayInOne.concat(s)+"\n";}
        }


        JOptionPane.showMessageDialog(null, arrayInOne, "RANKING", JOptionPane.INFORMATION_MESSAGE);
    }



    private void keepingInformationInArray(ArrayList<String> ranking) {

        String fileName = "src/resources/scores.txt";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

            while ((line = br.readLine()) != null){

                ranking.add(line);
            }

        } catch (FileNotFoundException e) {

            System.out.println("NO SE HA ENCONTRADO EL FICHERO");

        } catch (IOException e) {

            System.out.println("ERROR DURANTE LA LECTURA DEL FICHERO");
        }


    }
}
