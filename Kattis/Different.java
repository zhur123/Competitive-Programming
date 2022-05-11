import java.util.*;
 
public class Different {
	
	// Private Static Methods Starts Here
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Code Starts Here
        while(sc.hasNextLong()){
            System.out.println(Math.abs(sc.nextLong() - sc.nextLong()));

        }
		

		sc.close();
	}
 
}