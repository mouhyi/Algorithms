public class Rand7 {
	public static int rand5() {
		return (int) (Math.random() * 100) % 5;
	}

	public static int rand7() {
		int r1;
		while (true) {
			r1 = rand5();
			if (r1 < 2) {
				return rand5();
			} else if (r1>2) {
				r1 = rand5();
				if(r1==0){
					return 5;
				}else if (r1==1){
					return 6;
				}
			}
		}

	}

	public static void main(String[] args) {
		/* Test: call rand7 many times and inspect the results. */
		int[] arr = new int[7];
		int test_size = 1000000;
		for (int k = 0; k < test_size; k++) {
			arr[rand7()]++;
		}
		System.out.println("Expected Frequency:" + (100.0 / 7.0));
		for (int i = 0; i < 7; i++) {
			double percent = 100.0 * arr[i] / test_size;
			System.out.println(i + " appeared " + percent + "% of the time.");
		}
	}
}
