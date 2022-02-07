import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
 
public class flipfive {
	private static class FastScanner {
		private BufferedReader reader = null;
		private StringTokenizer tokenizer = null;
 
		public FastScanner(InputStream in) {
			reader = new BufferedReader(new InputStreamReader(in));
			tokenizer = null;
		}
 
		public String next() {
			if (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
 
		public String nextLine() {
			if (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					return reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken("\n");
		}
 
		public long nextLong() {
			return Long.parseLong(next());
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		public long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
	}
	
	// Comparator Template
	
	/**
	 * Compare {@code String}s in alphabetical order     
	 */
	private static class StringLT implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	}
	
	// Private Static Methods Starts Here
 
	private static boolean isGoal(int[][] goal, int [][] state) {
		for(int b = 0; b < 3; b++) {
			for(int c = 0; c < 3; c++) {
				if(goal[b][c] != state[b][c]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean within(int row, int column) {
		return row >= 0 && row <= 2 && column >= 0 && column <= 2;
	}
	
	private static String condense(int[][] state) {
		String result = "";
		for(int b = 0; b < 3; b++) {
			for(int c = 0; c < 3; c++) {
				result += state[b][c];
			}
		}
		return result;
	}
	private static int[][] operate(int[][] state, int row, int column) {
		int[][] copy = new int[3][3];
		for(int b = 0; b < 3; b++) {
//			for(int c = 0; c < 3; c++) {
//				copy[b][c] = state[b][c];
//			}
			copy[b] = Arrays.copyOfRange(state[b], 0, 3);
		}
		if(state[row][column] == 1) {
			copy[row][column] = 0;
		}else {
			copy[row][column] = 1;
		}
		if(within(row-1, column)) { // up
			if(state[row-1][column] == 1) {
				copy[row-1][column] = 0;
			}else {
				copy[row-1][column] = 1;
			}
		}
		if(within(row+1, column)) { // down
			if(state[row+1][column] == 1) {
				copy[row+1][column] = 0;
			}else {
				copy[row+1][column] = 1;
			}
		}
		if(within(row, column-1)) { // left
			if(state[row][column-1] == 1) {
				copy[row][column-1] = 0;
			}else {
				copy[row][column-1] = 1;
			}
		}
		if(within(row, column+1)) { // right
			if(state[row][column+1] == 1) {
				copy[row][column+1] = 0;
			}else {
				copy[row][column+1] = 1;
			}
		}
		return copy;
	}
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner(System.in);

		// Code Starts Here
		int p = sc.nextInt();
		for(int a = 0; a < p; a++) {
			int[][] goal = new int[3][3];
			for(int b = 0; b < 3; b++) {
				String line = sc.nextLine();
				for(int c = 0; c < 3; c++) {
					if(line.charAt(c) == '*') {
						goal[b][c] = 1;
					}
				}
			}
			// bfs
			LinkedList<SimpleEntry<int[][], Integer>> openSet = new LinkedList<>();
			HashSet<String> closedSet = new HashSet<String>();
			int[][] start = new int[3][3];
			openSet.add(new SimpleEntry<int[][], Integer>(start,0));
			while(openSet.size() > 0) {
				SimpleEntry<int[][], Integer> current = openSet.pollFirst();
				int[][] state = current.getKey();
				int number = current.getValue();
				if(!closedSet.contains(condense(state))) {
					if(isGoal(goal, state)) {
						System.out.println(number);
						break;
					}
					closedSet.add(condense(state));
					for(int i = 0; i < 3; i++) {
						for(int j = 0; j < 3; j++) {
							// switch colors
							SimpleEntry<int[][], Integer> generated = new SimpleEntry<int[][], Integer>(operate(state, i, j), number+1);
							if(!closedSet.contains(condense(generated.getKey()))) {
								openSet.add(generated);
							}
						}
					}
				}
			
			}
		}
		
	}
 
}