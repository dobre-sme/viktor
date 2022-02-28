public class LightSoftware extends Software{

    public LightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        setName(name);
        setCapacityConsumption(capacity+(capacity/2));
        setMemoryConsumption(memory/2);
        setHardwareComponentName(hardwareComponentName);
        setType("Light");
    }

}
