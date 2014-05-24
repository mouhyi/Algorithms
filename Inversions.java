import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Inversions {

	public static int increasingSubsequence(int[] seq) {
		int[] L = new int[seq.length];
		L[0] = 1;
		for (int i = 1; i < L.length; i++) {
			int maxn = 0;
			for (int j = 0; j < i; j++) {
				if (seq[j] < seq[i] && L[j] > maxn) {
					maxn = L[j];
				}
			}
			L[i] = maxn + 1;
		}
		int maxi = 0;
		for (int i = 0; i < L.length; i++) {
			if (L[i] > maxi) {
				maxi = L[i];
			}
		}
		return (maxi);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] a;
		String line;
		line = in.nextLine();
		int T, N;
		T = Integer.parseInt(line);
		while (T-- > 0) {
			line = in.nextLine();
			N = Integer.parseInt(line);
			line = in.nextLine();
			a = line.split("\\s+");
			int[] A = new int[N];
			int i = 0;
			for (String x : a) {
				A[i++] = Integer.parseInt(x);
			}
			if ((N - increasingSubsequence(A)) % 2 == 1) {
				System.out.println("Alice");
			} else {
				System.out.println("Bob");
			}
		}

	}
}