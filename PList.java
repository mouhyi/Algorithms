import java.util.ArrayList;


public class PList {
	ArrayList<PList> plist;
	ArrayList<Character> cl;
	
	public PList(ArrayList<PList> plist){
		this.plist = plist;
	}
	
	public PList(boolean init){
		this.cl = new ArrayList<Character>();
		if(init){
			cl.add('('); cl.add(')');
		}
		this.plist = new ArrayList<PList>();
		plist.add(this);
	}
	
	public static ArrayList<Character> nest(ArrayList<Character> l){
		ArrayList<Character> l2 = new ArrayList<Character> (l);
		l2.add(0, '(');
		l2.add(l2.size(), ')');
		return l2;
		
	}
	
	public static ArrayList<Character> concat(ArrayList<Character> l){
		ArrayList<Character> l2 = new ArrayList<Character> (l);
		l2.add(0, ')');
		l2.add(0, '(');
		return l2;
	}
	
	public static ArrayList<PList> insert(PList pl){
		ArrayList<PList> res = new ArrayList<PList>();
		if(pl.cl.isEmpty()){
			
		}
		//res.add(new PList)
		//PList tmp = new PList(false);
		for(int i=0; i< pl.plist.size(); i++){
			PList tmp = pl.plist.get(i);
		}
		return res;
	}
	/*
	public static ArrayList<PList> getPLists(int n){
		ArrayList<PList> res = new ArrayList<PList> ();
		if(n==0){
			return res;
		}
		ArrayList<PList> res1 = getPLists(n-1);
		for(PList pl: res1){
			res.add(insert(pl));
		}
		return res;
	}*/
}
