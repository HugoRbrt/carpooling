package fr.modele;

public class Trajet extends Modele implements Statement{
    private int idTrajet;
    private int dateDepart;
    private int heureDepart;
    private int placeDepart;
    private String immatriculation;
    private LinkedList<Troncon> listeTroncons;
    private Utilisateur proposePar;
    private Vehicule assurePar;

    public Trajet(int dateDepart, int heureDepart, int placeDepart, String immatriculation, Utilisateur proposePar, Vehicule assurePar) {
        //TODO
    }

    public Trajet(int idTrajet) {
        //TODO
    }

    public int getDateDepart() {
        //TODO
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