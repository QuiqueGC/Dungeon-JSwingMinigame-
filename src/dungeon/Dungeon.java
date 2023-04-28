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
        Skeleton skel = new Skeleton();
        WarriorSkeleton warriorSkel = new WarriorSkeleton();
        WarriorSkeleton warriorSkel2 = new WarriorSkeleton();
        PriestessSkeleton priestessSkel = new PriestessSkeleton();
        PriestessSkeleton priestessSkel2 = new PriestessSkeleton();
        Dragon dragon = new Dragon();


        Panels.createPanelMain(panelMain);


        Panels.createPanelStats();
        //lo añadimos al panel principal
        panelMain.add(Panels.panelStats);


        Panels.createPanelGaming();
        //lo añadimos al panel principal
        panelMain.add(Panels.panelGaming);


        //agregamos el listener de teclado
        panelMain.addKeyListener(new PanelMainListener());


        //timers de monstruos
        Timer timer2 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(0),Labels.labelsHitBoxMonsters.get(0), skel));
        Timer timer3 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(1),Labels.labelsHitBoxMonsters.get(1), skel));
        Timer timer4 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(2),Labels.labelsHitBoxMonsters.get(2), warriorSkel));
        Timer timer5 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(3),Labels.labelsHitBoxMonsters.get(3), warriorSkel2));
        Timer timer6 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(4),Labels.labelsHitBoxMonsters.get(4), priestessSkel));
        Timer timer7 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(5),Labels.labelsHitBoxMonsters.get(5), priestessSkel2));
        Timer timer8 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(6),Labels.labelsHitBoxMonsters.get(6), skel));
        Timer timer9 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(7),Labels.labelsHitBoxMonsters.get(7), skel));
        Timer timer10 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(8),Labels.labelsHitBoxMonsters.get(8), skel));
        Timer timer11 = new Timer(50, new TimerMovementSkeletons(Labels.labelsSkels.get(9),Labels.labelsHitBoxMonsters.get(9), skel));
        Timer timerDragon = new Timer(50, new TimerActionDragon(dragon));

        Timer timerLoosing = new Timer(10, new TimerLoosingAndWinning(frame, panelMain, timer2, timer3, timer4, timer5,
                timer6, timer7, timer8, timer9, timer10, timer11, timerDragon));

        timer2.start();
        timer3.start();
        timer4.start();
        timer5.start();
        timer6.start();
        timer7.start();
        timer8.start();
        timer9.start();
        timer10.start();
        timer11.start();
        timerDragon.start();

        timerLoosing.start();


        Labels.buttonPause.addMouseListener(new ButtonPauseListener(timer2, timer3, timer4, timer5,
                timer6, timer7, timer8, timer9, timer10, timer11, timerDragon, panelMain));
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
