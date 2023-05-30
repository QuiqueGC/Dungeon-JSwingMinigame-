package dungeon.jDialogs;

import classes.*;
import classes.characters.Character;
import classes.characters.Necromancer;
import classes.characters.PlagueDoctor;
import classes.characters.Knight;
import dungeon.Dungeon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * creado para almacenar ALL lo referente al JDialog de inicio extiende JDialog
 */
public class StartingGame extends JDialog {
    private JPanel contentPane = new JPanel();

    private JButton buttonNecromancer = new JButton();
    private JButton buttonKnight = new JButton();
    private JButton buttonPlagueDoctor = new JButton();

    private  JButton buttonRanking = new JButton();

    Necromancer necromancer = new Necromancer();
    Knight knight = new Knight();
    PlagueDoctor plagueDoctor = new PlagueDoctor();


    JLabel labelChooseYourCharacter = new JLabel();

    JLabel labelNecromancerFace = new JLabel();
    JLabel labelNecromancerlives = new JLabel();
    JLabel labelNecromancerSpeed = new JLabel();
    JLabel labelNecromancerItemText = new JLabel();
    JLabel labelMagicStaff = new JLabel();

    JLabel labelKnightFace = new JLabel();
    JLabel labelKnightLives = new JLabel();
    JLabel labelKnightSpeed = new JLabel();
    JLabel labelKnightItemText = new JLabel();
    JLabel labelSword = new JLabel();

    JLabel labelPlagueDoctorFace = new JLabel();
    JLabel labelPlagueDoctorLives = new JLabel();
    JLabel labelPlagueDoctorSpeed = new JLabel();
    JLabel labelPlagueDoctorItemText = new JLabel();
    JLabel labelMedallion = new JLabel();


    JLabel labelRulesText = new JLabel();
    JLabel labelRulesExplain = new JLabel();
    JLabel labelGold = new JLabel();

    public StartingGame() {

        this.setTitle("Cementery Gates");
        this.setSize(660, 640);
        this.setPreferredSize(this.getSize());
        this.setLocationRelativeTo(null);
        //cambia el icono de la aplicación
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("src/img/politecnics.png");
        this.setIconImage(icono);


        contentPaneCreation();

        setContentPane(contentPane);
        setModal(true);

        buttonRankingCreation();


        titleTextCreation();


        labelsNecromancerCreation();



        labelsKnightCreation();




        labelsPlagueDoctorCreation();





        labelsRulesGameCreation();




    }

    private void buttonRankingCreation() {

        creatingButton(buttonRanking, "Ranking");
        buttonRanking.setLocation(430,540);
        buttonRanking.addMouseListener(new ButtonRankingListener());
    }

    /**
     * engloba las JLables referentes a las reglas
     */
    private void labelsRulesGameCreation() {

        creatingLabelText(labelRulesText,"Objetivo del juego:");
        labelRulesText.setLocation(contentPane.getX()+10,labelMagicStaff.getY()+10);


        creatingLabelText(labelRulesExplain, "Coge todo el oro que puedas y huye por la puerta norte (mínimo 50)");
        labelRulesExplain.setSize(contentPane.getWidth(), labelRulesExplain.getHeight());
        labelRulesExplain.setLocation(labelRulesText.getX(), labelRulesText.getY()+30);


        Maps.labelIconCreation(labelGold,"src/img/dungeon/gold.png",32,32,contentPane);
        labelGold.setLocation(labelRulesExplain.getX(),labelRulesExplain.getY()+labelGold.getHeight()+30);
    }

    /**
     * engloba las JLabels referentes al médico de la plaga
     */
    private void labelsPlagueDoctorCreation() {

        creatingButton(buttonPlagueDoctor, "Médico de la peste");
        buttonPlagueDoctor.setLocation(buttonKnight.getX() + buttonNecromancer.getWidth() + 10, contentPane.getHeight() / 2);
        buttonPlagueDoctor.addMouseListener(new ButtonCharacterListener(plagueDoctor));

        Maps.labelIconCreation(labelPlagueDoctorFace, "src/img/statsLabels/face_priest.png", 200, 200, contentPane);
        labelPlagueDoctorFace.setLocation(buttonPlagueDoctor.getX(), labelNecromancerFace.getY());

        creatingLabelText(labelPlagueDoctorLives, "Vidas: "+plagueDoctor.getLives());
        labelPlagueDoctorLives.setLocation(buttonPlagueDoctor.getX(), buttonPlagueDoctor.getY() + 20);

        creatingLabelText(labelPlagueDoctorSpeed, "Velocidad: "+plagueDoctor.getSpeed());
        labelPlagueDoctorSpeed.setLocation(labelPlagueDoctorLives.getX(), labelPlagueDoctorLives.getY() + 20);

        creatingLabelText(labelPlagueDoctorItemText,"Objeto clave: ");
        labelPlagueDoctorItemText.setLocation(labelPlagueDoctorSpeed.getX(),labelPlagueDoctorSpeed.getY()+20);

        Maps.labelIconCreation(labelMedallion,"src/img/dungeon/medallion.png",40,40,contentPane);
        labelMedallion.setLocation(labelPlagueDoctorItemText.getX(),labelPlagueDoctorItemText.getY()+labelMedallion.getHeight()+20);

    }

    /**
     * engloba las JLabels referentes al caballero
     */
    private void labelsKnightCreation() {
        creatingButton(buttonKnight, "Caballero");
        buttonKnight.setLocation(buttonNecromancer.getX() + buttonNecromancer.getWidth() + 10, contentPane.getHeight() / 2);
        buttonKnight.addMouseListener(new ButtonCharacterListener(knight));

        Maps.labelIconCreation(labelKnightFace, "src/img/statsLabels/face_warrior.png", 200, 200, contentPane);
        labelKnightFace.setLocation(buttonKnight.getX(), labelNecromancerFace.getY());

        creatingLabelText(labelKnightLives, "Vidas: "+knight.getLives());
        labelKnightLives.setLocation(buttonKnight.getX(), buttonKnight.getY() + 20);

        creatingLabelText(labelKnightSpeed, "Velocidad: "+knight.getSpeed());
        labelKnightSpeed.setLocation(labelKnightLives.getX(), labelKnightLives.getY() + 20);

        creatingLabelText(labelKnightItemText,"Objeto clave: ");
        labelKnightItemText.setLocation(labelKnightSpeed.getX(),labelKnightSpeed.getY()+20);

        Maps.labelIconCreation(labelSword,"src/img/dungeon/sword.png",40,40,contentPane);
        labelSword.setLocation(labelKnightItemText.getX(),labelKnightItemText.getY()+labelSword.getHeight()+20);

    }

    /**
     * engloba las JLabels referentes al nigromante
     */
    private void labelsNecromancerCreation() {
        creatingButton(buttonNecromancer, "Nigromante");
        buttonNecromancer.setLocation(contentPane.getX() + 20, contentPane.getHeight() / 2);
        buttonNecromancer.addMouseListener(new ButtonCharacterListener(necromancer));

        Maps.labelIconCreation(labelNecromancerFace, "src/img/statsLabels/face_wizard.png", 200, 200, contentPane);
        labelNecromancerFace.setLocation(buttonNecromancer.getX(), buttonNecromancer.getY() - buttonNecromancer.getHeight() - labelNecromancerFace.getHeight());

        creatingLabelText(labelNecromancerlives, "Vidas: "+necromancer.getLives());
        labelNecromancerlives.setLocation(buttonNecromancer.getX(), buttonNecromancer.getY() + 20);

        creatingLabelText(labelNecromancerSpeed, "Velocidad: "+necromancer.getSpeed());
        labelNecromancerSpeed.setLocation(labelNecromancerlives.getX(), labelNecromancerlives.getY() + 20);

        creatingLabelText(labelNecromancerItemText,"Objeto clave: ");
        labelNecromancerItemText.setLocation(labelNecromancerSpeed.getX(),labelNecromancerSpeed.getY()+20);

        Maps.labelIconCreation(labelMagicStaff,"src/img/dungeon/magicStaff.png",40,40,contentPane);
        labelMagicStaff.setLocation(labelNecromancerItemText.getX(),labelNecromancerItemText.getY()+labelMagicStaff.getHeight()+20);

    }

    /**
     * contiene la JLabel del título
     */
    private void titleTextCreation() {
        creatingLabelText(labelChooseYourCharacter,"Elige tu personaje");
        labelChooseYourCharacter.setFont(new Font("Serif", Font.ITALIC, 20));
        labelChooseYourCharacter.setSize(contentPane.getWidth(),50);
        labelChooseYourCharacter.setHorizontalAlignment(SwingConstants.CENTER);
        labelChooseYourCharacter.setVerticalAlignment(SwingConstants.TOP);
    }

    /**
     * el listener que extiende el MouseAdapter (para el clic en los botones)
     */
    private class ButtonCharacterListener extends MouseAdapter {

        Character character;
        public ButtonCharacterListener(Character character) {
            this.character = character;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            Dungeon.character = this.character;
            choosingSure(this.character);
        }
    }

    private class ButtonRankingListener extends MouseAdapter {

        Character character;
        public ButtonRankingListener() {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

           // FilesRW.showRanking();

            JDialog ranking = new Ranking();
            ranking.setVisible(true);
        }
    }

    /**
     * contiene el JOptionPane de confirmación para la selección de personaje
     * @param character el objeto Character escogido por el jugador cuando hizo clic
     */
    private void choosingSure(Character character) {
        String characterName;
        int confirmado = JOptionPane.showConfirmDialog(null,
                "Seguro que quieres este personaje?",
                "confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmado == JOptionPane.YES_OPTION){

            choosingCharacter(character);

            do {
                characterName = JOptionPane.showInputDialog(null, "Escoge nombre", JOptionPane.QUESTION_MESSAGE);
            }while (characterName == null); // pongo null porque es lo que funciona para que vuelva en caso de darle a salir o a cancelar

            //introducimos el nombre en el personaje
            Dungeon.character.setName(characterName);
            //seteo aquí el nombre del personaje
            Labels.labelName.setText(characterName);

            this.setVisible(false);

        }else{

            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }


    /**
     * actualización de JLabels y personaje del jugador en base a la elección
     * @param character el Character escogido por el jugador
     */
    private void choosingCharacter(Character character) {

        if (character instanceof Necromancer){

            Maps.changingIconInALabel("src/img/statsLabels/face_wizard.png", Labels.labelCharacterStats);
            Dungeon.character = necromancer;
            Maps.changingIconInALabel("src/img/wizard/wizard_up.gif",Labels.labelCharacter);

        }else if (character instanceof Knight){

            Maps.changingIconInALabel("src/img/statsLabels/face_warrior.png", Labels.labelCharacterStats);
            Dungeon.character = knight;
            Maps.changingIconInALabel("src/img/warrior/warrior_up.gif",Labels.labelCharacter);

        }else if (character instanceof PlagueDoctor){

            Maps.changingIconInALabel("src/img/statsLabels/face_priest.png", Labels.labelCharacterStats);
            Dungeon.character = plagueDoctor;
            Maps.changingIconInALabel("src/img/priest/priest_up.gif",Labels.labelCharacter);
        }

    }

    /**
     * método para crear rápidamente JLabels iguales de texto
     * @param label la JLabel que queremos crear
     * @param text el texto que queremos introducir en ella
     */
    private void creatingLabelText(JLabel label, String text) {

        label.setText(text);
        label.setSize(200,100);
        label.setForeground(Color.white);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(label);
    }


    /**
     * creación del panel contenido en el JDialog
     */
    private void contentPaneCreation(){
        contentPane.setPreferredSize(new Dimension(660, 640));
        contentPane.setSize(new Dimension(660, 640));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(60,61,59));
    }

    /**
     * método para creación de botón rápido
     * @param button el JButton al que queramos dar forma
     * @param character el personaje al que equivaldrá este botón
     */
    private void creatingButton(JButton button, String character){

        //creación de label de botón de pausa
        button.setText(character);
        //establece que no se quede marcado el botón al pulsarlo
        button.setFocusPainted(false);
        //cambia el color de fondo añadiendo un nuevo color con el sistema RGB
        button.setBackground(new Color(100, 100, 200));
        //cambia el color de la letra a un color ya establecido
        button.setForeground(Color.white);
        button.setSize(200,50);
        contentPane.add(button);


    }

}

