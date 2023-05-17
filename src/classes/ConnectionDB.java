package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConnectionDB {


    private String db_url;
    private String user;
    private String passwd;

    private Connection connection;


    public ConnectionDB(String db_url, String user, String passwd) {

        this.db_url= db_url;
        this.user = user;
        this.passwd = passwd;

    }
    public void insertIntoRankingTable(classes.characters.Character character){

        LocalDateTime date = LocalDateTime.now();
        String today = date.toString();
        String insertQy = "insert into ranking (nombre, clase, oro, vidas, tiempo, victoria, fecha) values (?,?,?,?,?,?,?)";

        try {

            this.connection = DriverManager.getConnection(db_url, user, passwd);
            PreparedStatement ps = this.connection.prepareStatement(insertQy);

            ps.setString(1, character.getName());
            ps.setString(2,character.getType());
            ps.setInt(3,character.getGold());
            ps.setInt(4,character.getLives());
            ps.setInt(5,character.getTime());
            ps.setBoolean(6,character.isWin());
            ps.setString(7, today);

            int addRows = ps.executeUpdate();
            if (addRows > 0){
                System.out.println("Se ha añadido el registro en la base de datos");}

            ps.close();
            this.connection.close();

        } catch (SQLException e) {

            System.out.println("Error al acceder a la base de datos.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getDb_url() {
        return db_url;
    }

    public void setDb_url(String db_url) {
        this.db_url = db_url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


}
