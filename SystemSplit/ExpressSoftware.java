public class ExpressSoftware extends Software{

    public ExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        setName(name);
        setCapacityConsumption(capacity);
        setMemoryConsumption(memory*2);
        setHardwareComponentName(hardwareComponentName);
        setType("Express");
    }

}
