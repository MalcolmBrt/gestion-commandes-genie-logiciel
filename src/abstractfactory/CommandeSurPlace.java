package abstractfactory;

public class CommandeSurPlace extends Commande {
    public CommandeSurPlace(int numeroTel, String nomClient, String plat) {
        super(numeroTel, nomClient, plat);
    }

    public void afficherDetails() {
        System.out.println("----- Commande sur place ------");
        super.afficherDetails();
        System.out.println("-------------------------------");

    }
}