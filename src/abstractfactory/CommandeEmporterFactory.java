package abstractfactory;

public class CommandeEmporterFactory implements CommandeFactory {
    public Commande creerCommande() {
        return new CommandeEmporter();
    }
}