import java.util.*;
 
public class Kemija {
	
	// Private Static Methods Starts Here
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
        char[] arr = sc.nextLine().toCharArray();
		String str = "";
		for(int i = 0; i < arr.length; i++){
			if("aeiou".contains("" + arr[i])){
				str += arr[i];
				i += 2;
			}else{
				str += arr[i];
			}
		}
		System.out.println(str);

		sc.close();
	}
 
}