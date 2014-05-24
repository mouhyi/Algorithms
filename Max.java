
public class Max {
	
	public static int getMax(int a, int b){
		int m2 = (a^b)>>31;
		int an = a>>31;
		int res2 = ~an&a | an&b;
		
		int m = (a-b)>>31;
//		System.out.println("m = " + Integer.toBinaryString(m)+ ";;  m~ = "+ Integer.toBinaryString(~m));
		int res =  ~m & a | m & b;
		System.out.println(res);
		return (~m2&res | m2&res2);
	}
	
	public static void main(String[] args) {
		int a = 26;
		int b = -15;
		
		System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));		
		System.out.println("--------------------------------------");
		
		b = -15;
		a = 2147483647;
		
		System.out.println("max_naive(" + a + ", " + b + ") = " + getMaxNaive(a, b));
		System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));
	}

	private static int getMaxNaive(int a, int b) {
		return Math.max(a, b);
	}
}
