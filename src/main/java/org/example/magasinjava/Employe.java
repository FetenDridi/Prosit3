package org.example.magasinjava;

// Classe Employe
public class Employe {
    private int id;
    private String nom;
    private String adresse;
    private int nbr_heures;
    @Override
    public String toString() {
        return "Nom: " + nom + ", Adresse: " + adresse + ", Heures: " + nbr_heures;
    }
    public Employe(int id, String nom, String adresse, int nbr_heures) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nbr_heures = nbr_heures;
    }
    // Implémentation de la méthode equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true; // Vérifie si les références sont identiques
        }
        if (o == null || getClass() != o.getClass()) {
            return false; // Vérifie si l'objet est nul ou de classe différente
        }
        Employe employe = (Employe) o; // Cast l'objet en Employe
        return id == employe.id && // Compare les IDs
                nom.equals(employe.nom) && // Compare les noms
                adresse.equals(employe.adresse) && // Compare les adresses
                nbr_heures == employe.nbr_heures ; // Compare le nombre d'heures
    }

    public void afficher() {
        System.out.println("ID: " + id + ", Nom: " + nom + ", Adresse: " + adresse + ", Nbr Heures: " + nbr_heures);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNbrHeures() {
        return nbr_heures;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNbrHeures(int nbr_heures) {
        this.nbr_heures = nbr_heures;
    }
}

// Classe Caissier
class Caissier extends Employe {
    private int numeroDeCaisse;

    public Caissier(int id, String nom, String adresse, int nbr_heures, int numeroDeCaisse) {
        super(id, nom, adresse, nbr_heures);
        this.numeroDeCaisse = numeroDeCaisse;
    }

    public int getNumeroDeCaisse() {
        return numeroDeCaisse;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Numéro de Caisse: " + numeroDeCaisse);
    }
}

// Classe Vendeur
class Vendeur extends Employe {
    private double tauxDeVente;

    public Vendeur(int id, String nom, String adresse, int nbr_heures, double tauxDeVente) {
        super(id, nom, adresse, nbr_heures);
        this.tauxDeVente = tauxDeVente;
    }

    public double getTauxDeVente() {
        return tauxDeVente;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Taux de Vente: " + tauxDeVente);
    }
}

// Classe Responsable
class Responsable extends Employe {
    private float prime;

    public Responsable(int id, String nom, String adresse, int nbr_heures, float prime) {
        super(id, nom, adresse, nbr_heures);
        this.prime = prime;
    }

    public float getPrime() {
        return prime;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Prime: " + prime);
    }






}