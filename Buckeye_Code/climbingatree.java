import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class climbingatree {

    // Comparator Template

    /**
     * Compare {@code String}s in alphabetical order
     */
    private static class StringLT implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }

    // Private Static Methods Starts Here

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Code Starts Here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int map[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> current = adj.get(i);
            for (Integer j : current) {
                if (j > i) {
                    map[j] = map[i] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (map[i] > max) {
                max = map[i];
            }
        }

        System.out.println(max);

    }

}