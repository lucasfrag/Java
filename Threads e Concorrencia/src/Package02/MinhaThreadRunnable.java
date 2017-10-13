package Package02;

import java.util.logging.Level;
import java.util.logging.Logger;

import Package01.MeuRunnable;

public class MinhaThreadRunnable implements Runnable {
	private int numero;
	
	public MinhaThreadRunnable(int numero) {
		this.numero = numero;
	}
	
	@Override
	public void run() {
		
		for (int i=numero; numero <= 100; numero++) {
			System.out.println(numero);
			numero++;
		}
		
		try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(MeuRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
	
}
