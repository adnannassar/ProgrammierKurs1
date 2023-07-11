package ObserverPattern.InvalidationListner;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Customer implements InvalidationListener {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void invalidated(Observable observable) {
        System.out.println(observable);
    }
}
