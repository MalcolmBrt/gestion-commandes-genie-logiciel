package abstractfactory;

import java.util.ArrayList;

public abstract class Commande {
    private int numeroTel;
    private String nomClient;
    private ArrayList<Plat> plat = new ArrayList<Plat>();
    private int prix;

    public Commande(int numeroTel, String nomClient) {
        this.numeroTel = numeroTel;
        this.nomClient = nomClient;
    }
    
    public void afficherDetails() {
        System.out.println("Numéro de téléphone : " + numeroTel);
        System.out.println("Nom du client : " + nomClient);
        System.out.println("Plats commandés : ");
        for (Plat plat : plat) {
            System.out.println(plat);
        }
        System.out.println("Prix total : " + prix + " F");
    }

    public void ajouterPlat(Plat plat) {
        this.plat.add(plat);
        this.prix += plat.getPrix();
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

     
}