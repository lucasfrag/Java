
public class Fibonacci {
	
	public static double recursive(int n) {
		if (n == 0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		return recursive(n - 1) + recursive(n - 2);
	}
	
	public static double iterative(int n) {
		double f1 = 1, f2 = 0;
		
		for (int i = 0; i < n; i++) {
			double x = f1 + f2;
			f1 = f2;
			f2 = x;
		}
		
		return f2;
	}
	
}
