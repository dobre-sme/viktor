import java.util.*;

public class LINQuistics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> linqMap = new TreeMap<>(Collections.reverseOrder());
        List<String> collections = new LinkedList<>();
        String input = scan.nextLine();
        int mostMethods = 0;
        String biggestList = "";

        while (!input.equals("exit")) {
            String[] split = input.split("[.]");

            if (input.matches("[0-9]+")) {

                for (Map.Entry<String, List<String>> entry : linqMap.entrySet()) {
                    if (entry.getValue().size() > mostMethods) {
                        biggestList = entry.getKey();
                        mostMethods = entry.getValue().size();
                    }
                }

                linqMap.get(biggestList).sort(Comparator.comparingInt(String::length));
                if (linqMap.get(biggestList).size() < Integer.parseInt(input)) {
                    for (int i = 0; i < linqMap.get(biggestList).size(); i++) System.out.println("* " + linqMap.get(biggestList).get(i));
                } else {
                    for (int i = 0; i < Integer.parseInt(input); i++) System.out.println("* " + linqMap.get(biggestList).get(i));
                }

            }// if only number is given
            else if (input.matches("[A-Z-a-z]+")) {
                if (collections.contains(input)) {
                    linqMap.get(input).sort(Comparator.comparingInt(String::length).reversed());
                    for (int i = 0; i < linqMap.get(input).size(); i++) System.out.println("* " + linqMap.get(input).get(i));
                }

            }// if only collection is given
            else {
                if (!linqMap.containsKey(split[0])) {
                    collections.add(split[0]);
                    linqMap.put(split[0], new ArrayList<>());
                }
                for (int i = 1; i < split.length; i++) {
                    String[] noBrackets = split[i].split("[()]");
                    linqMap.get(split[0]).add(noBrackets[0]);
                }
            }// if format is: collection.method1().method2()...methodN()

            input = scan.nextLine();
        }

        String method = scan.next(), selection = scan.next();
        for (Map.Entry<String, List<String>> entry : linqMap.entrySet()) {
            if (entry.getValue().contains(method)) {//checks collection for method given in last line
                System.out.println(entry.getKey());
                entry.getValue().sort(Comparator.comparingInt(String::length).reversed());
                if (selection.equals("all")) {// prints methods
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        System.out.println("* " + entry.getValue().get(i));
                    }
                }
            }
        }
    }
}
