import java.util.*;

// Problem Link:
// Runtime: O()
// Space: O()
public class pathfinder {
	
	static int[][] grid;
	static int[][] dp;
	static int n;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		grid = new int[n][n];
		dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		dp[0][0] = grid[0][0];
		System.out.println(solve(n-1, n-1));
		
	}
	
	// Private Static Methods Starts Here
	private static int solve(int i, int j) {
		int result = 0;
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		if(i == 0) {
			result = solve(i, j-1) + grid[i][j];
		}else if(j == 0) {
			result = solve(i-1, j) + grid[i][j];
		}else {
			result = Math.min(solve(i-1, j), solve(i, j-1)) + grid[i][j];
		}
		dp[i][j] = result;
		return result;
	}
 
}