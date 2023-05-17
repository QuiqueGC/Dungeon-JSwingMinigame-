package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConnectionDB {


    private Connection connection;



    public ConnectionDB(String db_url, String user, String passwd) {

        try {

            this.connection = DriverManager.getConnection(db_url, user, passwd);

        } catch (SQLException e) {

            System.out.println("Error al acceder a la base de datos.");
        }

    }

    /**
     * método para introducir los datos del personaje en la base de datos
     * @param character Character con el que se ha jugado la partida
     */
    public void insertIntoRankingTable(classes.characters.Character character){

        LocalDateTime date = LocalDateTime.now();
        String today = date.toString();
        String insertQy = "insert into ranking (nombre, clase, oro, vidas, tiempo, victoria, fecha) values (?,?,?,?,?,?,?)";


            try {
                PreparedStatement ps = this.connection.prepareStatement(insertQy);

                ps.setString(1, character.getName());
                ps.setString(2, character.getType());
                ps.setInt(3, character.getGold());
                ps.setInt(4, character.getLives());
                ps.setInt(5, character.getTime());
                ps.setBoolean(6, character.isWin());
                ps.setString(7, today);

                int addRows = ps.executeUpdate();

                if (addRows > 0) {
                    System.out.println("Se ha añadido el registro en la base de datos");
                }
                ps.close();

            }catch (SQLException e){

                System.out.println("Error introduciendo los datos en la BD");

            }


    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * método para cerrar la conexión con la base de datos
     */
    public void closeConnection(){

        try {

            this.connection.close();

        } catch (SQLException e) {

            System.out.println("Error cerrando la conexión con la BD");
        }
    }


}
