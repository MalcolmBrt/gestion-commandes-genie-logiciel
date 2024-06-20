package strategy;

public class HappyHour implements TarificationStrategy {
    public int calculerPrix(int prixInitial) {
        return (int) (prixInitial * 0.7); // 30% de réduction
    }
}