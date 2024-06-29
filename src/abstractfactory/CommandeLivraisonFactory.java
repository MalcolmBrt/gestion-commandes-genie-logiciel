package abstractfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class CommandeLivraisonFactory implements CommandeFactory {
    public Commande creerCommande() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom : ");
        String nomClient = scanner.nextLine();
        System.out.print("Entrez le numéro de téléphone : ");
        int numeroTel = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante
        System.out.print("Entrez l'adresse : ");
        String adresse = scanner.nextLine();
        CommandeLivraison commande = new CommandeLivraison(numeroTel, nomClient, adresse);
        HashMap<Integer, Plat> menu = ConnexionBDD.getMenu();
        while (true) {
            // boucle for pour print tous les plats avec leur numéro du hashmap
            for (Map.Entry<Integer, Plat> entry : menu.entrySet()) {
                Integer numero = entry.getKey();
                Plat plat = entry.getValue();
                System.out.println(numero + " : " + plat);
            }
            System.out.print("Entrez le numéro du plat désiré (0 quand la commande est terminée) : ");
            int numeroPlat = scanner.nextInt();
            if (numeroPlat == 0) {
                break;
            }
            if (menu.containsKey(numeroPlat)) {
                commande.ajouterPlat(menu.get(numeroPlat));
            } else {
                System.out.println("Le numéro de plat est invalide.");
            }
        }
        return commande;
    }

    // Méthode utiliser pour les tests

    public Commande creerCommandeTest(String nomClient, int numeroTel, String adresse, List<Plat> plats) {
        CommandeLivraison commande = new CommandeLivraison(numeroTel, nomClient, adresse);
        for (Plat plat : plats) {
            commande.ajouterPlat(plat);
        }
        return commande;
    }

}
