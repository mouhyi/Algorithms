import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class QuiteProblem {
	public static void main(String[] args) {
		curvyblocks();
	}
	
	
	public static void curvyblocks(){
		Scanner in = new Scanner(System.in);
		double [] b = new double[4], t=new double[4];
		while(in.hasNextLine()){
			readDoubles(b,in);
			readDoubles(t,in);
			double [] p = new double[4];
			for (int i=0; i<4; i++){
				p[i] = b[i] - t[i];
			}
			System.out.println(findMax(p));
		}
	}
	
	public static HashMap<Double, Double> criticalPoints(double[] a){
		HashMap<Double, Double> max = new HashMap<Double, Double>();
		double x, x2;
		max.put(0.0, eval(a,0));
		max.put(1.0, eval(a,1));
		Double[] deriv = {a[1], 2*a[2], 3*a[3]};
		if(Math.pow(deriv[1],2.0)-4*deriv[2]*deriv[0]>=0){
			x = (-deriv[1] + Math.sqrt(Math.pow(deriv[1],2.0)-4*deriv[2]*deriv[0])) / (2*deriv[2]);
			x2 = (-deriv[1] - Math.sqrt(Math.pow(deriv[1],2.0)-4*deriv[2]*deriv[0])) / (2*deriv[2]);
			if(x>0 && x<1) max.put(x, eval(a,x));
			if(x2>0 && x2<1) max.put(x2, eval(a,x2));
		}
		return max;
	}
	
	public static double findMax(double[] a){
		HashMap<Double, Double> max = criticalPoints(a);
		return Collections.max( max.values()) - Collections.min( max.values());
		
	}
	
	
	public static double eval(double[] a, double x){
		double res = a[3]* Math.pow(x, 3) + a[2]* Math.pow(x, 2) + a[1]* x + a[0];
		return res;
	}
	
	public static void readDoubles(double[] a, Scanner in){
		String line = in.nextLine();
		String[] result = line.split("\\s+");
		int i=0;
        for (String s: result){
    	   a[i] = Double.parseDouble(s);
    	   i++;
        }
	}
	
	public static void quiteP(){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			String line = in.nextLine();
			boolean contain = Pattern.compile(Pattern.quote("problem"), Pattern.CASE_INSENSITIVE).matcher(line).find();
			System.out.println(contain ? "yes" : "no");
		}
	}
}
