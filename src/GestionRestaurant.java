
// Classe principale pour l'application

import java.util.ArrayList;
import java.util.Scanner;

import abstractfactory.*;
import strategy.*;

public class GestionRestaurant {
    private static ArrayList<Commande> commandes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandeFactory commandeFactory;
        TarificationStrategy tarificationStrategy;

        System.out.println("Bienvenue au système de gestion des commandes du restaurant.");

        while (true) {
            System.out.println("1. Créer une commande");
            System.out.println("2. Afficher les commandes");
            System.out.println("3. Quitter");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Sélectionnez le type de commande :");
                    System.out.println("1. Sur place");
                    System.out.println("2. À emporter");
                    System.out.println("3. À livrer");
                    int typeCommande = scanner.nextInt();

                    switch (typeCommande) {
                        case 1:
                            commandeFactory = new CommandeSurPlaceFactory();
                            break;
                        case 2:
                            commandeFactory = new CommandeEmporterFactory();
                            break;
                        case 3:
                            commandeFactory = new CommandeLivraisonFactory();
                            break;
                        default:
                            System.out.println("Choix invalide.");
                            continue;
                    }

                    Commande commande = commandeFactory.creerCommande();
                    commandes.add(commande);

                    System.out.println("Sélectionnez la stratégie de tarification :");
                    System.out.println("1. Normale");
                    System.out.println("2. Réduction (-10%)");
                    System.out.println("3. Happy Hour (-30%)");
                    int typeTarification = scanner.nextInt();

                    switch (typeTarification) {
                        case 1:
                            tarificationStrategy = new TarificationNormale();
                            break;
                        case 2:
                            tarificationStrategy = new Reduction();
                            break;
                        case 3:
                            tarificationStrategy = new HappyHour();
                            break;
                        default:
                            System.out.println("Choix invalide.");
                            continue;
                    }

                    int prixFinal = tarificationStrategy.calculerPrix(commande.getPrix());
                    commande.setPrix(prixFinal);
                    System.out.println("Prix final après application de la stratégie : " + prixFinal + " F");

                    break;
                case 2:
                    for (Commande c : commandes) {
                        c.afficherDetails();
                    }
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
    }
}
