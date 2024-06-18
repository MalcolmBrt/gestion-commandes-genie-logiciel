package abstractfactory;

public class CommandeLivraison extends Commande {
    private String adresse;

    public CommandeLivraison(int numeroTel, String nomClient, String adresse) {
        super(numeroTel, nomClient);
        this.adresse = adresse;
    }

    public void afficherDetails() {
        System.out.println("------- Commande à livrer -------");
        System.out.println("Adresse : " + adresse);
        super.afficherDetails();
        System.out.println("---------------------------------");

    }
}