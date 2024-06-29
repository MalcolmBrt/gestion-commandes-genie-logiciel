package abstractfactory;

public class Plat {
    private String nom;
    private int prix;

    public Plat(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return nom + " (" + prix + " F)";
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

}
