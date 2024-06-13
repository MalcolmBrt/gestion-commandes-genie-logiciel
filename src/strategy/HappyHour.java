package strategy;

public class HappyHour implements TarificationStrategy {
    public double calculerPrix(double prixInitial) {
        return prixInitial * 0.8; // 20% de réduction
    }
}