package classes.characters;

import classes.Labels;
import classes.Maps;
import classes.Panels;
import classes.items.Item;
import classes.items.Medallion;
import classes.items.MagicStaff;
import classes.items.Sword;
import classes.monsters.Monster;

import javax.swing.*;
import java.util.ArrayList;

/**
 * clase abstracta que engloba los personajes
 */
public abstract class Character {

     protected String name;
     protected String upLooking;
     protected String downLooking;
     protected String leftLooking;
     protected String rightLooking;
     protected int lives;
     protected int gold;
     protected int speed;
     protected String type;
     protected ArrayList<Item> inventory;
     protected int time;
     protected boolean dead;
     protected boolean win;
     public Character() {
     }

     public boolean isWin() {
          return win;
     }

     public void setWin(boolean win) {
          this.win = win;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getLives() {
          return lives;
     }

     public void setLives(int lives) {
          this.lives = lives;
     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }


     public int getTime() {
          return time;
     }

     public void setTime(int time) {
          this.time = time;
     }

     public int getGold() {
          return gold;
     }

     public void setGold(int gold) {
          this.gold = gold;
     }

     public int getSpeed() {
          return speed;
     }

     public void setSpeed(int speed) {
          this.speed = speed;
     }

     public ArrayList<Item> getInventory() {
          return inventory;
     }

     public void setInventory(ArrayList<Item> inventory) {
          this.inventory = inventory;
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

     public boolean isDead() {
          return dead;
     }

     public void setDead(boolean dead) {
          this.dead = dead;
     }

     @Override
     public String toString() {
          return this.name.toUpperCase()+ " || "+
                  "Clase: "+this.type+ " | "+
                  "Oro: "+ this.gold+ " | "+
                  "Vidas: " + this.lives + " | "+
                  "Tiempo: " + this.time+ " | "+
                  "Misión cumplida: "+this.win;
     }

     /**
      * indica lo que ocurrirá cuando el personaje colisiona con un monstruo
      * @param monster objeto Monster con el que colisiona
      * @param labelMonster JLabel del monstruo con el que colisiona
      */
     public void contactVSMonster(Monster monster, JLabel labelMonster, JLabel labelHitBoxMonster){
     }

     /**
      * el proceso de recibir daño de un personaje (cambio en el panel de stats y en el atributo lives)
      * @param monster objeto de Monster del que recibe el daño
      */
     public void sufferDamage(Monster monster){
          int arraySize;

          //Es la posición de inicio
          this.lives = this.lives - monster.getDamage();


          for (int i = 0; i < monster.getDamage(); i++) {
               arraySize = Labels.labelHearts.size();
               //borra el corazón del array
               if (arraySize > 0) {
                    Labels.labelHearts.get(arraySize - 1).setVisible(false);
                    Labels.labelHearts.remove(arraySize - 1);
               }
          }
          Labels.labelCharacter.setLocation(Labels.TILE_SIZE * 3, Labels.TILE_SIZE * 17);
          Labels.labelHitBoxCharacter.setLocation(Labels.labelCharacter.getX()+Labels.hitBoxDiference, Labels.labelCharacter.getY()+Labels.hitBoxDiference);



          if(this.lives <=0){
               this.lives = 0;
               this.dead = true;
          }

     }


     /**
      * lo que ocurre cuando entra en contacto con el oro
      */
     public void takingGold(){

          if (Labels.labelHitBoxCharacter.getBounds().intersects(Labels.labelGold.getBounds())){
               this.gold += 10;
               Labels.labelGoldText.setText("Oro obtenido: "+this.gold);
               Maps.checkingDeployimentColissionBorn(Labels.labelGold);
          }
     }

     /**
      * lo que ocurre cuando entra en contacto con la espada
      */
     public void takingSword(){
          if (Labels.labelHitBoxCharacter.getBounds().intersects(Labels.labelSword.getBounds())){


               Sword sword = new Sword();

               if(!this.inventory.contains(sword)){
                    this.inventory.add(sword);
                    Labels.labelSwordStats.setVisible(true);}


               Labels.labelSword.setVisible(false);
               Labels.labelSword.setBounds(1,1,1,1);
               Labels.labelSword.setLocation(0,0);


          }
     }

     /**
      * lo que ocurre cuando entra en contacto con el bastón mágico
      */
     public void takingMagicStaff(){
          if (Labels.labelHitBoxCharacter.getBounds().intersects(Labels.labelMagicStaff.getBounds())){


               MagicStaff magicStaff = new MagicStaff();

               if (!this.inventory.contains(magicStaff)){
                    this.inventory.add(magicStaff);
                    Labels.labelMagicStaffStats.setVisible(true);}


               Labels.labelMagicStaff.setVisible(false);
               Labels.labelMagicStaff.setBounds(1,1,1,1);
               Labels.labelMagicStaff.setLocation(0,0);

          }
     }

     /**
      * lo que ocurre cuando entra en contacto con el medallón
      */
     public void takingMedallion(){
          if (Labels.labelHitBoxCharacter.getBounds().intersects(Labels.labelMedallion.getBounds())){


               Medallion medallion = new Medallion();

               if(!this.inventory.contains(medallion)){
                    this.inventory.add(medallion);
                    Labels.labelMedallionStats.setVisible(true);
               }



               Labels.labelMedallion.setVisible(false);
               Labels.labelMedallion.setBounds(1,1,1,1);
               Labels.labelMedallion.setLocation(0,0);

          }
     }

     /**
      * movimiento del personaje hacia la derecha
      */
     public void characterMovingRight(){
          int x = Labels.labelCharacter.getX()+this.speed;
          boolean wallCollision = false;


          if (Labels.labelCharacter.getX() + Labels.labelCharacter.getWidth() >= Panels.panelGaming.getWidth()-Labels.TILE_SIZE) {
               wallCollision = true;

          }else{
               for (JLabel w :
                       Labels.walls) {
                    if (Labels.labelCharacter.getBounds().intersects(w.getBounds())) {
                         if (Labels.labelCharacter.getX() + Labels.labelCharacter.getWidth() < w.getX() + w.getWidth() && Labels.labelCharacter.getX() + Labels.labelCharacter.getWidth() > w.getX()) {
                              if (Labels.labelCharacter.getY()+Labels.labelCharacter.getHeight()/2 > w.getY() && Labels.labelCharacter.getY()+Labels.labelCharacter.getHeight()/2 < w.getY()+w.getHeight()){
                                   wallCollision = true;}

                         }
                    }
               }}
          if (!wallCollision) {
               Labels.labelCharacter.setLocation(x, Labels.labelCharacter.getY());
               Labels.labelHitBoxCharacter.setLocation(Labels.labelCharacter.getX()+Labels.hitBoxDiference, Labels.labelCharacter.getY()+Labels.hitBoxDiference);
          }

     }

     /**
      * movimiento del personaje hacia la izquierda
      */
     public void characterMovingLeft(){
          int x = Labels.labelCharacter.getX()-this.speed;
          boolean wallCollision = false;

          if (Labels.labelCharacter.getX() <= Panels.panelGaming.getX()-Panels.panelStats.getWidth()) {
               wallCollision = true;
          } else {
               for (JLabel w :
                       Labels.walls) {
                    if (Labels.labelCharacter.getBounds().intersects(w.getBounds())) {
                         if (Labels.labelCharacter.getX() < w.getX() + w.getWidth() && Labels.labelCharacter.getX() > w.getX()) {
                              if (Labels.labelCharacter.getY()+Labels.labelCharacter.getHeight()/2 > w.getY() && Labels.labelCharacter.getY()+Labels.labelCharacter.getHeight()/2 < w.getY()+w.getHeight()){
                                   wallCollision = true;}
                         }
                    }
               }}
          if (!wallCollision) {
               Labels.labelCharacter.setLocation(x, Labels.labelCharacter.getY());
               Labels.labelHitBoxCharacter.setLocation(Labels.labelCharacter.getX()+Labels.hitBoxDiference, Labels.labelCharacter.getY()+Labels.hitBoxDiference);
          }

     }

     /**
      * movimiento del personaje hacia arriba
      */
     public void characterMovingUp(){
          boolean wallCollision = false;
          int y = Labels.labelCharacter.getY()-this.speed;

          if (Labels.labelCharacter.getY() <= Panels.panelGaming.getY() + Labels.TILE_SIZE) {
               wallCollision = true;
          } else {
               for (JLabel w :
                       Labels.walls) {
                    if (Labels.labelCharacter.getBounds().intersects(w.getBounds())) {
                         if (Labels.labelCharacter.getY() < w.getY() + w.getHeight() && Labels.labelCharacter.getY() > w.getY()) {
                              if (Labels.labelCharacter.getX()+Labels.labelCharacter.getWidth()/2 > w.getX() && Labels.labelCharacter.getX()+Labels.labelCharacter.getWidth()/2 < w.getX()+w.getWidth()){
                                   wallCollision = true;}
                         }
                    }
               }}
          if (!wallCollision) {
               Labels.labelCharacter.setLocation(Labels.labelCharacter.getX(), y);
               Labels.labelHitBoxCharacter.setLocation(Labels.labelCharacter.getX()+Labels.hitBoxDiference, Labels.labelCharacter.getY()+Labels.hitBoxDiference);
          }


     }

     /**
      * movimiento del personaje hacia abajo
      */
     public void characterMovingDown() {
          int y = Labels.labelCharacter.getY()+this.speed;
          boolean wallCollision = false;


          if (Labels.labelCharacter.getY() + Labels.labelCharacter.getHeight() >= Panels.panelGaming.getHeight() - Labels.TILE_SIZE) {
               wallCollision = true;

          } else {
               for (JLabel w :
                       Labels.walls) {
                    if (Labels.labelCharacter.getBounds().intersects(w.getBounds())) {
                         if (Labels.labelCharacter.getY() + Labels.labelCharacter.getHeight() < w.getY() + w.getHeight() && Labels.labelCharacter.getY() + Labels.labelCharacter.getHeight() > w.getY()) {
                              if (Labels.labelCharacter.getX()+Labels.labelCharacter.getWidth()/2 > w.getX() && Labels.labelCharacter.getX()+Labels.labelCharacter.getWidth()/2 < w.getX()+w.getWidth()){
                                   wallCollision = true;}
                         }
                    }
               }}
          if (!wallCollision) {
               Labels.labelCharacter.setLocation(Labels.labelCharacter.getX(), y);
               Labels.labelHitBoxCharacter.setLocation(Labels.labelCharacter.getX()+Labels.hitBoxDiference, Labels.labelCharacter.getY()+Labels.hitBoxDiference);
          }

     }

}
