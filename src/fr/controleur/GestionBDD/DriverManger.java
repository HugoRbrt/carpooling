package fr.controleur.GestionBDD;

import java.sql.*;

// Paquetages pour la surveillance de tables
import oracle.jdbc.*;
import oracle.jdbc.dcn.*;
import java.util.Properties;

/**
 * Charger et configurer le driver de la base de données
 */

public class DriverManger {
    static final String USERNAME = "roberthu";
    static final String PASSWD = "roberthu";
    static final String URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";

    /* Objet obligatoire à conserver pour pouvoir arrêter la surveillance (correspond au thread de surveillance) */
    private DatabaseChangeRegistration dcr = null;

    /* Connection à la BBD SQL */
    public void getConnection() {
        
    }

    
}
