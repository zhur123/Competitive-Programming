import java.util.*;
 
/*
	Sieve of Eratosthenes, TLE
*/
public class lookingforprimes {
	
	// Private Static Methods Starts Here
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Code Starts Here
		int s = sc.nextInt();
		int l = sc.nextInt();
		String line = sc.next();
		long largest = -1;
		for(int i = 0; i < s; i++) {
			for(int j = i + 1; j <= s; j++) {
				if(j - i <= l && j - i + 1 >= 1) {
					long num = Long.parseLong(line.substring(i, j));
					if(checkPrime(num)) {
						largest = Math.max(largest, num);
					}
				}else {
					break;
				}
			}
		}
		if(largest == -1) {
			System.out.println("No Primes");
		}else {
			System.out.println(largest);
		}
	}

	private static boolean checkPrime(long num) {
		boolean isPrime = true;
		if(num == 1) {
			return false;
		}
		ArrayList<Integer> possible = new ArrayList<>();
		int high = (int) Math.sqrt(num) + 1;
		for(int i = 2; i <= high; i++) {
			possible.add(i);
		}
		for(int i = 2; i <= high; i++) {
			int counter = 2;
			while(counter * i <= high) {
				Integer multiple = counter * i;
				if(possible.contains(multiple)) {
					possible.remove(multiple);
				}
				counter++;
			}
		}
		for(int i = 0; i < possible.size(); i++) {
			if(num % possible.get(i) == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
 
}