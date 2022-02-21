import java.util.*;

public class AdoptionCenter extends Centers {

    static Map<String, List<Animal>> adoptionCenters = new HashMap<>();
    static List<String> adoptedAnimals = new ArrayList<>();

    public AdoptionCenter(String name) {
        super(name);
    }
}
