package fr.modele;

public class Utilisateur extends Modele implements Statement{
    private String email;
    private String nom;
    private String prenom;
    private String villeDeResidence;
    private String motDePasse;
    private int porteMonnaie;
    private LinkedList<Troncon> emprunte;
    private LinkedList<Trajet> propose;
    private LinkedList<Vehicule> conduit;

    public Utilisateur(String email, String nom, String prenom, String villeDeResidence, String motDePasse) {
        //TODO
    }

    public Utilisateur(String email) {
        //TODO
    }

    public String getEmail() {
        //TODO
    }

    public void setEmail(String email) {
        //TODO
    }

    public String getNom() {
        //TODO
    }

    public void setNom(String nom) {
        //TODO
    }

    public String getPrenom() {
        //TODO
    }

    public void setPrenom(String prenom) {
        //TODO
    }

    public String getVilleDeResidence() {
        //TODO
    }

    public void setVilleDeResidence(String villeDeResidence) {
        //TODO
    }

    public String getMotDePasse() {
        //TODO
    }

    public void setMotDePasse(String motDePasse) {
        //TODO
    }

    public int getPorteMonnaie() {
        //TODO
    }

    public void setPorteMonnaie(int porteMonnaie) {
        //TODO
    }

    public LinkedList<Troncon> getEmprunte() {
        //TODO
    }

    public void addEmprunte(Troncon troncon) {
        //TODO
    }

    public LinkedList<Trajet> getPropose() {
        //TODO
    }

    public void addPropose(Trajet trajet) {
        //TODO
    }

    public LinkedList<Vehicule> getConduit() {
        //TODO
    }

    public void addConduit(Vehicule vehicule) {
        //TODO
    }
}