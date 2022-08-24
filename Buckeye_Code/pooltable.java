package Buckeye_Code;
import java.util.*;

// Problem Link:
// Runtime: O()
// Space: O()
public class pooltable {
	
	// Public Static Variables
	
	// Private Static Methods Starts Here
	
    // private static class StringLT implements Comparator<String> {
	// 	@Override
	// 	public int compare(String o1, String o2) {
	// 		return o1.compareToIgnoreCase(o2);
	// 	}
	// }

    // private static class Pair<K, V>{
    //     K key;
    //     V value;
    //     public Pair(K first, V second){
    //         key = first;
    //         value = second;
    //     }
    // }
 
	public static void main(String[] args) {
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int w = sc.nextInt();
		int h = sc.nextInt();
		int factor = gcd(w, h);
		w /= factor;
		h /= factor;
		if(w == h) {
			System.out.println(2);
		}else if(w % 2 == 0) {
			System.out.println(1);
		}else {
			if(h % 2 == 0) {
				System.out.println(3);
			}else {
				System.out.println(2);
			}
		}
		
	}

	private static int gcd(int a, int b) {
		if(b==0)return a;
		return gcd(b, a%b);
	}
 
}