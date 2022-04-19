package fr.verbiagevoiture.modele;

import java.util.LinkedList;
import java.lang.Math;
import java.util.Calendar;

public class Troncon extends Modele implements Statement{
    private int idTrajet;
    private Trajet trajet;                         //redondance
    private int numTroncon;                        //numérotation à partir de 0
    private Calendar dateDepart;
    private Calendar dateArrivee;
    private String villeDepart;
    private String villeArrivee;
    private double[] gpsDepart = new double[2];    // [ latitudeDepart ; longitudeDepart ]
    private double[] gpsArrivee = new double[2];   // [ latitudeArrivee; longitudeArrivee ]
    private double distanceParcourue;              //méthode de calcul avec loi des sinus
    private int tempsEstime;                       //en minutes
    private int nbPassager;
    //private int tempsAttenteDepart;
    private LinkedList<Utilisateur> empruntePar;

    public Troncon(int idTrajet, Trajet trajet, int numTroncon, String villeDepart, String villeArrivee, double latitudeDepart, double longitudeDepart, double latitudeArrivee, double longitudeArrivee, int tempsEstime) {
        this.idTrajet = idTrajet;
        this.trajet = trajet.getTrajet(idTrajet);
        this.numTroncon = numTroncon;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.gpsDepart[0] = latitudeDepart;
        this.gpsDepart[1] = longitudeDepart;
        this.gpsArrivee[0] = latitudeArrivee;
        this.gpsArrivee[1] = longitudeArrivee;
        this.distanceParcourue = 6371 * Math.acos( Math.sin(gpsDepart[0])*Math.sin(gpsArrivee[0]) + Math.cos(gpsDepart[0])*Math.cos(gpsArrivee[0])*Math.cos(gpsArrivee[1]-gpsDepart[1]) );
        this.tempsEstime = tempsEstime;
        this.nbPassager = 0;
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
        System.out.println("Nombre de passager(s) = " + this.nbPassager);
    }

    public int getIdTrajet() {
        System.out.println("IdTrajet = " + this.idTrajet);
        return this.idTrajet;
    }

    public int getNumTroncon() {
        System.out.println("Numéro tronçon = " + this.numTroncon);
        return this.numTroncon;
    }

    public Calendar getDateDepart() {
        System.out.println("Date de départ = " + this.dateDepart.get(Calendar.YEAR) + this.dateDepart.get(Calendar.MONTH) + this.dateDepart.get(Calendar.DAY_OF_MONTH) );
        System.out.println("Heure de départ = " + this.dateDepart.get(Calendar.HOUR) + this.dateDepart.get(Calendar.MINUTE) );
        return this.dateDepart;
    }

    public void setDateDepart(int year, int month, int date, int hourOfDay, int minute) {
        this.dateDepart.set(year, month, date, hourOfDay, minute);
    }

    public Calendar getDateArrivee() {
        System.out.println("Date d'arrivée = " + this.dateArrivee.get(Calendar.YEAR) + this.dateArrivee.get(Calendar.MONTH) + this.dateArrivee.get(Calendar.DAY_OF_MONTH) );
        System.out.println("Heure d'arrivée = " + this.dateArrivee.get(Calendar.HOUR) + this.dateArrivee.get(Calendar.MINUTE) );
        return this.dateArrivee;
    }

    public void setDateArrivee(int year, int month, int date, int hourOfDay, int minute) {
        this.dateArrivee.set(year, month, date, hourOfDay, minute);
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

    public int getNbPassager() {
        System.out.println("Nombre de passager(s) = " + this.nbPassager);
        return this.nbPassager;
    }

    public int setNbPassager(int nbPassager) {
        this.nbPassager = nbPassager;
    }

    public LinkedList<Utilisateur> getEmpruntePar() {
        this.empruntePar.listIterator();
    }

    public void addEmpruntePar(Utilisateur utilisateur) {
        if(this.nbPassager == this.trajet.getNbPlacesDispoibles()) {
            throw new Exception("Nombre de passager maximum atteint");
        } else {
            this.empruntePar.add(utilisateur);
            this.nbPassager++;
        }
    }
}