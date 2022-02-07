import java.io.*;
import java.util.*;
 
public class amsterdamdistance {
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
		int n = sc.nextInt();
		double r = sc.nextDouble();
		int am = sc.nextInt();
		int an = sc.nextInt();
		int bm = sc.nextInt();
		int bn = sc.nextInt();
		int diffM = Math.abs(am-bm);
		double straight = r / n * Math.abs(an-bn);
		int smaller = Math.min(an, bn);
		double curved = 2 * Math.PI *  r * smaller / n * diffM / m / 2;
		double answer = 0;
		if((double) diffM/m < 2/Math.PI) {
			answer = straight + curved;
		}else {
			answer = straight + r / n * smaller * 2;
		}
		if(answer % 1 != 0) {
			System.out.println(answer);
		}else {
			System.out.println((int) answer);
		}
		
	}
 
}