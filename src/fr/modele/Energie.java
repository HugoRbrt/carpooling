package fr.modele;

public class Energie extends Modele implements Statement{
    private String energieUtilisee;
    private double alpha; //facteur coutEnergie

    public Energie(String energieUtilisee){
        if(energieUtilisee.equalsIgnoreCase("Diesel")) {
            this.energieUtilisee = "Diesel";
            this.alpha = 1.5;
        }
        else if(energieUtilisee.equalsIgnoreCase("Essence")) {
            this.energieUtilisee = "Essence";
            this.alpha = 1.5;
        }
        else if(energieUtilisee.equalsIgnoreCase("Hybride")) {
            this.energieUtilisee = "Hybride";
            this.alpha = 1;
        }
        else if(energieUtilisee.equalsIgnoreCase("Electrique")) {
            this.energieUtilisee = "Electrique";
            this.alpha = 0.5;
        } 
        else {
            throw new Exception("Energie Utilisée incorrect");
        }
    }

    public String getEnergieUtilisee(){
        System.out.println("Energie utilisée = " + this.energieUtilisee);
        return this.energieUtilisee;
    }

    public double getCoutEnergie(){
        System.out.println("Cout de l'énergie (facteur alpha) = " + this.alpha);
        return this.alpha;
    }

    public String setEnergie(String energieUtilisee){
        if(energieUtilisee.equalsIgnoreCase("Diesel")) {
            this.energieUtilisee = "Diesel";
            this.alpha = 1.5;
        }
        else if(energieUtilisee.equalsIgnoreCase("Essence")) {
            this.energieUtilisee = "Essence";
            this.alpha = 1.5;
        }
        else if(energieUtilisee.equalsIgnoreCase("Hybride")) {
            this.energieUtilisee = "Hybride";
            this.alpha = 1;
        }
        else if(energieUtilisee.equalsIgnoreCase("Electrique")) {
            this.energieUtilisee = "Electrique";
            this.alpha = 0.5;
        } 
        else {
            throw new Exception("Energie Utilisée incorrect");
        }
    }

}