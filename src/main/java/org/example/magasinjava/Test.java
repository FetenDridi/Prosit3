package org.example.magasinjava;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Produit p1 = new Produit(1001, "Vitalait", "Lait");
        p1.setPrix(0.7f);

        Produit p2 = new Produit(1001, "Vitalait", "Lait", 0.7f, new Date());
        Produit p3 = new Produit(1024, "Delice", "Lait", 0.8f, new Date());

//        // Comparaison avec la méthode qui prend un seul produit en paramètre
//        System.out.println("Comparaison de p1 et p2 (méthode comparer avec un paramètre) : " + p1.comparer(p2)); // true
//        System.out.println("Comparaison de p1 et p3 (méthode comparer avec un paramètre) : " + p1.comparer(p3)); // false
////
//        // Comparaison avec la méthode qui prend deux produits en paramètre
//        System.out.println("Comparaison de p1 et p2 (méthode comparer avec deux paramètres) : " + Produit.comparer(p1, p2)); // true
//        System.out.println("Comparaison de p2 et p3 (méthode comparer avec deux paramètres) : " + Produit.comparer(p2, p3)); // false

        // Création des magasins//prosit 4
        Magasin magasin1 = new Magasin(1, " Carrefour", "Centre-Ville");
        Magasin magasin2 = new Magasin(2, "Monoprix", "Menzah 6");
        magasin1.ajouterProduit(p1);
        magasin1.ajouterProduit(p2);
        magasin2.ajouterProduit(p3);
        // Création des employés pour le premier magasin
        Caissier caissier1 = new Caissier(1, "Ahmed", "Rue 1", 160, 101);
        Caissier caissier2 = new Caissier(2, "Fatma", "Rue 2", 140, 102);
        Vendeur vendeur1 = new Vendeur(3, "Sami", "Rue 3", 170, 0.10);
        Responsable responsable1 = new Responsable(4, "Ali", "Rue 4", 180, 500);

        magasin1.ajouterEmploye(caissier1);
        magasin1.ajouterEmploye(caissier2);
        magasin1.ajouterEmploye(vendeur1);
        magasin1.ajouterEmploye(responsable1);

        // Création des employés pour le deuxième magasin
        Caissier caissier3 = new Caissier(5, "Mouna", "Rue 5", 150, 201);
        Vendeur vendeur2 = new Vendeur(6, "Hassen", "Rue 6", 160, 0.12);
        Vendeur vendeur3 = new Vendeur(7, "Leila", "Rue 7", 165, 0.15);
        Vendeur vendeur4 = new Vendeur(8, "Karim", "Rue 8", 160, 0.09);
        Responsable responsable2 = new Responsable(9, "Yassine", "Rue 9", 190, 600);

        magasin2.ajouterEmploye(caissier3);
        magasin2.ajouterEmploye(vendeur2);
        magasin2.ajouterEmploye(vendeur3);
        magasin2.ajouterEmploye(vendeur4);
        magasin2.ajouterEmploye(responsable2);

        // Afficher les employés des magasins
        magasin1.afficherEmployes();
        magasin2.afficherEmployes();

        magasin1.afficherDetails();
        magasin2.afficherDetails();

        magasin1.afficherSalaires();
        magasin2.afficherSalaires();
        magasin1.afficherPrimesResponsables();
        magasin1.afficherSalairesEmployes();
        magasin1.afficherTousLesEmployes();


        Employe employe3 = new Caissier(1, "Atma", "Adresse1", 40, 700);
        Employe employe4 = new Caissier(1, "Atma", "Adresse1", 40, 700);

        if (employe3.equals(employe4)) {
            System.out.println("Les employés sont égaux.");
        } else {
            System.out.println("Les employés ne sont pas égaux.");
        }

        magasin1.afficherNbrEmployesParType();



    }}


        //ajout des produits
//       magasin1.ajouterProduit(new Produit(101, "Nestlé", "Chocolat", 2.5f);
//        magasin1.ajouterProduit(new Produit(102, "Danone", "Yaourt", 1.2f, new Date()));
//        magasin1.ajouterProduit(new Produit(103, "Oreo", "Biscuits", 3.0f, new Date()));
//        // Tentative d'ajouter un produit déjà existant
//        magasin1.ajouterProduit(new Produit(101, "Nestlé", "Chocolat", 2.5f, new Date()));
        //prosit3

        // Ajout de produits dans les magasins
        //        magasin1.ajouterProduit(p1);
        //        magasin2.ajouterProduit(p3);

//        // Afficher les magasins
//        magasin1.afficherMagasin();
//        magasin2.afficherMagasin();
//
//        // Chercher un produit dans les magasins
//        System.out.println("Recherche de p1 dans magasin1 : " + magasin1.chercherProduit(p1)); // true
//        System.out.println("Recherche de p3 dans magasin1 : " + magasin1.chercherProduit(p3)); // false
//        System.out.println("Recherche de p3 dans magasin2 : " + magasin2.chercherProduit(p3)); // true
//        System.out.println("Recherche de p1 dans magasin2 : " + magasin2.chercherProduit(p1)); // false
//
//        // Tentative de suppression d'un produit
//        boolean suppressionP1 = magasin1.supprimerProduit(p1); // Suppression de p1 dans magasin1
//        if (suppressionP1) {
//            System.out.println("Produit " + p1.libelle + " supprimé avec succès dans magasin1.");
//        } else {
//            System.out.println("Échec de la suppression du produit " + p1.libelle + " dans magasin1.");
//        }
//
//        // Afficher le magasin après la suppression
//        magasin1.afficherMagasin(); // Vérifier l'état du magasin après la suppression
//
//        // Comparaison des magasins
//        Magasin plusGrandMagasin = Magasin.comparerMagasins(magasin1, magasin2);
//        if (plusGrandMagasin != null) {
//
//
//            System.out.println("Le magasin avec le plus de produits est celui de l'adresse : " + plusGrandMagasin.getAdresse());
//        }
//    }
