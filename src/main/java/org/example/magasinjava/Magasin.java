package org.example.magasinjava;

public class Magasin {
    private int identifiant;
    private String nom;
    private String adresse;
    private final int CAPACITE = 50;
    private Produit[] produits = new Produit[CAPACITE]; // Tableau statique de produits
    private int nombreProduits = 0; // Compteur de produits dans ce magasin
    private static int totalProduits = 0; // Compteur de tous les produits dans tous les magasins

    private final int CAPACITE_EMPLOYES = 20;
    private Employe[] employes = new Employe[CAPACITE_EMPLOYES];
    private int nombreEmployes = 0;

    public Magasin(int identifiant, String nom, String adresse) {
        this.identifiant = identifiant;
        this.nom = nom;
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

    //Prosit 4:

    public boolean ajouterEmploye(Employe employe) {
        if (nombreEmployes < CAPACITE_EMPLOYES) {
            employes[nombreEmployes] = employe;
            nombreEmployes++;
            return true;
        } else {
            System.out.println("Capacité maximale d'employés atteinte pour le magasin.");
            return false;
        }
    }


    public void afficherEmployes() {
        System.out.println("Employés du magasin " + nom + " :");
        for (int i = 0; i < nombreEmployes; i++) {
            Employe e = employes[i];
            System.out.println("Nom : " + e.getNom() + ", Adresse : " + e.getAdresse() + ", Heures : " + e.getNbrHeures());

            // Display specific characteristics based on the type of employee
            if (e instanceof Vendeur) {
                System.out.println("Type : Vendeur, Taux de Vente : " + ((Vendeur) e).getTauxDeVente());
            } else if (e instanceof Caissier) {
                System.out.println("Type : Caissier, Numéro de Caisse : " + ((Caissier) e).getNumeroDeCaisse());
            } else if (e instanceof Responsable) {
                System.out.println("Type : Responsable, Prime : " + ((Responsable) e).getPrime());
            }
        }
    }

    public void afficherDetails() {
        System.out.println("ID du magasin : " + identifiant);
        System.out.println("Nom du magasin : " + nom);
        System.out.println("Adresse du magasin : " + adresse);
        System.out.println("Nombre de produits : " + totalProduits);
        System.out.println("Nombre d'employés : " + nombreEmployes);

        System.out.println("\nProduits :");
        for (Produit produit : produits) {
            if (produit != null) {
                System.out.println("  - " + produit);
            }
        }

        System.out.println("\nEmployés :");
        if (employes != null) {
            System.out.println("Employés du magasin " + nom + " :");
            for (Employe e : employes) {
                if (e != null) {
                    System.out.println("Nom : " + e.getNom() + ", Adresse : " + e.getAdresse() + ", Heures : " + e.getNbrHeures());

                    // Affichage des caractéristiques spécifiques en fonction du type d'employé
                    if (e instanceof Vendeur) {
                        System.out.println("Type : Vendeur, Taux de Vente : " + ((Vendeur) e).getTauxDeVente());
                    } else if (e instanceof Caissier) {
                        System.out.println("Type : Caissier, Numéro de Caisse : " + ((Caissier) e).getNumeroDeCaisse());
                    } else if (e instanceof Responsable) {
                        System.out.println("Type : Responsable, Prime : " + ((Responsable) e).getPrime());
                    }
                }
            }
        } else {
            System.out.println("Aucun employé disponible dans le magasin.");
        }
    }


    //question 6 prosit4:
    public void afficherSalaires() {
        System.out.println("\nSalaires des employés :");

        for (Employe e : employes) {
            if (e != null) {
                double salaire = 0;

                if (e instanceof Responsable) {
                    Responsable responsable = (Responsable) e;
                    int heures = responsable.getNbrHeures();
                    double prime = responsable.getPrime();

                    // Calcul du salaire pour un responsable
                    if (heures > 160) {
                        // Heures supplémentaires
                        int heuresSupplementaires = heures - 160;
                        salaire = (160 * 10) + (heuresSupplementaires * 10 * 1.2) + prime;
                    } else {
                        salaire = heures * 10 + prime;
                    }

                } else if (e instanceof Caissier) {
                    Caissier caissier = (Caissier) e;
                    int heures = caissier.getNbrHeures();

                    // Calcul du salaire pour un caissier
                    if (heures > 180) {
                        // Heures supplémentaires
                        int heuresSupplementaires = heures - 180;
                        salaire = (180 * 5) + (heuresSupplementaires * 5 * 1.15);
                    } else {
                        salaire = heures * 5;
                    }

                } else if (e instanceof Vendeur) {
                    Vendeur vendeur = (Vendeur) e;
                    double tauxDeVente = vendeur.getTauxDeVente();
                    salaire = 450 * (tauxDeVente / 100);
                }

                System.out.println("Nom : " + e.getNom() + ", Salaire : " + salaire + " DT");
            }
        }
    }

    //question7:
    public void afficherPrimesResponsables() {
        System.out.println("\nPrimes des responsables :");

        for (Employe e : employes) {
            if (e instanceof Responsable) {
                Responsable responsable = (Responsable) e;
                System.out.println("Nom : " + responsable.getNom() + ", Prime : " + responsable.getPrime() + " DT");
            }
        }
    }

    //question8:
    public void afficherSalairesEmployes() {
        System.out.println("\nSalaires des employés :");

        for (Employe e : employes) {
            if (e != null) {
                double salaire = 0;

                if (e instanceof Responsable) {
                    Responsable responsable = (Responsable) e;
                    int heures = responsable.getNbrHeures();
                    double prime = responsable.getPrime();

                    if (heures > 160) {
                        int heuresSupplementaires = heures - 160;
                        salaire = (160 * 10) + (heuresSupplementaires * 10 * 1.2) + prime;
                    } else {
                        salaire = heures * 10 + prime;
                    }

                    System.out.println("Nom : " + responsable.getNom() + ", Salaire : " + salaire + " DT");

                } else if (e instanceof Caissier) {
                    Caissier caissier = (Caissier) e;
                    int heures = caissier.getNbrHeures();

                    if (heures > 180) {
                        int heuresSupplementaires = heures - 180;
                        salaire = (180 * 5) + (heuresSupplementaires * 5 * 1.15);
                    } else {
                        salaire = heures * 5;
                    }

                    System.out.println("Nom : " + caissier.getNom() + ", Salaire : " + salaire + " DT");

                } else if (e instanceof Vendeur) {
                    Vendeur vendeur = (Vendeur) e;
                    double tauxDeVente = vendeur.getTauxDeVente();
                    salaire = 450 * (tauxDeVente / 100);

                    System.out.println("Nom : " + vendeur.getNom() + ", Salaire : " + salaire + " DT");
                }
            }
        }
    }


    //question10:
    public void afficherTousLesEmployes() {
        System.out.println("\nTous les employés du magasin " + nom + " :");

        for (Employe e : employes) {
            if (e != null) {
                System.out.println(e.toString());
            }
        }
    }


    //affiche nb employe par type:
    public void afficherNbrEmployesParType() {
        int compteurCaissiers = 0;
        int compteurVendeurs = 0;
        int compteurResponsables = 0;

        // Compter les employés par type
        for (Employe employe : employes) {
            if (employe instanceof Caissier) {
                compteurCaissiers++;
            } else if (employe instanceof Vendeur) {
                compteurVendeurs++;
            } else if (employe instanceof Responsable) {
                compteurResponsables++;
            }
        }

        // Affiche le résultat
        System.out.println("Nombre d'employés par type :");
        System.out.println("Caissiers : " + compteurCaissiers);
        System.out.println("Vendeurs : " + compteurVendeurs);
        System.out.println("Responsables : " + compteurResponsables);
    }









}