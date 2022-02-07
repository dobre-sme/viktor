import java.text.DecimalFormat;
import java.util.*;
// accepts input in following format:
// bank -> account -> balance

public class orderedBankingSystem {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Float>> bankingSys = new TreeMap<>();
        String input = scan.nextLine();

        while (!input.equals("end")) {
            String[] split = input.split(" -> ");
            String bank = split[0];
            String account = split[1];
            float newValue = Float.parseFloat(split[2]);
            if (!bankingSys.containsKey(bank)) { //add new bank, account and balance
                bankingSys.put(bank, new TreeMap<>(Collections.reverseOrder()));
                bankingSys.get(bank).put(account, newValue);
            }
            else if (bankingSys.get(bank).containsKey(account)) { //add new value to account
                float oldValue = bankingSys.get(bank).get(account);
                bankingSys.get(bank).put(account, oldValue + newValue);
            }
            else bankingSys.get(bank).put(account, newValue); //add new account and value to bank

            input = scan.nextLine();
        }//fills bank, account and account balance

        DecimalFormat df = new DecimalFormat("0.#####");//doesn't work

        for (Map.Entry<String, Map<String, Float>> bankEntry : bankingSys.entrySet()) {
            for (Map.Entry<String, Float> accountEntry : bankingSys.get(bankEntry.getKey()).entrySet()) {
                System.out.printf(accountEntry.getKey() + " -> " + df.format(accountEntry.getValue())
                + " (" + bankEntry.getKey() + ")");
                System.out.println();
            }
        }//prints map in format - account -> balance (bank)
    }
}
