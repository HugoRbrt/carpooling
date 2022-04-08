package fr.controleur.GestionBDD;

import java.sql.*;

/**
 * Réaliser la connexion et l'authentification à la base de données.
 */

public class Connection {
    /* Méthode qui crée une connexion à la BD */
    private Connection connect() /*throws SQLException*/ {
        System.out.print("Connecting to the database... "); 
        Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWD);
        System.out.println("connected");
        return conn;
    }

    @override
    //de la classe Connection qui existe déjà ?
    public void setAutoCommit(boolean b) {
        //TODO
    }

    //fermeture de connexion à la base
    public void close() {
        //TODO
    }
}
