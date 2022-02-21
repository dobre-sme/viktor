import java.util.*;
import java.util.stream.Collectors;

public class Centers {

    String name;
    public Centers (String name) {
        this.name = name;
    }

    public static List orderAnimals (List<String> name) {
        List<String> orderedList = name.stream().sorted().collect(Collectors.toList());
        return orderedList;
    }

}
