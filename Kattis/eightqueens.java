import java.io.*;
import java.util.*;
import java.awt.*;
 
public class eightqueens {
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
 
	public static void main(String[] args) {
		FastScanner sc = new FastScanner(System.in);

		// Code Starts Here
		
		int[][] board = new int[8][8];
		Point[] queens = new Point[64];
		int counter = 0;
		for(int x = 0; x < 8; x++) {
			String line = sc.nextLine();
			for(int y = 0; y < 8; y++) {
				if(line.charAt(y) == '*') {
					queens[counter++] = new Point(x, y);
					board[x][y] = -1;
				}
			}
		}
		boolean valid = true;
		if(counter == 8) {
			for(int a = 0; a < counter; a++) {
				Point queen = queens[a];
				int x = (int) queen.getX();
				int y = (int) queen.getY();
				int sum = 4;
				for(int i = 0; i < 8; i++) { // row
					sum += board[x][i];
				}
				for(int i = 0; i < 8; i++) { // column
					sum += board[i][y];
				}
				// diagonal \\ this way
				int startX;
				int startY;
				int temp;
				if(x == y) {
					startX = 0;
					startY = 0;
				}else if(x > y) { // bottom left
					startX = x - y;
					startY = 0;
				}else { // top right
					startX = 0;
					startY = y - x;
				}
				if(x > y) { // bottom left
					temp = 0;
					for(int i = startX; i < 8; i++) { 
						sum += board[i][temp];
						temp++;
					}
				}else { // top right
					temp = 0;
					for(int i = startY; i < 8; i++) { 
						sum += board[temp][i];
						temp++;
					}
				}
				// diagonal // this way
				if(x + y == 7) {
					startX = 0;
					startY = 7;
				}else if(x + y < 7) { // top left
					startX = 0;
					startY = x + y;
				}else { // bottom right
					startX = x + y - 7;
					startY = 7;
				}
				if(x > y) { // top left
					temp = 0;
					for(int i = startY; i >= 0; i--) {
						sum += board[temp][i];
						temp++;
					}
				}else { // bottom right
					temp = 7;
					for(int i = startX; i < 8; i++) { 
						sum += board[i][temp];
						temp--;
					}
				}
				if(sum < 0) {
					valid = false;
					break;
				}
			}
		}else {
			valid = false;
		}
		
		if(valid) {
			System.out.println("valid");
		}else {
			System.out.println("invalid");
		}
		
		
	}
 
}