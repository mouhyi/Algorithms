import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ChoosingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Integer, Boolean> factors ;
		while(in.hasNextLine()){
			factors = new HashMap<Integer, Boolean>();
			List<Integer> list =  readInts(in);
			boolean good;
			for(int i=0; i<list.size(); i++){
				int n = list.get(i);
				if( primeFactors(n, factors)){
					list.remove(list.indexOf(n));
					i--;
				}
			}
			for(int i=0; i<list.size(); i++){
				int n = list.get(i);
				if(checkPrimeFactors(n, factors)){
					list.remove(list.indexOf(n));
					i--;
				}
			}
			System.out.println( (Collections.max(list)) );
		}
	}

	public static ArrayList<Integer> readInts( Scanner in) {
		String line = in.nextLine();
		String[] result = line.split("\\s+");
		int size = Integer.parseInt(result[0]);
		ArrayList<Integer> a = new ArrayList<Integer>(size);
		for (int i=1; i<result.length; i++) {
			a.add(i-1, Integer.parseInt(result[i]));
		}
		return a;
	}

	public static boolean primeFactors(int n, HashMap<Integer, Boolean> factors) {
		boolean res=true;
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				if(factors.containsKey(i)){
					factors.put(i, true);
					res = false;
				}else{
					factors.put(i, false);
				}
				n /= i;
			}
		}
		if (n > 1) {
			factors.put(n, false);
		}
		return res;
	}
	
	public static boolean checkPrimeFactors(int n, HashMap<Integer, Boolean> factors){
		boolean res=true;
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				res = factors.get(i);
				n /= i;
			}
		}
		return res;
		
	}
}
