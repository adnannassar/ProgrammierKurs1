package ObserverPattern.InvalidationListner;

import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class Artikel {
    private DoubleProperty price;
    private String name;

    public Artikel(String name , double price) {
        this.price = new SimpleDoubleProperty(price);
        this.name = name;
    }

    public void setPrice(double newPrice){
        this.price.set(newPrice);
    }

    public double getPrice(){
        return this.price.get();
    }


    public void addListener(InvalidationListener invalidationListener){
        price.addListener(invalidationListener);
    }
}
