
public class Recursive {
	public static double fatorial (int n) {
		if (n < 2) {
			return 1;
		}
		
		return n * fatorial (n - 1);
	}
}
