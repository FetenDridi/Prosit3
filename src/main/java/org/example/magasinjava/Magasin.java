package org.example.magasinjava;

public class Magasin {
    private int identifiant;
    private String adresse;
    private final int CAPACITE = 50;
    private Produit[] produits = new Produit[CAPACITE]; // Tableau statique de produits
    private int nombreProduits = 0; // Compteur de produits dans ce magasin
    private static int totalProduits = 0; // Compteur de tous les produits dans tous les magasins

    public Magasin(int identifiant, String adresse) {
        this.identifiant = identifiant;
        this.adresse = adresse;
    }

    public void afficherMagasin() {
        System.out.println("Magasin ID: " + identifiant + " Adresse: " + adresse + " Capacité: " + CAPACITE);
        System.out.println("Produits dans le magasin:");
        for (int i = 0; i < nombreProduits; i++) {
            System.out.println("Nom: " + produits[i].libelle + " Prix: " + produits[i].getPrix());
        }
    }

    // Méthode pour chercher un produit dans le magasin
    public boolean chercherProduit(Produit produitCherche) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].comparer(produitCherche)) { // Utilisation de la méthode comparer
                return true; // Produit trouvé
            }
        }
        return false; // Produit non trouvé
    }

    // Méthode pour ajouter un produit une seule fois
    public boolean ajouterProduit(Produit produit) {
        // Vérifier si le produit existe déjà
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].comparer(produit)) {
                System.out.println("Produit déjà présent dans le magasin.");
                return false; // Ne pas ajouter si le produit est déjà présent
            }
        }

        // Ajouter le produit seulement s'il n'existe pas déjà
        if (nombreProduits < CAPACITE) {
            produits[nombreProduits] = produit;
            nombreProduits++;
            totalProduits++;
            return true;
        } else {
            System.out.println("Capacité maximale atteinte dans le magasin.");
            return false;
        }
    }

    // Pour afficher le nombre total des produits dans tous les magasins
    public static int getTotalProduits() {
        return totalProduits;
    }

    // Méthode pour comparer deux magasins et retourner celui avec le plus de produits
    public static Magasin comparerMagasins(Magasin magasin1, Magasin magasin2) {
        if (magasin1.nombreProduits > magasin2.nombreProduits) {
            return magasin1;
        } else if (magasin1.nombreProduits < magasin2.nombreProduits) {
            return magasin2;
        } else {
            System.out.println("Les deux magasins ont le même nombre de produits.");
            return null; // Si les deux magasins ont le même nombre de produits
        }
    }

    public int getNombreProduits() {
        return nombreProduits;
    }

    public String getAdresse() {
        return adresse;
    }

    // Méthode pour supprimer un produit du magasin
    public boolean supprimerProduit(Produit produitASupprimer) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].comparer(produitASupprimer)) { // Utilisation de la méthode comparer
                // Décaler les produits à gauche pour supprimer le produit trouvé
                for (int j = i; j < nombreProduits - 1; j++) {
                    produits[j] = produits[j + 1];
                }
                produits[nombreProduits - 1] = null; // Optionnel : nettoyer la dernière position
                nombreProduits--; // Décrémenter le compteur de produits
                totalProduits--; // Décrémenter le compteur de produits total
                System.out.println("Produit supprimé : " + produitASupprimer.libelle);
                return true; // Produit supprimé avec succès
            }
        }
        System.out.println("Produit non trouvé dans le magasin.");
        return false; // Produit non trouvé
    }


}
