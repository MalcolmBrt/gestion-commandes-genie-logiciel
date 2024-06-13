package abstractfactory;

public class CommandeEnLigneFactory implements CommandeFactory {
    public Commande creerCommande() {
        return new CommandeEnLigne();
    }
}