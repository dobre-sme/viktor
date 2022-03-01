public class Software {

    private String name, type, hardwareComponentName;
    private int capacityConsumption, memoryConsumption;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    public String getHardwareComponentName() {
        return hardwareComponentName;
    }

    public void setHardwareComponentName(String hardwareComponentName) {
        this.hardwareComponentName = hardwareComponentName;
    }
}
