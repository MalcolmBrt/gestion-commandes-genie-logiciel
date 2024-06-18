package abstractfactory;

public class CommandeSurPlace extends Commande {
    public CommandeSurPlace(int numeroTel, String nomClient) {
        super(numeroTel, nomClient);
    }

    public void afficherDetails() {
        System.out.println("------ Commande sur place -------");
        super.afficherDetails();
        System.out.println("---------------------------------");

    }
}