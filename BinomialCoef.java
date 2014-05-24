import java.io.IOException;
import java.util.Scanner;

/*
 * This solution works for values of n that are small
 * How do I represent out of range values that the test data contains?
 *
 */
public class BinomialCoef {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		int [] input = new int[2];
		while((T--)>0){
			String line = in.nextLine();
			String[] result = line.split("\\s+");
			for (int i=0; i<2; i++) {
				input[i] = Integer.parseInt(result[i]);
			}
			System.out.println(modZero(input[0], input[1]));
		}
	}
	
	public static int modZero(int n, int p){
		int result=0;
		for(int k=0; k<=n; k++){
			if(maxPower(n-k, p) > maxPower(k+1, p) ){
				result ++;
			}
		}
		return result;
	}
	
	public static int maxPower(int x, int p){
		int res=0;
		while(x>0){
			if(x % p != 0){
				break;
			}
			res++;
			x = x/p;
		}
		return res;
	}
}
