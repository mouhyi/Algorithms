import java.util.HashMap;


public class LongestNonRepeatedSubString {
	public static void main(String[] args) {
		char [] str = "stackoverflow".toCharArray();
		System.out.println(find(str));
	}
	
	public static int find(char[]str){
		HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
		int start=0, max=0, i=0;
		
		for(i=0; i<str.length; i++){
			if(map.containsKey(str[i]) && map.get(str[i])>=start){
				max = Math.max(max, i - start);
				start = map.get(str[i])+1;
			}
			map.put(str[i], i);
		}
		max = Math.max(max, i - start);
		return max;
		
	}
}
