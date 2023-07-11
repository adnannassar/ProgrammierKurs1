package ObserverPattern.SupportListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Artikel {
    private double price;
    private final PropertyChangeSupport support;
    private static final String price_key = "price";


    public double getPrice() {
        return price;
    }

    public static String gerPriceKey() {
        return price_key;
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }

    public Artikel(double price) {
        this.price = price;
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }


    public void setPrice(double newPrice) {
        double oldPrice = this.price;
        this.price = newPrice;
        support.firePropertyChange(price_key, oldPrice, newPrice);
    }

}
