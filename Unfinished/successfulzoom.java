import java.util.*;
 
public class successfulzoom {
	
	// Private Static Methods Starts Here
 
	public static void main(String[] args) {
		// Code Starts Here
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		String[] arr = sc.nextLine().split(" ");
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		boolean cont = false;
		boolean complete = true;
		int save = 0;
		for(int i = 1; i <= n / 2; i++) {
			int prev = 0;
			save = i;
			for(int j = i - 1; j < n; j += i) {
				if(j < n) {
					if(array[j] > prev) {
						prev = array[j];
					}else {
						complete = false;
						break;
					}
				}
			}
			if(complete) {
				break;
			}else {
				complete = true;
				if(i == n/2) {
					complete = false;
				}
			}
		}
		if(complete) {
			System.out.println(save);
		}else {
			System.out.println("ABORT!");
		}
		
	}
 
}