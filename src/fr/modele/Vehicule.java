package fr.modele;

public class Vehicule extends Modele implements Statement{
    private String immatriculation;
    private String marque;
    private String modele;
    private int puissanceFiscale;
    private int placeVehicule;
    private Energie energieUtilisee;
    private Utilisateur ConduitPar;
    private LinkedList<Trajet> assure;

    public Vehicule(String immatriculation, String marque, String modele, int puissanceFiscale, int placeVehicule, Energie energieUtilisee, Utilisateur conduitPar)

    public Vehicule(String immatriculation){
        //TODO
    }

    public String getImmatriculation(){
        //TODO
    }

    public void setImmatriculation(String immatriculation){
        //TODO
    }

    public String getMarque(){
        //TODO
    }

    public void setMarque(String marque){
        //TODO
    }

    public String getModele(){
        //TODO
    }

    public void setModele(String modele){
        //TODO
    }

    public int getPuissanceFiscale(){
        //TODO
    }

    public void setPuissanceFiscale(int puissanceFiscale){
        //TODO
    }

    public int getPlacevehicule(){
        //TODO
    }

    public void setPlaceVehicule(int placeVehicule){
        //TODO
    }

    public Energie getEnergieUtilisee(){
        //TODO
    }

    public void setEnergieUtilisee(int energieUtilisee){
        //TODO
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