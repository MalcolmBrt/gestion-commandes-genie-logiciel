package abstractfactory;

public abstract class Commande {
    protected int numeroTel;
    protected String nomClient;
    protected String plat;

    public Commande(int numeroTel, String nomClient, String plat) {
        this.numeroTel = numeroTel;
        this.nomClient = nomClient;
        this.plat = plat;
    }
    
    public void afficherDetails() {
        System.out.println("Numéro de téléphone : " + numeroTel);
        System.out.println("Nom du client : " + nomClient);
        System.out.println("Plat : " + plat);
    }
}