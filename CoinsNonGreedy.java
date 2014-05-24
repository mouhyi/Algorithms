import java.util.HashMap;

/*
 * function to compute change from an arbitrary list of coin values.
 * What is at issue is that the obvious “greedy” algorithm for 
 * making change that proceeds by doling out as many coins as
 *  possible in decreasing order of value does not always work.
 *  Given only a 5 cent and a 2 cent coin, we cannot make
 *  16 cents in change by first taking three 5’s and then proceeding
 *  to dole out 2’s. In fact we must use two 5’s and three 2’s to make 16 cents.
 *  Here’s a method that works for any set of coin
 */
public class CoinsNonGreedy {
	
	public static void main(String []args){
		int [] coins = {20,5,2};
		Result res = computeChange(coins, 0, 21);
		if(res.valid){
			printMap(res.map);
		}else{
			System.out.println("Not Possible!");
		}
		
	}
	
	public static <K,V> void printMap(HashMap<K,V> map){
		for(K k: map.keySet()){
			System.out.println(k.toString()+" - "+map.get(k));
		}
	}
	
	public static Result computeChange(int[] coins, int index, int amt){
		Result res = new Result(false) ;
		if(amt <= 0){
			return new Result(true);
		}
		int n = amt / coins[index];
		if(index == coins.length-1){
			if(amt % coins[index] == 0){
				res = new Result(true);
				res.map.put(coins[index], n);
			}else{
				res = new Result(false);
			}
			return res;
		}for(int i=n; i>=0; i--){
			res = computeChange(coins, index+1, amt-i*coins[index]);
			if(res.valid){
				res.map.put(coins[index], i);
				break;
			}
		}
		return res;
		
	}
}

class Result{
	boolean valid;
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public Result(boolean valid){
		this.valid = valid;
		map = new HashMap<Integer, Integer>();
	}
}
