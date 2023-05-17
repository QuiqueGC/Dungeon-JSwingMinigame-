package classes;

import classes.characters.Character;
import classes.characters.Knight;
import classes.characters.Necromancer;
import classes.characters.PlagueDoctor;
import dungeon.Dungeon;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Clase que guarda todos los métodos referentes a lectura y escritura de ficheros
 */
public class FilesRW {


    /**
     * Muestra los paneles con el ranking
     */
    public static void showRanking() {

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
    public static String puttingArrayIntoString(ArrayList<Character> ranking, String character) {

        String arrayInOne = null;
        int counter = 1;
        Collections.sort(ranking);


        if (character != null){

            removingFromRanking(ranking, character);
        }

        //si inicializo el iterator antes del removingFromRanking me peta el programa
        Iterator<Character> it = ranking.iterator();

        while(it.hasNext() && counter <= 5){

            if(arrayInOne == null){
                arrayInOne ="#"+counter+" "+ it.next() + "\n";
            }else{
                arrayInOne = arrayInOne.concat("#"+counter+" "+it.next().toString())+"\n";}

            counter++;
        }


        return arrayInOne;
    }





    /**
     * Busca dentro del array todos los objetos que no sean del tipo del personaje que estamos usando y los borra
     * @param ranking el arrayList con el ranking
     * @param character String con el tipo de personaje
     */
    public static void removingFromRanking(ArrayList<Character> ranking, String character) {

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
    public static void keepingInformationInArray(ArrayList<Character> ranking) {

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


    /**
     * Añade al fichero la puntuación del jugador
     */
    public static void addingScore() {

        Path path = Paths.get("src/resources/scores.txt");

        try {
            Files.writeString(path, Dungeon.character.toFile()+System.lineSeparator(), StandardOpenOption.APPEND);

        } catch (IOException e) {

            System.out.println("ERROR EN LA ESCRITURA DEL FICHERO");
        }
    }




}
