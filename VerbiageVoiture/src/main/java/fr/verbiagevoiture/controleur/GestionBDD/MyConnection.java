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
    public boolean RechargerSolde(float valeur) {
    	return user.RechargerSolde(valeur);
    }
    public boolean RechargerSolde(float valeur, String email) {
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
    public ArrayList<String []> getMyTrajet(){
    	return trajet.getMyTrajet(user.myEmail);
    }
    public boolean deleteTrajet(int idTrajet) {
    	return trajet.deleteTrajet(idTrajet);
    }
    public int addTrajet(int placeDepart, String immatriculation, String email, int dateArrive, int dateDepart) {
    	return trajet.addTrajet(placeDepart, immatriculation, email, dateArrive, dateDepart);
    }
    public int addTroncon(int numTroncon, int idTrajet, String gpsDep,  String gpsAr,String villeDep,  String villeAr, int temps, int tempsAttente) {
    	return trajet.addTroncon(numTroncon,idTrajet, gpsDep, gpsAr, villeDep, villeAr, temps, tempsAttente);
    }
    public boolean deleteTroncon(int numTroncon, int idTrajet) {
    	return trajet.deleteTroncon(numTroncon, idTrajet);
    }
    public int getNumberTroncon(int idTrajet) {
    	return troncon.getNumberTroncon(idTrajet);
    }
    
    
    //VehiculeController method
    public boolean addVehicule(String email, String Immatriculation, String Marque, String Modele, int pfiscale, int placeVehicule, String energieUtilise) {
    	return vehicule.addVehicule(email, Immatriculation, Marque, Modele, pfiscale, placeVehicule, energieUtilise);
    }
    public boolean addVehicule(String Immatriculation, String Marque, String Modele, int pfiscale, int placeVehicule, String energieUtilise) {
    	return vehicule.addVehicule(user.myEmail, Immatriculation, Marque, Modele, pfiscale, placeVehicule, energieUtilise);
    }
    public ArrayList<String> getMyVehicule(){
    	return vehicule.getMyVehicule(user.myEmail);
    }
    public ArrayList<String> getMyVehicule(String mail){
    	return vehicule.getMyVehicule(mail);
    }

    //tronconController method
    public boolean deleteEmprunte(int idTrajet) {
    	return troncon.deleteEmprunte(idTrajet);
    }
    public boolean deleteEmprunte(int numTroncon, int idTrajet) {
    	return troncon.deleteEmprunte(numTroncon, idTrajet);
    }
    public boolean addEmprunte(int numTroncon, int idTrajet, String email) {
    	return troncon.addEmprunte(numTroncon, idTrajet, email);
    }
    public boolean addEmprunte(int numTroncon, int idTrajet) {
    	return troncon.addEmprunte(numTroncon, idTrajet, user.myEmail);
    }
    public ArrayList<int []> getTronconEmprunte(String email){
    	return troncon.getTronconEmprunte(email);
    }
    public ArrayList<int []> getTronconEmprunte(){
    	return troncon.getTronconEmprunte(user.myEmail);
    }
    public float coutTroncon(int numTroncon, int idTrajet ) {
    	return troncon.coutTroncon(numTroncon, idTrajet);
    }
    
    //multi controller
    public boolean deleteTrajetwithTroncon(int idTrajet) {
    	boolean success = deleteTrajet(idTrajet);
    	if(!success) {return success;}
    	//TODO : get number of troncon for this trajet
    	int nbTroncon = getNumberTroncon(idTrajet);
    	for(int i=1;i<=nbTroncon;i++) {
    		success = deleteTroncon(i, idTrajet);
    		if(!success) {return success;}
    	}
    	deleteEmprunte(idTrajet);	//if one of this troncon was booked, we delete the booking
    	return success;
    }

}
