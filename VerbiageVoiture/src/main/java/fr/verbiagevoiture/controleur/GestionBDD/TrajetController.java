package fr.verbiagevoiture.controleur.GestionBDD;

import java.sql.Connection;

public class TrajetController{
    public Connection conn;
    
    public TrajetController(Connection c) {
    	conn = c;
    }
    
}


