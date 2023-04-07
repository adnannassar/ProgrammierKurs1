package Grundlagen;

import java.util.LinkedList;

public abstract class Mitarbeiter {
    private String name;
    double gehalt;

    public abstract double berechneJahresGehalt();

    public Mitarbeiter(String name, double gehalt) {
        this.name = name;
        this.gehalt = gehalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }
}

interface Finnanzamt {
    int F_bonus = 1000;

    double steuerErklärung();
}

class Driver extends Mitarbeiter {

    public Driver(String name, double gehalt) {
        super(name, gehalt);
    }

    @Override
    public double berechneJahresGehalt() {
        return gehalt * 12;
    }
}

class Manager extends Mitarbeiter implements Finnanzamt {
    private double bonus;

    public Manager(String name, double gehalt, double bonus) {
        super(name, gehalt);
        this.bonus = bonus;
    }


    @Override
    public double berechneJahresGehalt() {
        return (gehalt * 12) + bonus + steuerErklärung();
    }

    @Override
    public String getName() {
        return "The Grundlagen.Manager: " + super.getName();
    }


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public double steuerErklärung() {
        return berechneJahresGehalt() + 5 * 10 / 100 % 2;

    }
}

class GeschäftsFührer extends Mitarbeiter implements Finnanzamt {
    private float anteil;
    private double bonus;

    public GeschäftsFührer(String name, double gehalt, float anteil, double bonus) {
        super(name, gehalt);
        this.anteil = anteil;
        this.bonus = bonus;
    }

    public float getAnteil() {
        return anteil;
    }

    public void setAnteil(float anteil) {
        this.anteil = anteil;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double berechneJahresGehalt() {
        return (gehalt * 12) + ((anteil * gehalt) / 100);
    }

    @Override
    public double steuerErklärung() {
        return 1000;
    }
}

class Test {
    public static void main(String[] args) {
        Mitarbeiter m1 = new Manager("Grundlagen.Manager", 1000, 5000);
        Mitarbeiter m2 = new GeschäftsFührer("Grundlagen.GeschäftsFührer", 50000, 5, 10000);
        Mitarbeiter m3 = new Driver("Grundlagen.Driver", 500);

        Firma firma = new Firma("Grundlagen.Firma GmbH");
        firma.addMitarbeiter(m1);
        firma.addMitarbeiter(m2);
        firma.addMitarbeiter(m3);
    }
}


class Firma {
    private String name;
    private LinkedList<Mitarbeiter> mitarbeiters;


    public Firma(String name) {
        this.name = name;
    }

    public void addMitarbeiter(Mitarbeiter m) {
        mitarbeiters.add(m);
    }

}
