import java.util.*;
 
public class rollingthedice {
	
	// Private Static Methods Starts Here
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
		int n = sc.nextInt();
		int t = sc.nextInt();
		int numerator;
		if(t - 1 < n) {
			numerator = (int) Math.round(((double)t - 1)/(n*n)*1000);
		}else{
			numerator = (int) Math.round(((double)2 * n - t + 1)/(n*n)*1000);
		}
		System.out.println(numerator + "/" + 1000);
		
	}
}
