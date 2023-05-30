package dungeon.jDialogs;

import classes.FilesRW;
import classes.Maps;
import classes.characters.Character;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase que extiende JDialog para mostrar el ranking en una ventana
 */
public class Ranking extends JDialog {



    public Ranking(){
        JLabel labelTitle = new JLabel();
        JLabel labelCharacterPicked = new JLabel();
        JLabel labelName = new JLabel();
        JLabel labelGold = new JLabel();
        JLabel labelLives = new JLabel();
        JLabel labelMissionComplete = new JLabel();

        JPanel contentPane = new JPanel();
        ArrayList<Character> rankingList = new ArrayList<>();
        int positionY = 100;

        this.setTitle("Cementery Gates");
        this.setSize(660, 640);
        this.setPreferredSize(this.getSize());
        this.setLocationRelativeTo(null);
        //cambia el icono de la aplicación
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("src/img/politecnics.png");
        this.setIconImage(icono);

        contentPaneCreation(contentPane);

        setContentPane(contentPane);
        setModal(true);



        //label del título
        showingLabelText(labelTitle, contentPane, "Ranking General");
        //coloca en el centro del panel la label
        labelTitle.setSize(contentPane.getWidth(),50);
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setVerticalAlignment(SwingConstants.TOP);

        showingLabelText(labelCharacterPicked, contentPane, "NOMBRE");
        labelCharacterPicked.setLocation(20,50);


        showingLabelText(labelName, contentPane, "PERSONAJE");
        labelName.setLocation(labelCharacterPicked.getX()+labelCharacterPicked.getWidth(), 50);

        showingLabelText(labelGold, contentPane, "ORO");
        labelGold.setLocation(labelName.getX()+labelName.getWidth(), 50);


        showingLabelText(labelLives, contentPane, "VIDAS");
        labelLives.setLocation(labelGold.getX()+labelGold.getWidth(), 50);


        showingLabelText(labelMissionComplete, contentPane, "VICTORIA");
        labelMissionComplete.setLocation(labelLives.getX()+labelLives.getWidth(), 50);

        FilesRW.keepFileInArray(rankingList);


        for (int i = 0; i < 10; i++) {

            puttingDataInRanking(rankingList.get(i), contentPane, positionY);

            positionY +=50;
        }

    }

    /**
     * Introduce el ranking dentro del JPanel character a character
     * @param character el Character que queremos introducir
     * @param contentPane el JPanel en el que introduciremos el ranking
     * @param positionY la posición en el eje Y en la que irá cada línea del ranking
     */
    private void puttingDataInRanking(Character character, JPanel contentPane, int positionY) {

        JLabel labelCharacterType = new JLabel();
        JLabel labelName = new JLabel();
        JLabel labelGold = new JLabel();
        JLabel labelLives = new JLabel();
        JLabel labelWinner = new JLabel();
        String victory;

        showingLabelText(labelName, contentPane, character.getName());
        labelName.setLocation(15,positionY);

        Maps.labelIconCreation(labelCharacterType,character.getDownLooking(),32,32,contentPane);
        labelCharacterType.setLocation(180,positionY);

        showingLabelText(labelGold, contentPane, Integer.toString(character.getGold()));
        labelGold.setLocation(260,positionY);

        showingLabelText(labelLives, contentPane, Integer.toString(character.getLives()));
        labelLives.setLocation(370,positionY);

        if (character.isWin()){
            victory = "Sí";
        }else {
            victory = "No";
        }

        showingLabelText(labelWinner, contentPane, victory);
        labelWinner.setLocation(500,positionY);

    }


    /**
     * Crea y muestra la JLabel de texto
     * @param label la JLabel que queremos introducir
     * @param contentPane el JPanel en el que introduciremos la JLabel
     * @param text el Texto que queremos que contenga
     */
    private void showingLabelText(JLabel label, JPanel contentPane, String text) {
        creatingLabelText(label,text, contentPane);
        label.setFont(new Font("Serif", Font.ITALIC, 20));
        label.setSize(120,50);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);

    }

    //este método está repetido en varios JDialog. Lo suyo sería crearlo en la clase maps
    private void creatingLabelText(JLabel label, String text, JPanel contentPane) {

        label.setText(text);
        label.setSize(200,100);
        label.setForeground(Color.white);
        //Coloca el texto centrado dentro de la label
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(label);
    }

    /**
     * Crea el JPanel con sus especificaciones
     * @param contentPane El JPanel al que daremos forma
     */
    private void contentPaneCreation(JPanel contentPane){
        contentPane.setPreferredSize(new Dimension(660, 640));
        contentPane.setSize(new Dimension(660, 640));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(60,61,59));
    }



}
