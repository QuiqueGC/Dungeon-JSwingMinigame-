package classes.items;
import javax.swing.JLabel;
import classes.Labels;

/**
 * clase para la espada que implementa Item
 */
public class Sword implements Item{


    /**
     * lo que ocurre cuando se utiliza la espada
     * @param labelMonster la JLabel del monstruo en el que puede tener efecto el objeto
     */
    @Override
    public void useItem(JLabel labelMonster, JLabel labelHitBoxMonster) {

        Labels.labelSwordStats.setVisible(false);
        labelMonster.setVisible(false);
        labelMonster.setBounds(1, 1, 1, 1);
        labelMonster.setLocation(0, 0);
        labelHitBoxMonster.setVisible(false);
        labelHitBoxMonster.setBounds(1, 1, 1, 1);
        labelHitBoxMonster.setLocation(0, 0);


    }
}
