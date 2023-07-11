package ObserverPattern.SupportListener;

public class Main {
    public static void main(String[] args) {
        Artikel car = new Artikel(200000);

        Customer c1 = new Customer("Badr");
        Customer c2 = new Customer("Ali");
        Customer c3 = new Customer("Batoul");
        Customer c4 = new Customer("Hadeel");

        car.addPropertyChangeListener(c1);
        car.addPropertyChangeListener(c4);


        car.setPrice(160000);

    }
}
