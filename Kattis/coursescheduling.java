import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
 
public class coursescheduling {
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
		public int compare(String c1, String c2) {
			String s1 = c1.replaceAll("[^0-9]", "");
			String s2 = c2.replaceAll("[^0-9]", "");
			if(s1.equals("") && s2.equals("")) {
				return c1.compareToIgnoreCase(c2);
			}else if(s1.equals("")) {
				return 1;
			}else if(s2.equals("")){
				return -1;
			}
			int num1 = Integer.valueOf(s1);
			int num2 = Integer.valueOf(s2);
			if(num1 == num2) {
				return c1.compareToIgnoreCase(c2);
			}else {
				return Integer.compare(num1, num2);
			}
		}
	}
	
	// Private Static Methods Starts Here
 
	public static void main(String[] args) {
		FastScanner sc = new FastScanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		HashSet<SimpleEntry<String, String>> set = new HashSet<SimpleEntry<String,String>>();
		for(int i = 0; i < n; i++) {
			String first = sc.next();
			String last = sc.next();
			String course = sc.next();
			SimpleEntry<String, String> pair = new SimpleEntry<String, String>(first + " " + last, course);
			if(!set.contains(pair)) {
				set.add(pair);
			}
		}
		Comparator<String> order = new StringLT();
		HashMap<String, Integer> map = new HashMap<>();
		for(SimpleEntry<String, String> pair : set) {
			String course = pair.getValue();
			if(map.containsKey(course)) {
				map.replace(course, map.get(course) + 1);
			}else {
				map.put(course, 1);
			}
		}
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.addAll(map.keySet());
		int size = map.size();
		for(int i = 0; i < size; i++) {
			String course = treeSet.pollFirst();
			System.out.println(course + " " + map.get(course));
		}
		
		
	}
 
}