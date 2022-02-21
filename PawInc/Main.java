import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        while (!command.equals("Paw Paw Pawah")) {
            String[] splitInput = command.split(" [|] ");

            switch (splitInput[0]) {
                case "RegisterAdoptionCenter":
                    AnimalCenterManager.registerAdoptionCenter(splitInput[1]);
                    break;
                case "RegisterCleansingCenter":
                    AnimalCenterManager.registerCleansingCenter(splitInput[1]);
                    break;
                case "RegisterCastrationCenter":
                    AnimalCenterManager.registerCastrationCenter(splitInput[1]);
                    break;
                case "RegisterDog":
                    AnimalCenterManager.registerDog(splitInput[1], Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]), splitInput[4]);
                    break;
                case "RegisterCat":
                    AnimalCenterManager.registerCat(splitInput[1], Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]), splitInput[4]);
                    break;
                case "SendForCastration":
                    AnimalCenterManager.sendForCastration(splitInput[1], splitInput[2]);
                    break;
                case "SendForCleansing":
                    AnimalCenterManager.sendForCleansing(splitInput[1], splitInput[2]);
                    break;
                case "Cleanse":
                    AnimalCenterManager.cleanse(splitInput[1]);
                    break;
                case "Adopt":
                    AnimalCenterManager.adopt(splitInput[1]);
                    break;
                case "Castrate":
                    AnimalCenterManager.castrate(splitInput[1]);
                    break;
                case "CastrationStatistics":
                    AnimalCenterManager.castrationStatistics();
                    break;
            }

            command = scan.nextLine();
        }

        AnimalCenterManager.printStatistics();

    }
}
