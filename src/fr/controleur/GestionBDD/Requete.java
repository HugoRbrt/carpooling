package fr.controleur.GestionBDD;

import java.sql.*;

public class Requete {

    static final String URL = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
    private static final String USERNAME = "login";                            // a adapter
    private static final String PASSWD = "passwd";                             // A adapter
    private static String STMT = "";//ex "select * from emp"; // la requete que l'on veut formuler

    public Connection getActiveConnection(){
        // Chargement du driver Oracle
        System.out.print("Loading Oracle driver... ");
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        System.out.println("loaded");

        // Etablissement de la connection
        
        System.out.println("connected");
    }

    public void setRequest(String request){
        this.STMT=request;
    }

    // méthode de réalisation d'une requete STMT
    public void makeRequest(){
        try{
            Connection conn = getActiveConnection();

            // Creation de la requete
            Statement stmt = conn.createStatement();

            // Execution de la requete
            ResultSet rset = stmt.executeQuery(STMT);

            // Affichage du resultat
            System.out.println("Results:");
            dumpResultSet(rset);
            System.out.println();

            // Fermeture
            rset.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
        }
    }

    private void dumpResultSet(ResultSet rset) throws SQLException {
        ResultSetMetaData rsetmd = rset.getMetaData();
        int i = rsetmd.getColumnCount();
        while (rset.next()) {
            for (int j = 1; j <= i; j++) {
                System.out.print(rset.getString(j) + "\t");
            }
            System.out.println();
        }
    }

    public void makeUpdateRequest(){
        // Creation de la requete
        try{
            Connection conn = getActiveConnection();

            // Creation de la requete
            Statement stmt = conn.createStatement();

            // Execution de la requete
            int nbUdpated = stmt.executeUpdate(STMT);
            System.out.println(nbUdpated+" lignes actualisées");
            // Fermeture
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
        }
    }


}
