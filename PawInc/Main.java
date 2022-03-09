import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        AnimalCenterManager manager = new AnimalCenterManager();

        while (!command.equals("Paw Paw Pawah")) {
            String[] splitInput = command.split(" [|] ");

            switch (splitInput[0]) {
                case "RegisterAdoptionCenter":
                    manager.registerAdoptionCenter(splitInput[1]);
                    break;
                case "RegisterCleansingCenter":
                    manager.registerCleansingCenter(splitInput[1]);
                    break;
                case "RegisterCastrationCenter":
                    manager.registerCastrationCenter(splitInput[1]);
                    break;
                case "RegisterDog":
                    manager.registerDog(splitInput[1], Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]), splitInput[4]);
                    break;
                case "RegisterCat":
                    manager.registerCat(splitInput[1], Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]), splitInput[4]);
                    break;
                case "SendForCastration":
                    manager.sendForCastration(splitInput[1], splitInput[2]);
                    break;
                case "SendForCleansing":
                    manager.sendForCleansing(splitInput[1], splitInput[2]);
                    break;
                case "Cleanse":
                    manager.cleanse(splitInput[1]);
                    break;
                case "Adopt":
                    manager.adopt(splitInput[1]);
                    break;
                case "Castrate":
                    manager.castrate(splitInput[1]);
                    break;
                case "CastrationStatistics":
                    manager.castrationStatistics();
                    break;
            }

            command = scan.nextLine();
        }

        manager.printStatistics();

    }
}
