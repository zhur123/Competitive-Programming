import java.util.*;

// Problem Link:
// Runtime: O(n * n * gcd)
// Space: O(n * n)
public class divisorpath {
	
	// Public Static Variables
	static long[][] grid;
	static long[][] dp;
	
	// Private Static Methods
	
    private static class StringLT implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	}

    private static class Pair<K, V>{
        K key;
        V value;
        public Pair(K first, V second){
            key = first;
            value = second;
        }
    }
 
	public static void main(String[] args) {
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		grid = new long[n][n];
		dp = new long[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextLong();
			}
		}
		dp[0][0] = grid[0][0];
		System.out.println(solve(n-1, n-1));
		
	}
	
	// O(n * n * gcd)
	// O(1)
	private static long solve(int i, int j) {
		if(dp[i][j] != 0 || (i == 0 && j == 0)) {
			return dp[i][j];
		}
		long answer = 0;
		long divisor = 0;
		if(i == 0) {
			divisor = gcd(solve(i, j-1), grid[i][j]);
			answer = dp[i][j-1] / divisor * grid[i][j];
		}else if(j == 0) {
			divisor = gcd(solve(i-1, j), grid[i][j]);
			answer = dp[i-1][j] / divisor * grid[i][j];
		}else {
			divisor = gcd(solve(i-1, j), grid[i][j]);
			long answerTop = dp[i-1][j] / divisor * grid[i][j];
			divisor = gcd(solve(i, j-1), grid[i][j]);
			long answerBot = dp[i][j-1] / divisor * grid[i][j];
			answer = Math.min(answerTop, answerBot);
		}
		dp[i][j] = answer;
		return answer;
	}

	// O(log(min(a, b)))
	// O(1)
	public static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}