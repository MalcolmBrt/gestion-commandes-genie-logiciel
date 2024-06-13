package abstractfactory;

public class CommandeEnLigne implements Commande {
    public void afficherDetails() {
        System.out.println("Commande en ligne");
    }
}