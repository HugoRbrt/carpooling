package fr.verbiagevoiture;

import java.sql.*;
import java.util.ArrayList;

//import oracle.jdbc.*;
import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;
//import oracle.jdbc.dcn.*;
//import java.util.*;
public class VehiculeControllerTest
{
    public static void main(String[] args) {
        
    	MyConnection myUser = new MyConnection();
    	
        System.out.println(" ajout du vehicule twingo BB123BB ");
        if(myUser.addVehicule("BB123BB@gmail.com", "BB123BB", "Renault", "twingo", 50, 4, "essence")) {
        	System.out.println("[OK] ajout effectué");
        }else {
        	System.out.println("[KO] echec de l'ajout ");
        }
    	
        System.out.println(" ajout du vehicule 306 306306 ");
        if(myUser.addVehicule("BB123BB@gmail.com", "306306", "peugeot", "306", 120, 4, "essence")) {
        	System.out.println("[OK] ajout effectué");
        }else {
        	System.out.println("[KO] echec de l'ajout ");
        }
        
        System.out.println("	affichage des vehicule appartenant à BB123BB@gmail.com : ");
        ArrayList<String> array = myUser.getMyVehicule("BB123BB@gmail.com");
        while(!array.isEmpty()) {
        	System.out.println("   "+array.remove(0));
        }
        
        //fermeture
        try {
            myUser.closeConnection();
        }  catch (SQLException e) {
            System.err.println("failed closure connexion ");
            e.printStackTrace(System.err);
        }
        
    }
}
