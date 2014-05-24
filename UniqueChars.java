import java.util.BitSet;


public class UniqueChars {
	
	public static boolean hasUniqueChars(String s){
		if (s==null || s.isEmpty()) return true;
		
		BitSet bs = new BitSet(1 << Character.SIZE/2);
		bs.clear();
		for(char c: s.toCharArray()){
			if(bs.get(c)){
				return false;
			}
			bs.set(c);
		}
		return true;
	}
	
	public static boolean hasUniqueChars2(String s){
		if (s==null || s.isEmpty()) return true;
		
		char[] str = s.toCharArray();        
		java.util.Arrays.sort(str);
		
		for(int i=0; i<str.length-1; i++){
			if(str[i]==str[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + hasUniqueChars(word) + " " + hasUniqueChars2(word));
		}
	}
}
