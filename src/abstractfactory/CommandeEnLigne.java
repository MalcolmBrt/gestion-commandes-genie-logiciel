package abstractfactory;

public class CommandeEnLigne extends Commande {
    public CommandeEnLigne(int numeroTel, String nomClient, String plat) {
        super(numeroTel, nomClient, plat);
    }

    public void afficherDetails() {
        System.out.println("------ Commande en ligne ------");
        super.afficherDetails();
        System.out.println("-------------------------------");

    }
}