package org.example.magasinjava;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Produit p1 = new Produit(1001, "Vitalait", "Lait");
        p1.setPrix(0.7f);

        Produit p2 = new Produit(1001, "Vitalait", "Lait", 0.7f, new Date());
        Produit p3 = new Produit(1024, "Delice", "Lait", 0.8f, new Date());

        // Comparaison avec la méthode qui prend un seul produit en paramètre
        System.out.println("Comparaison de p1 et p2 (méthode comparer avec un paramètre) : " + p1.comparer(p2)); // true
        System.out.println("Comparaison de p1 et p3 (méthode comparer avec un paramètre) : " + p1.comparer(p3)); // false

        // Comparaison avec la méthode qui prend deux produits en paramètre
        System.out.println("Comparaison de p1 et p2 (méthode comparer avec deux paramètres) : " + Produit.comparer(p1, p2)); // true
        System.out.println("Comparaison de p2 et p3 (méthode comparer avec deux paramètres) : " + Produit.comparer(p2, p3)); // false

        // Création des magasins
        Magasin magasin1 = new Magasin(1, "Avenue Habib Bourguiba");
        Magasin magasin2 = new Magasin(2, "Rue de la Liberté");

        // Ajout de produits dans les magasins
        magasin1.ajouterProduit(p1);
        magasin2.ajouterProduit(p3);

        // Afficher les magasins
        magasin1.afficherMagasin();
        magasin2.afficherMagasin();

        // Chercher un produit dans les magasins
        System.out.println("Recherche de p1 dans magasin1 : " + magasin1.chercherProduit(p1)); // true
        System.out.println("Recherche de p3 dans magasin1 : " + magasin1.chercherProduit(p3)); // false
        System.out.println("Recherche de p3 dans magasin2 : " + magasin2.chercherProduit(p3)); // true
        System.out.println("Recherche de p1 dans magasin2 : " + magasin2.chercherProduit(p1)); // false

        // Tentative de suppression d'un produit
        boolean suppressionP1 = magasin1.supprimerProduit(p1); // Suppression de p1 dans magasin1
        if (suppressionP1) {
            System.out.println("Produit " + p1.libelle + " supprimé avec succès dans magasin1.");
        } else {
            System.out.println("Échec de la suppression du produit " + p1.libelle + " dans magasin1.");
        }

        // Afficher le magasin après la suppression
        magasin1.afficherMagasin(); // Vérifier l'état du magasin après la suppression

        // Comparaison des magasins
        Magasin plusGrandMagasin = Magasin.comparerMagasins(magasin1, magasin2);
        if (plusGrandMagasin != null) {
            System.out.println("Le magasin avec le plus de produits est celui de l'adresse : " + plusGrandMagasin.getAdresse());
        }
    }
}
