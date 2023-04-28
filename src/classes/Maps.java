package classes;

import dungeon.Dungeon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * engloba los mapas y algún método genérico
 */
public class Maps {

   public static int[][] gamingTable;
    public static int[][] gamingTable2;


    /**
     * chequea que el despliegue de una JLabel sea en un lugar sin muros
     * @param label la JLabel que queremos colocar
     */
    public static void checkingDeployimentColissionBorn(JLabel label) {
        int x, y;
        boolean colission;

        do {
            colission = false;
            //pongo 3/36 y 3/18 por el tema de los muros (así ya los descarto directamente)
            x = (int) (Math.random() * (36 - 3 + 1) + 3);
            y = (int) (Math.random() * (18 - 3 + 1) + 3);

            if (gamingTable[y][x] != 0 || gamingTable2[y][x] != 0) {
                colission = true;
            } else {
                x *= Labels.TILE_SIZE;
                y *= Labels.TILE_SIZE;
                label.setLocation(x, y);
                if (x <= Labels.TILE_SIZE * 7) {
                    if (y >= Labels.TILE_SIZE * 15) {
                        colission = true;
                    }
                } else {

                    for (JLabel w : Labels.walls) {

                        colission = label.getBounds().intersects(w.getBounds()) ||
                                label.getBounds().intersects(Labels.labelCharacter.getBounds());

                    }
                }
            }
        } while (colission);
    }

    /**
     * método para creación rápida de imágenes/iconos
     *
     * @param label  JLabel en la que queremos incluir la imagen
     * @param url    String con la dirección donde está la imagen
     * @param width  int con el ancho que queremos para la imagen
     * @param height int con la altura de la imagen que queremos
     * @param panel  JPanel donde queremos introducir la imagen
     */
    public static void labelIconCreation(JLabel label, String url, int width, int height, JPanel panel) {
        label.setSize(width, height);
        ImageIcon imageIcon = new ImageIcon(url);
        Icon icon = new ImageIcon(
                imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)
        );
        label.setIcon(icon);
        panel.add(label);

    }

    /**
     * cambia el icono de una label
     *
     * @param url   String con la dirección de la imagen
     * @param label JLabel que se quiere modificar
     */
    public static void changingIconInALabel(String url, JLabel label) {
        ImageIcon imageIcon = new ImageIcon(url);
        Icon icon = new ImageIcon(
                imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)
        );
        label.setIcon(icon);
    }

    /*--------------------------------------MAPS----38 X 20-----------------------------------------------------------------*/

    /**
     * crea los muros que estarán por delante del personaje
     */
    public static void paintingWalls() {

        Labels.walls = new ArrayList<>();
        int tilePositionY = 0;
        int tilePositionX;


        gamingTable =
                new int[][]{{10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 17, 13, 14, 1, 1, 1, 3},
                        {9, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 16, 0, 15, 2, 2, 2, 4},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 1, 1, 1, 1, 3, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 0, 10, 1, 1, 1, 1, 0, 0, 0, 0, 35, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 29, 18, 19, 20, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 8, 0, 0, 0, 0, 28, 30, 31, 21, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 5},
                        {8, 0, 0, 10, 1, 1, 1, 0, 0, 0, 5, 0, 0, 0, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 37, 0, 0, 0, 0, 4, 0, 0, 5},
                        {8, 0, 0, 9, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 0, 0, 0, 0, 5, 0, 0, 5},
                        {8, 0, 0, 8, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 5},
                        {8, 0, 0, 7, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 1, 1, 1, 1, 6, 0, 0, 0, 0, 0, 0, 5, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                        {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                        {7, 1, 17, 13, 14, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6},
                        {12, 2, 16, 0, 15, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 11}};


        for (int i = 0; i < 20; i++) {
            tilePositionX = 0;
            for (int j = 0; j < 38; j++) {
                Labels.labelFloor = new JLabel();
                switch (gamingTable[i][j]) {
                    case 0:
                        break;
                    case 1:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/1_arribaYAbajo.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 2:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/2_baseArribaYabajo.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 3:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/3_esquinaAD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 4:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/4_derechaAr.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 5:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/5_derechaAb.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 6:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/6_esquinaAbD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 7:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/7_esquinaAbI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 8:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/8_izq.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 9:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/9_izqAr.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 10:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/10_esqAI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 11:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/11_baseAbD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 12:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/12_baseAbI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 13:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/puerta/13_puertaArriba.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 14:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/puerta/14_puertaArribaD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 15:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/puerta/15_puertaAbajoD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 16:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/puerta/16_puertaAbajoI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 17:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/puerta/17_puertaArribaI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 18:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/18_arI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 19:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/19_ArD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 20:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/20_DAr.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        //Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 21:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/21_esqArD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 28:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/28_IAr.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 29:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/29_esqIAr.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 30:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/30_centroIzqAr.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 31:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/31_centroDar.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 32:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/32_centroDAb.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 33:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/33_centroIAb.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 34:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/columna/34_ar.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 35:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/columna/35_cent.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 37:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/columna2/37_ar.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        //Labels.walls.add(Labels.labelFloor);
                        break;
                    case 38:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/columna2/38_cent.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                }

                tilePositionX += Labels.TILE_SIZE;
            }
            tilePositionY += Labels.TILE_SIZE;
        }

    }

    /**
     * crea los muros que estarán por detrás del personaje
     */
    public static void paintingWalls2() {

        int tilePositionY = 0;
        int tilePositionX;


        gamingTable2 =
                new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 2, 2, 2, 2, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0,0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 36, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 36, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27, 33, 32, 22, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 26, 25, 24, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 0, 0, 0},
                        {0, 0, 0, 9, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 2, 2, 2, 2, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 11, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


        for (int i = 0; i < 20; i++) {
            tilePositionX = 0;
            for (int j = 0; j < 38; j++) {
                Labels.labelFloor = new JLabel();
                switch (gamingTable2[i][j]) {
                    case 0:
                        break;
                    case 2:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/2_baseArribaYabajo.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 4:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/4_derechaAr.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 11:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/11_baseAbD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 12:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/12_baseAbI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 22:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/22_Dab.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 23:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/23_esqAbD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 24:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/24_abD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 25:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/25_abI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 26:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/26_esqAbI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 27:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/27_IAb.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 32:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/32_centroDAb.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 33:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/arbol/33_centroIAb.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 36:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/columna/36_ab.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 39:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/columna2/39_ab.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;
                    case 40:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/muro/columna2/40_derruida.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        Labels.walls.add(Labels.labelFloor);
                        break;


                }

                tilePositionX += Labels.TILE_SIZE;
            }
            tilePositionY += Labels.TILE_SIZE;
        }

    }


    /**
     * crea los suelos
     */
    public static void paintingFloor() {
        int tilePositionY = 0;
        int tilePositionX;


        int[][] gamingTableFloor =
                {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 8, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 7, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 7, 9, 9, 5, 5, 4, 0, 0, 0, 0, 0, 0, 0, 8, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 7, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 7, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 6, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 1, 1, 1, 9, 9, 9, 9, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 8, 1, 2, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 5, 5, 9, 9, 9, 9, 5, 5, 5, 4, 0, 0, 0, 0, 0, 0, 0, 7, 9, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 8, 1, 1, 9, 9, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 9, 9, 3, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 5, 5, 5, 4, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


        for (int i = 0; i < 20; i++) {
            tilePositionX = 0;
            for (int j = 0; j < 38; j++) {
                Labels.labelFloor = new JLabel();
                switch (gamingTableFloor[i][j]) {
                    case 0:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/9_sueloPrueba.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 1:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/1_arriba.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 2:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/2_esquinaAD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 3:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/3_derecha.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 4:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/4_esquinaAbD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 5:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/5_abajo.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 6:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/6_esquinaAbI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 7:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/7_izq.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 8:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/8_esqAI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 9:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/suelo/0_suelo.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;


                }

                tilePositionX += Labels.TILE_SIZE;
            }
            tilePositionY += Labels.TILE_SIZE;
        }


    }

    public static void paintingGrass(){
        int tilePositionY = 0;
        int tilePositionX;
        int[][] grassPanel =
                {       {8, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 1, 2},
                        {7, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 3},
                        {7, 9, 9, 9, 9, 3, 8, 1, 1, 1, 1, 1, 2, 0, 0, 0, 8, 1, 1, 2, 7, 9, 3, 8, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 2, 7, 9, 3},
                        {7, 9, 9, 9, 9, 3, 7, 9, 9, 9, 9, 9, 3, 0, 0, 0, 7, 9, 9, 3, 7, 9, 3, 7, 9, 9, 9, 9, 9, 9, 9, 9, 7, 9, 3, 7, 9, 3},
                        {7, 9, 9, 9, 9, 3, 6, 5, 5, 5, 5, 5, 4, 0, 0, 0, 7, 9, 9, 3, 7, 9, 3, 7, 9, 2, 8, 9, 3, 0, 0, 0, 7, 9, 3, 7, 9, 3},
                        {6, 5, 5, 5, 5, 4, 0, 0, 0, 0, 0, 0, 8, 1, 1, 1, 9, 9, 9, 3, 7, 9, 3, 7, 9, 3, 7, 9, 3, 0, 0, 0, 7, 9, 3, 7, 9, 3},
                        {0, 0, 0, 0, 0, 0, 8, 1, 1, 1, 2, 0, 7, 9, 9, 9, 9, 9, 9, 3, 7, 9, 3, 7, 9, 3, 7, 9, 3, 0, 0, 0, 6, 5, 4, 7, 9, 3},
                        {0, 0, 0, 0, 0, 0, 7, 9, 9, 9, 3, 0, 7, 9, 9, 9, 9, 9, 9, 3, 7, 9, 3, 7, 9, 3, 6, 5, 4, 0, 0, 0, 0, 0, 0, 7, 9, 3},
                        {0, 0, 8, 1, 2, 0, 7, 9, 9, 9, 3, 0, 7, 9, 9, 9, 9, 9, 9, 3, 7, 9, 3, 7, 9, 3, 0, 8, 1, 1, 1, 1, 1, 1, 2, 7, 9, 3},
                        {0, 0, 7, 9, 3, 0, 7, 9, 9, 9, 3, 0, 7, 9, 9, 9, 9, 9, 9, 3, 6, 5, 4, 7, 9, 3, 0, 7, 9, 9, 9, 9, 9, 9, 3, 7, 9, 3},
                        {0, 0, 7, 9, 3, 0, 7, 9, 9, 9, 3, 0, 6, 5, 5, 5, 5, 5, 5, 4, 0, 0, 0, 6, 5, 4, 0, 7, 9, 9, 9, 9, 9, 9, 3, 7, 9, 3},
                        {0, 0, 7, 9, 3, 0, 7, 9, 9, 9, 3, 8, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 9, 5, 5, 5, 5, 4, 7, 9, 3},
                        {0, 0, 7, 9, 3, 0, 7, 9, 9, 9, 3, 7, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 9, 3, 0, 0, 0, 0, 0, 6, 5, 4},
                        {0, 0, 7, 9, 3, 0, 7, 9, 9, 9, 3, 7, 9, 9, 9, 9, 3, 8, 1, 1, 1, 1, 1, 1, 2, 0, 0, 7, 9, 3, 8, 1, 1, 1, 1, 1, 2, 0},
                        {0, 0, 6, 5, 4, 0, 7, 9, 9, 9, 3, 6, 5, 5, 5, 5, 4, 7, 9, 9, 9, 9, 9, 9, 3, 0, 0, 7, 9, 3, 7, 9, 9, 9, 9, 9, 3, 0},
                        {8, 1, 1, 1, 1, 2, 7, 9, 9, 9, 3, 0, 0, 0, 0, 0, 0, 6, 5, 5, 5, 5, 5, 5, 4, 0, 0, 6, 5, 4, 7, 9, 9, 9, 9, 9, 3, 0},
                        {7, 9, 9, 9, 9, 3, 7, 9, 9, 9, 3, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 6, 5, 5, 5, 5, 5, 4, 0},
                        {7, 9, 9, 9, 9, 3, 6, 5, 5, 5, 4, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {7, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {6, 5, 5, 5, 5, 4, 0, 0, 0, 0, 0, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


        for (int i = 0; i < 20; i++) {
            tilePositionX = 0;
            for (int j = 0; j < 38; j++) {
                Labels.labelFloor = new JLabel();
                switch (grassPanel[i][j]) {
                    case 0:
                        break;
                    case 1:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/1_hierbaAr.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 2:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/2_hierbaArD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 3:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/3_hierbaD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 4:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/4_hierbaAbD.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 5:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/5_hierbaAb.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 6:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/6_hierbaAbI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 7:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/7_hierbaI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 8:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/8_hierbaArI.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;
                    case 9:
                        Maps.labelIconCreation(Labels.labelFloor, "src/img/hierba/9_hierbaCent.png", Labels.TILE_SIZE, Labels.TILE_SIZE, Panels.panelGaming);
                        Labels.labelFloor.setLocation(tilePositionX, tilePositionY);
                        break;


                }

                tilePositionX += Labels.TILE_SIZE;
            }
            tilePositionY += Labels.TILE_SIZE;
        }

    }
}