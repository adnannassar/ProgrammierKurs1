package AlteKlausuren.Klausur_24_02_2021.Aufgabe_003;

import com.sun.webkit.ThemeClient;

public class VersandService implements Runnable {
    private final Warteschlange warteschlange;
    private final int delay;

    public VersandService(Warteschlange warteschlange, int delay) {
        this.warteschlange = warteschlange;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (warteschlange) {
                while (warteschlange.isEmpty()) {
                    try {
                        warteschlange.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Thread versandThread = new Thread(new VersandTask(warteschlange.dequeue()));
                versandThread.start();
                versandThread.interrupt();
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
