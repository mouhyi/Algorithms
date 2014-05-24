
public class MinSorting {
	static class Pair{
		int first=0, last=0;
		
		Pair(int f, int l){
			this.first=f;
			this.last=l;
		}
		
		@Override
		public String toString() {
			return "i = "+first + "  --  j = "+last;
		}
	}
	
	static Pair findIndices(int [] a){
		if(a==null || a.length<2){
			return new Pair(0,0);
		}
		
		int i=0, j=a.length-1;
		
		while(i<j && a[i]<=a[j]){
			if(a[i]<=a[i+1]){
				i++;
				System.out.println("i: "+i);
			}
			if(a[j]>=a[j-1]){
				j--;
				System.out.println("j: "+j);
			}
		}
		
		if(a[i] > a[j]){
			int minRight = a[j];
			System.out.println("minRight: "+minRight);
			
			int maxLeft = a[i];
			System.out.println("MaxLeft: "+maxLeft);
			
			while(i>=0 && a[i] > minRight){ i--; }
			i++;
			
			while(j<a.length && a[j]<maxLeft) { j++; }
			j--;
		}
		
		return new Pair(i,j);
		
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 4, 6, 10, 11, 7,5, 12, 11, 16, 18, 19};
		//int[] array = {2,4,3,1};
		System.out.println(findIndices(array));
	}
}
