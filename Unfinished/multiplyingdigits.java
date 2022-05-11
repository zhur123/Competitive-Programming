import java.io.*;
import java.util.*;
 
public class multiplyingdigits {
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
	
	private static LinkedList<Long> factor(long n, int base) {
		LinkedList<Long> factors = new LinkedList<>();
		if(n == 0 || n== 1) {
			
		}else {
			for(long i = base - 1; i >= 2; i--) {
				if(n % i == 0) {
					factors.add(i);
					factors.addAll(factor(n / i, base));
					i = 0;
				}
			}
		}
		return factors;
	}
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner(System.in);

		// Code Starts Here
		int base = sc.nextInt();
		long n = sc.nextLong();
		LinkedList<Long> factorsLL = factor(n, base);
		if(n == 1) {
			System.out.println(1);
		}else if(factorsLL.size() == 0) {
			System.out.println("impossible");
		}else {
			for(int i = base-1; i >= 2; i--) {
				LinkedList<Long> next = factor(n, i);
				if(next.size() < factorsLL.size() && next.size() != 0) {
					factorsLL = next;
				}
			}
			int times = factorsLL.size();
			int power = times-1;
			long actual = 0;
			for(int i = 0; i < times; i++) {
				actual += (factorsLL.pollLast() * (long) Math.pow(base, power--));
			}
			System.out.println(actual);
		}
		
	}
 
}