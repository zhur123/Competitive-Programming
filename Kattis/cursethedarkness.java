import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.Point2D;
 
public class cursethedarkness {
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
		int m = sc.nextInt();
		for(int a = 0; a < m; a++) {
			Point2D book = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
			int n = sc.nextInt();
			Point2D[] candles = new Point2D[n];
			for(int b = 0; b < n; b++) {
				candles[b] = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
			}
			boolean light = false;
			for(int b = 0; b < n; b++) {
				if(Point.distance(book.getX(), book.getY(), candles[b].getX(), candles[b].getY()) <= 8) {
					light = true;
					break;
				}
			}
			if(light) {
				System.out.println("light a candle");
			}else {
				System.out.println("curse the darkness");
			}
		}
		
		
	}
 
}