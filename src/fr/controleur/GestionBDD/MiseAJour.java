package fr.controleur.GestionBDD;

import java.sql.*;

public class MiseAJour{

    //Point de sauvegarde
    public void setSavePoint();

    //Publication des changements de la BD
    public void commit();

    //Annulation des modifs depuis le dernier commit
    public void rollback();

    //méthode d'execution des transactions de modif de la base (insert, delete)
    public void executeUpdate();
}
