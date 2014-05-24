
public class LargestContiguousSum {
	public static int findLargestContiguousSum(int[] a){
		int max=0, cur=0;
		
		for(int i=0; i<a.length; i++){
			if(cur>0){
				cur = cur + a[i];
			}else{
				cur = a[i];
			}
			
			if(cur>max){
				max = cur;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {2, -8, 3, -2, 4, -10};
		System.out.println(findLargestContiguousSum(a));
	}
}
