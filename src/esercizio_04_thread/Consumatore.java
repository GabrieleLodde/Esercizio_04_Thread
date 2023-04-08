package esercizio_04_thread;
public class Consumatore extends Thread{
    private Risorsa r;
    private int val = 0;
    private boolean running = true;

    Consumatore(String nome, Risorsa r) {
        super(nome);
        this.r = r;
    }

    public void arresta() {
        this.running = false;
    }

    public void run() {
        while (running) {
            r.consuma();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
    }
    
}