package classes.characters;

import classes.items.Item;
import classes.items.Sword;
import classes.monsters.Monster;

import javax.swing.*;
import java.util.ArrayList;

/**
 * clase para el caballero que extiende la clase Character
 */
public class Knight extends Character {


    public Knight() {
        this.type = "Caballero";
        this.lives = 5;
        this.speed = 3;
        this.upLooking = "src/img/warrior/warrior_up.gif";
        this.downLooking = "src/img/warrior/warrior_down.gif";
        this.leftLooking = "src/img/warrior/warrior_left.gif";
        this.rightLooking = "src/img/warrior/warrior_right.gif";
        this.inventory = new ArrayList<>();
        this.dead = false;
        this.win = false;
    }


    /**
     * determina lo que ocurre cuando el caballero entra en contacto con un monstruo
     * @param monster objeto Monster con el que colisiona
     * @param labelMonster JLabel del monstruo con el que colisiona
     */
    @Override
    public void contactVSMonster(Monster monster, JLabel labelMonster, JLabel labelHitBoxMonster) {
        ArrayList<Item> aux = this.inventory;
        int loops = 0;
        int indexToDelete = 0;
        boolean itemExists = false;

        for (Item item :
                aux) {
            if (item instanceof Sword) {
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
