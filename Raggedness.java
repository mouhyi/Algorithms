import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Raggedness {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		String line;
		while(in.hasNextLine()){
			line = in.nextLine();
			if(line.isEmpty()) break;
			lengths.add(line.length());
		}
		int max = Collections.max(lengths);
		int rag=0;
		for(int i=0; i<lengths.size()-1; i++){
			rag += Math.pow(max-lengths.get(i), 2);
		}
		System.out.println(rag);
	}
}	
