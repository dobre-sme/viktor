import java.util.*;
//program calculates the most spending customer using a map of products and their prices
//and a map that is essentially a grocery list. it also uses discounts to lower prices
public class mostValuedCustomer {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String text = null;
        text = scan.nextLine();
        Map<String, Double> productsMap = new HashMap<String, Double>();
        Map<String, List<String>> customerMap = new HashMap<String, List<String>>();

        while (!text.equals("Shop is open")) {
            String[] split = text.split(" ");
            double price = Float.parseFloat(split[1]);
            productsMap.put(split[0], price);
            text = scan.nextLine();
        }//fills map with product as key and its price as value

        text = scan.nextLine();
        String bigSpender = "";
        int spenders = 0;
        double oldSum = 0;

        while (!text.equals("Print")) {
            String[] customSplit = text.split(": ");
            String[] productSplit = customSplit[1].split(", ");

            customerMap.put(customSplit[0], new ArrayList<>());
            double sum = 0;

            for (int i = 0; i < productSplit.length; i++) {
                customerMap.get(customSplit[0]).add(productSplit[i]);
                sum += productsMap.get(productSplit[i]);
            }//fills product list

            if (sum > oldSum) {
                bigSpender = customSplit[0];
                oldSum = sum;
            }

            text = scan.nextLine();
            spenders++;
        }//fills map with customer as key and his products as value in a list

        System.out.println("Biggest Spender: " + bigSpender + "\n ^Products bought:");
        
    }
}
