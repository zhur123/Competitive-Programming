import java.util.Scanner;

public class duckmaker {

    // Private Static Methods Starts Here

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Code Starts Here
        int w = sc.nextInt();
        int h = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        for (int i = 0; i < h; i++) {
            if ((i + 1) * w < line.length()) {
                System.out.println(line.substring(i * w, (i + 1) * w));
            } else {
                System.out.println(line.substring(i * w));
                break;
            }
        }

    }

}