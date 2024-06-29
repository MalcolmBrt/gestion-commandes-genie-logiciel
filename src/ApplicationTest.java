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
        assertNotNull(commande);
        assertTrue(commande instanceof CommandeSurPlace);
        assertEquals(1600, commande.getPrix());
    }

    @Test
    public void testCreationCommandeEmporter() {
        CommandeFactory factory = new CommandeEmporterFactory();
        List<Plat> plats = Arrays.asList(new Plat("Salade César", 890));
        Commande commande = ((CommandeEmporterFactory) factory).creerCommandeTest("Jane Doe", 987654321, plats);
        assertNotNull(commande);
        assertTrue(commande instanceof CommandeEmporter);
        assertEquals(890, commande.getPrix());
    }

    @Test
    public void testCreationCommandeLivraison() {
        CommandeFactory factory = new CommandeLivraisonFactory();
        List<Plat> plats = Arrays.asList(new Plat("Burger Classic", 1050));
        Commande commande = ((CommandeLivraisonFactory) factory).creerCommandeTest("Alice Doe", 112233445,
                "123 Main St", plats);
        assertNotNull(commande);
        assertTrue(commande instanceof CommandeLivraison);
        assertEquals(1050, commande.getPrix());
    }

    @Test
    public void testTarificationNormale() {
        TarificationStrategy strategy = new TarificationNormale();
        int prixInitial = 1000;
        int prixFinal = strategy.calculerPrix(prixInitial);
        assertEquals(prixInitial, prixFinal);
    }

    @Test
    public void testTarificationReduction() {
        TarificationStrategy strategy = new Reduction();
        int prixInitial = 1000;
        int prixFinal = strategy.calculerPrix(prixInitial);
        assertEquals(900, prixFinal);
    }

    @Test
    public void testTarificationHappyHour() {
        TarificationStrategy strategy = new HappyHour();
        int prixInitial = 1000;
        int prixFinal = strategy.calculerPrix(prixInitial);
        assertEquals(700, prixFinal);
    }

    @Test
    public void testConnexionBDD() {
        HashMap<Integer, Plat> menu = ConnexionBDD.getMenu();
        assertNotNull(menu);
        assertFalse(menu.isEmpty());
    }
}
