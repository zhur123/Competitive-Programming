import java.util.*;
 
public class DivisorPath {
	
	// Private Static Methods Starts Here
 
	public static class Node{
		long number;
		HashMap<Integer, Integer> factors = new HashMap<>();
		
		Node(long number, HashMap<Integer, Integer> factors){
			this.number = number;
			this.factors = factor;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		long[][] grid = new long[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextLong();
			}
		}
		
	}
 
}