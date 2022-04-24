package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.*;
import java.util.ArrayList;

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
   
    // Méthode qui crée une connexion à la BD
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
    
    //fermeture de la connexion
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
    public boolean CheckEmail(String email) {
    	return user.CheckEmail(email);
    }
    public boolean RechargerSolde(int valeur) {
    	return user.RechargerSolde(valeur);
    }
    public boolean RechargerSolde(int valeur, String email) {
    	return user.RechargerSolde(valeur, email);
    }
    public String AfficherSolde(String email) {
    	return user.AfficherSolde(email);
    }
    public String AfficherSolde() {
    	return user.AfficherSolde();
    }
    
    
    
    //TrajetController method
    public ArrayList<String []> getMyTrajet(String email){
    	return trajet.getMyTrajet(email);
    }
    public boolean deleteTrajet(int idTrajet) {
    	return trajet.deleteTrajet(idTrajet);
    }
    public int addTrajet(int placeDepart, String immatriculation, String email, int dateArrive, int dateDepart) {
    	return trajet.addTrajet(placeDepart, immatriculation, email, dateArrive, dateDepart);
    }
    
    //VehiculeController method
    public boolean addVehicule(String email, String Immatriculation, String Marque, String Modele, int pfiscale, int placeVehicule, String Energieutilise) {
    	return vehicule.addVehicule(email, Immatriculation, Marque, Modele, pfiscale, placeVehicule, Energieutilise);
    }
    public ArrayList<String> getMyVehicule(String email){
    	return vehicule.getMyVehicule(email);
    }
}
