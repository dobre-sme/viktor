import java.util.ArrayList;
import java.util.Scanner;

public class hornetAssult {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] hiveSplit = scan.nextLine().split(" ");
		String[] hornetSplit = scan.nextLine().split(" ");
		int[] hive = new int[hiveSplit.length];
		int [] hornet = new int[hornetSplit.length];
		int hornetCounter = 0, hiveCounter = 0;
		
		for (int i=0;i<hiveSplit.length;i++) {
			hive[i] = Integer.parseInt(hiveSplit[i]);
		}//fills hives
		for (int i=0;i<hornetSplit.length;i++) {
			hornet[i] = Integer.parseInt(hornetSplit[i]);
		}// fills hornets
		
		for(int i=0;i<hive.length;i++) {
			for(int j=0;j<hornet.length;j++) {
				hive[i] -= hornet[j];
			}// hives attacked by hornets
			if (hive[i] >= 0 ) {
				hornet[hornetCounter] = 0;
				hornetCounter++;
			}//hornet dies
		}
		
		for(int i=0;i<hive.length;i++) {
			if(hive[i] > 0) {
				System.out.print(hive[i] + " ");
				hiveCounter++;
			}//prints out remaining hives if any
		}
		if(hiveCounter == 0) {
			for(int i=0;i<hornet.length;i++) 
				if(hornet[i] > 0) System.out.print(hornet[i] + " ");
		}// prints hornets if any
		
	}
}
