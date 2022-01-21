import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class hornetComm {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String message = "(?<firstQuery>\\d+) <-> (?<secondQuery>[0-9A-Z-a-z]+)$";
		String broadcast = "(?<firstQuery>[^0-9]+) <-> (?<secondQuery>[0-9A-Z-a-z]+)";
		//pattern
		
		String text = "bruh";
		
		ArrayList messageList = new ArrayList();
		ArrayList broadcastList = new ArrayList();
		//lists for items
		
		Pattern patternMessage = Pattern.compile(message);
		Pattern patternBroadcast = Pattern.compile(broadcast);
		//pattern compiler
		
		//System.out.println(resultMessage + "\n" + resultBroadcast);
		// System.out.println(matchBroadcast.group("firstQuery"));
		
		while (!text.equals("Hornet is Green")) {
			
			text = scan.nextLine();
			
			Matcher matchMessage = patternMessage.matcher(text);
			Matcher matchBroadcast = patternBroadcast.matcher(text);
			//pattern matcher
			
			boolean resultMessage = matchMessage.matches();
			boolean resultBroadcast = matchBroadcast.matches();
			//pattern match confirmation
			
			if (resultMessage == true) {
				messageList.add(matchMessage.group("firstQuery"));
				messageList.add(matchMessage.group("secondQuery"));
			} //fills messages
			else if (resultBroadcast == true) {
				broadcastList.add(matchBroadcast.group("firstQuery"));
				broadcastList.add(matchBroadcast.group("secondQuery"));
			}//fills broadcasts
			
			
			if (text.equals("Hornet is Green")) break;
		}
		
		System.out.println("Broadcasts:");
		if (broadcastList.isEmpty()) System.out.println("none");
		else {
			for (int i=0;i < broadcastList.size();i+=2) {
				for (int j=0;j < broadcastList.get(i+1).toString().length();j++) {
					if(broadcastList.get(i+1).toString().charAt(j) >= 'a' && broadcastList.get(i+1).toString().charAt(j) <= 'z')
					System.out.print(Character.toUpperCase(broadcastList.get(i+1).toString().charAt(j)));
					else System.out.print(Character.toLowerCase(broadcastList.get(i+1).toString().charAt(j)));
				}
				System.out.println(" -> " + broadcastList.get(i));
			}
		}//prints broadcasts
		System.out.println("Messages:");
		if (messageList.isEmpty()) System.out.println("none");
		else {
			for (int i=0;i < messageList.size();i+=2) {
				int rev = 0, original = Integer.parseInt(messageList.get(i).toString());
				while(original != 0) {
			         int digit = original % 10;
			         rev = rev * 10 + digit;
			         original /= 10;
			      }
				System.out.println(rev + " -> " + messageList.get(i+1));
			}
		}//prints messages
		
	}

}
