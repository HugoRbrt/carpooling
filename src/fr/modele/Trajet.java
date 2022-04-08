package fr.modele;

import java.util.Calendar;
import java.util.LinkedList;

public class Trajet extends Modele implements Statement{
    private int idTrajet;
    private Calendar dateDepart;
    private Calendar dateArrivee;
    private String villeDepart;
    private String villeArrivee;
    private double[] gpsDepart = new double[2];    // [ latitudeDepart ; longitudeDepart ]
    private double[] gpsArrivee = new double[2];   // [ latitudeArrivee; longitudeArrivee ]
    // private String immatriculation;
    private Vehicule assurePar;
    private int nbPlacesDisponibles;
    private Utilisateur proposePar;
    private LinkedList<Troncon> listeTroncons;

    public Trajet(Calendar dateDepart, String villeDepart, String villeArrivee, double latitudeDepart, double longitudeDepart, double latitudeArrivee, double longitudeArrivee, /*String immatriculation,*/ Utilisateur conducteur, Vehicule vehicule, int nbPlacesDisponibles) {
        this.dateDepart = dateDepart;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.gpsDepart[0] = latitudeDepart;
        this.gpsDepart[1] = longitudeDepart;
        this.gpsArrivee[0] = latitudeArrivee;
        this.gpsArrivee[1] = longitudeArrivee;
        // this.immatriculation = immatriculation;
        this.proposePar = conducteur;
        this.assurePar = vehicule;
        this.nbPlacesDisponibles = nbPlacesDisponibles;
        this.listeTroncons = new LinkedList<Troncon>(); //ou new LinkedList<>(); ?
    }

    public int getIdTrajet() {
        System.out.println("IdTrajet = " + this.idTrajet);
        return this.idTrajet;
    }

    public Trajet getTrajet(int idTrajet) {
        Trajet t = new Trajet(this.dateDepart, this.villeDepart, this.villeArrivee, this.gpsDepart[0], this.gpsDepart[1], this.gpsArrivee[0], this.gpsArrivee[1], this.immatriculation, this.proposePar, this.assurePar);
        System.out.println("Date de départ = " + this.dateDepart);
        System.out.println("Ville de départ = " + this.villeDepart);
        System.out.println("Ville d'arrivée = " + this.villeArrivee);
        System.out.println("Latitude Départ = " + this.gpsDepart[0]);
        System.out.println("Longitude Départ = " + this.gpsDepart[1]);
        System.out.println("Latitude Arrivée = " + this.gpsArrivee[0]);
        System.out.println("Longitude Arrivée = " + this.gpsArrivee[1]);
        // System.out.println("Immatriculation = " + this.immatriculation);
        System.out.println("Conducteur = " + this.proposePar);
        System.out.println("Véhicule = " + this.assurePar);
        System.out.println("Places maximum disponobles sur le trajet = " + this.nbPlacesDisponibles);
        return t;
    }

    public int getNbPlacesDispoibles() {
        System.out.println("Places maximum disponobles sur le trajet = " + this.nbPlacesDisponibles);
        return this.nbPlacesDisponibles;
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

/*     public String getimmatriculation() {
        System.out.println("Immatriculation = " + this.immatriculation);
        return this.immatriculation;
    }

    public void setimmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    } */

    public Vehicule getAssurePar() {
        System.out.println("Trajet fait avec le véhicule : " + this.assurePar.getImmatriculation());
        return this.assurePar;
    }

    public void setAssurePar(Vehicule assurePar) {
        this.assurePar = assurePar;
    }

    public LinkedList<Troncon> getListeTronçons() {
        this.listeTroncons.listIterator();
    }

    /* Les tronçons doivent être ajoutés dans l'ordre de parcours */
    public void addTroncons(Troncon troncon) {
        if(this.listeTroncons.size() == 0) {
            if(troncon.getVilleDepart()!=this.villeDepart) {
                throw new Exception("La ville de départ du 1er tronçon doit correspondre à la ville de départ du trajet!");
            }
        }
        if(troncon.getNumTroncon()!=this.listeTroncons.size()) {
            throw new Exception("Les tronçons doivent être ajoutés dans l'ordre!");
        }
        if(troncon.getVilleDepart().equalsIgnoreCase(this.villeArrivee)) {
            throw new Exception("Le tronçon ne peut pas commencer avec la ville d'arrivée..");
        }
        if(troncon.getVilleArrivee().equalsIgnoreCase(this.villeDepart)) {
            throw new Exception("Le tronçon ne peut pas finir avec la ville de départ..");
        }
        if(!troncon.getVilleDepart().equalsIgnoreCase(this.listeTroncons.getLast().getVilleArrivee())) {
            throw new Exception("La ville de départ du tronçon doit correspondre à la ville d'arrivée du tronçon précédent");
        }
        this.listeTroncons.add(troncon);
    }

/*      EN VRAI TROP DE TRUC A VERIFIER, mais option à considérer pour une amélioration
        public void addSubTroncon(int numtroncon, Troncon troncon) {
        if(!this.listeTroncons.get(numtroncon-1).getVilleArrivee().equalsIgnoreCase(troncon.getVilleDepart())) {
            throw new Exception("La ville de départ du tronçon doit correspondre à la ville d'arrivée du tronçon précédent");
        }
        // if(!this.listeTroncons.get(numtroncon).getVilleArrivee().equalsIgnoreCase(troncon.getVilleArrivee())) {
        //     throw new Exception("La ville d'arrivée du tronçon doit correspondre à la ville de départ du tronçon suivant");
        // }
        this.listeTroncons.add(numtroncon, troncon);
    } */
}