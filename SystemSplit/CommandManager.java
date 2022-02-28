import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandManager {

    public void RegisterPowerHardware(String name, int capacity, int memory) {
        Hardware.hardwareMap.put(new PowerHardware(name, capacity, memory), new ArrayList<>());
    }

    public void RegisterHeavyHardware(String name, int capacity, int memory) {
        Hardware.hardwareMap.put(new HeavyHardware(name, capacity, memory), new ArrayList<>());
    }

    public void RegisterExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        for (Map.Entry<Hardware, List<Software>> entry : Hardware.hardwareMap.entrySet()) {
            if (entry.getKey().getName().equals(hardwareComponentName)) {
                if (entry.getKey().getMaxCapacity() >= entry.getKey().getSoftwareCapacity() + capacity &&
                        entry.getKey().getMaxMemory() >= entry.getKey().getSoftwareMemory() + (memory * 2)) {
                    Hardware.hardwareMap.get(entry.getKey()).add(new ExpressSoftware(hardwareComponentName, name, capacity, memory));
                    entry.getKey().setSoftwareCapacity(entry.getKey().getSoftwareCapacity() + capacity);
                    entry.getKey().setSoftwareMemory(entry.getKey().getSoftwareMemory() + (memory * 2));
                }
            }
        }
    }

    public void RegisterLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        for (Map.Entry<Hardware, List<Software>> entry : Hardware.hardwareMap.entrySet()) {
            if (entry.getKey().getName().equals(hardwareComponentName)) {
                if (entry.getKey().getMaxCapacity() >= entry.getKey().getSoftwareCapacity() + (capacity + (capacity / 2)) &&
                        entry.getKey().getMaxMemory() >= entry.getKey().getSoftwareMemory() + (memory / 2)) {
                    Hardware.hardwareMap.get(entry.getKey()).add(new LightSoftware(hardwareComponentName, name, capacity, memory));
                    entry.getKey().setSoftwareCapacity(entry.getKey().getSoftwareCapacity() + (capacity + (capacity / 2)));
                    entry.getKey().setSoftwareMemory(entry.getKey().getSoftwareMemory() + (memory / 2));
                }
            }
        }
    }

    public void ReleaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        for (Map.Entry<Hardware, List<Software>> entry : Hardware.hardwareMap.entrySet()) {
            if (entry.getKey().getName().equals(hardwareComponentName)) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (entry.getValue().get(i).getName().equals(softwareComponentName)) {
                        Hardware.hardwareMap.get(entry.getKey()).remove(entry.getValue().get(i));
                    }
                }
            }
        }
    }

    public void Analyze() {
        int currentCapacity = 0, maxCapacity = 0, currentMemory = 0, maxMemory = 0, hardwareComponents = 0, softwareComponents = 0;

        for (Map.Entry<Hardware, List<Software>> entry : Hardware.hardwareMap.entrySet()) {
            maxCapacity += entry.getKey().getMaxCapacity();
            maxMemory += entry.getKey().getMaxMemory();
            hardwareComponents++;
            for (int i = 0; i < entry.getValue().size(); i++) {
                currentCapacity += entry.getValue().get(i).getCapacityConsumption();
                currentMemory += entry.getValue().get(i).getMemoryConsumption();
                softwareComponents++;
            }
        }
        System.out.println("System Analysis");
        System.out.println("Hardware Components: " + hardwareComponents);
        System.out.println("Software Components: " + softwareComponents);
        System.out.println("Total Operational Memory: " + currentMemory + " / " + maxMemory);
        System.out.println("Total Capacity Taken: " + currentCapacity + " / " + maxCapacity);
    }

    public void SystemSplit() {

        for (Map.Entry<Hardware, List<Software>> entry : Hardware.hardwareMap.entrySet()) {
            int expressSoftware = 0, lightSoftware = 0, currentCapacity = 0, maxCapacity = 0, currentMemory = 0, maxMemory = 0;
            maxCapacity += entry.getKey().getMaxCapacity();
            maxMemory += entry.getKey().getMaxMemory();
            System.out.println("Hardware Component - " + entry.getKey().getName());
            for (int i = 0; i < entry.getValue().size(); i++) {
                currentCapacity += entry.getValue().get(i).getCapacityConsumption();
                currentMemory += entry.getValue().get(i).getMemoryConsumption();
                if (entry.getValue().get(i).getType().equals("Express Software")) {
                    expressSoftware++;
                } else lightSoftware++;
            }
            System.out.println("Express Software Components - " + expressSoftware);
            System.out.println("Light Software Components - " + lightSoftware);
            System.out.println("Memory Usage: " + currentMemory + " / " + maxMemory);
            System.out.println("Capacity Usage: " + currentCapacity + " / " + maxCapacity);
            System.out.println("Type: " + entry.getKey().getType());
            System.out.print("Software Components: ");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i).getName());
                if (i != entry.getValue().size()-1) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
