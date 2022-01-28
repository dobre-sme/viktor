import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Camping {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String pattern = "(?<person>[A-Z-a-z]+) (?<model>[0-9A-Z-a-z]+) (?<nights>[0-9]+)$";
		Pattern compiler = Pattern.compile(pattern);
		
		Map<String, List<String>> carOwner = new HashMap<String, List<String>>();
		Map <String, Integer> nightSpent = new HashMap<String, Integer>();
		
		while(true) {
			String test = scan.nextLine();
			if (test.equals("end")) break;
			
			Matcher compMatcher = compiler.matcher(test);
			boolean result = compMatcher.matches(); // for some reason code breaks if this is removed
			String name = compMatcher.group("person");
			String model = compMatcher.group("model");
			int nights = Integer.parseInt(compMatcher.group("nights"));
			
			if (!carOwner.containsKey(name)) {
				carOwner.put(name, new ArrayList<>());
				nightSpent.put(name, nights);
				carOwner.get(name).add(model);
			} else {
				if (!carOwner.get(name).contains(model)) carOwner.get(name).add(model);
				int oldNights = nightSpent.get(name);
				nightSpent.put(name, oldNights + nights);
			}
		}// fills maps
		for (Map.Entry<String, List<String>> entry : carOwner.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().size());
			for (int j=0;j<carOwner.get(entry.getKey()).size();j++)  System.out.println("***" + entry.getValue().get(j));
			System.out.println("Total stay: " + nightSpent.get(entry.getKey()) + " nigths");
		} // prints the person, his vehicles and nights spent
	}
}
