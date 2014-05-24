import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * The member states of the UN are planning to send two people to the Moon. But there is a problem. In line with their principles of global unity, they want to pair astronauts in such a way, that both are citizens of different countries.
 There are N astronauts numbered with identifiers from 0 to N-1. They are qualified and trained to be sent to the moon. But the trouble is that those in charge of the mission haven’t been directly informed about the citizenship of each astronaut. The only information they have is that some particular pairs of astronauts belong to the same country.

 Your task is to compute in how many ways they can pick a pair of astronauts satisfying the above criteria, to be sent to the moon. Assume that you are provided enough pairs to let you identify the groups of astronauts even though you might not know their country directly. For instance, if 1,2,3 are astronauts from the same country; it is sufficient to mention that (1,2) and (2,3) are pairs of astronauts from the same country without providing information about a third pair (1,3). 

 Input Format
 The first line contains two integers, N and I separated by a single space. I lines follow. each line contains 2 integers separated by a single space A and B such that

 0 ≤ A, B ≤ N-1

 and A and B are astronauts from the same country.

 Output Format
 An integer containing the number of permissible ways in which a pair of astronauts can be sent to the moon.

 Constraints
 1<=N<=105
 1<=I<=106

 Sample Input

 4 2
 0 1
 2 3
 Sample Output

 4
 Explanation
 As persons numbered 0 and 1 belong to same country and 2 and 3 belong to same country. So the UN can choose one person of 0,1 and one out of 2,3. So number of ways of choosing pair is 4.
 */

public class JouneyToMoon {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int[] input = new int[2];
		String line = in.nextLine();
		String[] result = line.split("\\s+");
		for (int i = 0; i < 2; i++) {
			input[i] = Integer.parseInt(result[i]);
		}
		int N = input[0], I = input[1];
		// System.out.println("N="+N);
		UF uf = new UF(N);

		while (I-- > 0) {
			line = in.nextLine();
			result = line.split("\\s+");
			for (int i = 0; i < 2; i++) {
				input[i] = Integer.parseInt(result[i]);
			}
			// System.out.println(""+input[0]+" , "+input[1]);
			uf.union(input[0], input[1]);
		}
		int res = N * (N - 1) / 2;
		HashSet<Integer> hs;
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(
				N);
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(uf.find(i))) {
				hs = new HashSet<Integer>();
				map.put(uf.find(i), hs);
			} else {
				hs = map.get(uf.find(i));
			}
			hs.add(i);
		}
		int k;
		for (HashSet<Integer> set : map.values()) {
			// System.out.println(set);
			k = set.size();
			res -= nChoose2(k);
		}

		System.out.println(res);
	}

	static int nChoose2(int n) {
		return n * (n - 1) / 2;
	}
}

class UF {
	private int[] id; // id[i] = parent of i
	private byte[] rank; // rank[i] = rank of subtree rooted at i (cannot be
							// more than 31)
	private int count; // number of components

	/**
	 * Initializes an empty union-find data structure with <tt>N</tt> isolated
	 * components <tt>0</tt> through <tt>N-1</tt>
	 * 
	 * @throws java.lang.IllegalArgumentException
	 *             if <tt>N &lt; 0</tt>
	 * @param N
	 *            the number of sites
	 */
	public UF(int N) {
		if (N < 0)
			throw new IllegalArgumentException();
		count = N;
		id = new int[N];
		rank = new byte[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			rank[i] = 0;
		}
	}

	/**
	 * Return the component identifier for the component containing site
	 * <tt>p</tt>.
	 * 
	 * @param p
	 *            the integer representing one object
	 * @return the component identifier for the component containing site
	 *         <tt>p</tt>
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless <tt>0 &le; p &lt; N</tt>
	 */
	public int find(int p) {
		if (p < 0 || p >= id.length)
			throw new IndexOutOfBoundsException();
		while (p != id[p]) {
			id[p] = id[id[p]]; // path compression by halving
			p = id[p];
		}
		return p;
	}

	/**
	 * Return the number of components.
	 * 
	 * @return the number of components (between <tt>1</tt> and <tt>N</tt>)
	 */
	public int count() {
		return count;
	}

	/**
	 * Are the two sites <tt>p</tt> and <tt>q</tt> in the same component?
	 * 
	 * @param p
	 *            the integer representing one site
	 * @param q
	 *            the integer representing the other site
	 * @return true if the two sites <tt>p</tt> and <tt>q</tt> are in the same
	 *         component; false otherwise
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless both <tt>0 &le; p &lt; N</tt> and
	 *             <tt>0 &le; q &lt; N</tt>
	 */
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 * Merge the component containing site <tt>p</tt> with the the component
	 * containing site <tt>q</tt>.
	 * 
	 * @param p
	 *            the integer representing one site
	 * @param q
	 *            the integer representing the other site
	 * @throws java.lang.IndexOutOfBoundsException
	 *             unless both <tt>0 &le; p &lt; N</tt> and
	 *             <tt>0 &le; q &lt; N</tt>
	 */
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;

		// make root of smaller rank point to root of larger rank
		if (rank[i] < rank[j])
			id[i] = j;
		else if (rank[i] > rank[j])
			id[j] = i;
		else {
			id[j] = i;
			rank[i]++;
		}
		count--;
	}
}
