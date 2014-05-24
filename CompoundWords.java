import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CompoundWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String cur = null;
		ArrayList<String> prefices = new ArrayList<String>();
		ArrayList<String> keys = new ArrayList<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		while (in.hasNextLine()) {

			cur = in.nextLine();
			if (cur.isEmpty())
				break;

			if (map.get(cur) == null) {
				map.put(cur, new ArrayList<String>());
			}
			map.get(cur).add("!!!!");

			if (prefices.isEmpty()) {
				prefices = new ArrayList<String>();
			}

			// find possible prefixes
			keys = new ArrayList<String>();
			for (String s : prefices) {
				if (cur.startsWith(s)) {
					keys.add(s);
				}
			}

			if (!keys.isEmpty()) {
				for (String key : keys) {
					String w2 = cur.substring(key.length(), cur.length());
				
					ArrayList<String> l = map.get(w2);
					if (l == null) {
						map.put(w2, new ArrayList<String>());
						l = map.get(w2);
					}
					l.add(cur);
				}

			}
			prefices.add(cur);
		}

		ArrayList<String> l = new ArrayList<String>();
		process(map, l);
		
		HashSet<String> hs = new HashSet<String>();
		hs.addAll(l);
		l.clear();
		l.addAll(hs);
		Collections.sort(l);
		for (String w : l) {
			System.out.println(w);
		}
	}

	public static void process(HashMap<String, ArrayList<String>> map,
			ArrayList<String> l) {
		for (String k : map.keySet()) {
			ArrayList<String> ws = map.get(k);
			if (ws.contains("!!!!")) {
				for (String s : ws) {
					if (!s.equals("!!!!")) {
						l.add(s);
					}
				}
			}
		}
	}
}
