import java.util.*;

public class Lambada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        Map<String, String> lambadas = new HashMap<>();
        String lastExpres = "";

        while (!expression.equals("lambada")) {
            if (expression.equals("dance")) lambadas.put(lastExpres, lastExpres + "." + lambadas.get(lastExpres));
            else {
                String[] split = expression.split(" => [A-Z-a-z]+.");
                lambadas.put(split[0], split[1]);
                lastExpres = split[0];
            }

            expression = scan.nextLine();
        }

        for (Map.Entry<String, String> entry : lambadas.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getKey() + "." + entry.getValue());
        }
    }
}
