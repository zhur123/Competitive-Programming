import java.math.BigInteger;
import java.util.*;

// Problem Link: https://buckeyecode.club/problem/view/divisorpath
// Runtime: 
// Space: 
public class divisorpath2 {
	
	// Public Static Variables

	
	// Private Static Methods
	
    private static class StringLT implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	}

    private static class Node implements Comparable<Node>{
        long number;
        int x;
        int y;
        public Node(long number, int x, int y){
            this.number = number;
            this.x = x;
            this.y = y;
        }
        
		@Override
		public int compareTo(Node other) {
			if(this.number < other.number) {
				return -1;
			}else if(this.number > other.number){
				return 1;
			}else {
				return 0;
			}
		}

    }
 
	public static void main(String[] args) {
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		long[][] grid = new long[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextLong();
			}
		}
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(grid[0][0], 0, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			if(node.x == n-1 && node.y == n-1) {
				System.out.println(node.number);
				break;
			}
			if(node.y+1 <= n-1) {
				long divisor = gcd(node.number, grid[node.x][node.y + 1]);
				long answer = (node.number / divisor) * grid[node.x][node.y + 1];
				if(answer > 0) {
					queue.add(new Node(answer, node.x, node.y + 1));
				}
			}
			if(node.x+1 <= n-1) {
				long divisor = gcd(node.number, grid[node.x + 1][node.y]);
				
				long answer = (node.number / divisor) * grid[node.x + 1][node.y];
				if(answer > 0) {
					queue.add(new Node(answer, node.x + 1, node.y));
				}
			}
		}
		
	}

	// O(log(min(a, b)))
	// O(1)
	public static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}