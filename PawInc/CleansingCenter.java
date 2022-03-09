import java.util.*;

public class CleansingCenter extends Centers {

    private final List<Animal> animals = new ArrayList<>();

    public CleansingCenter(String name) {
        super(name);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimalList() {
        return(animals);
    }
}

