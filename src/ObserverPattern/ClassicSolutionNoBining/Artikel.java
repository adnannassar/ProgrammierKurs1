package ObserverPattern.ClassicSolutionNoBining;

public class Artikel {
    private String name;
    private double price;

    Firma firma;

    public Artikel(String name, double price, Firma firma) {
        this.name = name;
        this.price = price;
        this.firma = firma;
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
            System.out.println("Es gibt neue Angebote!");
            firma.werbungDrucken();
        } else {
            price = newPrice;
        }
    }

    @Override
    public String toString() {
        return name + " " + price + "€";
    }
}
