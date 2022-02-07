import java.util.*;

//program calculates the most spending customer using a map of products and their prices
//and a map that is essentially a grocery list. it also uses discounts to lower prices
public class mostValuedCustomer {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String text;
        text = scan.nextLine();
        Map<String, Double> productsMap = new HashMap<>();
        Map<String, List<String>> customerMap = new HashMap<>();

        while (!text.equals("Shop is open")) {
            String[] split = text.split(" ");
            double price = Float.parseFloat(split[1]);
            productsMap.put(split[0], price);
            text = scan.nextLine();
        }//fills map with product as key and its price as value

        text = scan.nextLine();//first customer and his shopping list
        String bigSpender = "";
        double oldSum = 0;

        while (!text.equals("Print")) {
           if (text.equals("Discount")) productsMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(3).forEach(e -> {
               e.setValue(e.getValue() * 0.9);// cuts the cost of the top 3 products by price by 10%
           });
           else {
               String[] customSplit = text.split(": ");
               String[] productSplit = customSplit[1].split(", ");

               customerMap.put(customSplit[0], new ArrayList<>());
               double sum = 0;

               for (String s : productSplit) {
                   customerMap.get(customSplit[0]).add(s);
                   sum += productsMap.get(s);
               }//fills product list

               if (sum > oldSum) {
                   bigSpender = customSplit[0];
                   oldSum = sum;
               }//finds the person who has spent the most in the shop
           }
            text = scan.nextLine();
        }//fills map with customer as key and his products as value in a list

        double total = 0;
        List<String> bigProducts = new ArrayList<>();
        for (String s : customerMap.get(bigSpender)) {
            if (!bigProducts.contains(s)) bigProducts.add(s);
            total += productsMap.get(s);
        }// new list of products that doest repeat the customers product

        System.out.println("Biggest spender: " + bigSpender + "\n^Products bought:");
        for (String s : bigProducts) {
            System.out.printf("^^^" + s + ": " + "%.2f", productsMap.get(s));
            System.out.println();
        }
        System.out.printf("Total: " + "%.2f", total);
    }
}
