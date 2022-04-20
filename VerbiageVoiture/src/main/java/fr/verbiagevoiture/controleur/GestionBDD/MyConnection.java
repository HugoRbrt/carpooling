package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.*;

/**
 * Réaliser la connexion et l'authentification à la base de données.
 */

public class MyConnection {
    static final String USERNAME = "roberthu";
    static final String PASSWD = "roberthu";
    static final String URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
    public Connection conn;
    public UtilisateurController user;
    public VehiculeController vehicule;
    public TronconController troncon;
    public TrajetController trajet;
    public EnergieController energie;
   
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
            this.conn = null;
        }
        user = new UtilisateurController(conn);
        vehicule = new VehiculeController(conn);
        troncon = new TronconController(conn);
        trajet = new TrajetController(conn);
        energie = new EnergieController(conn);
    }
    
    public void closeConnection() throws SQLException {
    	try {
            System.out.print("closing connection to the database... "); 
            conn.close();
            System.out.println("closed "); 
    	} catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
            this.conn = null;
        }
    }

    //UtilisateurController method
    public boolean creerUtilisateur(String email, String nom, String prenom, String villeDeResidence, String mdp) {
    	return user.creerUtilisateur(email, nom, prenom, villeDeResidence, mdp);
    }
    public boolean CheckEmailAndMDP(String email, String mdp) {
    	return user.CheckEmailAndMDP(email, mdp);
    }
    
}
