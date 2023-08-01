package AlteKlausuren.Klausur_24_02_2021.Aufgabe_003;

public class BestellService implements Runnable {
    private final Warteschlange warteschlange;
    private final int delay;

    public BestellService(Warteschlange warteschlange, int delay) {
        this.warteschlange = warteschlange;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (warteschlange) {
                while (warteschlange.isFull()) {
                    try {
                        warteschlange.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                warteschlange.enqueue(new Bestellung("Cola"));
                warteschlange.notifyAll();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
