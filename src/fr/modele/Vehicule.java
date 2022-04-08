package fr.modele;

import java.util.LinkedList;

public class Vehicule extends Modele implements Statement{
    private String immatriculation;
    private String marque;
    private String modele;
    private int puissanceFiscale;
    private int placeVehicule;
    private Energie energieUtilisee;
    private LinkedList<Utilisateur> conduitPar;
    private LinkedList<Trajet> assure;

    public Vehicule(String immatriculation, String marque, String modele, int puissanceFiscale, int placeVehicule, Energie energieUtilisee, LinkedList<Utilisateur> conducteurs) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.puissanceFiscale = puissanceFiscale;
        this.placeVehicule = placeVehicule;
        this.energieUtilisee = energieUtilisee;
        this.conduitPar = conducteurs;
    }

    public void printVehicule(){
        System.out.println("Immatriculation = " + this.immatriculation);
        System.out.println("Marque = " + this.marque);
        System.out.println("Modèle = " + this.modele);
        System.out.println("Puissance fiscale = " + this.puissanceFiscale);
        System.out.println("Place disponibles pour passager = " + this.placeVehicule);
        System.out.println("Energie utilisée = " + this.energieUtilisee.getEnergieUtilisee());
    }

    public String getImmatriculation(){
        System.out.println("Immatriculation = " + this.immatriculation);
        return this.immatriculation;
    }

    public void setImmatriculation(String immatriculation){
        this.immatriculation = immatriculation;
    }

    public String getMarque(){
        System.out.println("Marque = " + this.marque);
        return this.marque;
    }

    public void setMarque(String marque){
        this.marque = marque;
    }

    public String getModele(){
        System.out.println("Modèle = " + this.modele);
        return this.modele;
    }

    public void setModele(String modele){
        this.modele = modele;
    }

    public int getPuissanceFiscale(){
        System.out.println("Puissance fiscale = " + this.puissanceFiscale);
        return this.puissanceFiscale;
    }

    public void setPuissanceFiscale(int puissanceFiscale){
        this.puissanceFiscale = puissanceFiscale;
    }

    public int getPlacevehicule(){
        System.out.println("Place disponibles pour passager = " + this.placeVehicule);
        return this.placeVehicule;
    }

    public void setPlaceVehicule(int placeVehicule){
        this.placeVehicule = placeVehicule;
    }

    public Energie getEnergieUtilisee(){
        System.out.println("Energie utilisée = " + this.energieUtilisee.getEnergieUtilisee());
        return this.energieUtilisee;
    }

    public void setEnergieUtilisee(String energieUtilisee){
        this.energieUtilisee.setEnergie(energieUtilisee);
    }

    public Utilisateur getConduitPar(){
        //TODO
    }

    public void setConduitPar(int conduitPar){
        //TODO
    }

    public LinkedList<Trajet> getAssure(){
        //TODO
    }

    public void addAssure(Trajet trajet){
        //TODO
    }
}