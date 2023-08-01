package AlteKlausuren.Klausur_24_02_2021.Aufgage_001;

public class Value {
    private double x, y;

    public Value(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(X:" + x + ", Y:" + y + ")";
    }
}
