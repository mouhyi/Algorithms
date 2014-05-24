import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArraySumPairs {
	static class ArrayEntry{
		int index, value;
		
		ArrayEntry(int i, int v){
			this.index=i;
			this.value=v;
		}

		@Override
		public String toString() {
			return "ArrayEntry [index=" + index + ", value=" + value + "]";
		}
		
		
	}
	
	static class Pair<T>{
		T v1, v2;
		
		Pair(T v1, T v2){
			this.v1=v1;
			this.v2=v2;
		}

		@Override
		public String toString() {
			return "Pair [v1=" + v1 + ", v2=" + v2 + "]";
		}
		
		
	}
	
	public static List<Pair<ArrayEntry>> findSumPairs(int[] a, int X){
		List<Pair<ArrayEntry>> result = new ArrayList<Pair<ArrayEntry>>();
		Arrays.sort(a);
		int i=0, j=a.length-1, sum=0, tmpj=0;
		
		while(i<j){
			sum = a[i]+a[j];
			if(sum == X){
				// handle duplicate elements
				tmpj=j;
				while(i<tmpj && a[i]+a[tmpj]==X){
					result.add(new Pair<ArrayEntry>(new ArrayEntry(i, a[i]), new ArrayEntry(tmpj, a[tmpj])));
					tmpj--;
				}
				i++;
				
			}else if(sum > X){
				j--;
			}else{
				i++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,2,3,4,4,5};
		System.out.println(findSumPairs(a, 6));
	}
}
