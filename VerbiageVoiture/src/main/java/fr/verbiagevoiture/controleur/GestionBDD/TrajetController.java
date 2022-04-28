package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
    	    System.err.println("failed to create new prepareStatement (getMyTrajet)");
    		e1.printStackTrace();
    	}
    	
    	//query execution
    	ResultSet rset = null;
    	try {
    	    rset =  pstmt.executeQuery();
    	} catch (SQLException e) {
    	    System.err.println("failed to executeQuery (getMyTrajet)");
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
        		value[3]= rset.getTimestamp(4).toString();
        		value[4]= rset.getTimestamp(5).toString();
        		i++;
        	}
    	}  catch (SQLException e) {
            System.err.println("failed for the access to  ResultSet (getMyTrajet)");
            e.printStackTrace(System.err);
        }
    	//close
    	try {
    		rset.close();
    	} catch (SQLException e) {
    	    System.err.println("failed to close (getMyTrajet)");
    		e.printStackTrace();
    	}
    	return myTrajet;
    }

    public boolean deleteTrajet(int idTrajet) {
    	boolean b = false;
    	//query creation
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement("DELETE FROM TRAJET WHERE IDTRAJET = ?");
    		pstmt.setInt(1, idTrajet);
    	} catch (SQLException e1) {
    	    System.err.println("failed to create new prepareStatement (deleteTrajet)");
    		e1.printStackTrace();
    	}
    	//query execution
    	int rset=0;
    	try {
    	    rset =  pstmt.executeUpdate();
    	} catch (SQLException e) {
    	    System.err.println("failed to executeQuery (deleteTrajet)");
    		e.printStackTrace();
    	}
    	//response analysis
    	b = rset==1; //if the line was deleted rset==1
    	
    	//return 
    	return b;
    }
    
    //return the IDtrajet which was created (-1 if it was impossible)
    public int addTrajet(int placeDepart, String immatriculation, String email, Timestamp dateArrive, Timestamp dateDepart) {
    	int b = -1;
    	int idTrajet = 0;
    	//get idTrajet not used
    	Statement stmt = null;
    	try {
    		stmt = conn.createStatement();
    	} catch (SQLException e1) {
    	    System.err.println("failed to create new prepareStatement (addTrajet)");
    		e1.printStackTrace();
    	}
    	ResultSet rs = null;
    	try {
			rs = stmt.executeQuery("SELECT MAX(IDTRAJET) FROM TRAJET");
		} catch (SQLException e) {
            System.err.println("failed to executeQuery (addTrajet)");
			e.printStackTrace();
		}
    	try {
        	rs.next();
        	idTrajet = rs.getInt(1)+1;
    	} catch (SQLException e) {
            System.err.println("failed to execute getInt (addTrajet)");
			e.printStackTrace();
		}
    	
    	//query creation
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement("INSERT INTO TRAJET VALUES (?, ?, ?, ?, ?, ?, 0, 0)");
			pstmt.setInt(1, idTrajet);
			pstmt.setInt(2, placeDepart);
			pstmt.setString(3, immatriculation);
			pstmt.setString(4, email);
			pstmt.setTimestamp(5, dateArrive);
			pstmt.setTimestamp(6, dateDepart);
    	} catch (SQLException e1) {
    	    System.err.println("failed to create new prepareStatement (addTrajet)");
    		e1.printStackTrace();
    	}
    	//query execution
    	int rset=0;
    	try {
    	    rset =  pstmt.executeUpdate();
    	} catch (SQLException e) {
    	    System.err.println("failed to executeQuery (addTrajet)");
    		e.printStackTrace();
    	}
    	//response analysis
    	if(rset==1) {//if the line was add rset==1
    		b = idTrajet;
    	}
    	
    	//return 
    	return b;
    }
    
  //return the numero_troncon which was created (-1 if it was impossible)
    public int addTroncon(int numTroncon, int idTrajet, String gpsDep,  String gpsAr,String villeDep,  String villeAr, int temps, int tempsAttente) {
    	//coordonnees gps : degre:minute:degre:minute
    	if(idTrajet<0 || gpsDep.isBlank() || gpsAr.isBlank() || villeDep.isBlank() || villeAr.isBlank() || temps<0 || tempsAttente<0) {
    		return -1;
    	}
    	int b = -1;
    	//TODO : calculer la distance à partir des coordonnéesGPS
    	int distance = 0;
    	
    	//query creation
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement("INSERT INTO TRONCON VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0)");
			pstmt.setInt(1, numTroncon);
			pstmt.setInt(2, idTrajet);
			pstmt.setString(3, gpsDep);
			pstmt.setString(4, gpsAr);
			pstmt.setString(5, villeDep);
			pstmt.setString(6, villeAr);
			pstmt.setInt(7, distance);
			pstmt.setInt(8, temps);
			pstmt.setInt(9, tempsAttente);
    	} catch (SQLException e1) {
    	    System.err.println("failed to create new prepareStatement2 (addTroncon)");
    		e1.printStackTrace();
    	}
    	//query execution
    	int rset2=0;
    	try {
    	    rset2 =  pstmt.executeUpdate();
    	} catch (SQLException e) {
    	    System.err.println("failed to executeQuery (addTroncon)");
    		e.printStackTrace();
    	}
    	//response analysis
    	if(rset2==1) {//if the line was add rset==1
    		b = idTrajet;
    	}
    	
    	//return 
    	return b;
    }
    


    public boolean deleteTroncon(int numTroncon, int idTrajet) {
    	boolean b = false;
    	//query creation
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement("DELETE FROM TRONCON WHERE IDTRAJET = ? AND NUMERO_TRONCON = ?");
    		pstmt.setInt(1, idTrajet);
    		pstmt.setInt(2, numTroncon);
    	} catch (SQLException e1) {
    	    System.err.println("failed to create new prepareStatement (deleteTrajet)");
    		e1.printStackTrace();
    	}
    	//query execution
    	int rset=0;
    	try {
    	    rset =  pstmt.executeUpdate();
    	} catch (SQLException e) {
    	    System.err.println("failed to executeQuery (deleteTrajet)");
    		e.printStackTrace();
    	}
    	//response analysis
    	b = rset==1; //if the line was deleted rset==1
    	
    	//return 
    	return b;
    }
    
    public ArrayList<String []> findTrajet(String villeDep, String villeAr){
    	//query creation
    	ArrayList<String []> myTrajet = new ArrayList<String []>();
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement("SELECT T1.IDTRAJET, T1.NUMERO_TRONCON, T2.NUMERO_TRONCON  FROM TRONCON T1, TRONCONT T2 WHERE T1.IDTRAJET = T2.IDTRAJET AND T1.VILLE_DEPART = ? AND T2.VILLE_ARRIVEE = ?");
    		pstmt.setString(1, villeDep);
    		pstmt.setString(1, villeAr);
    	} catch (SQLException e1) {
    	    System.err.println("failed to create new prepareStatement (getMyTrajet)");
    		e1.printStackTrace();
    	}
    	
    	//query execution
    	ResultSet rset = null;
    	try {
    	    rset =  pstmt.executeQuery();
    	} catch (SQLException e) {
    	    System.err.println("failed to executeQuery (getMyTrajet)");
    		e.printStackTrace();
    	}
    	int i=0;
    	String[] value;
    	//response analysis
    	try {
        	while(rset.next()) {
        		myTrajet.add(new String[3]);
        		value = myTrajet.get(i);
        		value[0]= rset.getString(1);
        		value[1]= rset.getString(2);
        		value[2]= rset.getString(3);
        		i++;
        	}
    	}  catch (SQLException e) {
            System.err.println("failed for the access to  ResultSet (getMyTrajet)");
            e.printStackTrace(System.err);
        }
    	//close
    	try {
    		rset.close();
    	} catch (SQLException e) {
    	    System.err.println("failed to close (getMyTrajet)");
    		e.printStackTrace();
    	}
    	return myTrajet;
    	
    }
    
    
}  