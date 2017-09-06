
public class Iterative {
	public static double fatorial(int n) {
		double x = 1;
		
		for (int i = 2; i <= n; i++) {
			x *= i;
		}
		return x;
	}
}
