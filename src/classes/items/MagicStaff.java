package classes.items;

import classes.Labels;
import classes.Maps;
import classes.Panels;
import dungeon.Dungeon;

import javax.swing.*;

/**
 * clase para el objeto del bastón mágico que implementa Item
 */
public class MagicStaff implements Item {

    /**
     * lo que ocurre cuando se utiliza el bastón mágico
     * @param labelMonster la JLabel del monstruo en el que puede tener efecto el objeto
     */
    @Override
    public void useItem(JLabel labelMonster) {
        int index;

        Labels.labelMagicStaffStats.setVisible(false);

        JLabel labelHeart = new JLabel();
        Maps.labelIconCreation(labelHeart, "src/img/dungeon/heart.png", 12, 12, Panels.panelStats);

        index = Labels.labelHearts.size();
        labelHeart.setLocation(Labels.labelHearts.get(index - 1).getX() + labelHeart.getWidth() + Labels.MARGIN,
                Labels.labelHearts.get(index - 1).getY());
        Labels.labelHearts.add(labelHeart);

        //Es la posición de inicio
        Labels.labelCharacter.setLocation(Labels.TILE_SIZE * 3, Labels.TILE_SIZE * 17);

        Dungeon.character.setLives(Dungeon.character.getLives() + 1);

    }
}
