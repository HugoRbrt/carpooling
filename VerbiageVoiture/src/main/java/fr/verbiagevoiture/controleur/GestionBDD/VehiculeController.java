package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.Connection;

public class VehiculeController{
    public Connection conn;
    
    public VehiculeController(Connection c) {
    	conn = c;
    }
    // requetes spécifiques
}
