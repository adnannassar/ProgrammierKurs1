package ObserverPattern.ClassicSolutionNoBining;

import java.util.LinkedList;

public class Firma {
    private LinkedList<Artikel> artikels;
    private String name;

    public Firma(String name) {
        this.artikels = new LinkedList<>();
        this.name = name;
    }


    public LinkedList<Artikel> getArtikels() {
        return artikels;
    }

    public void setArtikels(LinkedList<Artikel> artikels) {
        this.artikels = artikels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addArtikel(Artikel artikel){
        this.artikels.add(artikel);
    }
    public void werbungDrucken(){
        System.out.println("Werbeprospekt");
        for(Artikel a  : artikels){
            System.out.println(a);
        }
    }
}
