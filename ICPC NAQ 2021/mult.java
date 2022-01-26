import java.util.Scanner;

public class mult {

    // Private Static Methods Starts Here

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Code Starts Here
        int n = sc.nextInt();
        boolean start = true;
        int target = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (start) {
                target = num;
                start = false;
            } else if (num % target == 0) {
                System.out.println(num);
                start = true;
            }
        }

    }

}