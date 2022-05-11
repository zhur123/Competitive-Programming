import java.util.*;
 
public class Jazzitup {
	
	// Private Static Methods Starts Here
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
        int n = sc.nextInt();
		HashSet<Integer> factors = new HashSet<>();
		int max = (int)Math.sqrt(n);
		for(int i = 2; i <= max; i++){
			if(n % i == 0){
				factors.add(i);
			}
		}
		for(int i = 2; i < n; i++){
			boolean cont = true;
			for(int fact : factors){
				if(cont && i % fact == 0){
					cont = false;
					break;
				}
			}
			if(!cont){
				continue;
			}
			if (n % i != 0){
				System.out.println(i);
				break;
			}
		}

		sc.close();
	}
 
}