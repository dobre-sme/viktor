import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class arrayData {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String data = scan.nextLine();//numbers
		String choice = scan.nextLine();//all max or min
		ArrayList<Integer> dataList = new ArrayList();
		String[] dataSplit = data.split(" ");
		float sum = 0, count = 0;
		
		for(int i=0;i<dataSplit.length;i++) {
			dataList.add(Integer.parseInt(dataSplit[i]));
			sum += Integer.parseInt(dataSplit[i]);
			count++;
		}// fills list while calculating the average
		Collections.sort(dataList);//sorts list
		float average = sum/count;
		
		for(int i=0;i<dataList.size();i++) {
			if (Integer.parseInt(dataList.get(i).toString()) < average) {
				dataList.remove(i);
				i--;
			}//removes underperforming numbers
			else if(choice.equals("All")) System.out.print(dataList.get(i) + " ");
		}
		if(choice.equals("Min")) System.out.println(dataList.get(0));
		if(choice.equals("Max")) System.out.println(dataList.get(dataList.size()-1));
	}
}
