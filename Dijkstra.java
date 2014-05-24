
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Vertex implements Comparable<Vertex> {
	public final int name;
	public HashMap<Integer, Edge> adjacencies = new HashMap<Integer, Edge> ();
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public Vertex(int argName) {
		name = argName;
	}

	public int id() {
		return name;
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}
	
	public String toString() {
	    return "-- "+(name+1);
	  }


}

class Edge {
	public final Vertex target;
	public final Vertex start;
	public final int weight;

	public Edge(Vertex argStart, Vertex argTarget, int argWeight) {
		target = argTarget;
		weight = argWeight;
		start = argStart;
	}
}

public class Dijkstra {
	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies.values()) {
				Vertex v = e.target;

				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static ArrayList<Vertex> getShortestPathTo(Vertex target) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}

	public static void reset(ArrayList<Vertex> vertices, ArrayList<Vertex> path, Vertex d) {
		HashMap<Integer, Edge> newAdj;
		int i = 0;
		for (Vertex v : vertices) {
			v.minDistance = Double.POSITIVE_INFINITY;
			v.previous = null;
			newAdj = new HashMap<Integer, Edge>(v.adjacencies.size());
			i = 0;
			for (Edge e : v.adjacencies.values()) {
				Vertex w = e.target;
				if (!path.contains(w) || w.equals(d)) {
					newAdj.put(e.target.id(), e);
				}
			}
			v.adjacencies = newAdj;
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String[] a;
		String line;
		line = in.nextLine();
		a = line.split("\\s+");
		int N, R;
		N = Integer.parseInt(a[0]);
		R = Integer.parseInt(a[1]);

		ArrayList<Vertex> vertices = new ArrayList<Vertex>(N+1);
		for (int i = 0; i < N; i++) {
			vertices.add(new Vertex(i));
		}

		for (int i = 0; i < R; i++) {
			line = in.nextLine();
			if(line.isEmpty()) continue;
			a = line.split("\\s+");
			int u = Integer.parseInt(a[0]);
			int v = Integer.parseInt(a[1]);
			int cost = Integer.parseInt(a[2]);
			vertices.get(u-1).adjacencies.put(v-1, new Edge(vertices.get(u-1), vertices
					.get(v-1), cost));
		}

		
		int s = 1;
		int d = N;
		
		int sum =0;

		computePaths(vertices.get(s-1));
		ArrayList<Vertex> path = getShortestPathTo(vertices.get(d-1));
		
		for(int i=0; i<path.size()-1; i++){
			Vertex u = path.get(i);
			Vertex v = path.get(i+1);
			Edge e = u.adjacencies.get(v.id());
			sum += e.weight;
		}
		
		reset(vertices, path, vertices.get(d-1));
		computePaths(vertices.get(s-1));
		path = getShortestPathTo(vertices.get(d-1));
		for(int i=0; i<path.size()-1; i++){
			Vertex u = path.get(i);
			Vertex v = path.get(i+1);
			Edge e = u.adjacencies.get(v.id());
			sum += e.weight;
		}
		
		System.out.println(sum);

	}
	
	
	
}