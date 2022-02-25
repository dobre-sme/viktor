import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hardware {

    private String name, type;
    private int maxCapacity, maxMemory, softwareCapacity, softwareMemory;
    static Map<Hardware, List<Software>> hardwareMap = new HashMap<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public int getSoftwareMemory() {
        return softwareMemory;
    }

    public void setSoftwareMemory(int softwareMemory) {
        this.softwareMemory = softwareMemory;
    }

    public int getSoftwareCapacity() {
        return softwareCapacity;
    }

    public void setSoftwareCapacity(int softwareCapacity) {
        this.softwareCapacity = softwareCapacity;
    }
}
