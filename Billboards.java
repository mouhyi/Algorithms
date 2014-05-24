import java.io.IOException;
import java.util.Scanner;


public class Billboards {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int [] input = new int[2];
		String line = in.nextLine();
		String[] result = line.split("\\s+");
		for (int i=0; i<2; i++) {
			input[i] = Integer.parseInt(result[i]);
		}
		int N = input[0], K = input[1];
		int [] p = new int[N], opt = new int[N];
		for(int i=0; i<N; i++){
			p[i] = Integer.parseInt(in.nextLine());
		}
		opt[0] = p[0];
		int cur =1;
		int min = p[0];
		for(int i=1; i< N; i++){
			if(cur<K){
				cur++;
				if(min > p[i]) min = p[i];
				opt[i] = opt[i-1] + p[i];
			}else{
				
			}
		}
		/**
		 * opt = opt[N][K]
		 */
	}	
}
