package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.*;

/**
 * Contenir la requête SQL et la transmettre à la base de données.
 */

public interface Statement {
    PreparedStatement stmt = conn.prepareStatement("select * from system.LesSalles  where NBPLACES >? and NOM  like ?"); 

    // méthode de création des requetes
    public prepareStatement() {
            //TODO
        }

    // méthodes de création des requêtes
    public createStatement(/*param1, param2 ..*/) {
            //TODO
        }

}
