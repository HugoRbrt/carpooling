package fr.verbiagevoiture;

import java.sql.*;
import java.util.ArrayList;

import fr.verbiagevoiture.controleur.IntToTimestamp;
//import oracle.jdbc.*;
import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;
//import oracle.jdbc.dcn.*;
//import java.util.*;
public class TrajetControllerTest
{
    public static void main(String[] args) {
        
    	MyConnection myUser = new MyConnection();
        System.out.println(" ajout du trajet de BB123BB  ");
        int newId = myUser.addTrajet(3, "BB123BB", "BB123BB@gmail.com", IntToTimestamp.convert(2022,6,17,9,30), IntToTimestamp.convert(2022,6,17,7,0));
        if(newId != -1) {
        	System.out.println("[OK] ajout effectué");
        }else {
        	System.out.println("[KO] echec de l'ajout ");
        }
        
        System.out.println(" affichage des trajets de BB123BB  ");
        ArrayList<String []> array = myUser.getMyTrajet("BB123BB@gmail.com");
        String [] value;
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
        

        System.out.println(" ajout du trajet de ima  ");
        int newId2 = myUser.addTrajet(3, "ima", "test", IntToTimestamp.convert(2022,6,19,19,30), IntToTimestamp.convert(2022,6,19,18,0));
        if(newId2 != -1) {
        	System.out.println("[OK] ajout effectué");
        }else {
        	System.out.println("[KO] echec de l'ajout ");
        }
        
        System.out.println(" ajout du 1er troncon associé  ");
        newId = myUser.addTroncon(1, newId2, "49.51:2.19", "48.23:4.30", "Paris", "Brest", 6*60*60 , 100);
        if(newId != -1) {
        	System.out.println("[OK] ajout effectué");
        }else {
        	System.out.println("[KO] echec de l'ajout ");
        }
        
        System.out.println(" ajout du 2eme troncon associé  ");
        newId = myUser.addTroncon(2, newId2, "48.23:4.30", "20.12:13.49", "Brest", "Lille", 4*60*60 , 0);
        if(newId != -1) {
        	System.out.println("[OK] ajout effectué");
        }else {
        	System.out.println("[KO] echec de l'ajout ");
        }
        
        System.out.println("test emprunte le troncon 2 ");
        boolean b = myUser.addEmprunte(2, newId2, "test");
        if(b) {
        	System.out.println("[OK] ajout effectué");
        }else {
        	System.out.println("[KO] echec de l'ajout ");
        }
        
        System.out.println("calcul cout de troncon 2 : ");
        float f = myUser.coutTroncon(2, newId2);
        int distance = 0;
        if(f == 0.1*0.5*distance*1) {
        	System.out.println("[OK] le cout est de 0");
        }else {
        	System.out.println("[KO] echec du calcul de cout ");
        }
        
        System.out.println("affichage des troncon emprunte par test");
        ArrayList<int []> value2 = myUser.getTronconEmprunte("test");
    	System.out.print("test emprunte :");
        for(int i=0;i<value2.size();i++) {
        	System.out.print("\n  Trajet "+value2.get(i)[0]+" troncon n°"+value2.get(i)[1]);
        }
    	System.out.println(".");
        
        System.out.println(" suppression du trajet et des troncons de ima ");
        if(myUser.deleteTrajetwithTroncon(newId2)) {
        	System.out.println("[OK] suppression effectué");
        }else {
        	System.out.println("[KO] echec de la supression");
        }
        
        
        
        /*
        System.out.println(" suppression du troncon num 1 du trajet 1 ");
        if(myUser.deleteTroncon(1, 1)) {
        	System.out.println("[OK] suppression effectué");
        }else {
        	System.out.println("[KO] echec de la supression");
        }
        
        System.out.println(" suppression du trajet de BB123BB (ID ="+newId+") ");
        if(myUser.deleteTrajet(newId)) {
        	System.out.println("[OK] suppression effectué");
        }else {
        	System.out.println("[KO] echec de la supression");
        }
        */
        
        //fermeture
        try {
            myUser.closeConnection();
        }  catch (SQLException e) {
            System.err.println("failed closure connexion ");
            e.printStackTrace(System.err);
        }
        
        
        
    }
}
