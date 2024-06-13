package strategy;

public class Reduction implements TarificationStrategy {
    public double calculerPrix(double prixInitial) {
        return prixInitial * 0.9; // 10% de réduction
    }
}