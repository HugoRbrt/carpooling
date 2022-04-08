package fr.modele;

import java.util.Calendar;
import java.util.LinkedList;

public class Trajet extends Modele implements Statement{
    private int idTrajet;
    private Calendar dateDepart;
    private String villeDepart;
    private String villeArrivee;
    private double[] gpsDepart = new double[2];    // [ latitudeDepart ; longitudeDepart ]
    private double[] gpsArrivee = new double[2];   // [ latitudeArrivee; longitudeArrivee ]
    private String immatriculation;
    private Utilisateur proposePar;
    private Vehicule assurePar;
    private LinkedList<Troncon> listeTroncons;

    public Trajet(Calendar dateDepart, String villeDepart, String villeArrivee, double latitudeDepart, double longitudeDepart, double latitudeArrivee, double longitudeArrivee, String immatriculation, Utilisateur conducteur, Vehicule vehicule) {
        this.dateDepart = dateDepart;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.gpsDepart[0] = latitudeDepart;
        this.gpsDepart[1] = longitudeDepart;
        this.gpsArrivee[0] = latitudeArrivee;
        this.gpsArrivee[1] = longitudeArrivee;
        this.immatriculation = immatriculation;
        this.proposePar = conducteur;
        this.assurePar = vehicule;
        this.listeTroncons = new LinkedList<Troncon>(); //ou new LinkedList<>(); ?
    }

    public int getIdTrajet() {
        System.out.println("IdTrajet = " + this.idTrajet);
        return this.idTrajet;
    }

    public void printTrajet(int idTrajet) {
        System.out.println("Date de départ = " + this.dateDepart);
        System.out.println("Ville de départ = " + this.villeDepart);
        System.out.println("Ville d'arrivée = " + this.villeArrivee);
        System.out.println("Latitude Départ = " + this.gpsDepart[0]);
        System.out.println("Longitude Départ = " + this.gpsDepart[1]);
        System.out.println("Latitude Arrivée = " + this.gpsArrivee[0]);
        System.out.println("Longitude Arrivée = " + this.gpsArrivee[1]);
        System.out.println("Immatriculation = " + this.immatriculation);
        System.out.println("Conducteur = " + this.proposePar);
        System.out.println("Véhicule = " + this.assurePar);
    }

    public Calendar getDateDepart() {
        System.out.println("Date de départ = " + this.dateDepart.get(Calendar.YEAR) + this.dateDepart.get(Calendar.MONTH) + this.dateDepart.get(Calendar.DAY_OF_MONTH) );
        System.out.println("Heure de départ = " + this.dateDepart.get(Calendar.HOUR) + this.dateDepart.get(Calendar.MINUTE) );
        return this.dateDepart;
    }

    public void setDateDepart(int year, int month, int date, int hourOfDay, int minute) {
        this.dateDepart.set(year, month, date, hourOfDay, minute);
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

    public String getimmatriculation() {
        System.out.println("Immatriculation = " + this.immatriculation);
        return this.immatriculation;
    }

    public void setimmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Vehicule getAssurePar() {
        System.out.println("Trajet fait avec le véhicule : " + this.assurePar.getImmatriculation());
        return this.assurePar;
    }

    public void setAssurePar(Vehicule assurePar) {
        this.assurePar = assurePar;
    }

    public LinkedList<Troncon> getListeTronçons() {
        //TODO
    }

    public void addTroncons(Troncon troncon) {
        //TODO
    }
}