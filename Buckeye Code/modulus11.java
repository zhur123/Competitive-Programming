import java.util.*;
 
public class modulus11_2 {
	
	// Private Static Methods Starts Here
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		String line = sc.next();
		int mod = 0;
		boolean even = true;
		for(int i = n - 1; i >= 0; i--) {
			int digit = Character.getNumericValue(line.charAt(i));
			if(even) {
				mod += digit;
				even = false;
			}else {
				mod -= digit;
				even = true;
			}
		}
		System.out.println((mod % 11 + 11) % 11);
	}
 
}