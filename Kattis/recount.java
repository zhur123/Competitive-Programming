import java.io.*;
import java.util.*;
 
public class recount {
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
		String str = sc.nextLine();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		while(!str.equals("***")) {
			if(map.containsKey(str)) {
				int value = map.get(str);
				map.replace(str, value+1);
			}else {
				map.put(str, 1);
			}
			str = sc.nextLine();
		}
		int max = 0;
		String name = "";
		int nextNum = 0;
		String next = "";
		HashSet<String> set = new HashSet<String>(map.keySet());
		for(String s: set) {
			int num = map.get(s);
			if(num > max) {
				max = num;
				name = s;
			}else if(num == max) {
				nextNum = max;
			}
		}
		if(nextNum == max) {
			System.out.println("Runoff!");
		}else {
			System.out.println(name);
		}
	}
 
}