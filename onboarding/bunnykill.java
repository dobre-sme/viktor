import java.util.Scanner;

public class bunnykill {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String currentRow;
		int rowcounter = 0;
		String[] splitter = null;
		int matrix[][] = null;
		
		do {
			
			currentRow = scan.nextLine();
			splitter = currentRow.split(" ");
			
			if (rowcounter == 0) matrix = new int[splitter.length][splitter.length];
			// checks length of first row to determine the number of columns
			
			for(int col=0; col < splitter.length;col++) {
				
				matrix[rowcounter][col] = Integer.parseInt(splitter[col]);
			}
		
			rowcounter++;
		} while (rowcounter != splitter.length);
		// fills the matrix
		
		String bombLocation;
		bombLocation = scan.nextLine();
		String[] bombSplitter = bombLocation.split(" ");
		int bombs = bombSplitter.length;
		
		for(int i=0;i < bombs;i++) {
			String[] locationSplitter = bombSplitter[i].split(",");
			// gets the bomb location(s)
		
			int bombRow = Integer.parseInt(locationSplitter[0]);
			int bombCol = Integer.parseInt(locationSplitter[1]);
			int bombValue = matrix[bombRow][bombCol];
			matrix[bombRow][bombCol] += bombValue;
			// holds the bomb value otherwise spaghetti code deletes it
		
			for(int row=bombRow-1;row <= bombRow+1;row++) {
				for(int col=bombCol-1; col <= bombCol+1;col++) {
					if (row >= 0 && row <= matrix.length-1 && 0 <= col && col <= matrix.length-1) matrix[row][col] -= bombValue;
				}
			}// BOOM
		}
		
		int kills = 0, damage = 0;
		
		for(int row=0;row < splitter.length;row++) {
			for(int col=0;col < splitter.length;col++) {
				if (matrix[row][col] > 0) damage += matrix[row][col];
				if (matrix[row][col] > 0) kills++;
			}
		}// counts kills and damage
		System.out.println(damage + "\n" + kills);
	}
}
