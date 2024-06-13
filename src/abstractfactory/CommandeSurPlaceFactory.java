package abstractfactory;

public class CommandeSurPlaceFactory implements CommandeFactory {
    public Commande creerCommande() {
        return new CommandeSurPlace();
    }
}