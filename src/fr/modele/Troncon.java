package fr.modele;

public class Troncon extends Modele implements Statement{
    private int idTrajet;
    private int numTroncon;
    private Trajet trajet;
    private String villeDepart;
    private String villeArrivee;
    private String gpsDepart;
    private String gpsArrivee;
    private double distanceParcourue;
    private int tempsEstime;
    private int tempsAttenteDepart;
    private LinkedList<Utilisateur> empruntePar;

    public Troncon(int idTrajet, int numTroncon, Trajet trajet, String villeDepart, String villeArrivee, String gpsDepart, String gpsArrivee, double distanceParcourue, int tempsEstime, int tempsAttenteDepart) {
        //TODO
    }

    public Troncon(int idTrajet, int numTroncon) {
        //TODO
    }

    public int getIdTrajet() {
        //TODO
    }

    public int getNumTroncon() {
        //TODO
    }

    public Trajet getTrajet() {
        //TODO
    }

    public String getVilleDepart() {
        //TODO
    }

    public void setVilleDepart(String villeDepart) {
        //TODO
    }

    public String getVilleArrivee() {
        //TODO
    }

    public void setVilleArrivee(String villeArrivee) {
        //TODO
    }

    public String getGpsDepart() {
        //TODO
    }

    public void setGpsDepart(String gpsDepart) {
        //TODO
    }

    public String getGpsArrivee() {
        //TODO
    }

    public void setGpsArrivee(String gpsArrivee) {
        //TODO
    }

    public double getDistanceParcourue() {
        //TODO
    }

    public void setDistanceParcourue(double distanceParcourue) {
        //TODO
    }

    public int getTempsEstime() {
        //TODO
    }

    public void setTempsEstime(int tempsEstime) {
        //TODO
    }

    public int getTempsAttenteDepart() {
        //TODO
    }

    public void setTempsAttenteDepart(int tempsAttenteDepart) {
        //TODO
    }

    public LinkedList<Utilisateur> getEmpruntePar() {
        //TODO
    }

    public void addEmpruntePar(Utilisateur utilisateur) {
        //TODO
    }
}