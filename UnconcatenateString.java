import java.util.HashMap;
import java.util.Hashtable;

import CtCILibrary.AssortedMethods;
import CtCILibrary.Trie;



public class UnconcatenateString {
	public static Trie dictionary;
	static HashMap<Integer, Integer> cost = new   HashMap<Integer, Integer>();
	
	public static int getCost(String s){
		if(s.isEmpty()) return 0;
		return dictionary.contains(s, true)? 0: s.length();
	}
	
	// return opt(start, s.length-1)
	// prev= substring(start, i+1)
	public static int process(String s, int i, int start){
		int res=0;
		
		if(i == s.length()-1) res =  getCost(s.substring(start));
		
		else if(cost.containsKey(start)){
			return cost.get(start);
		}
		
		else if(!dictionary.contains(s.substring(start, i+1), false)){
			return i+1-start + process(s, i+1, i+1);
		}
		else{
			int c11 = getCost(s.substring(start, i+1));
			int c12 = process(s, i+1, i+1);
			int c2	= process(s, i+1, start);
			res =  Math.min(c11+c12, c2);
		}
		
		cost.put(start, res);
		
		return res;
		
	}
	
	public static String clean(String str) {
		char[] punctuation = {',', '"', '!', '.', '\'', '?', ','};
		for (char c : punctuation) {
			str = str.replace(c, ' ');
		}
		return str.replace(" ", "").toLowerCase();
	}
	
	public static void main(String[] args) {
		dictionary = AssortedMethods.getTrieDictionary();
		String sentence = "As one of the top companies in the world, Google will surely attract the attention of computer gurus. This does not, however, mean the company is for everyone.";
		sentence = clean(sentence);
		System.out.println(sentence);
		//Result v = parse(0, 0, new Hashtable<Integer, Result>());
		//System.out.println(v.parsed);
		int v = process(sentence, 0, 0);
		System.out.println(v);
	}

}
