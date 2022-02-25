import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandManager{

    public void RegisterPowerHardware(String name, int capacity, int memory) {
        Hardware.hardwareMap.put(new PowerHardware(name, capacity, memory), new ArrayList<>());
    }

    public void RegisterHeavyHardware(String name, int capacity, int memory) {
        Hardware.hardwareMap.put(new HeavyHardware(name, capacity, memory), new ArrayList<>());
    }

    public void RegisterExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        for (Map.Entry<Hardware, List<Software>> entry : Hardware.hardwareMap.entrySet()) {
            if (entry.getKey().getName().equals(hardwareComponentName)) {
                if (entry.getKey().getMaxCapacity() >= capacity && entry.getKey().getMaxMemory() >= memory*2) {
                    Hardware.hardwareMap.get(entry.getKey()).add(new ExpressSoftware(hardwareComponentName, name, capacity, memory));
                    entry.getKey().setSoftwareCapacity(entry.getKey().getSoftwareCapacity() + capacity);
                    entry.getKey().setSoftwareMemory(entry.getKey().getSoftwareMemory() + (memory*2));
                }
            }
        }
    }

    public void RegisterLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        for (Map.Entry<Hardware, List<Software>> entry : Hardware.hardwareMap.entrySet()) {
            if (entry.getKey().getName().equals(hardwareComponentName)) {
                if (entry.getKey().getMaxCapacity() >= capacity+(capacity/2) && entry.getKey().getMaxMemory() >= memory/2) {
                    Hardware.hardwareMap.get(entry.getKey()).add(new LightSoftware(hardwareComponentName, name, capacity, memory));
                    entry.getKey().setSoftwareCapacity(entry.getKey().getSoftwareCapacity() + (capacity+(capacity/2)));
                    entry.getKey().setSoftwareMemory(entry.getKey().getSoftwareMemory() + (memory/2));
                }
            }
        }
    }

    public void Analyze() {
        int currentCapacity = 0, maxCapacity = 0, currentMemory = 0, maxMemory = 0;

        for (Map.Entry<Hardware, List<Software>> entry : Hardware.hardwareMap.entrySet()) {
            maxCapacity += entry.getKey().getMaxCapacity();
            maxMemory += entry.getKey().getMaxMemory();
            for (int i = 0; i < entry.getValue().size(); i++) {
                currentCapacity += entry.getValue().get(i).getCapacityConsumption();
                currentMemory += entry.getValue().get(i).getMemoryConsumption();
            }
        }

        System.out.println("Total Operational Memory: " + currentMemory + " / " + maxMemory);
        System.out.println("Total Capacity Taken: " + currentCapacity + " / " + maxCapacity);
    }

}
