import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class B2Palindrome {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		System.out.println(mthpalindrome(m));

	}
	
	public static int mthpalindrome(int m){
		switch (m){
			case 1: return 1;
			case 2: return 3;
			default:{
				HashMap <Integer, ArrayList<Integer>> pal_bits = new HashMap <Integer, ArrayList<Integer>>();
				pal_bits.put(1, new ArrayList<Integer>());
				pal_bits.get(1).add(1);
				pal_bits.put(2, new ArrayList<Integer>());
				pal_bits.get(2).add(3);
				int bits = 3;
				
				int[] pal = new int[m+1];
				pal[1] = 1;
				pal[2]=3;
				int msb = 1<<2;
				int i=3;
				while(i<=m){
					pal_bits.put(bits, new ArrayList<Integer>());
					pal_bits.get(bits).add(msb+1);
					pal[i] = msb+1;
					// i++;
					if(i>=m) return pal[m];
					
					for(int l=1; l<bits-1; l++){
						if((bits-l)%2 == 1) continue;
						if(i>m) return pal[m];
						for(int prevPal: pal_bits.get(l)){
							i++;
							if(i>m) return pal[m];
							pal[i] = msb+1+ (prevPal<<(bits-l)/2);
							pal_bits.get(bits).add(pal[i]);
							if(i>m) return pal[m];
						}
					}
					
//					for(int prevPal: pal_bits.get(bits-2)){
//						i++;
//						if(i>m) return pal[m];
//						pal[i] = msb+1+ (prevPal<<1);
//						pal_bits.get(bits).add(pal[i]);
//						if(i>m) return pal[m];
//					}
					bits++;
					
					i++;
					msb = msb*2;
				}
				return pal[m];
			}
		}
	}
	
	public static boolean isPalindrome(int n){
		    int m = 0;

		    for(int tmp = n; tmp>0; tmp >>= 1){
		        m = (m << 1) | (tmp & 1);
		    }    	
		    return m == n;
	}
}
