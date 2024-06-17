package abstractfactory;

import java.util.Scanner;

public class CommandeSurPlaceFactory implements CommandeFactory {
    public Commande creerCommande() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom : ");
        String nomClient = scanner.nextLine();
        System.out.print("Entrez le numéro de téléphone : ");
        int numeroTel = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne restante
        System.out.print("Entrez le plat : ");
        String plat = scanner.nextLine();
        return new CommandeSurPlace(numeroTel, nomClient, plat);
    }
}