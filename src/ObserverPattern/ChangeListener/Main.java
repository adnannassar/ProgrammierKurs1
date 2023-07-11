package ObserverPattern.ChangeListener;

public class Main {
    public static void main(String[] args) {
        Artikel car = new Artikel("Car", 250000 );

        Customer c1 = new Customer("Badr");
        Customer c2 = new Customer("Ali");
        Customer c3 = new Customer("Batoul");
        Customer c4 = new Customer("Hadeel");

        car.addListener(c1);
        car.addListener(c4);

        car.setPrice(150000);

    }
}
