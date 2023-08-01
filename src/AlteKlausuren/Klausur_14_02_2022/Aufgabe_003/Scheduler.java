package AlteKlausuren.Klausur_14_02_2022.Aufgabe_003;

import javax.swing.*;

public class Scheduler {
    public static void main(String[] args) {

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(counter++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        t2.start();
        JOptionPane.showMessageDialog(null, "Stop");
        t2.interrupt();
    }

    void start(Thread t, Runnable r) throws InterruptedException {
        t.start();
        Thread t2 = new Thread(r);
        t2.start();
        t.join();
        t2.join();
    }
}
