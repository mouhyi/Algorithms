import java.util.Scanner;


public class Candies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line;
		line = in.nextLine();
		int T;
		T = Integer.parseInt(line);
		int[] ratings = new int[T];
		int i=0;
		while(T-->0){
			line = in.nextLine();
			ratings[i++] = Integer.parseInt(line);
		}
		int res = findCandies(ratings);
		System.out.println(res);
		
  }

	private static int findCandies(int[] ratings) {
		int result=0;
		int last=0;
		int length=1;
		int[] a = new int[ratings.length];
		a[0]=1;
		int i=1;
		boolean dec=true;
		while( i<ratings.length){
			if(!dec){
				length =1 ;
			}else{
				if(a[i]<a[i-1]){
					length++;
				}else{
					last = last + Math.max(1, length-1);
					result += sum(last, last+length-1);
					dec = false;
					while(i<ratings.length && a[i]==a[i-1]){
						result += last;
						i++;
					}
				}
			}
			i++;
		}
		return result;
	} 
	
	public static int sum(int start, int end){
		int s =0;
		int d= end-start;
		s = start*(d+1);
		s += d*(d+1)/2;
		return s;
	}
}
