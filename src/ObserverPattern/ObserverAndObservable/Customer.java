package ObserverPattern.ObserverAndObservable;

import java.util.Observable;
import java.util.Observer;

public class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object msg) {
        System.out.println(name + " wurde benachrichtigt, dass" + msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
