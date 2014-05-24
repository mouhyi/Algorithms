
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



class Vertex {
	int cur1, cur2;
	public final String name;

	public Vertex(int cur1, int cur2) {
		this.cur1 = cur1;
		this.cur2 = cur2;
		name = cur1 + "-" + cur2;

	}

	public String id() {
		return name;
	}

	public String toString() {
		return name;
	}

}

/** Acyclic Graph class **/

public class AG {

	public static int bfs( int c1, int c2, int volume) {
		int count =0;
		Vertex source = new Vertex(0,0);
		HashMap<String, Boolean> vertices = new HashMap<String,Boolean>();
		LinkedList<Vertex> vertexQueue = new LinkedList<Vertex>();
		LinkedList<Vertex> tmpQueue = new LinkedList<Vertex>();
		vertexQueue.add(source);
		vertices.put(source.name, true);
		HashMap<String,Vertex> nodes ;
		
		while (!vertexQueue.isEmpty()) {
			tmpQueue = new LinkedList<Vertex>();
			for(Vertex u: vertexQueue){
				//Vertex u = vertexQueue.poll();
				
				// if found return distance
				if(u.cur1== volume || u.cur2 == volume){
					return count;
				}
				// Visit each edge exiting u
				nodes = generateNodes(c1, u.cur1, c2, u.cur2);
				for (Vertex v: nodes.values()){
					if (!vertices.containsKey(v.name)) {
						vertices.put(v.name, true);
						tmpQueue.add(v);
					}
				}
			}
			count ++;
			vertexQueue = tmpQueue;
		}
		return -1;
	}
	
	public static HashMap<String,Vertex> generateNodes(int c1, int cur1, int c2, int cur2){
		HashMap<String,Vertex> list = new HashMap<String,Vertex> ();
		Vertex v;
		v = new Vertex(0, cur2);
		list.put(v.name, v);
		v = new Vertex(cur1, 0);
		list.put(v.name, v);
		v= new Vertex(c1, cur2);
		list.put(v.name, v);
		v= new Vertex(cur1, c2);
		list.put(v.name, v);
		v= new Vertex( Math.min(c1, cur1+cur2)  , Math.max(0, cur2 + cur1 - c1));
		list.put(v.name, v);
		v= new Vertex( Math.max(cur2 + cur1 - c2, 0) , Math.min(c2, cur1+cur2));
		list.put(v.name, v);
		
		return list;
	}
	

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String[] a;
		String line;
		line = in.nextLine();
		a = line.split("\\s+");
		int c1, c2, volume;
		c1 = Integer.parseInt(a[0]);
		c2 = Integer.parseInt(a[1]);
		volume = Integer.parseInt(a[2]);
		
		int res = bfs(c1, c2, volume);
		if(res>=0){
			System.out.println(res);
		}else{
			System.out.println("no");
		}
		
		return ;
		
	}

}
