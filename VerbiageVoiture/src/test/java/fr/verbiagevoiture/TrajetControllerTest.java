package fr.verbiagevoiture;

import java.sql.*;
import java.util.ArrayList;

//import oracle.jdbc.*;
import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;
//import oracle.jdbc.dcn.*;
//import java.util.*;
public class TrajetControllerTest
{
    public static void main(String[] args) {
        
    	MyConnection myUser = new MyConnection();
        System.out.println(" ajout du trajet de BB123BB  ");
        int newId = myUser.addTrajet(3, "BB123BB", "BB123BB@gmail.com", 1, 10);
        if(newId != -1) {
        	System.out.println("[OK] ajout effectué");
        }else {
        	System.out.println("[KO] echec de l'ajout ");
        }
    	
        System.out.println(" affichage des trajets de AA123AA  ");
        ArrayList<String []> array = myUser.getMyTrajet("AA123AA@gmail.com");
        String [] value;
        while(!array.isEmpty()) {
        	value = array.remove(0);
        	System.out.println("IDTRAJET:" + value[0] +
        			" PLACE_DEPART:" + value[1] +
        			" IMMATRICULATION:" +value[2] +
        			" DATE_ARRIVEE:" + value[3] +
        			" DATE_DEPART:" + value[4] );
        }
        
        System.out.println(" affichage des trajets de BB123BB  ");
        array = myUser.getMyTrajet("BB123BB@gmail.com");
        while(!array.isEmpty()) {
        	value = array.remove(0);
        	System.out.println("IDTRAJET:" + value[0] +
        			" PLACE_DEPART:" + value[1] +
        			" IMMATRICULATION:" +value[2] +
        			" DATE_ARRIVEE:" + value[3] +
        			" DATE_DEPART:" + value[4] );
        }
        
        System.out.println(" suppression du trajet de BB123BB (ID ="+newId+") ");
        if(myUser.deleteTrajet(newId)) {
        	System.out.println("[OK] suppression effectué");
        }else {
        	System.out.println("[KO] echec de la supression");
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
