import java.util.Scanner;

public class hornetWings {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int flaps = scan.nextInt();
		int distance = scan.nextInt();
		int endurance = scan.nextInt();
		
		System.out.println((flaps/1000)*distance + " m.");
		System.out.println((flaps/100) + (flaps/endurance)*distance + " s.");
	}

}
