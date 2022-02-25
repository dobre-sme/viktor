public class PowerHardware extends Hardware{

    public PowerHardware(String name, int capacity, int memory) {
        setName(name);
        setMaxCapacity(capacity-((capacity*3)/4));
        setMaxMemory(memory+((memory*3)/4));
        setType("PowerHardware");
        setSoftwareCapacity(0);
        setSoftwareMemory(0);
    }

}
