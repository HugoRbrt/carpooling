package fr.verbiagevoiture;

import fr.verbiagevoiture.vue.WelcomeScreen;

/**
 * Hello world!
 *
 */
public class App {
    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            WelcomeScreen window = new WelcomeScreen();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
