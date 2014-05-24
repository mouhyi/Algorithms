import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Graph {
	int count;
	
	public Graph(int c){
		this.count = c;
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String line;
		line = in.nextLine();
		int T = Integer.parseInt(line);
		
		while(T-->0){
			solve(in);
		}
		
	}

	private static void solve(Scanner in) {
		String line;
		String[] a;
		line = in.nextLine();
		int N = Integer.parseInt(line);
		HashMap<String, Graph> map = new HashMap<String, Graph> ();
		while(N-->0){
			line = in.nextLine();
			a = line.split("\\s+");
			Graph g1 = map.get(a[0]);
			Graph g2 = map.get(a[1]);
			if(g1==null && g2==null){
				g1 = new Graph(2);
				map.put(a[0], g1);
				map.put(a[1], g1);
			}else if(g1==g2){
				continue;
			}else if(g1!=null && g2!=null){
				merge(map, g1, g2);
			}else if(g2==null && g1!=null){
				map.put(a[1], g1);
				g1.count ++;
			}else if (g2!=null && g1==null){
				map.put(a[0], g2);
				g2.count ++;
			}
			System.out.println(map.get(a[0]).count);
		}
	}

	private static void merge(HashMap<String, Graph> map, Graph g1, Graph g2) {
		Graph tmp;
		if(g1.count < g2.count){
			tmp = g1;
			g1 = g2;
			g2 = tmp;
		}
		setValue(map,g2,g1);
	}
	
	private static void setValue(HashMap<String, Graph> map, Graph g2, Graph g1){
		for(String k :map.keySet()){
			if(map.get(k)==g2){
				map.put(k, g1);
			}
		}
		g1.count += g2.count;
	}
}
