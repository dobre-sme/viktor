import java.util.ArrayList;
import java.util.List;

public class TheSystem {

    List<Hardware> hardwareList = new ArrayList<>();

    public void RegisterPowerHardware(String name, int capacity, int memory) {
        hardwareList.add(new PowerHardware(name, capacity, memory));
    }

    public void RegisterHeavyHardware(String name, int capacity, int memory) {
        hardwareList.add(new HeavyHardware(name, capacity, memory));
    }

    public void RegisterExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        for (Hardware hardware : hardwareList) {
            if (hardware.getName().equals(hardwareComponentName)) {
                if (hardware.getMaxCapacity() >= hardware.getSoftwareCapacity() + capacity &&
                        hardware.getMaxMemory() >= hardware.getSoftwareMemory() + (memory * 2)) {
                    hardware.softwareList.add(new ExpressSoftware(hardwareComponentName, name, capacity, memory));
                    hardware.setSoftwareCapacity(hardware.getSoftwareCapacity() + capacity);
                    hardware.setSoftwareMemory(hardware.getSoftwareMemory() + (memory * 2));
                }
            }
        }
    }

    public void RegisterLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        for (Hardware hardware : hardwareList) {
            if (hardware.getName().equals(hardwareComponentName)) {
                if (hardware.getMaxCapacity() >= hardware.getSoftwareCapacity() + (capacity + (capacity / 2)) &&
                        hardware.getMaxMemory() >= hardware.getSoftwareMemory() + (memory / 2)) {
                    hardware.softwareList.add(new LightSoftware(hardwareComponentName, name, capacity, memory));
                    hardware.setSoftwareCapacity(hardware.getSoftwareCapacity() + (capacity + (capacity / 2)));
                    hardware.setSoftwareMemory(hardware.getSoftwareMemory() + (memory / 2));
                }
            }
        }
    }

    public void ReleaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        for (Hardware hardware : hardwareList) {
            if (hardware.getName().equals(hardwareComponentName)) {
                hardware.softwareList.removeIf(software -> software.getName().equals(softwareComponentName));
            }
        }
    }

    public void Analyze() {
        int currentCapacity = 0, maxCapacity = 0, currentMemory = 0, maxMemory = 0, hardwareComponents = 0, softwareComponents = 0;

        for (Hardware hardware : hardwareList) {
            maxCapacity += hardware.getMaxCapacity();
            maxMemory += hardware.getMaxMemory();
            hardwareComponents++;
            for (Software software : hardware.softwareList) {
                currentCapacity += software.getCapacityConsumption();
                currentMemory += software.getMemoryConsumption();
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
        for (Hardware hardware : hardwareList) {
            int expressSoftware = 0, lightSoftware = 0, currentCapacity = 0, maxCapacity = 0, currentMemory = 0, maxMemory = 0;
            maxCapacity += hardware.getMaxCapacity();
            maxMemory += hardware.getMaxMemory();
            System.out.println("Hardware Component - " + hardware.getName());
            for (Software software : hardware.softwareList) {
                currentCapacity += software.getCapacityConsumption();
                currentMemory += software.getMemoryConsumption();
                if (software.getType().equals("Express")) {
                    expressSoftware++;
                } else lightSoftware ++;
            }
            System.out.println("Express Software Components - " + expressSoftware);
            System.out.println("Light Software Components - " + lightSoftware);
            System.out.println("Memory Usage: " + currentMemory + " / " + maxMemory);
            System.out.println("Capacity Usage: " + currentCapacity + " / " + maxCapacity);
            System.out.println("Type: " + hardware.getType());
            System.out.print("Software Components: ");
            for (Software software : hardware.softwareList) {
                System.out.print(software.getName());
                if (!software.equals(hardware.softwareList.get(hardware.softwareList.size()-1))) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
