package esercizio_04_thread;
public class Risorsa {
    private int val;
    private boolean disponibile = false;

    public synchronized int consuma() {
        while (!disponibile) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        disponibile = false;
        System.out.println(Thread.currentThread().getName() + " ha consumato " + val);
        notify();
        return val;
    }

    public synchronized void produci(int val) {
        while (disponibile) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.val = val;
        disponibile = true;
        System.out.println(Thread.currentThread().getName() + " ha prodotto " + val);
        notify();
    }
    
}