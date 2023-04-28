package classes.monsters;

import classes.Labels;
import dungeon.Dungeon;

import javax.swing.*;

/**
 *clase para el dragón que extiende Monster
 */
public class Dragon extends Monster{

    public Dragon() {
        this.speed = 9;
        this.damage = 3;
    }

    @Override
    public void monsterAttack(JLabel labelMonster) {

        Dungeon.character.sufferDamage(this);
    }

}
