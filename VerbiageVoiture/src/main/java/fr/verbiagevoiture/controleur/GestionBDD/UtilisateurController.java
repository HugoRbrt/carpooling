package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.*;

public class UtilisateurController extends MyConnection{
        
    public void creerUtilisateur(){
        if(conn==null){
        throw new Exception("Pas de connexion à la base de données");
    }

    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Utilisateur VALUES (?, NOM, PRENOM, VILLE_DE_RESIDENCE) (?,?,?,?,?) ");
    //TODO : faire en sorte de récupérer les informations issues de l'interface pour compléter la requete 
    
    ResultSet rset = pstmt.executeQuery(); // on éxecute la requête 
	dumpResult(rset);
	rset.close();
    
    conn.commit(); // on valide les modifications de la base

    
}
public void CheckEmailAndMDP(){

}

/*
SELECT , email, MDP // Tristan : ici j'ai commencé à renseigner le texte pour faire une première requete
 FROM Utilisateur
  WHERE email == email_entré;
   AND MDP = mdp_entré
 */

}
