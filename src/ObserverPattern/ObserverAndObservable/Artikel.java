package ObserverPattern.ObserverAndObservable;


import java.util.Observable;

public class Artikel extends Observable {
    private String name;
    private double price;

    public Artikel(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (newPrice < this.price) {
            price = newPrice;
            String msg = " der Prise von " + name + " wurde reduziert, Der neue Preis ist " + price + "€";
            setChanged();
            notifyObservers(msg);
        } else {
            price = newPrice;
        }
    }

    @Override
    public String toString() {
        return name + " " + price + "€";
    }
}
