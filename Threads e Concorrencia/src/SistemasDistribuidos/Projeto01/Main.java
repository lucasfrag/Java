package SistemasDistribuidos.Projeto01;

public class Main {
    public static void main(String[] args) {
        new MeuThread().start();
        
        MeuRunnable meuRunnable = new MeuRunnable();
        new Thread(meuRunnable).start();
        
    }
}
