
public class Trie {
	
	private TrieNode root;
	
	public Trie(String[] l){
		root = new TrieNode();
		for(String s: l){
			this.insertString(s);
		}
	}
	
	public void insertString(String s){
		char[] a  =s.toCharArray();
		for(int i=0; i<=a.length; i++){
			// assume currnt node matches in inserChild
			root.insertChild(a, i);
		}
	}
	
	public boolean contains(String s, boolean exact){
		return root.contains(s, 0, exact);
	}
	
	public boolean contains(String s){
		return this.contains(s,true);
	}
	
	public void print(){
		System.out.print("\\\n");
		for (TrieNode tn: root.getChildren().values()){
			System.out.print("ROOT   ");
			tn.print();
		}
	}
	
	public static void main(String[] args){
		String [] l  = {"alpes", "ali"};
		Trie t = new Trie(l);
		//System.out.println(t.root.getChild('a'));
		//t.print();
		System.out.println(t.contains("pes", true));
		System.out.println(t.contains("lpe", true));
		System.out.println(t.contains("lpe", false));
		
	}
}
