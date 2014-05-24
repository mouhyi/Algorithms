import java.util.Scanner;

/*
Ones
Given any integer 0 ≤ n ≤ 10000 not divisible by 2 or 5, some multiple of n is a number which in decimal
notation is a sequence of 1’s. How many digits are in the smallest such a multiple of n?
Input specification
The input will be integers one per line.
Output specification
The output is the number of digits in the smallest such multiple of n, one per line.
Sample input
3
7
9901
Sample output
3
6
12

 */
public class Ones {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int n = in.nextInt();
			System.out.println(getOnes(n));
		}
	}
	
	public static int getOnes(int n){
		int count = 1, sum = 1, x=1;
		while(sum>0){
			x = (10*x)%n;
			sum = (sum+x)%n;
			count++;
		}
		return count;
	}
}
