import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        String pattern = "(?<command>[A-Z-a-z]+)([(])(?<values>.+)([)])";
        Pattern compiler = Pattern.compile(pattern);

        CommandManager commandManager = new CommandManager();

        while (!command.equals("System Split")) {

            if (command.equals("Analyze()")) {
                commandManager.Analyze();
            }
            else {

                Matcher matcher = compiler.matcher(command);
                boolean match = matcher.matches();
                String[] values = matcher.group("values").split(", ");

                switch (matcher.group("command")) {

                    case "RegisterPowerHardware":
                        commandManager.RegisterPowerHardware(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                        break;
                    case "RegisterHeavyHardware":
                        commandManager.RegisterHeavyHardware(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                        break;
                    case "RegisterExpressSoftware":
                        commandManager.RegisterExpressSoftware(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
                        break;
                    case "RegisterLightSoftware":
                        commandManager.RegisterLightSoftware(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
                        break;
                    case "ReleaseSoftwareComponent":
                        commandManager.ReleaseSoftwareComponent(values[0], values[1]);
                }
            }

            command = scan.nextLine();
        }

    }
}
