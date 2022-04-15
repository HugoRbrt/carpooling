package src.fr.controleur.GestionBDD;

import java.sql.*;

// Paquetages pour la surveillance de tables
import oracle.jdbc.*;
//import oracle.jdbc.dcn.*;
import java.util.Properties;

/**
 * Charger et configurer le driver de la base de données
 */

public class DriverManger {


    /* Objet obligatoire à conserver pour pouvoir arrêter la surveillance (correspond au thread de surveillance) */
    private DatabaseChangeRegistration dcr = null;

    /* Connection à la BBD SQL */
    public void getConnection() {
        
    }

    
}
