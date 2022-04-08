package fr.modele;

import java.util.LinkedList;
import java.lang.Math;

public class Troncon extends Modele implements Statement{
    private int idTrajet;
    private int numTroncon;
    //private Trajet trajet; redondance
    private String villeDepart;
    private String villeArrivee;
    private double[] gpsDepart = new double[2];    // [ latitudeDepart ; longitudeDepart ]
    private double[] gpsArrivee = new double[2];   // [ latitudeArrivee; longitudeArrivee ]
    private double distanceParcourue;              //méthode de calcul avec loi des sinus
    private int tempsEstime;                       //en minutes
    //private int tempsAttenteDepart;
    private LinkedList<Utilisateur> empruntePar;

    public Troncon(int idTrajet, int numTroncon, String villeDepart, String villeArrivee, double latitudeDepart, double longitudeDepart, double latitudeArrivee, double longitudeArrivee, int tempsEstime) {
        this.idTrajet = idTrajet;
        this.numTroncon = numTroncon;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.gpsDepart[0] = latitudeDepart;
        this.gpsDepart[1] = longitudeDepart;
        this.gpsArrivee[0] = latitudeArrivee;
        this.gpsArrivee[1] = longitudeArrivee;
        this.distanceParcourue = 6371 * Math.acos( Math.sin(gpsDepart[0])*Math.sin(gpsArrivee[0]) + Math.cos(gpsDepart[0])*Math.cos(gpsArrivee[0])*Math.cos(gpsArrivee[1]-gpsDepart[1]) );
        this.tempsEstime = tempsEstime;
    }

    public void printTroncon(int idTrajet, int numTroncon) {
        System.out.println("IdTrajet = " + this.idTrajet);
        System.out.println("Numéro tronçon = " + this.numTroncon);
        System.out.println("Ville de départ = " + this.villeDepart);
        System.out.println("Ville d'arrivée = " + this.villeArrivee);
        System.out.println("Latitude Départ = " + this.gpsDepart[0]);
        System.out.println("Longitude Départ = " + this.gpsDepart[1]);
        System.out.println("Latitude Arrivée = " + this.gpsArrivee[0]);
        System.out.println("Longitude Arrivée = " + this.gpsArrivee[1]);
        System.out.println("Distance parcourue = " + this.distanceParcourue);
        System.out.println("Temps estimé = " + this.tempsEstime);
    }

    public int getIdTrajet() {
        System.out.println("IdTrajet = " + this.idTrajet);
        return this.idTrajet;
    }

    public int getNumTroncon() {
        System.out.println("Numéro tronçon = " + this.numTroncon);
        return this.numTroncon;
    }

    public String getVilleDepart() {
        System.out.println("Ville de départ = " + this.villeDepart);
        return this.villeDepart;
    }

    public String getVilleArrivee() {
        System.out.println("Ville de d'arrivée = " + this.villeArrivee);
        return this.villeArrivee;
    }

    public double[] getGpsDepart() {
        System.out.println("Latitude Départ = " + this.gpsDepart[0]);
        System.out.println("Longitude Départ = " + this.gpsDepart[1]);
        return this.gpsDepart;
    }

    public double[] getGpsArrivee() {
        System.out.println("Latitude Arrivée = " + this.gpsArrivee[0]);
        System.out.println("Longitude Arrivée = " + this.gpsArrivee[1]);
        return this.gpsArrivee;
    }

    public double getDistanceParcourue() {
        System.out.println("Distance parcourue = " + this.distanceParcourue);
    }

    public int getTempsEstime() {
        System.out.println("Temps estimé = " + this.tempsEstime);
        return this.tempsEstime;
    }

    public void setTempsEstime(int tempsEstime) {
        this.tempsEstime = tempsEstime;
    }

    public LinkedList<Utilisateur> getEmpruntePar() {
        //TODO
    }

    public void addEmpruntePar(Utilisateur utilisateur) {
        //TODO
    }
}