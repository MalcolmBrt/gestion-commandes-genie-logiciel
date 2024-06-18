package abstractfactory;

public class CommandeEmporter extends Commande {
    public CommandeEmporter(int numeroTel, String nomClient) {
        super(numeroTel, nomClient);
    }

    public void afficherDetails() {
        System.out.println("------ Commande à emporter ------");
        super.afficherDetails();
        System.out.println("---------------------------------");
    }
}