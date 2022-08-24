import java.util.*;

// Problem Link:
// Runtime: O()
// Space: O()
public class pathfinder3 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && j == 0) {

				}else if(i == 0) {
					dp[i][j] += dp[i][j-1];
				}else if(j == 0) {
					dp[i][j] += dp[i-1][j];
				}else {
					int above = dp[i-1][j];
					int left = dp[i][j-1];
					if(above < left) {
						dp[i][j] += above;
					}else {
						dp[i][j] += left;
					}
				}
			}
		}
		System.out.println(dp[n-1][n-1]);
		
	}
	
	// Private Static Methods Starts Here
 
}