package dungeon;

import classes.characters.Character;
import classes.monsters.Dragon;
import classes.monsters.PriestessSkeleton;
import classes.monsters.Skeleton;
import classes.monsters.WarriorSkeleton;
import dungeon.listeners.*;
import classes.*;
import javax.swing.*;
import java.awt.*;


public class Dungeon {
    private JPanel panelMain;
    public static Character character;


    public static void main(String[] args) {


        JFrame frame = new JFrame("Cementery Gates");


        // añadimos un windowListener de apertura de ventana
        frame.addWindowListener(new FrameWindowListener(frame));


        frame.setContentPane(new Dungeon(frame).panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();


        //vuelve visible el frame
        frame.setVisible(true);


        //Coloca la ventana en el centro de la pantalla
        frame.setLocationRelativeTo(null);


        //cambia el icono de la aplicación
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("src/img/politecnics.png");
        frame.setIconImage(icono);


    }


    public Dungeon(JFrame frame) {

        ConnectionDB connectionDB = new ConnectionDB("jdbc:mysql://localhost:3306/dungeon","dungeonMaster","1234");
        int seconds = 0;
        Skeleton skel = new Skeleton();
        WarriorSkeleton warriorSkel = new WarriorSkeleton();
        WarriorSkeleton warriorSkel2 = new WarriorSkeleton();
        PriestessSkeleton priestessSkel = new PriestessSkeleton();
        PriestessSkeleton priestessSkel2 = new PriestessSkeleton();
        Dragon dragon = new Dragon();
        Timer[] timers = new Timer[10];


        Panels.createPanelMain(panelMain);


        Panels.createPanelStats();
        //lo añadimos al panel principal
        panelMain.add(Panels.panelStats);


        Panels.createPanelGaming();
        //lo añadimos al panel principal
        panelMain.add(Panels.panelGaming);


        //agregamos el listener de teclado
        panelMain.addKeyListener(new PanelMainListener());

        //timer de contador de tiempo
        timers[0] = new Timer(1000, new SecondsCounter(seconds));

        //timers de monstruos

        for (int i = 0; i < 4; i++) {
            //creo la variable j porque los timers van un nivel de índice por encima de los otros arrays
            int j = i+1;
            timers[j] = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(i),Labels.labelsHitBoxMonsters.get(i), skel));
        }
        timers[5] = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(4),Labels.labelsHitBoxMonsters.get(4), priestessSkel));
        timers[6] = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(5),Labels.labelsHitBoxMonsters.get(5), priestessSkel2));
        timers[7] = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(6),Labels.labelsHitBoxMonsters.get(6), warriorSkel));
        timers[8] = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(7),Labels.labelsHitBoxMonsters.get(7), warriorSkel2));
        timers[9] = new Timer(50, new TimerActionDragon(dragon));


        //timer de victoria o derrota
        Timer timerLoosing = new Timer(10, new TimerLoosingAndWinning(frame, panelMain, timers, connectionDB));


        for (int i = 0; i < 10; i++) {
            timers[i].start();
        }

        timerLoosing.start();


        Labels.buttonPause.addMouseListener(new ButtonPauseListener(timers, panelMain));
    }



    /**
     * chequea si el jugador tiene los requisitos para ganar y si lo ha hecho
     */
    public static void checkWinning() {
        boolean goldToWin = Dungeon.character.getGold() >= 50;
        boolean placeToLeave = Labels.labelCharacter.getBounds().intersects(Labels.walls.get(33).getBounds()) ||
                Labels.labelCharacter.getBounds().intersects(Labels.walls.get(32).getBounds()) ||
                Labels.labelCharacter.getBounds().intersects(Labels.walls.get(34).getBounds());

        if (goldToWin && placeToLeave){

            Labels.labelCharacter.setVisible(false);

            Dungeon.character.setWin(true);


        }

    }
}
