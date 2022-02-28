public class HeavyHardware extends Hardware{

    public HeavyHardware(String name, int capacity, int memory) {
        setName(name);
        setMaxCapacity(capacity*2);
        setMaxMemory((memory*3)/4);
        setType("Heavy");
    }

}
