package dungeon.listeners;

import classes.*;
import dungeon.Dungeon;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * listener para el teclado que extiende KeyAdapter
 */
public class PanelMainListener extends KeyAdapter {

    int whereHeLookingFor = 0;

    public PanelMainListener() {
    }

    /**
     * evento que responde a las diferentes pulsadas de teclas
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);



        switch (e.getKeyCode()) {

            case KeyEvent.VK_RIGHT -> {

                whereHeLookingFor = labelLookingRightDirection(whereHeLookingFor);

                Dungeon.character.characterMovingRight();

            }
            case KeyEvent.VK_LEFT -> {

                whereHeLookingFor = labelLookingLeftDirection(whereHeLookingFor);

                Dungeon.character.characterMovingLeft();
            }

            case KeyEvent.VK_UP -> {


                whereHeLookingFor = labelLookingUpDirection(whereHeLookingFor);

                Dungeon.character.characterMovingUp();

            }


            case KeyEvent.VK_DOWN -> {


                whereHeLookingFor = labelLookingDownDirection(whereHeLookingFor);

                Dungeon.character.characterMovingDown();

            }
        }
        takingThings();

        Dungeon.checkWinning();
    }


    /**
     * alberga los métodos del personaje para coger las diferentes cosas
     */
    private void takingThings(){

        Dungeon.character.takingGold();

        Dungeon.character.takingSword();

        Dungeon.character.takingMagicStaff();

        Dungeon.character.takingMedallion();

    }

    /**
     * chequea que la JLabel esté mirando hacia la derecha y, en caso de que no sea así, lo cambia
     * @param lookingToGoodPlace int que indica la dirección hacia la que mira
     * @return lookingToGoodPlace con la dirección hacia la que está mirando una vez corregida
     */
    public static int labelLookingRightDirection(int lookingToGoodPlace) {
        if (lookingToGoodPlace != 1) {
            Maps.changingIconInALabel(Dungeon.character.getRightLooking(), Labels.labelCharacter);
            lookingToGoodPlace = 1;
        }
        return lookingToGoodPlace;
    }

    /**
     * chequea que la JLabel esté mirando hacia la izquierda y, en caso de que no sea así, lo cambia
     * @param lookingToGoodPlace int que indica la dirección hacia la que mira
     * @return lookingToGoodPlace con la dirección hacia la que está mirando una vez corregida
     */
    public static int labelLookingLeftDirection(int lookingToGoodPlace) {
        if (lookingToGoodPlace != 2) {
            Maps.changingIconInALabel(Dungeon.character.getLeftLooking(), Labels.labelCharacter);
            lookingToGoodPlace = 2;
        }
        return lookingToGoodPlace;
    }

    /**
     * chequea que la JLabel esté mirando hacia arriba y, en caso de que no sea así, lo cambia
     * @param lookingToGoodPlace int que indica la dirección hacia la que mira
     * @return lookingToGoodPlace con la dirección hacia la que está mirando una vez corregida
     */
    public static int labelLookingUpDirection(int lookingToGoodPlace) {
        if (lookingToGoodPlace != 3) {
            Maps.changingIconInALabel(Dungeon.character.getUpLooking(), Labels.labelCharacter);
            lookingToGoodPlace = 3;
        }
        return lookingToGoodPlace;
    }

    /**
     * chequea que la JLabel esté mirando hacia abajo y, en caso de que no sea así, lo cambia
     * @param lookingToGoodPlace int que indica la dirección hacia la que mira
     * @return lookingToGoodPlace con la dirección hacia la que está mirando una vez corregida
     */
    public static int labelLookingDownDirection(int lookingToGoodPlace) {
        if (lookingToGoodPlace != 4) {
            Maps.changingIconInALabel(Dungeon.character.getDownLooking(), Labels.labelCharacter);
            lookingToGoodPlace = 4;
        }
        return lookingToGoodPlace;
    }



}