import java.util.Scanner;

public class Tritiling {

	static int[] dp = new int[31];

	static int[] f = new int[31];
	static int[] g = new int[31];

	public static int solve(int n) {
		if (n < 0) {
			return 0;
		} else if (dp[n] != 0) {
			return dp[n];
		} else {
			dp[n] = 3 * solve(n - 2);
			for (int i = 4; i <= n; i += 2) {
				dp[n] += 2 * solve(n - i);
			}
			return dp[n];
		}
	}

	public static void solveDP() {
		f[1] = 0;
		f[2] = 3;
		g[1] = 1;
		g[2] = 0;
		f[0] = 1;
		for (int i = 1; 2 * i - 1 <= 30; ++i){
			f[2 * i - 1] = 0;
		}
		for (int i = 3; i <= 30; ++i) {
			f[i] = f[i - 2] + g[i - 1] + g[i - 1];
			g[i] = f[i - 1] + g[i - 2];
		}
	}

	public static void main(String[] args) throws Exception {


		solveDP();
		Scanner in = new Scanner(System.in);
		int n;
		while ((n = in.nextInt()) != -1) {
			dp[0] = 1;
//			System.out.println(solve(n));
			System.out.println(f[n]);
		}
	}

}
