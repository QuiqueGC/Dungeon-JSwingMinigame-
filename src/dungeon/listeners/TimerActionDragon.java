package dungeon.listeners;

import classes.*;
import classes.monsters.Monster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * listener para la aparición del dragón que implementa ActionListener
 */
public class TimerActionDragon implements ActionListener {

   int randomAparition = (int) (Math.random()*(900-500+1)+500);
    //int counterAparition = 100;
    int timer = 0;
    int dragonX = Labels.labelDragon.getX();
    int dragonY = Labels.labelDragon.getY();

    Monster monster;

    public TimerActionDragon(Monster monster) {
        this.monster = monster;
    }

    /**
     * la acción que se realiza con el timer del dragón
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        timer++;
        boolean outOfThePanel = Labels.labelDragon.getX() + Labels.labelDragon.getWidth() <= 0
                || Labels.labelDragon.getY() + Labels.labelDragon.getHeight() <= 0;



                if (timer >= randomAparition) {
                Labels.labelDragon.setLocation(dragonX, dragonY);
                dragonX -= this.monster.getSpeed() * 2;
                dragonY -= this.monster.getSpeed();

                    if(Labels.labelDragon.getBounds().intersects(Labels.labelCharacter.getBounds())){
                monster.monsterAttack(Labels.labelDragon);}

        }
                if (outOfThePanel){
                    timer = 0;
                    dragonX= Panels.panelGaming.getWidth();
                    dragonY = Panels.panelGaming.getHeight();
                    Labels.labelDragon.setLocation(dragonX,dragonY);
                }
    }


}
