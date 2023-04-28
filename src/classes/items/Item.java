package classes.items;

import javax.swing.*;

/**
 * interfaz que se aplicará para todos los objetos
 */
public interface Item {

    /**
     * uso del propio objeto
     * @param labelMonster la JLabel del monstruo en el que puede tener efecto el objeto
     */
    public abstract void useItem(JLabel labelMonster);


}




