package fr.verbiagevoiture;

import java.sql.*;
//import oracle.jdbc.*;
import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;
//import oracle.jdbc.dcn.*;
//import java.util.*;
public class UtilisateurControllerTest
{
    static final String url = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
    static String password = "roberthu";
    static String login = "roberthu";
    public static void main(String[] args) {
        
    	MyConnection myUser = new MyConnection();
        System.out.println("	creation d'un utilisateur qui n'existe pas :  ");
        if(myUser.creerUtilisateur("rbrthg@gmail.com", "rbrt","hg", "rc", "rbrthg")) {
        	System.out.println("[OK] utilisateur cree");
        }else {
        	System.out.println("[KO] utilisateur NON cree");
        }
        

        System.out.println("	creation d'un utilisateur qui existe deja :  ");
        if(myUser.creerUtilisateur("rbrthg@gmail.com", "rbrt","hg", "rc", "rbrthg")) {
        	System.out.println("[KO] utilisateur cree");
        }else {
        	System.out.println("[OK] utilisateur NON cree");
        }
        
        
        System.out.println("	verification de la présence d'un utilisateur présent : ");
        if(myUser.CheckEmailAndMDP("rbrthg@gmail.com", "rbrthg")) {
        	System.out.println("[OK] utilisateur existe");
        }else {
        	System.out.println("[KO] utilisateur existe PAS");
        }    
        
        
        System.out.println("	verification de la présence d'un utilisateur non présent (MDP mauvais) : ");
        if(myUser.CheckEmailAndMDP("rbrthg@gmail.com", "FAUX")) {
        	System.out.println("[KO] utilisateur existe");
        }else {
        	System.out.println("[OK] utilisateur existe PAS");
        }

        System.out.println("	verification de la présence d'un utilisateur non présent (email mauvais) : ");
        if(myUser.CheckEmailAndMDP("FAUX", "rbrthg")) {
        	System.out.println("[KO] utilisateur existe");
        }else {
        	System.out.println("[OK] utilisateur existe PAS");
        } 

        System.out.println("	verification de la présence d'un email non présent : ");
        if(myUser.CheckEmail("FAUX")) {
        	System.out.println("[KO] utilisateur existe");
        }else {
        	System.out.println("[OK] utilisateur existe PAS");
        } 

        System.out.println("	verification de la présence d'un email présent : ");
        if(myUser.CheckEmail("rbrthg@gmail.com")) {
        	System.out.println("[OK] utilisateur existe");
        }else {
        	System.out.println("[KO] utilisateur existe PAS");
        } 

        System.out.println("	ajout de 10€ a rbrthg@gmail.co : ");
        if(myUser.RechargerSolde(10,"rbrthg@gmail.com")) {
        	System.out.println("[OK] ajout reussi");
        }else {
        	System.out.println("[KO] echec de l'ajout");
        } 

        System.out.println("	afficher solde de rbrthg@gmail.co : ");
        System.out.println(myUser.AfficherSolde("rbrthg@gmail.com"));
        
        
        
        
        //fermeture
        try {
            myUser.closeConnection();
        }  catch (SQLException e) {
            System.err.println("failed closure connexion ");
            e.printStackTrace(System.err);
        }
        
    }
}
