package classes.characters;

import classes.items.Item;
import classes.items.Medallion;
import classes.monsters.Monster;

import javax.swing.*;
import java.util.ArrayList;

/**
 * clase para el médico de la plaga que extiende la clase character
 */
public class PlagueDoctor extends Character {

    public PlagueDoctor() {
        this.type = "Médico de la peste";
        this.lives = 4;
        this.speed = 5;
        this.upLooking = "src/img/priest/priest_up.gif";
        this.downLooking = "src/img/priest/priest_down.gif";
        this.leftLooking = "src/img/priest/priest_left.gif";
        this.rightLooking = "src/img/priest/priest_right.gif";
        this.inventory = new ArrayList<>();
        this.dead = false;
        this.win = false;
    }


    public PlagueDoctor(String name, String type, int gold, int lives, int time, boolean win){

        this.name = name;
        this.type = type;
        this.gold = gold;
        this.lives = lives;
        this.time = time;
        this.win = win;
        this.downLooking = "src/img/priest/priest_down.gif";
    }
    /**
     * lo que ocurre cuando el médico de la plaga entra en contacto con un montruo
     * @param monster objeto Monster con el que colisiona
     * @param labelMonster JLabel del monstruo con el que colisiona
     */
    @Override
    public void contactVSMonster(Monster monster, JLabel labelMonster,JLabel labelHitBoxMonster) {
        ArrayList<Item> aux = this.inventory;
        int loops = 0;
        int indexToDelete = 0;
        boolean itemExists = false;

        for (Item item :
                aux) {
            if (item instanceof Medallion) {

                itemExists = true;

                indexToDelete = loops;

                item.useItem(labelMonster, labelHitBoxMonster);
            }
            loops++;
        }
        if (!itemExists) {

            this.sufferDamage(monster);

        } else {
            aux.remove(indexToDelete);
            this.inventory = aux;
        }
    }

}
