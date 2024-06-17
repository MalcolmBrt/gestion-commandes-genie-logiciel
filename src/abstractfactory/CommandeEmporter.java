package abstractfactory;

public class CommandeEmporter extends Commande {
    public CommandeEmporter(int numeroTel, String nomClient, String plat) {
        super(numeroTel, nomClient, plat);
    }

    public void afficherDetails() {
        System.out.println("----- Commande à emporter -----");
        super.afficherDetails();
        System.out.println("-------------------------------");

    }
}