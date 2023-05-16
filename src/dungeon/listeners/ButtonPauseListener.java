package dungeon.listeners;
import classes.Labels;
import classes.characters.Character;
import classes.characters.Knight;
import classes.characters.Necromancer;
import classes.characters.PlagueDoctor;
import dungeon.Dungeon;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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

        ArrayList<Character> generalRanking = new ArrayList<>();
        ArrayList<Character> characterRanking = new ArrayList<>();
        String ranking;
        String rankingCharacter;


        keepingInformationInArray(generalRanking);
        keepingInformationInArray(characterRanking);


        ranking = puttingArrayIntoString(generalRanking, null);

        rankingCharacter = puttingArrayIntoString(characterRanking, Dungeon.character.getType());




        JOptionPane.showMessageDialog(null, ranking, "RANKING GENERAL", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, rankingCharacter, "RANKING DE PERSONAJE", JOptionPane.INFORMATION_MESSAGE);

    }


    /**
     * Convierte el array de personajes en un String para mostrar el ranking (tanto general como de personaje)
     * @param ranking el ArrayList con los personajes del ranking
     * @param character el String con el tipo de personaje que está jugando
     * @return el String que usaremos para mostrar el ranking
     */
    private String puttingArrayIntoString(ArrayList<Character> ranking, String character) {

        String arrayInOne = null;
        int counter = 1;
        Collections.sort(ranking);


        if (character != null){
                removingFromRanking(ranking, character);}

        //si inicializo el iterator antes del removingFromRanking me peta el programa
        Iterator<Character> it = ranking.iterator();

        while(it.hasNext() && counter <= 5){

            if(arrayInOne == null){
                arrayInOne ="#"+counter+ it.next() + "\n";
            }else{
                arrayInOne = arrayInOne.concat("#"+counter+it.next().toString())+"\n";}

            counter++;
        }


        return arrayInOne;
    }


    /**
     * Busca dentro del array todos los objetos que no sean del tipo del personaje que estamos usando y los borra
     * @param ranking el arrayList con el ranking
     * @param character String con el tipo de personaje
     */
    private void removingFromRanking(ArrayList<Character> ranking, String character) {

        ArrayList<Character> charactersToDelete = new ArrayList<>();

        for (Character c :
                ranking) {
            if (!c.getType().equals(character)){

                charactersToDelete.add(c);
            }
        }
        ranking.removeAll(charactersToDelete);

    }


    /**
     * guarda los datos del fichero en un array
     * @param ranking el ArrayList con los distintos personajes
     */
    private void keepingInformationInArray(ArrayList<Character> ranking) {

        String fileName = "src/resources/scores.txt";
        String line;
        boolean win;
        String[] data;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

            while ((line = br.readLine()) != null){

                data = line.split(";");

                win= data[5].equals("true");

                if (data[1].equals("Nigromante")){

                    ranking.add(new Necromancer(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),win));

                } else if (data[1].equals("Caballero")) {

                    ranking.add(new Knight(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),win));

                }else {

                    ranking.add(new PlagueDoctor(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),win));
                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("NO SE HA ENCONTRADO EL FICHERO");

        } catch (IOException e) {

            System.out.println("ERROR DURANTE LA LECTURA DEL FICHERO");
        }


    }
}
