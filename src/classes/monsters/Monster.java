package classes.monsters;

import classes.Labels;
import classes.Maps;
import classes.Panels;
import dungeon.Dungeon;

import javax.swing.*;

/**
 * la clase abstracta que engloba a todos los monstruos
 */
abstract public class Monster {


    protected String upLooking;
   protected String downLooking;
     protected String leftLooking;
    protected   String rightLooking;

    protected  int speed;

    protected int damage;

    public Monster() {
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getUpLooking() {
        return upLooking;
    }

    public void setUpLooking(String upLooking) {
        this.upLooking = upLooking;
    }

    public String getDownLooking() {
        return downLooking;
    }

    public void setDownLooking(String downLooking) {
        this.downLooking = downLooking;
    }

    public String getLeftLooking() {
        return leftLooking;
    }

    public void setLeftLooking(String leftLooking) {
        this.leftLooking = leftLooking;
    }

    public String getRightLooking() {
        return rightLooking;
    }

    public void setRightLooking(String rightLooking) {
        this.rightLooking = rightLooking;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    /**
     * movimiento del monstruo hacia la derecha
     * @param labelMonster la JLabel que pertenece al monstruo
     * @param direction int que indica la dirección hacia la que está yendo el monstruo
     * @return int con la dirección hacia la que irá el monstruo
     */
    public int monsterMovingRight(JLabel labelMonster,JLabel labelHitBoxMonster, int direction) {
       int x = labelMonster.getX()+this.speed;
        boolean wallCollision = false;
        int checkingY = labelMonster.getY()/Labels.TILE_SIZE;
        int checkingX = x/Labels.TILE_SIZE;

        if (labelHitBoxMonster.getBounds().intersects(Labels.labelHitBoxCharacter.getBounds())) {

        monsterAttack(labelMonster, labelHitBoxMonster);
        }

        if (labelMonster.getX() + labelMonster.getWidth() >= Panels.panelGaming.getWidth() - Labels.TILE_SIZE * 2) {
            wallCollision = true;
            direction = 2;
        }
        else if (Maps.gamingTable[checkingY][checkingX] != 0 || Maps.gamingTable2[checkingY][checkingX] != 0){
            wallCollision = true;
            direction =2;
        } else {
            for (JLabel w :
                    Labels.walls) {
                if (labelMonster.getBounds().intersects(w.getBounds())) {
                    if (labelMonster.getX() + labelMonster.getWidth() < w.getX() + w.getWidth() && labelMonster.getX() + labelMonster.getWidth() > w.getX()) {
                        if (labelMonster.getY() + labelMonster.getHeight() / 2 > w.getY() && labelMonster.getY() + labelMonster.getHeight() / 2 < w.getY() + w.getHeight()) {
                            wallCollision = true;
                            direction = 2;
                        }

                    }
                }
            }
        }
        if (!wallCollision) {
            labelMonster.setLocation(x, labelMonster.getY());
            labelHitBoxMonster.setLocation(labelMonster.getX()+Labels.hitBoxDiference, labelMonster.getY()+Labels.hitBoxDiference);

        }
        return direction;
    }

    /**
     * movimiento del monstruo hacia la izquierda
     * @param labelMonster la JLabel que pertenece al monstruo
     * @param direction int que indica la dirección hacia la que está yendo el monstruo
     * @return int con la dirección hacia la que irá el monstruo
     */
    public int monsterMovingLeft(JLabel labelMonster,JLabel labelHitBoxMonster, int direction) {
       int x = labelMonster.getX()-this.speed;
        boolean wallCollision = false;
        int checkingY = labelMonster.getY()/Labels.TILE_SIZE;
        int checkingX = x/Labels.TILE_SIZE;

        if (labelHitBoxMonster.getBounds().intersects(Labels.labelHitBoxCharacter.getBounds())) {

       monsterAttack(labelMonster, labelHitBoxMonster);
        }


        if (labelMonster.getX() <= Panels.panelGaming.getX() + Labels.TILE_SIZE * 2) {
            wallCollision = true;
            direction = 1;
        }
        else  if (Maps.gamingTable[checkingY][checkingX] != 0 || Maps.gamingTable2[checkingY][checkingX] != 0){
            wallCollision = true;
            direction =1;
        }else {

            for (JLabel w :
                    Labels.walls) {
                if (labelMonster.getBounds().intersects(w.getBounds())) {
                    if (labelMonster.getX() < w.getX() + w.getWidth() && labelMonster.getX() > w.getX()) {
                        if (labelMonster.getY() + labelMonster.getHeight() / 2 > w.getY() && labelMonster.getY() + labelMonster.getHeight() / 2 < w.getY() + w.getHeight()) {
                            wallCollision = true;
                            direction = 1;
                        }
                    }
                }
            }
        }
        if (!wallCollision) {
            labelMonster.setLocation(x, labelMonster.getY());
            labelHitBoxMonster.setLocation(labelMonster.getX()+Labels.hitBoxDiference, labelMonster.getY()+Labels.hitBoxDiference);
        }
        return direction;
    }

    /**
     * movimiento del monstruo hacia arriba
     * @param labelMonster la JLabel que pertenece al monstruo
     * @param direction int que indica la dirección hacia la que está yendo el monstruo
     * @return int con la dirección hacia la que irá el monstruo
     */
    public int monsterMovingUp(JLabel labelMonster,JLabel labelHitBoxMonster, int direction) {
       int y = labelMonster.getY()-this.speed;
        boolean wallCollision = false;
        int checkingY = y/Labels.TILE_SIZE;
        int checkingX = labelMonster.getX()/Labels.TILE_SIZE;

        if (labelHitBoxMonster.getBounds().intersects(Labels.labelHitBoxCharacter.getBounds())) {
        monsterAttack(labelMonster, labelHitBoxMonster);}


        if (labelMonster.getY() <= Panels.panelGaming.getY() + Labels.TILE_SIZE * 2) {
            wallCollision = true;
            direction = 4;
        }
       else  if (Maps.gamingTable[checkingY][checkingX] != 0 || Maps.gamingTable2[checkingY][checkingX] != 0){
            wallCollision = true;
            direction =4;
        }else {
            for (JLabel w :
                    Labels.walls) {
                if (labelMonster.getBounds().intersects(w.getBounds())) {
                    if (labelMonster.getY() < w.getY() + w.getHeight() && labelMonster.getY() > w.getY()) {
                        if (labelMonster.getX() + labelMonster.getWidth() / 2 > w.getX() && labelMonster.getX() + labelMonster.getWidth() / 2 < w.getX() + w.getWidth()) {
                            wallCollision = true;
                            direction = 4;
                        }
                    }
                }
            }
        }
        if (!wallCollision) {
            labelMonster.setLocation(labelMonster.getX(), y);
            labelHitBoxMonster.setLocation(labelMonster.getX()+Labels.hitBoxDiference, labelMonster.getY()+Labels.hitBoxDiference);
        }

        return direction;
    }

    /**
     * movimiento del monstruo hacia abajo
     * @param labelMonster la JLabel que pertenece al monstruo
     * @param direction int que indica la dirección hacia la que está yendo el monstruo
     * @return int con la dirección hacia la que irá el monstruo
     */
    public int monsterMovingDown(JLabel labelMonster,JLabel labelHitBoxMonster, int direction) {
        int y = labelMonster.getY()+this.speed;
        boolean wallCollision = false;
        int checkingY = y/Labels.TILE_SIZE;
        int checkingX = labelMonster.getX()/Labels.TILE_SIZE;

        if (labelHitBoxMonster.getBounds().intersects(Labels.labelHitBoxCharacter.getBounds())) {

        monsterAttack(labelMonster, labelHitBoxMonster);}

        if (labelMonster.getY() + labelMonster.getHeight() >= Panels.panelGaming.getHeight() - Labels.TILE_SIZE * 2) {
            wallCollision = true;
            direction = 3;
        }
        else
        if (Maps.gamingTable[checkingY][checkingX] != 0 || Maps.gamingTable2[checkingY][checkingX] != 0){
            wallCollision = true;
            direction =3;
        }else {

            for (JLabel w :
                    Labels.walls) {
                if (labelMonster.getBounds().intersects(w.getBounds())) {
                    if (labelMonster.getY() + labelMonster.getHeight() < w.getY() + w.getHeight() && labelMonster.getY() + labelMonster.getHeight() > w.getY()) {
                        if (labelMonster.getX() + labelMonster.getWidth() / 2 > w.getX() && labelMonster.getX() + labelMonster.getWidth() / 2 < w.getX() + w.getWidth()) {
                            wallCollision = true;
                            direction = 3;
                        }
                    }
                }
            }
        }
        if (!wallCollision) {
            labelMonster.setLocation(labelMonster.getX(), y);
            labelHitBoxMonster.setLocation(labelMonster.getX()+Labels.hitBoxDiference, labelMonster.getY()+Labels.hitBoxDiference);
        }

        return direction;
    }

    /**
     * lo que ocurre cuando ataca el monstruo
     * @param labelMonster la JLabel que pertenece al monstruo
     */
    public void monsterAttack(JLabel labelMonster, JLabel labelHitBoxMonster){

        Dungeon.character.contactVSMonster(this, labelMonster, labelHitBoxMonster);
    }
}
