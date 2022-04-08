package fr.modele;

import java.util.Date;

public class Trajet extends Modele implements Statement{
    private int idTrajet;
    private Date dateDepart;
    //private Date heureDepart; inutile
    private float latitude;
    private float longitude;
    private String immatriculation;
    private LinkedList<Troncon> listeTroncons;
    private Utilisateur proposePar;
    private Vehicule assurePar;

    public Trajet(Date dateDepart, float latitude, float longitude, String immatriculation, Utilisateur conducteur, Vehicule vehicule) {
        this.dateDepart = dateDepart;
        this.latitude = latitude;
        this.longitude = longitude;
        this.immatriculation = immatriculation;
        this.proposePar = conducteur;
        this.assurePar = vehicule;
    }

    public void printTrajet(int idTrajet) {
        System.out.prinln("Date de départ = " + this.dateDepart);
        System.out.prinln("Latitude = " + this.latitude);
        System.out.prinln("Longitude = " + this.longitude);
        System.out.prinln("Immatriculation = " + this.immatriculation);
        System.out.prinln("Conducteur = " + this.proposePar);
        System.out.prinln("Véhicule = " + this.assurePar);
    }

    public Date getDateDepart() {
        
        return this.dateDepart;
    }

    public void setDateDepart(int dateDepart) {
        //TODO
    }

    public int getHeureDepart() {
        //TODO
    }

    public void setHeureDepart(int heureDepart) {
        //TODO
    }

    public int getPlaceDepart() {
        //TODO
    }

    public void setPlaceDepart(int placeDepart) {
        //TODO
    }

    public String getimmatriculation() {
        //TODO
    }

    public void setimmatriculation(String immatriculation) {
        //TODO
    }

    public LinkedList<Troncon> getListeTronçons() {
        //TODO
    }

    public void addTroncons(Troncon troncon) {
        //TODO
    }

    public Utilisateur getProposePar() {
        //TODO
    }

    public void setProposePar(Utilisateur proposePar) {
        //TODO
    }

    public Vehicule getAssurePar() {
        //TODO
    }

    public void setAssurePar(Vehicule assurePar) {
        //TODO
    }
}