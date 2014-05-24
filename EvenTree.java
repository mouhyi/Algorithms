import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class EvenTree {
	
	static int edges = 0;
	
	public static void main(String[] args) throws IOException {
		TNode root =null;
		Scanner in = new Scanner(System.in);
		int [] input = new int[2];
		String line = in.nextLine();
		String[] result = line.split("\\s+");
		for (int i=0; i<2; i++) {
			input[i] = Integer.parseInt(result[i]);
		}
		int M = input[1];
		
		edges = 0;
		HashMap<Integer, TNode> V = new HashMap<Integer, TNode>();
		TNode v, w; 
		while((M--)>0){
			line = in.nextLine();
			result = line.split("\\s+");
			for (int i=0; i<2; i++) {
				input[i] = Integer.parseInt(result[i]);
			}
			
			if(! V.containsKey(input[0])){
				V.put(input[0], new TNode(input[0]));
			}
			w = V.get(input[0]);
			if(! V.containsKey(input[1])){
				V.put(input[1], new TNode(input[1]));
			}
			v = V.get(input[1]);
			w.parent = v;
			v.children.add(w);
			
			if((root == null) || root.parent!= null){
				root = v;
			}
		}
		dfs(root);
		
		System.out.print(edges);
	}
	
	public static int dfs(TNode v){
		if(v == null){
			return 0;
		}
		int rank = 1;
		for(TNode w: v.children){
			rank += dfs(w);
		}

		if( rank % 2 == 0 && v.parent!=null){
			edges ++;
		}
		return rank;
		
	}
	
	public static class TNode{
		int key;
		public TNode parent;
		public ArrayList<TNode> children = new ArrayList<TNode> ();
		
		public TNode(int k){
			this.key = k;
		}
	}
}
