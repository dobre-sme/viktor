import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

//unfinished map sorting
public class Camping {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String pattern = "(?<person>[A-Z-a-z]+) (?<model>[0-9A-Z-a-z]+) (?<nights>[0-9]+)$";
		Pattern compiler = Pattern.compile(pattern);
		
		Map<String, List<String>> carOwner = new TreeMap<>();
		Map <String, Integer> nightSpent = new HashMap<>();
		
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
		}

		Map<String, List<String>> sorted = carOwner.entrySet().stream()
				.sorted(comparingInt(e -> e.getValue().size()))
				.collect(toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(b, a) -> { throw new AssertionError(); },
						LinkedHashMap::new
				));

		for (Map.Entry<String, List<String>> entry : sorted.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().size());
			for (int j=0;j<sorted.get(entry.getKey()).size();j++)  System.out.println("***" + entry.getValue().get(j));
			System.out.println("Total stay: " + nightSpent.get(entry.getKey()) + " nights");
		} // prints the person, his vehicles and nights spent
	}
}
