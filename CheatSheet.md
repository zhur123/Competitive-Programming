```java
import java.util.*;
public class Name {

    // Global Variables
    public static HashMap<Integer, Integer> map;

    // Private Static Methods Starts Here
    private static class StringLT implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	}

    private static class Pair<K, V>{
        K key;
        V value;
        public Pair(K first, V second){
            key = first;
            value = second;
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Pair<String, Integer> pair = new Pair<>("5", 5);
        System.out.println(pair.key + pair.value);
        // Code Starts Here

    }

}
```