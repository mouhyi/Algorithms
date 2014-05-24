import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class TrieNode {
	private char c;
	HashMap<Character, TrieNode> children;
	boolean terminates;
	
	public TrieNode(Character c){
		children = new HashMap<Character, TrieNode>();
		this.c = c;
	}
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}

	public TrieNode getChild(char c){
		return children.get(c);
	}
	
	public void insertChild(char[] a, int start){
		if(start== a.length){
			this.insertEndOfString();
			return;
		}
		
		TrieNode n = this.getChild(a[start]);
		if(n==null){
			n = new TrieNode(a[start]);
			children.put(a[start], n);
		}
		
		n.insertChild(a, start+1);
	}
	
	public void insertEndOfString(){
		this.terminates = true;
	}
	
	public void print(){
		/*if(terminates){
			System.out.print("\\\n");
		}*/
		
		System.out.println(this.c +",  Children="+children.keySet());
		for(TrieNode tn: children.values()){
			System.out.print("----");
			tn.print();
		}
	}

	public HashMap<Character,TrieNode> getChildren() {
		// TODO Auto-generated method stub
		return children;
	}


	public boolean contains(String s, int i, boolean exact) {
		if(i == s.length()){
			return !exact | this.terminates;
		}
		TrieNode tn = children.get(s.charAt(i));
		
		return tn.contains(s, i+1, exact);
		
	}	
}
