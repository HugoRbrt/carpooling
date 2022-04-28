package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.*;
//import oracle.jdbc.OracleConnection;

public class UtilisateurController{
    public Connection conn;
    public String myEmail;
    
    public UtilisateurController(Connection c) {
    	conn = c;
    }
        
    public boolean creerUtilisateur(String email, String nom, String prenom, String villeDeResidence, String mdp){
    	//check if the fields are corrects
    	if(email.isBlank() || nom.isBlank() || prenom.isBlank() || villeDeResidence.isBlank() || mdp.isBlank() ) {
    		return false;
    	}
    	myEmail = email;
    	
    	if(CheckEmail(email)) { // check if the account already exist 
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
			//si INSERT reussi : valeur de retour (rset.next() == true)
			//si INSERT pas reussi : pas de valeur de retour (rset.next() == false)
			
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
    	//check if the fields are corrects
    	if(email.isBlank() || mdp.isBlank()) {
    		return false;
    	}
    	myEmail = email;
    	
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
    	//check if the field is correcrt
    	if(email.isBlank()) {
    		return false;
    	}
    	myEmail = email;
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
    
    public boolean RechargerSolde(float valeur) {
    	if(myEmail.isBlank() || valeur<=0) {
    		return false;
    	}
    	System.out.println("debut..");

    	PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("UPDATE UTILISATEUR SET PORTE_MONNAIE = PORTE_MONNAIE + ? WHERE EMAIL = ?");
			pstmt.setFloat(1, valeur);
			pstmt.setString(2, myEmail);
		} catch (SQLException e1) {
            System.err.println("failed to create new prepareStatement (RechargerSolde)");
			e1.printStackTrace();
		}
    	System.out.println("milieu..");
		int nb = 0;
    	try {
			nb = pstmt.executeUpdate();
		} catch (SQLException e) {
            System.err.println("failed to executeUpdate (RechargerSolde)");
			e.printStackTrace();
		}
    	System.out.println("fin..");
		try {
		    conn.commit(); // on valide les modifications de la base
		} catch (SQLException e) {
            System.err.println("failed to commit (RechargerSolde)");
			e.printStackTrace();
		}
    	return nb==1;
    }
    public boolean RechargerSolde(float valeur, String email) {
    	myEmail = email;
    	return RechargerSolde(valeur);
    }
    
    public String AfficherSolde(String email) {
    	myEmail = email;
    	if(myEmail.isBlank()) {
    		return new String();
    	}

    	PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("SELECT PORTE_MONNAIE FROM UTILISATEUR WHERE EMAIL = ?");
			pstmt.setString(1, myEmail);
		} catch (SQLException e1) {
            System.err.println("failed to create new prepareStatement (AfficherSolde)");
			e1.printStackTrace();
		}
		ResultSet rset = null;
    	try {
    		rset = pstmt.executeQuery();
		} catch (SQLException e) {
            System.err.println("failed to executeUpdate (AfficherSolde)");
			e.printStackTrace();
		}
    	String value = "";
    	//response analysis
    	try {
        	while(rset.next()) {
        		value = rset.getString(1);
        	}
    	}  catch (SQLException e) {
            System.err.println("failed for the access to  ResultSet (AfficherSolde)");
            e.printStackTrace(System.err);
        }
    	//close
    	try {
    		rset.close();
    	} catch (SQLException e) {
    	    System.err.println("failed to close (AfficherSolde)");
    		e.printStackTrace();
    	}
    	return value;
    }
    
    public String AfficherSolde() {
    	return AfficherSolde(myEmail);
    }
    
}
