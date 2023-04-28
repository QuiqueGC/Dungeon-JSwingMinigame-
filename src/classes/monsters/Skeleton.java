package classes.monsters;

import classes.Labels;
import dungeon.Dungeon;

import javax.swing.*;


/**
 * clase para el esqueleto que extiende Monster
 */
public class Skeleton extends Monster {
    public Skeleton() {
        this.upLooking = "src/img/monsters/skeleton/skeleton_up.gif";
        this.downLooking = "src/img/monsters/skeleton/skeleton_down.gif";
        this.leftLooking = "src/img/monsters/skeleton/skeleton_left.gif";
        this.rightLooking ="src/img/monsters/skeleton/skeleton_right.gif";
        this.speed=5;
        this.damage = 1;
    }

}
