import java.util.ArrayList;
import java.util.Scanner;

public class stringDecrypt {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> asci = new ArrayList();
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		String numbersLine = scan.nextLine();
		String[] splitter = numbersLine.split(" ");
		
		for (int i=0;i<splitter.length;i++) {
			if(Integer.parseInt(splitter[i]) >= 65 && Integer.parseInt(splitter[i]) <= 90) asci.add(Integer.parseInt(splitter[i]));
		}//removes underperforming numbers
		
		for(int i=n+m;n<i;n++) {
			int a = asci.get(n);
			 System.out.print((char)a);
		}//prints ASCII
	}
}
