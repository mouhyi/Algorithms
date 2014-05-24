public class Strings {
	static int stringSimilarity(String s) {
		int count = s.length(), j = 0, k = 0;
		for (int i = 1; i < s.length(); i++) {
			System.out.println(s.substring(i));
			j = 0;
			k = i;
			while (j < s.length() && k < s.length()
					&& s.charAt(j) == s.charAt(k)) {
				count++;
				j++;
				k++;
			}
			System.out.println("count="+j);
		}
		
		

		return count;
	}
	
	public static void main(String[] args){
		System.out.println(stringSimilarity("ababaa"));
	}
	
}
