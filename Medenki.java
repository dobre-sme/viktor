import java.util.Scanner;

public class Medenki {
  public static void main(String[] args) {
	  
	  Scanner scan = new Scanner(System.in);
	  
	  int viktor = 0, naskor = 0, medenka = 0;
	  int blackattack = 0, whiteattack = 0;
	  int blackconsec = 1, whiteconsec = 1;
	  int attacksave = 0;
	  
	  while(medenka != 10000) {
		  
		  String attack = scan.nextLine();
		  if (attack.equals("end")) break;
		  
		  String[] splitter = attack.split(" ");
		  medenka = Integer.parseInt(splitter[0]);
		  
		  if (splitter[1].equals("dark")) {
			 if (blackattack == medenka) blackconsec++;
			 blackattack = medenka;
			 for(int counter=0;counter < medenka; medenka--) {
				 
				 if(medenka*60 == attacksave) {
					 blackconsec = 2;
					 attacksave = 0;
				 }
				 if(blackconsec%5 == 0) {
					 naskor += 270*medenka;
					 blackconsec = 1;
					 attacksave = 270*medenka;
					 medenka = 0;
				 }
				 else naskor += 60;	
			 }
		  }
		  if (splitter[1].equals("white")) {
			  if (whiteattack == medenka) whiteconsec++;
			  whiteattack = medenka;
			  for(int counter=0;counter < medenka; medenka--) {
				  
				  if (whiteconsec%2 == 0) {
					  viktor += 165*medenka;
					  whiteconsec = 0;
					  medenka = 0;
				  }
				  else viktor += 60;
				  
			  }
		  }
	  }
	  if (viktor > naskor) System.out.println("Winner - Viktor" + '\n' + "Damage - " + viktor);
	  else System.out.println("Winner - Naskor" + '\n' + "Damage - " + naskor);
  }
}
