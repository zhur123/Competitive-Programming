import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class rpncalculator {

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
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < n; i++) {
            String op = sc.nextLine();
            if (op.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (op.equals("-")) {
            	int num = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num);
            } else if (op.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (op.equals("/")) {
                int num = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num);
            } else if (op.equals("enter")) {
                stack.push(stack.peek());
            } else if (op.equals("swap")) {
                int num = stack.pop();
                int num2 = stack.pop();
                stack.push(num);
                stack.push(num2);
            } else {
                if (stack.size() != 0) {
                    stack.pop();
                }
                stack.push(Integer.valueOf(op));
            }
        }
        System.out.println(stack.pop());
    }

}