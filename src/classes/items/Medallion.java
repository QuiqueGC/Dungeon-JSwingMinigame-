package classes.items;

import classes.Labels;

import javax.swing.*;

/**
 * clase para el medallón que implementa Item
 */
public class Medallion implements Item{



    /**
     * lo que ocurre cuando se usa el medallón
     * @param labelMonster la JLabel del monstruo en el que puede tener efecto el objeto
     */
    @Override
    public void useItem(JLabel labelMonster) {

        Labels.labelMedallionStats.setVisible(false);
        //Es la posición de inicio
        Labels.labelCharacter.setLocation(Labels.TILE_SIZE * 3, Labels.TILE_SIZE * 17);

    }
}
