import java.util.Random;



public class MasterMind {
	
	public static class Result {
		public int hits;
		public int pseudoHits;
		
		public Result(int h, int p) {
			hits = h;
			pseudoHits = p;
		}
		
		public Result() {
			hits = 0;
			pseudoHits = 0;
		}
		
		public String toString() {
			return "(" + hits + ", " + pseudoHits + ")";
		}
	};
	
	public static char letterFromCode(int k) {
		switch (k) {
		case 0:
			return 'B';
		case 1:
			return 'G';
		case 2:
			return 'R';
		case 3:
			return 'Y';
		default:
			return '0';
		}		
	}
	
	public static int codeFromLetter(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}		
	}
	
	public static Result estimateBad(String g, String s) {
		char[] guess = g.toCharArray();
		char[] solution = s.toCharArray();
		int hits = 0;
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == solution[i]) {
				hits++;
				solution[i] = '0';
				guess[i] = '0';
			}
		}
		
		int pseudohits = 0;
		
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] != '0') {
				for (int j = 0; j < solution.length; j++) {
					if (solution[j] != '0') {
						if (solution[j] == guess[i]) {
							pseudohits++;
							solution[j] = '0';
							break;
						}
					}
				}
			}
		}
		
		return new Result(hits, pseudohits);
	}
	
	
	public static boolean test(String guess, String solution) {
		Result res1 = estimate(guess, solution);
		Result res2 = estimateBad(guess, solution);
		if (res1.hits == res2.hits && res1.pseudoHits == res2.pseudoHits) {
			return true;
		} else {
			System.out.println("FAIL: (" + guess + ", " + solution + "): " + res1.toString() + " | " + res2.toString());
			return false;
		}
	}
	
	private static Result estimate(String guess, String solution) {
		if(guess.length() != 4 || solution.length()!=4){
			System.out.println("ERROR");
			return null;
		}
		
		Result res = new Result();
		int countG[]= {0,0,0,0};
		int countS[]= {0,0,0,0};
		
		for(int i=0; i<guess.length(); i++){
			if(guess.charAt(i) == solution.charAt(i)){
				res.hits++;
			}
			countG[codeFromLetter(guess.charAt(i))] ++;
			countS[codeFromLetter(solution.charAt(i))] ++;
		}
		
		for(int i=0; i<countG.length; i++){
			res.pseudoHits += Math.min(countG[i], countS[i]);
		}
		
		res.pseudoHits -= res.hits;
		
		return res;
	}

	public static String randomString() {
		int length = 4;
		char[] str = new char[length];
		Random generator = new Random();
		
		for (int i = 0; i < length; i++) {
			int v = generator.nextInt(4);
			char c = letterFromCode(v);
			str[i] = c;
		}
		
		return String.valueOf(str);
	}
	
	public static boolean testRandom() {
		String guess = randomString();
		String solution = randomString();
		return test(guess, solution);
	}
	
	public static boolean test(int count) {
		for (int i = 0; i < count; i++) {
			if (!testRandom()) {
				return true;
			}
		}
		return false;
	}
	
	/********************** END TEST CODE ************************/
	
	
	public static void main(String[] args) {
		test(1000);
	}
}
