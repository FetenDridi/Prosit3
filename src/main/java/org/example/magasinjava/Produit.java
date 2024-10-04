package org.example.magasinjava;
import java.util.Date;

public class Produit {
    private int identifiant;
    private String marque;
    String libelle;
    private Date dateexp;
    private float prix;

    public Produit(int id, String m, String l) {
        this.identifiant = id;
        this.marque = m;
        this.libelle = l;
    }

    public Produit(int identifiant, String m, String l, float p, Date d) {
        this.identifiant = identifiant;
        this.marque = m;
        this.libelle = l;
        setPrix(p); // On utilise le setter pour valider le prix
        this.dateexp = d;
    }

    public Produit() {}

    // Getter pour prix
    public float getPrix() {
        return prix;
    }

    // Setter pour prix avec validation
    public void setPrix(float prix) {
        if (prix >= 0) {
            this.prix = prix;
        } else {
            System.out.println("Erreur: Le prix ne peut pas être négatif.");
            this.prix = 0; // On met un prix par défaut en cas d'erreur
        }
    }

    public void afficher() {
        System.out.println("id: " + identifiant + " marque: " + marque + " libellé: " + libelle + " prix: " + this.prix);
    }

    public String toString() {
        return "id: " + identifiant + " marque: " + marque + " libellé: " + libelle + " prix: " + this.prix + " Date: " + dateexp;
    }

    // Méthode comparer avec un seul parametre
    public boolean comparer(Produit autreProduit) {
        return this.identifiant == autreProduit.identifiant &&
                this.libelle.equals(autreProduit.libelle) &&
                this.prix == autreProduit.getPrix();
    }

    // Méthode comparer avec deux produits
    public static boolean comparer(Produit produit1, Produit produit2) {
        return produit1.identifiant == produit2.identifiant &&
                produit1.libelle.equals(produit2.libelle) &&
                produit1.getPrix() == produit2.getPrix();
    }
}
