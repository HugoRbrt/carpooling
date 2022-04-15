package src.fr.controleur.GestionBDD;

import java.sql.*;

/**
 * Réaliser la connexion et l'authentification à la base de données.
 */

public class MyConnection {
    static final String USERNAME = "roberthu";
    static final String PASSWD = "roberthu";
    static final String URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
    private Connection conn;
   
    /* Méthode qui crée une connexion à la BD */
    public MyConnection() {
        try{
            // Chargement du driver Oracle
            System.out.print("Loading Oracle driver... "); 
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("loaded");

            // Connection à la BD
            System.out.print("Connecting to the database... "); 
            this.conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWD);
            System.out.println("connected");

            // Demarrage de la transaction (implicite)
            this.conn.setAutoCommit(false); // Pas de autocommit
            this.conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        } catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
        }
    }
        
    public void closeConnection() throws SQLException {
        conn.close();
    }

}
