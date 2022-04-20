package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.*;
//import oracle.jdbc.OracleConnection;

public class UtilisateurController{
    public Connection conn;
    
    public UtilisateurController(Connection c) {
    	conn = c;
    }
        
    public boolean creerUtilisateur(String email, String nom, String prenom, String villeDeResidence, String mdp){
    	if(CheckEmailAndMDP(email, mdp)) { // check if the account already exist 
    		return  false;
    	}
    	
    	PreparedStatement pstmt = null;
		try {
	    	pstmt = conn.prepareStatement(
		    		"INSERT INTO UTILISATEUR VALUES (?, ?, ?, ?, ?, 0)");
			pstmt.setString(1, email);
			pstmt.setString(2, nom);
			pstmt.setString(3, prenom);
			pstmt.setString(4, villeDeResidence);
			pstmt.setString(5, mdp);
		} catch (SQLException e1) {
            System.err.println("failed to create new prepareStatement (creerUtilisateur)");
			e1.printStackTrace();
		}

		ResultSet rset = null;
		try {
		    rset =  pstmt.executeQuery();
		} catch (SQLException e) {
            System.err.println("failed to executeQuery (creerUtilisateur)");
			e.printStackTrace();
		}
		
		boolean accountAdded = false;
		try {
			//TODO verifier les valeurs de retour possible d'un insert into
			//pour le moment : si INSERT reussi : valeur de retour (rset.next() == true)
			//				   si INSERT pas reussi : pas de valeur de retour (rset.next() == false)
			
			accountAdded = rset.next(); // if rset.next is false, it means that an error occurs 
		}catch (SQLException e) {
            System.err.println("failed to access to ResultSet.next (creerUtilisateur)");
			e.printStackTrace();
		}
		
		try {
			rset.close();
		    conn.commit(); // on valide les modifications de la base
		} catch (SQLException e) {
            System.err.println("failed to close & commit (creerUtilisateur)");
			e.printStackTrace();
		}
		return accountAdded;
	    
	}
    
    public boolean CheckEmailAndMDP(String email, String mdp){
    	PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("SELECT EMAIL FROM UTILISATEUR WHERE EMAIL = ? AND MDP = ? ");
			pstmt.setString(1, email);
			pstmt.setString(2, mdp);
		} catch (SQLException e1) {
            System.err.println("failed to create new prepareStatement (CheckEmailAndMDP)");
			e1.printStackTrace();
		}
		int nb = 0;
    	try {
			nb = pstmt.executeUpdate();
		} catch (SQLException e) {
            System.err.println("failed to executeUpdate (CheckEmailAndMDP)");
			e.printStackTrace();
		}
    	return nb!=0; //return true only if we have 1 or more line with the right email/mdp
	}
    
    public boolean CheckEmail(String email){
    	PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("SELECT EMAIL FROM UTILISATEUR WHERE EMAIL = ?");
			pstmt.setString(1, email);
		} catch (SQLException e1) {
            System.err.println("failed to create new prepareStatement (CheckEmailAndMDP)");
			e1.printStackTrace();
		}
		int nb = 0;
    	try {
			nb = pstmt.executeUpdate();
		} catch (SQLException e) {
            System.err.println("failed to executeUpdate (CheckEmailAndMDP)");
			e.printStackTrace();
		}
    	return nb!=0; //return true only if we have 1 or more line with the right email/mdp
	}
    
}
