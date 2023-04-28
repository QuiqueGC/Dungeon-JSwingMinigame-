package classes.characters;

import classes.items.Item;
import classes.items.MagicStaff;
import classes.monsters.Monster;

import javax.swing.*;
import java.util.ArrayList;

/**
 * clase para el nigromante que extiende la clase character
 */
public class Necromancer extends Character {

    public Necromancer() {
        this.lives = 3;
        this.speed = 7;
        this.upLooking = "src/img/wizard/wizard_up.gif";
        this.downLooking = "src/img/wizard/wizard_down.gif";
        this.leftLooking = "src/img/wizard/wizard_left.gif";
        this.rightLooking = "src/img/wizard/wizard_right.gif";
        this.inventory = new ArrayList<>();
        this.dead = false;
        this.win = false;
    }

    /**
     * lo que ocurre cuando el nigromante entra en contacto con un monstruo
     * @param monster objeto Monster con el que colisiona
     * @param labelMonster JLabel del monstruo con el que colisiona
     */
    @Override
    public void contactVSMonster(Monster monster, JLabel labelMonster) {
        ArrayList<Item> aux = this.inventory;
        int loops = 0;
        int indexToDelete = 0;
        boolean itemExists = false;

        for (Item item :
                aux) {
            if (item instanceof MagicStaff) {
                itemExists = true;
                indexToDelete = loops;

                item.useItem(labelMonster);

            }
            loops++;
        }

        if (!itemExists) {

            this.sufferDamage(monster);

        } else {
            aux.remove(indexToDelete);
            this.inventory=aux;
        }
    }


    @Override
    public String toString() {
        return "Mago-->   " +
                "Vidas: " + this.lives +
                "   Velocidad: " + this.speed;
    }

}
