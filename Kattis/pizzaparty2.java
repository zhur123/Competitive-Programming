import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class pizzaparty2 {

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
            tempAnd.clear();
            tempAnd.addAll(and);
            for (SimpleEntry<String, LinkedList<String>> pair : tempAnd) {
                String finalTopping = pair.getKey();
                LinkedList<String> list = pair.getValue();
                LinkedList<String> temp = new LinkedList<>();
                temp.addAll(list);
                for (String str : temp) {
                    if (set.contains(str)) {
                        list.remove(str);
                    }
                }
                if (list.isEmpty()) {
                    delta++;
                    set.add(finalTopping);
                    and.remove(pair);
                }
            }

            tempOr.clear();
            tempOr.addAll(or);
            for (SimpleEntry<String, LinkedList<String>> pair : tempOr) {
                String finalTopping = pair.getKey();
                LinkedList<String> list = pair.getValue();
                boolean found = false;
                for (String str : list) {
                    if (set.contains(str)) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    delta++;
                    set.add(finalTopping);
                    or.remove(pair);
                }
            }
        }
        System.out.println(set.size());
    }

}