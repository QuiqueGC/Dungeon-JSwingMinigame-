package classes.monsters;

import classes.Labels;

import javax.swing.*;

/**
 * clase para el guerrero esqueleto que extiende Monster
 */
public class WarriorSkeleton extends Monster {

    public WarriorSkeleton() {
        this.upLooking = "src/img/monsters/warriorSkeleton/warriorSkeleton_up.gif";
        this.downLooking = "src/img/monsters/warriorSkeleton/warriorSkeleton_down.gif";
        this.leftLooking = "src/img/monsters/warriorSkeleton/warriorSkeleton_left.gif";
        this.rightLooking ="src/img/monsters/warriorSkeleton/warriorSkeleton_right.gif";
        this.speed=2;
        this.damage = 1;
    }

    /**
     * además del ataque normal, el guerrero esqueleto crece en tamaño y poder con cada ataque
     * @param labelMonster la JLabel que pertenece al monstruo
     */
    @Override
    public void monsterAttack(JLabel labelMonster, JLabel labelHitBoxMonster) {
        super.monsterAttack(labelMonster, labelHitBoxMonster);

        labelMonster.setSize(labelMonster.getWidth()+25,labelMonster.getHeight()+25);
        labelHitBoxMonster.setSize(labelMonster.getWidth()- Labels.hitBoxDiference,labelMonster.getHeight()-Labels.hitBoxDiference);
        this.damage++;
    }
}
