import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class FirstNonRepeatedCharacter {
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			String[] lineArray = line.split("\\s");
			if (lineArray.length > 0) {
				// Process line of input Here
				System.out.println(firstNonRepeatedCharacter(lineArray[0]));
			}
		}

		
	}

	public static char firstNonRepeatedCharacter(String s) {

		HashSet<Character> set = new HashSet<Character>();

		char c = '\0';
		char[] a = s.toCharArray();
		Arrays.sort(a);
		char cur;
		int i = 0;
		while (i < a.length) {
			cur = a[i];
			if (i + 1 < a.length && a[i + 1] == cur) {
				while (i < a.length && a[i] == cur) {
					i++;
				}
			} else {
				set.add(a[i]);
				i++;
			}
		}
		a = s.toCharArray();
		for (i = 0; i < a.length; i++) {
			if (set.contains(a[i])) {
				return a[i];
			}
		}
		return c;
	}
}
