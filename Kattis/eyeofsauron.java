import java.util.Scanner;

public class eyeofsauron {

    // Private Static Methods Starts Here

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Code Starts Here
        String[] str = sc.nextLine().split("\\(\\)");
        if (str[0].length() == str[1].length()) {
            System.out.println("correct");
        } else {
            System.out.println("fix");
        }

    }

}