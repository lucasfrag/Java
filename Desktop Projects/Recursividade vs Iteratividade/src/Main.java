
public class Main {

	public static void main(String[] args) {
		
		/* Teste de recursividade */
		System.out.println(Recursive.fatorial(6));
		
		/* Teste de iteratividade */
		System.out.println(Iterative.fatorial(6));
		
		System.out.println("");
		
		long s, e, t;
		
		/* Teste de tempo de resposta recursividade */
		s = System.currentTimeMillis();
		System.out.println(Fibonacci.recursive(47));
		e = System.currentTimeMillis();
		System.out.println(t = e - s);
		
		
		/* Teste de tempo de resposta iteratividade */
		s = System.currentTimeMillis();
		System.out.println(Fibonacci.iterative(47));
		e = System.currentTimeMillis();
		System.out.println(t = e - s);		
	}

}
