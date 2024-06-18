package strategy;

public class Reduction implements TarificationStrategy {
    public int calculerPrix(int prixInitial) {
        return (int) (prixInitial * 0.9); // 10% de réduction
    }
}