import java.util.*;

public class AdoptionCenter extends Centers {

    private final List<Animal> animals = new ArrayList<>();

    public AdoptionCenter(String name) {
        super(name);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimalList() {
        return animals;
    }
}