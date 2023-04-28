package classes;
import javax.swing.*;
import java.awt.*;

/**
 * contiene el panel de juego y el panel de stats
 */
public class Panels {

    //Panel de stats
    public static JPanel panelStats;

    //Panel de juego
    public static JPanel panelGaming;

    private static final int MAX_HEIGHT = 640;
    private static final int MAX_WIDTH = 1344;






    /**
     * crea el panelMain
     * @param panelMain JPanel con el panel Main para poder modificarlo
     */
    public static void createPanelMain(JPanel panelMain){

        //dimensiones (42 (4 de éstas son para stats) casillas * 20 casillas)
        panelMain.setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
        panelMain.setSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));

        //establecemos el layout (ponemos null, ya que el grid layout tendrá que ser en el panel de juego)
        panelMain.setLayout(null);

        //Con el setFocusable permitimos que el teclado haga efecto en el panelMain
        //Hay que hacer un requestFocus cuando se hace clic en pausa para reanudar
        panelMain.setFocusable(true);


    }


    /**
     * Contiene el panel de stats
     */
    public static void createPanelStats() {

        //declaramos un nuevo JPanel
        panelStats = new JPanel();

        //lo establecemos a invisible hasta que el jugador escoja all
        panelStats.setVisible(false);

        //establecemos posición
        panelStats.setLocation(0, 0);

        //establecemos tamaño
        panelStats.setSize(128, MAX_HEIGHT);


        //ponemos un color de fondo (por ahora)
        panelStats.setBackground(new Color(61,60,59));

       //establecemos el layout
        panelStats.setLayout(null);

        Labels.showStatsLabels();

    }

    /**
     * contiene el panel de juego
     */
    public static void createPanelGaming() {
        //declaramos un nuevo JPanel
        panelGaming = new JPanel();

        //establecemos posición
        panelGaming.setLocation(panelStats.getWidth(), 0);

        //establecemos tamaño
        panelGaming.setSize(MAX_WIDTH - panelStats.getWidth(), MAX_HEIGHT);

        //establecemos el layout
        panelGaming.setLayout(null);

        panelGaming.setVisible(false);

        Labels.showGamingLabels();

    }
}
