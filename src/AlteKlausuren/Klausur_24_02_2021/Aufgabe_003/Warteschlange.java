package AlteKlausuren.Klausur_24_02_2021.Aufgabe_003;

public class Warteschlange {
    private int first, last;
    private Bestellung[] array;

    public Warteschlange(int size) {
        this.first = this.last = -1;
        this.array = new Bestellung[size];
    }

    public boolean isEmpty() {
        return last == -1 && first == -1;
    }

    public boolean isFull() {
        return (first == -1 && last == array.length - 1) || (first == last && first != -1);
    }

    public void enqueue(Bestellung value) {
        if (!isFull()) {
            last = (last + 1) % array.length;
            array[last] = value;
        }
    }

    public Bestellung dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            first = (first + 1) % array.length;
            Bestellung tempData = array[first];
            // reset pointers
            if (first == last) {
                first = last = -1;
            }
            return tempData;
        }
    }


}
