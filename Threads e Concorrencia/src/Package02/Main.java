package Package02;

public class Main {
	public static void main(String[] args) {
		MinhaThreadRunnable par = new MinhaThreadRunnable(1);
		MinhaThreadRunnable impar = new MinhaThreadRunnable(2);
		
		Thread t1 = new Thread(par);
		Thread t2 = new Thread(impar);

		t1.start();
		t2.start();
	}
}
