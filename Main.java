import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Collections;
import java.util.Scanner;

class Main{

	public static HashMap<Integer, Integer> M = new HashMap<Integer, Integer> ();

	public static void main(String[] args) {
		
		int [] in = read();
		while(in != null ) {
			M = new HashMap<Integer, Integer> ();
			System.out.print(""+ in[0]+"	"+in[1]+"	"); 
			System.out.println(+algorithm(in[0],in[1]));
			in = read();
		}
	}

	public static int algorithm(int a, int b ){
		int max =-1;
		int n=1;
		
		for (int i=a; i<=b; i++){
			int bla = getCycle(i);
			M.put(i,bla );
		}
		int res = Collections.max(M.values());
		return res;
	}

	public static int getCycle(int n){
		int tmp;
		if (M.containsKey(n))
			return M.get(n);
		if (n==1)
			return 1;
		else if (n %2 == 0){
			tmp = getCycle(n/2) +1;
			M.put(n, tmp);
			return tmp;
		}
		else if (n %2 == 1){
			tmp = getCycle(3*n+1) +1;
			M.put(n, tmp);
			return tmp;
		}
		return -1;
	}
	
	public static int[] read(){
		int [] input = new int[2];
	  try {
	       BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	       String line = stdin.readLine();
	       if (line.isEmpty()){
	    	   return null;
	       }
	       String [] result = line.split("\\s+");
	       int i=0;
	       for (String s: result){
	    	   input[i] = Integer.parseInt(s);
	    	   i++;
	       }
	       return input;
	  }
	  
	  catch (java.io.IOException e) { e.printStackTrace() ;}
	  catch (NumberFormatException e) {e.printStackTrace() ; }
	  catch (Exception e) {e.printStackTrace() ;}
	       
	  return null;
	}
	
	public static void readIn(){
		Scanner in = new Scanner(System.in);
		int n;
		while(in.hasNextInt()) {
			n = in.nextInt();
		}
		// System.out.printf("%4d, %6.2f, %s, %c\n", i, d, s, c);
	}
}