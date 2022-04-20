package fr.verbiagevoiture;

import java.sql.*;
import oracle.jdbc.*;
//import oracle.jdbc.dcn.*;
//import java.util.*;
public class ConnectionTest
{
    static final String url = "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1";
    static String password = "roberthu";
    static String login = "roberthu";
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        }  catch (SQLException e) {
            System.err.println("failed to create new driver");
            e.printStackTrace(System.err);
        }
        try {
            OracleConnection conn =(OracleConnection) DriverManager.getConnection(url, login, password);
            conn.setAutoCommit(false); // desactivation de l'autocommit
           
            Statement stmt = conn.createStatement();
            
            //int nb = stmt.executeUpdate("INSERT INTO CONDUIT VALUES ('BB123BB','BB123BB@gmail.com')");
            //System.out.print(nb);
            ResultSet rs = stmt.executeQuery("SELECT * FROM CONDUIT ");
            while(rs.next()) {
            	String lastName = rs.getString(1);
            	String firstName = rs.getString(2);
            	System.out.println(lastName+ ',' +firstName);
            }
            
            
            conn.close();
        }  catch (SQLException e) {
            System.err.println("failed connexion ");
            e.printStackTrace(System.err);
        }
    }
}
