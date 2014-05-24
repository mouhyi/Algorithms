import java.io.*;
import java.util.Arrays;

public class FollowingInteger {
	/*
	 * You are writing out a list of numbers.Your list contains all numbers with
	 * exactly Di digits in its decimal representation which are equal to i, for
	 * each i between 1 and 9, inclusive. You are writing them out in ascending
	 * order. For example, you might be writing every number with two '1's and
	 * one '5'. Your list would begin 115, 151, 511, 1015, 1051. Given N, the
	 * last number you wrote, compute what the next number in the list will be.
	 * The number of 1s, 2s, ..., 9s is fixed but the number of 0s is arbitrary.
	 * 
	 * Input sample:
	 * 
	 * Your program should accept as its first argument a path to a filename.
	 * Each line in this file is one test case. Each test case will contain an
	 * integer n < 10^6
	 * 
	 * Output sample:
	 * 
	 * For each line of input, generate a line of output which is the next
	 * integer in the list.
	 */
	
	
	public static int followingInteger(String n){

		String s = new StringBuilder("0"+n).reverse().toString();
		int [] a = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
		      a[i] = s.charAt(i) - '0';
		}
		
		// find inversion
		int i=0;
		
		while(i<a.length-1){
			if(a[i]<=a[i+1]){
				i++;
			}else{
				// find upper bound
				int x=a[i+1];
				int ub = a[i], ubIndex=i;
				for(int j=i; j>=0; j--){
					if(a[j]>x && a[j]<ub){
						ub = a[j];
						ubIndex = j;
					}
				}
				
				// swap ub and x
				a[ubIndex] = a[i+1];
				a[i+1] = ub;
				
				// sort a[0..i]
				int[] subA  = Arrays.copyOfRange(a, 0, i+1);
				Arrays.sort(subA);
				for(int j=0; j<=i; j++){
					a[j] = subA[i-j];
				}
				
				// recover int
				StringBuilder sb = new StringBuilder(a.length);
				for(int j=a.length-1; j>=0; j--){
					sb.append(a[j]);
				}
				
				return Integer.valueOf(sb.toString());
				
			}
		}
			
		return 0;
	}
	

	
	public static void main (String[] args) throws IOException {

	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	        String[] lineArray = line.split("\\s");
	        if (lineArray.length > 0) {
	            System.out.println(followingInteger(lineArray[0]));
	        }
	    }
	  }
}
