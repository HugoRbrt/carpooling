package fr.verbiagevoiture.modele;

import java.util.Scanner; // importe la classe Scanner du package java.util
import java.util.LinkedList;

public class Utilisateur extends Modele {
    private String email;
    private String nom;
    private String prenom;
    private String villeDeResidence;
    private String mdp;
    private double porteMonnaie;
    private LinkedList<Vehicule> conduit;
    private LinkedList<Trajet> propose;
   

    public Utilisateur(String email, String nom, String prenom, String villeDeResidence, String motDePasse) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.villeDeResidence = villeDeResidence;
        this.mdp = motDePasse;
        this.porteMonnaie = 0.0;
        this.conduit = new LinkedList<Vehicule>();  //ou new LinkedList<>(); ?
        this.propose = new LinkedList<Trajet>();    //ou new LinkedList<>(); ?
    }

    public void printInfoUtilisateur(String email) {
        System.out.println("email = " + this.email);
        System.out.println("nom = " + this.nom);
        System.out.println("prenom = " + this.prenom);
        System.out.println("ville de résidence = " + this.villeDeResidence);
        System.out.println("porte monnaie = " + this.porteMonnaie);
        //System.out.println("mes véhicules sont : ");
    }

    public String getEmail() {
        System.out.println("email = " + this.email);
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        System.out.println("nom = " + this.nom);
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        System.out.println("prenom = " + this.prenom);
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVilleDeResidence() {
        System.out.println("j'habite la ville de : " + this.villeDeResidence);
        return this.villeDeResidence;
    }

    public void setVilleDeResidence(String villeDeResidence) {
        this.villeDeResidence = villeDeResidence;
    }

    public String getMotDePasse() {
        System.out.println("mdp = " + this.mdp);
        return this.mdp;
    }

    public void setMotDePasse(String motDePasse) {
        System.out.println("saisissez votre ancien mot de passe : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals(this.mdp)) {
            this.mdp = motDePasse;
        } else {
            System.out.println("ancien mot de passe incorrect");
        }
    }

    public double getPorteMonnaie() {
        System.out.println("Mon solde est de : " + this.porteMonnaie + " €");
        return this.porteMonnaie;
    }

    public void addPorteMonnaie(float montant) {
        this.porteMonnaie = this.porteMonnaie + montant;
    }

    public LinkedList<Vehicule> getConduit() {
        this.conduit.listIterator();
    }

    public void addConduit(Vehicule vehicule) {
        this.conduit.add(vehicule);
    }

    public LinkedList<Trajet> getPropose() {
        this.propose.listIterator();
    }

    public void addPropose(Trajet trajet) {
        this.propose.add(trajet);
    }
}