package classes.monsters;

import classes.Labels;

import javax.swing.*;

/**
 * clase para la doncella esqueleto que extiende Monster
 */
public class PriestessSkeleton extends Monster {
    public PriestessSkeleton() {
        this.upLooking = "src/img/monsters/priestessSkeleton/priestessSkeleton_up.gif";
        this.downLooking = "src/img/monsters/priestessSkeleton/priestessSkeleton_down.gif";
        this.leftLooking = "src/img/monsters/priestessSkeleton/priestessSkeleton_left.gif";
        this.rightLooking ="src/img/monsters/priestessSkeleton/priestessSkeleton_right.gif";
        this.speed=8;
        this.damage = 1;
    }


    /**
     * además del ataque normal, aumenta la velocidad de la doncella esqueleto
     * @param labelMonster la JLabel que pertenece al monstruo
     */
    @Override
    public void monsterAttack(JLabel labelMonster) {
        super.monsterAttack(labelMonster);

        this.speed += 4;
    }
}
