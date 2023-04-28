package dungeon.listeners;

import javax.swing.*;

import classes.*;
import classes.monsters.Monster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * guarda el movimiento de todos los monstruos en el tablero (implementa ActionListener)
 */
public class TimerMovementSkeletons implements ActionListener {
    Monster monster;
    JLabel labelMonster;

    JLabel labelHitBoxMonster;
    int lookingToGoodPlace = 0;

    int direction = (int) (Math.random() * (4 - 1 + 1) + 1);

    //esta variable será usada para los cambios de dirección "impredecibles" cuando dejen de atascárseme las putas labels
    int perpendicularChangeMovement;

    public TimerMovementSkeletons(JLabel labelMonster, JLabel labelHitBoxMonster, Monster monster) {
        this.labelMonster = labelMonster;
        this.monster = monster;
        this.labelHitBoxMonster = labelHitBoxMonster;

    }


    /**
     * engloba los desplazamientos de los esqueletos durante la partida
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int randomAux = (int) (Math.random() * (300 - 70 + 1) + 70);

        switch (direction) {
            case 1: {

                lookingToGoodPlace = labelLookingRightDirection(lookingToGoodPlace);

               direction = monster.monsterMovingRight(labelMonster, labelHitBoxMonster, direction);

                if (perpendicularChangeMovement >= randomAux) {
                    perpendicularChangeMovement = 0;

                    do {
                        direction = (int) (Math.random() * (4 - 1 + 1) + 1);

                    } while (direction == 1 || direction == 2);
                }
                break;
            }
            case 2: {
                lookingToGoodPlace = labelLookingLeftDirection(lookingToGoodPlace);

                direction = monster.monsterMovingLeft(labelMonster, labelHitBoxMonster, direction);

                if (perpendicularChangeMovement >= randomAux) {
                    perpendicularChangeMovement = 0;
                    do {
                        direction = (int) (Math.random() * (4 - 1 + 1) + 1);

                    } while (direction == 1 || direction == 2);
                }
                break;
            }
            case 3: {
                lookingToGoodPlace = labelLookingUpDirection(lookingToGoodPlace);

                direction = monster.monsterMovingUp(labelMonster, labelHitBoxMonster, direction);

                if (perpendicularChangeMovement >= randomAux) {
                    perpendicularChangeMovement = 0;
                    do {
                        direction = (int) (Math.random() * (4 - 1 + 1) + 1);

                    } while (direction == 3 || direction == 4);
                }
                break;
            }
            case 4: {
                lookingToGoodPlace = labelLookingDownDirection(lookingToGoodPlace);

                direction = monster.monsterMovingDown(labelMonster, labelHitBoxMonster, direction);

                if (perpendicularChangeMovement >= randomAux) {
                    perpendicularChangeMovement = 0;
                    do {
                        direction = (int) (Math.random() * (4 - 1 + 1) + 1);

                    } while (direction == 3 || direction == 4);
                }
                break;
            }
        }
        perpendicularChangeMovement++;
    }
    /**
     * chequea que la JLabel esté mirando hacia la derecha y, en caso de que no sea así, lo cambia
     * @param lookingToGoodPlace int que indica la dirección hacia la que mira
     * @return lookingToGoodPlace con la dirección hacia la que está mirando una vez corregida
     */
    private int labelLookingRightDirection(int lookingToGoodPlace) {
        if (lookingToGoodPlace != 1) {
            Maps.changingIconInALabel(monster.getRightLooking(), labelMonster);
            lookingToGoodPlace = 1;
        }
        return lookingToGoodPlace;
    }

    /**
     * chequea que la JLabel esté mirando hacia la izquierda y, en caso de que no sea así, lo cambia
     * @param lookingToGoodPlace int que indica la dirección hacia la que mira
     * @return lookingToGoodPlace con la dirección hacia la que está mirando una vez corregida
     */
    private int labelLookingLeftDirection(int lookingToGoodPlace) {
        if (lookingToGoodPlace != 2) {
            Maps.changingIconInALabel(monster.getLeftLooking(), labelMonster);
            lookingToGoodPlace = 2;
        }
        return lookingToGoodPlace;
    }


    /**
     * chequea que la JLabel esté mirando hacia arriba y, en caso de que no sea así, lo cambia
     * @param lookingToGoodPlace int que indica la dirección hacia la que mira
     * @return lookingToGoodPlace con la dirección hacia la que está mirando una vez corregida
     */
    private int labelLookingUpDirection(int lookingToGoodPlace) {
        if (lookingToGoodPlace != 3) {
            Maps.changingIconInALabel(monster.getUpLooking(), labelMonster);
            lookingToGoodPlace = 3;
        }
        return lookingToGoodPlace;
    }


    /**
     * chequea que la JLabel esté mirando hacia abajo y, en caso de que no sea así, lo cambia
     * @param lookingToGoodPlace int que indica la dirección hacia la que mira
     * @return lookingToGoodPlace con la dirección hacia la que está mirando una vez corregida
     */
    private int labelLookingDownDirection(int lookingToGoodPlace) {
        if (lookingToGoodPlace != 4) {
            Maps.changingIconInALabel(monster.getDownLooking(), labelMonster);
            lookingToGoodPlace = 4;
        }
        return lookingToGoodPlace;
    }


}

