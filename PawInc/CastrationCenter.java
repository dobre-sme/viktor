import java.util.*;

public class CastrationCenter extends Centers{

    static Map<String, List<Animal>> castrationCenters = new HashMap<>();
    static List<String> castratedAnimals = new ArrayList<>();

    public CastrationCenter(String name) {
        super(name);
    }


}
