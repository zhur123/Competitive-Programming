import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class pizzaparty {

    // Private Static Methods Starts Here

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Code Starts Here
        int n = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        LinkedList<SimpleEntry<String, LinkedList<String>>> and = new LinkedList<>();
        LinkedList<SimpleEntry<String, LinkedList<String>>> or = new LinkedList<>();

        while (n-- > 0) {
            String line = sc.next();
            if (line.equals("if")) {
                LinkedList<String> toppings = new LinkedList<>();
                toppings.add(sc.next());
                line = sc.next();
                if (line.equals("or")) {
                    while (!line.equals("then")) {
                        toppings.add(sc.next());
                        line = sc.next();
                    }
                    String finalTopping = sc.next();
                    or.add(new SimpleEntry<String, LinkedList<String>>(
                            finalTopping, toppings));
                } else {
                    while (!line.equals("then")) {
                        toppings.add(sc.next());
                        line = sc.next();
                    }
                    String finalTopping = sc.next();
                    and.add(new SimpleEntry<String, LinkedList<String>>(
                            finalTopping, toppings));
                }
            } else {
                set.add(line);
            }
        }
        int delta = 1;
        LinkedList<SimpleEntry<String, LinkedList<String>>> tempAnd = new LinkedList<>();
        LinkedList<SimpleEntry<String, LinkedList<String>>> tempOr = new LinkedList<>();
        while (delta > 0) {
            delta = 0;
            int andSize = and.size();
            for (int i = 0; i < andSize; i++) {
                SimpleEntry<String, LinkedList<String>> m = and.remove(0);
                String finalTopping = m.getKey();
                LinkedList<String> list = m.getValue();
                boolean all = true;
                for (String str : list) {
                    if (!set.contains(str)) {
                        all = false;
                    }
                }
                if (all) {
                    delta++;
                    set.add(finalTopping);
                } else {
                    tempAnd.add(m);
                }
            }
            and.clear();
            and.addAll(tempAnd);
            tempAnd.clear();

            int orSize = or.size();
            for (int i = 0; i < orSize; i++) {
                SimpleEntry<String, LinkedList<String>> pair = or.remove(0);
                String finalTopping = pair.getKey();
                LinkedList<String> list = pair.getValue();
                boolean one = false;
                for (String str : list) {
                    if (set.contains(str)) {
                        one = true;
                        break;
                    }
                }
                if (one) {
                    delta++;
                    set.add(finalTopping);
                } else {
                    tempOr.add(pair);
                }
            }
            or.clear();
            or.addAll(tempOr);
            tempOr.clear();
        }
        System.out.println(set.size());
    }

}