package ObserverPattern.ClassicSolutionNoBining;

public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma("Kaufland");
        Artikel a1 = new Artikel("Coca cola", 1.45, firma);
        Artikel a2 = new Artikel("Sinalco cola", 2.45, firma);
        Artikel a3 = new Artikel("Fanta", 1.00, firma);
        Artikel a4 = new Artikel("Coca cola Zero", 0.99, firma);

        firma.addArtikel(a1);
        firma.addArtikel(a2);
        firma.addArtikel(a3);
        firma.addArtikel(a4);

        a1.setPrice(1.30);
    }
}
