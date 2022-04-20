package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculeController{
    public Connection conn;
    
    public VehiculeController(Connection c) {
    	conn = c;
    }
    // requetes spécifiques
    private boolean VehiculeAlreadyExist(String Immatriculation) {
    	PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("SELECT IMMATRICULATION FROM VEHICULE WHERE IMMATRICULATION = ?");
			pstmt.setString(1, Immatriculation);
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
    public boolean addVehicule(String email, String Immatriculation, String Marque, String Modele, int pfiscale, int placeVehicule, String Energieutilise) {
    	boolean vehicleAdded = false;
    	//verification that the vehicle does not already exist
    	if(VehiculeAlreadyExist(Immatriculation)) {
    		System.out.println("Vehicule Already Exist");
    		return false;
    	}
    	
    	//add vehicle in table VEHICULE
    	PreparedStatement pstmt = null;
		try {
	    	pstmt = conn.prepareStatement(
		    		"INSERT INTO VEHICULE VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, Immatriculation);
			pstmt.setString(2, Marque);
			pstmt.setString(3, Modele);
			pstmt.setInt(4, pfiscale);
			pstmt.setInt(5, placeVehicule);
			pstmt.setString(6, Energieutilise);
		} catch (SQLException e1) {
            System.err.println("failed to create new prepareStatement (addVehicule)");
			e1.printStackTrace();
		}

		ResultSet rset = null;
		try {
		    rset =  pstmt.executeQuery();
		} catch (SQLException e) {
            System.err.println("failed to executeQuery (addVehicule)");
			e.printStackTrace();
		}
		try {
			//TODO verifier les valeurs de retour possible d'un insert into
			//pour le moment : si INSERT reussi : valeur de retour (rset.next() == true)
			//				   si INSERT pas reussi : pas de valeur de retour (rset.next() == false)
			
			vehicleAdded = rset.next(); // if rset.next is false, it means that an error occurs 
		}catch (SQLException e) {
            System.err.println("failed to access to ResultSet.next (addVehicule)");
			e.printStackTrace();
		}
		if(vehicleAdded) {//we add the vehicle  in CONDUIT only if vehicle was added in table VEHICULE
			
			//add vehicle in table CONDUIT
	    	PreparedStatement pstmt2 = null;
			try {
		    	pstmt2 = conn.prepareStatement(
			    		"INSERT INTO CONDUIT VALUES (?, ?)");
				pstmt2.setString(1, Immatriculation);
				pstmt2.setString(2, email);
			} catch (SQLException e1) {
	            System.err.println("failed to create new prepareStatement (addVehicule) 2");
				e1.printStackTrace();
			}

			ResultSet rset2 = null;
			try {
			    rset2 =  pstmt2.executeQuery();
			} catch (SQLException e) {
	            System.err.println("failed to executeQuery (addVehicule) 2");
				e.printStackTrace();
			}
			try {
				//TODO verifier les valeurs de retour possible d'un insert into
				//pour le moment : si INSERT reussi : valeur de retour (rset.next() == true)
				//				   si INSERT pas reussi : pas de valeur de retour (rset.next() == false)
				
				vehicleAdded = rset2.next(); // if rset.next is false, it means that an error occurs 
			}catch (SQLException e) {
	            System.err.println("failed to access to ResultSet.next (addVehicule) 2");
				e.printStackTrace();
			}
			
		}
		try {
			rset.close();
		    conn.commit(); // on valide les modifications de la base
		} catch (SQLException e) {
            System.err.println("failed to close & commit (creerUtilisateur)");
			e.printStackTrace();
		}
    	
    	return vehicleAdded;
    }
    
    public ArrayList<String> getMyVehicule(String email){
    	//query creation
    	ArrayList<String> myVehicule = new ArrayList<String>();
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement("SELECT IMMATRICULATION  FROM CONDUIT WHERE EMAIL = ?");
    		pstmt.setString(1, email);
    	} catch (SQLException e1) {
    	    System.err.println("failed to create new prepareStatement (getMyVehicule)");
    		e1.printStackTrace();
    	}
    	
    	//query execution
    	ResultSet rset = null;
    	try {
    	    rset =  pstmt.executeQuery();
    	} catch (SQLException e) {
    	    System.err.println("failed to executeQuery (getMyVehicule)");
    		e.printStackTrace();
    	}
    	//response analysis
    	try {
        	while(rset.next()) {
        		myVehicule.add(rset.getString(1));
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
    	return myVehicule;
    }
}
