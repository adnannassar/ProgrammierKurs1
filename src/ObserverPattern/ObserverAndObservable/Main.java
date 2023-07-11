package ObserverPattern.ObserverAndObservable;


public class Main {
    public static void main(String[] args) {
        Artikel a1 = new Artikel("Coca cola", 1.45);
        Artikel a2 = new Artikel("Sinalco cola", 2.45);
        Artikel a3 = new Artikel("Fanta", 1.00);
        Artikel a4 = new Artikel("Coca cola Zero", 0.99);

        Customer c1 = new Customer("Badr");
        Customer c2 = new Customer("Ali");
        Customer c3 = new Customer("Mohamad");

        a1.addObserver(c1);
        a1.addObserver(c2);
        a1.addObserver(c3);

        a1.setPrice(1.35);
        a2.setPrice(1.25); // no effect!

    }
}
