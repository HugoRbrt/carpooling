package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrajetController{
    public Connection conn;
    
    public TrajetController(Connection c) {
    	conn = c;
    }
    
    public ArrayList<String []> getMyTrajet(String email) {
    	//query creation
    	ArrayList<String []> myTrajet = new ArrayList<String []>();
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement("SELECT IDTRAJET, PLACE_DEPART, IMMATRICULATION, DATE_ARRIVEE, DATE_DEPART  FROM TRAJET WHERE EMAIL = ?");
    		pstmt.setString(1, email);
    	} catch (SQLException e1) {
    	    System.err.println("failed to create new prepareStatement (CheckEmailAndMDP)");
    		e1.printStackTrace();
    	}
    	
    	//query execution
    	ResultSet rset = null;
    	try {
    	    rset =  pstmt.executeQuery();
    	} catch (SQLException e) {
    	    System.err.println("failed to executeQuery (creerUtilisateur)");
    		e.printStackTrace();
    	}
    	int i=0;
    	String[] value;
    	//response analysis
    	try {
        	while(rset.next()) {
        		myTrajet.add(new String[5]);
        		value = myTrajet.get(i);
        		value[0]= Integer.toString(rset.getInt(1));
        		value[1]= rset.getString(2);
        		value[2]= rset.getString(3);
        		value[3]= Integer.toString(rset.getInt(4));
        		value[4]= Integer.toString(rset.getInt(5));
        		i++;
        	}
    	}  catch (SQLException e) {
            System.err.println("failed connexion ");
            e.printStackTrace(System.err);
        }
    	try {
    		rset.close();
    	} catch (SQLException e) {
    	    System.err.println("failed to close (getMyTrajet)");
    		e.printStackTrace();
    	}
    	return myTrajet;
    }
    
}