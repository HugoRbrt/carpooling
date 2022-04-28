package fr.verbiagevoiture;

import fr.verbiagevoiture.controleur.GestionBDD.MyConnection;
import fr.verbiagevoiture.vue.WelcomeScreen;

public class App {
    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        MyConnection myco = new MyConnection();

        try {
            WelcomeScreen window = new WelcomeScreen(myco);
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
