package ObserverPattern.ChangeListener;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Customer implements ChangeListener {

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
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        System.out.println("Artikel: " + observable.toString() + " Old price: " +oldValue + ", new Price: " + newValue);
    }
}
