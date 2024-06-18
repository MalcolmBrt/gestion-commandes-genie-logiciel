package abstractfactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandeSurPlaceFactory implements CommandeFactory {
    public Commande creerCommande() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom : ");
        String nomClient = scanner.nextLine();
        System.out.print("Entrez le numéro de téléphone : ");
        int numeroTel = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante
        CommandeSurPlace commande = new CommandeSurPlace(numeroTel, nomClient);
        HashMap<Integer, Plat> menu = ConnexionBDD.getMenu();
        System.out.println(menu.get(2));
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

}