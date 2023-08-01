package AlteKlausuren.Klausur_14_02_2022.Aufgabe_002;

public class Car {
    private String carmaker, model, color;
    private int price;

    public Car(String carmaker, int price) {
        this.carmaker = carmaker;
        this.price = price;
    }

    public String getCarmaker() {
        return carmaker;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return carmaker + ", " + price;
    }
}
