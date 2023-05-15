package classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * engloba casi todas las JLabels del panel de stats y del panel de juego
 */
public class Labels {

    public static JLabel labelName, labelCharacterStats,labelSwordStats, labelMagicStaffStats, labelMedallionStats, labelGoldText, labelDragon;
    private static JLabel labelLives, labelBag, labelGoldStats, labelDivisionLine, labelDivisionLine2;
    public static ArrayList<JLabel> labelHearts;

    public final static int MARGIN=8;

    //labels de panel de juego---------------------------------------------------------------------------------
    public static JLabel labelCharacter, labelFloor, labelSkeleton,
            labelSword, labelMagicStaff, labelMedallion,
            labelGold, labelHitBoxCharacter, labelHitBoxMonster,  labelHitBoxDragon;

    //el botón de pausa (no sé en qué clase meterlo)
    public static JButton buttonPause;

    public static int hitBoxDiference = 12;

    public static final int TILE_SIZE = 32;

    public static ArrayList<JLabel> walls;
    public static ArrayList<JLabel> labelsSkels;

    public static ArrayList<JLabel> labelsHitBoxMonsters;


    /**
     * muestra las JLabels del panel de stats
     */
    public static void showStatsLabels() {


        //Establecemos la label del nombre
        showLabelName();

        //establecemos label de la imagen del personaje en las stats (escogemos el contenido
        //a partir de un JPaneOption en el FrameWindowListener)
        showLabelCharacterStats();

        //establecemos la label vidas
        showLabelLives();

        //labels de vidas
        //Se queda en comentarios porque la función creo que se tiene que llamar después de escoger pj
        //tengo que dejarlo aquí porque si no me da error. En el listener lo arreglo con la cantidad y parece que no hay problema
        showLabelHearts(1);
        //labelHearts.get(0).setVisible(false);

        //línea divisoria
        showLabelDivLine();

        //label de la mochila
        showLabelBag();

        //establecemos la label inventario
        //showLabelInventory();

        //label del icono de la espada
        showLabelSwordStats();

        //label del icono de la poción
        showLabelMagicStaffStats();

        //label del icono de la mitra
        showLabelMedallionStats();

        //línea divisoria 2
        showLabelDivLine2();

        //la label con el icono del oro
        showLabelGold();

        //establecemos la label oro
        showLabelGoldText();





        //la idea es ir haciendo las labels visibles o no en base a si se tienen en posesión o no (o si te quitan vidas)
        // Imagino que podré usar un boolean para determinar las acciones
        // Algo así -> boolean x = label.getvisible(true)

    }


    /**
     * Crea la etiqueta donde estará el nombre
     */
    private static void showLabelName(){
        labelName = new JLabel();

        //No lo seteo aquí el texto, ya que se hará desde un JPaneOption en el FrameWindowListener
        //labelName.setText("Nombre");
        labelName.setSize(Panels.panelStats.getWidth(), 80);
        labelName.setLocation(0, TILE_SIZE/2);
        labelName.setFont(new Font("Serif", Font.ITALIC, 20));
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        labelName.setVerticalAlignment(SwingConstants.TOP);
        labelName.setForeground(Color.white);
        Panels.panelStats.add(labelName);
    }


    /**
     * crea la etiqueta de la imagen que habrá en las stats
     */
    private static void showLabelCharacterStats() {
        labelCharacterStats = new JLabel();
        Maps.labelIconCreation(labelCharacterStats, null,
                Panels.panelStats.getWidth()-MARGIN*2, Panels.panelStats.getWidth()-MARGIN*2, Panels.panelStats);
        labelCharacterStats.setLocation(MARGIN, 64);
    }

    /**
     * crea la etiqueta con el texto "Vidas:"
     */
    private static void showLabelLives() {
        labelLives = new JLabel();
        labelLives.setText("Vidas:");
        labelLives.setSize(Panels.panelStats.getWidth()-MARGIN, 50);
        labelLives.setLocation(MARGIN, labelCharacterStats.getY()+labelCharacterStats.getHeight()+MARGIN);
        labelLives.setFont(new Font("Serif", Font.ITALIC, 20));
        labelLives.setForeground(Color.white);
        Panels.panelStats.add(labelLives);
        //labelLives.setVisible(false);

    }






    /**
     * Crea la sucesión de etiquetas de corazones
     */
    public static void showLabelHearts(int characterLives) {
        int xHeartPosition = MARGIN;
        labelHearts = new ArrayList<>();
        for (int i = 0; i < characterLives; i++) {
           JLabel labelHeart = new JLabel();

           //pongo el if para que no se muestre el corazón de la primera creación del arrayList
           if (characterLives !=1){
            Maps.labelIconCreation(labelHeart, "src/img/dungeon/heart.png", 12, 12, Panels.panelStats);
           }
            labelHearts.add(labelHeart);
            labelHearts.get(i).setLocation(xHeartPosition, labelLives.getY() + labelLives.getHeight());
            xHeartPosition += labelHearts.get(i).getWidth()+MARGIN;
        }
    }

    /**
     * Crea la etiqueta con la línea divisoria
     */
    private static void showLabelDivLine() {
        labelDivisionLine = new JLabel();
        Maps.labelIconCreation(labelDivisionLine, "src/img/statsLabels/pruebaDivisoria.png", Panels.panelStats.getWidth(), 30, Panels.panelStats);
        labelDivisionLine.setLocation(0, 325);
        //labelDivisionLine.setVisible(false);
    }


    /**
     * crea la etiqueta con la imagen de la mochila (para el inventario)
     */
    private static void showLabelBag() {
        labelBag = new JLabel();
        Maps.labelIconCreation(labelBag, "src/img/statsLabels/bag.png", 40, 40, Panels.panelStats);
        labelBag.setLocation(MARGIN, labelDivisionLine.getY() + labelDivisionLine.getHeight());
        //labelBag.setVisible(false);
    }



    /**
     * crea la etiqueta con la imagen de la espada para las stats
     */
    private static void showLabelSwordStats() {
        labelSwordStats = new JLabel();
        Maps.labelIconCreation(labelSwordStats, "src/img/dungeon/sword.png", 32, 32, Panels.panelStats);
        labelSwordStats.setLocation(Panels.panelStats.getWidth() / 2 - labelSwordStats.getWidth() / 2, labelBag.getY() + labelBag.getHeight());
        labelSwordStats.setVisible(false);
    }

    /**
     * crea la etiqueta con la imagen del bastón para las stats
     */
    private static void showLabelMagicStaffStats() {
        labelMagicStaffStats = new JLabel();
        Maps.labelIconCreation(labelMagicStaffStats, "src/img/dungeon/magicStaff.png", 32, 32, Panels.panelStats);
        labelMagicStaffStats.setLocation(Panels.panelStats.getWidth() / 2 - labelSwordStats.getWidth() / 2,labelSwordStats.getY()+labelSwordStats.getHeight()+8);
        labelMagicStaffStats.setVisible(false);
    }


    /**
     * crea la etiqueta con la imagen del medallón para las stats
     */
    private static void showLabelMedallionStats() {
        labelMedallionStats = new JLabel();
        Maps.labelIconCreation(labelMedallionStats, "src/img/dungeon/medallion.png", 32, 32, Panels.panelStats);
        labelMedallionStats.setLocation(Panels.panelStats.getWidth() / 2 - labelSwordStats.getWidth() / 2, labelMagicStaffStats.getY()+ labelMagicStaffStats.getHeight()+8);
        labelMedallionStats.setVisible(false);
    }

    /**
     * crea la etiqueta con la segunda línea divisoria
     */
    private static void showLabelDivLine2() {
        labelDivisionLine2 = new JLabel();
        Maps.labelIconCreation(labelDivisionLine2, "src/img/statsLabels/pruebaDivisoria.png", Panels.panelStats.getWidth(), 30, Panels.panelStats);
        labelDivisionLine2.setLocation(0, labelMedallionStats.getY() + labelMedallionStats.getHeight());
        //labelDivisionLine2.setVisible(false);
    }

    /**
     * crea la etiqueta con la imagen del oro para las stats
     */
    private static void showLabelGold() {
        labelGoldStats = new JLabel();
        Maps.labelIconCreation(labelGoldStats, "src/img/dungeon/treasure.png", 45, 45, Panels.panelStats);
        labelGoldStats.setLocation(Panels.panelStats.getWidth()/2-labelGoldStats.getWidth()/2,labelDivisionLine2.getY()+labelDivisionLine2.getHeight());
        //labelGoldStats.setVisible(false);
    }

    /**
     * crea la etiqueta con el texto "oro obtenido:"
     */
    private static void showLabelGoldText() {
        labelGoldText = new JLabel();
        labelGoldText.setText("Oro obtenido:");
        labelGoldText.setLocation(MARGIN,labelGoldStats.getY()+labelGoldStats.getHeight());
        labelGoldText.setSize(Panels.panelStats.getWidth()-MARGIN,32);
        labelGoldText.setForeground(Color.white);
        Panels.panelStats.add(labelGoldText);
        //labelGoldText.setVisible(false);
    }





//AQUÍ EMPIEZAN LAS LABELS DEL PANEL DE JUEGO--------------------------------------------------------------



    /**
     * contiene todas las labels del panel de juego
     */
    public static void showGamingLabels() {
    int maybeGrass  = (int) (Math.random() * (2));


        //creación del dragón
        labelDragon = new JLabel();
        Maps.labelIconCreation(labelDragon, "src/img/dungeon/dragon_left.gif", 192, 128, Panels.panelGaming);
        labelDragon.setLocation(Panels.panelGaming.getWidth(), Panels.panelGaming.getHeight());
        //hitBox del dragón
        labelHitBoxDragon = new JLabel();
        labelHitBoxDragon.setSize(labelDragon.getWidth()-hitBoxDiference,labelDragon.getHeight()-hitBoxDiference);
        Panels.panelGaming.add(labelHitBoxDragon);


        //creación de label de botón de pausa
        buttonPause = new JButton();
        buttonPause.setText("Pausa");
        //establece que no se quede marcado el botón al pulsarlo
        buttonPause.setFocusPainted(false);
        //cambia el color de fondo añadiendo un nuevo color con el sistema RGB
        buttonPause.setBackground(new Color(61, 60, 59));
        //cambia el color de la letra a un color ya establecido
        buttonPause.setForeground(Color.white);
        buttonPause.setSize(100,TILE_SIZE);
        buttonPause.setLocation(Panels.panelGaming.getWidth()/2-buttonPause.getWidth()/2,0);
        Panels.panelGaming.add(buttonPause);


        Maps.paintingWalls();

        //label del personaje
        labelCharacter = new JLabel();
        //pongo null en la url para modificarla dependiendo de la elección del jugador
        Maps.labelIconCreation(labelCharacter, null, 48, 48, Panels.panelGaming);
        labelCharacter.setLocation(TILE_SIZE*3, TILE_SIZE*18);

        //hitBox del personaje
        labelHitBoxCharacter = new JLabel();
        labelHitBoxCharacter.setSize(labelCharacter.getWidth()-hitBoxDiference,labelCharacter.getHeight()-hitBoxDiference);
        labelHitBoxCharacter.setLocation(labelCharacter.getX()+hitBoxDiference, labelCharacter.getY()+hitBoxDiference);
        Panels.panelGaming.add(labelHitBoxCharacter);


        //labels de monstruos y sus hitBox
         labelsSkels = new ArrayList<>();
        labelsHitBoxMonsters = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            labelHitBoxMonster = new JLabel();
            labelSkeleton = new JLabel();
            Maps.labelIconCreation(labelSkeleton, null, 32, 48, Panels.panelGaming);
            labelsSkels.add(labelSkeleton);
            labelHitBoxMonster.setSize(labelSkeleton.getWidth()-hitBoxDiference,labelSkeleton.getHeight()-hitBoxDiference);
            labelsHitBoxMonsters.add(labelHitBoxMonster);
        }



        //colocación de espada en el tablero
        labelSword = new JLabel();
            Maps.labelIconCreation(labelSword, "src/img/dungeon/sword.png", 20, 20, Panels.panelGaming);

        //colocación de poción en el tablero
        labelMagicStaff = new JLabel();
        Maps.labelIconCreation(labelMagicStaff, "src/img/dungeon/magicStaff.png", 20, 20, Panels.panelGaming);

        //colocación de mitra en el tablero
        labelMedallion = new JLabel();
        Maps.labelIconCreation(labelMedallion, "src/img/dungeon/medallion.png", 20, 20, Panels.panelGaming);


        //colocación de oro en el tablero
        labelGold = new JLabel();
        Maps.labelIconCreation(labelGold, "src/img/dungeon/gold.png", 20, 20, Panels.panelGaming);


        Maps.paintingWalls2();
        //Creación de suelo


        if (maybeGrass == 0){
        Maps.paintingGrass();}

        Maps.paintingFloor();

        Maps.checkingDeployimentColissionBorn(labelSword);
        Maps.checkingDeployimentColissionBorn(labelMagicStaff);
        Maps.checkingDeployimentColissionBorn(labelMedallion);
        Maps.checkingDeployimentColissionBorn(labelGold);


        for (JLabel m : labelsSkels
        ) {
            Maps.checkingDeployimentColissionBorn(m);
        }
        for (int i = 0; i < 10; i++) {

            labelsHitBoxMonsters.get(i).setLocation(labelsSkels.get(i).getX()+hitBoxDiference, labelsSkels.get(i).getY()+hitBoxDiference);
        }

    }


}
