package IO;

import java.io.Serializable;

public class Angestellter implements Serializable {
    private String name;
    private double gehalt;
    public static final long serialVersionUID = 1L;

    public Angestellter(String name, double gehalt) {
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

    @Override
    public String toString() {
        return "Name: " + name + ", Gehalt: " + gehalt;
    }
}

