import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import abstractfactory.*;
import strategy.*;

public class ApplicationTest {

    @Test
    public void testCreationCommandeSurPlace() {
        CommandeFactory factory = new CommandeSurPlaceFactory();
        List<Plat> plats = Arrays.asList(new Plat("Pizza Margherita", 1100), new Plat("Soupe du jour", 500));
        Commande commande = ((CommandeSurPlaceFactory) factory).creerCommandeTest("John Doe", 123456789, plats);
        assertNotNull("La commande ne doit pas être nulle", commande);
        assertTrue("La commande doit être une instance de CommandeSurPlace", commande instanceof CommandeSurPlace);
        assertEquals("Le prix total de la commande doit être 1600", 1600, commande.getPrix());
    }

    @Test
    public void testCreationCommandeEmporter() {
        CommandeFactory factory = new CommandeEmporterFactory();
        List<Plat> plats = Arrays.asList(new Plat("Salade César", 890));
        Commande commande = ((CommandeEmporterFactory) factory).creerCommandeTest("Jane Doe", 987654321, plats);
        assertNotNull("La commande ne doit pas être nulle", commande);
        assertTrue("La commande doit être une instance de CommandeEmporter", commande instanceof CommandeEmporter);
        assertEquals("Le prix total de la commande doit être 890", 890, commande.getPrix());
    }

    @Test
    public void testCreationCommandeLivraison() {
        CommandeFactory factory = new CommandeLivraisonFactory();
        List<Plat> plats = Arrays.asList(new Plat("Burger Classic", 1050));
        Commande commande = ((CommandeLivraisonFactory) factory).creerCommandeTest("Alice Doe", 112233445,
                "123 Main St", plats);
        assertNotNull("La commande ne doit pas être nulle", commande);
        assertTrue("La commande doit être une instance de CommandeLivraison", commande instanceof CommandeLivraison);
        assertEquals("Le prix total de la commande doit être 1050", 1050, commande.getPrix());
    }

    @Test
    public void testTarificationNormale() {
        TarificationStrategy strategy = new TarificationNormale();
        int prixInitial = 1000;
        int prixFinal = strategy.calculerPrix(prixInitial);
        assertEquals("Le prix final doit être égal au prix initial", prixInitial, prixFinal);
    }

    @Test
    public void testTarificationReduction() {
        TarificationStrategy strategy = new Reduction();
        int prixInitial = 1000;
        int prixFinal = strategy.calculerPrix(prixInitial);
        assertEquals("Le prix final doit être 10% inférieur au prix initial", 900, prixFinal);
    }

    @Test
    public void testTarificationHappyHour() {
        TarificationStrategy strategy = new HappyHour();
        int prixInitial = 1000;
        int prixFinal = strategy.calculerPrix(prixInitial);
        assertEquals("Le prix final doit être 30% inférieur au prix initial", 700, prixFinal);
    }

    @Test
    public void testConnexionBDD() {
        ConnexionBDD connexion = new ConnexionBDD();
        HashMap<Integer, Plat> menu = connexion.getMenu();
        assertNotNull("Le menu ne doit pas être nul", menu);
        assertFalse("Le menu ne doit pas être vide", menu.isEmpty());
    }
}
