import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private final List<AdoptionCenter> adoptionCenters = new ArrayList<>();

    private final List<CleansingCenter> cleansingCenters = new ArrayList<>();

    private final List<CastrationCenter> castrationCenters = new ArrayList<>();

    private final List<String> adoptedAnimals = new ArrayList<>();

    private final List<String> cleansedAnimals = new ArrayList<>();

    private final List<String> castratedAnimals = new ArrayList<>();

    public void registerCleansingCenter(String name) {
        cleansingCenters.add(new CleansingCenter(name));
    }// registers Cleansing Center

    public void registerAdoptionCenter(String name) {
        adoptionCenters.add(new AdoptionCenter(name));
    }// registers Adoption Center

    public void registerCastrationCenter(String name) {
        castrationCenters.add(new CastrationCenter(name));
    }// registers Castration Center

    public void registerDog(String name, int age, int commands, String adoptionCenterName) {
        for (AdoptionCenter adoptionCenter : adoptionCenters) {
            if (adoptionCenter.getName().equals(adoptionCenterName)) {
                adoptionCenter.addAnimal(new Dog(name, age, commands, adoptionCenterName));
            }
        }
    }// registers dog

    public void registerCat(String name, int age, int intellect, String adoptionCenterName) {
        for (AdoptionCenter adoptionCenter : adoptionCenters) {
            if (adoptionCenter.getName().equals(adoptionCenterName)) {
                adoptionCenter.addAnimal(new Cat(name, age, intellect, adoptionCenterName));
            }
        }
    }// registers cat

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        List<Animal> animalsToRemove = new ArrayList<>();

        for (Animal animal : getAdoptionCenter(adoptionCenterName).getAnimalList()) {
            if (!animal.getCleansingStatus()) {
                getCleansingCenter(cleansingCenterName).addAnimal(animal);
                animalsToRemove.add(animal);
                // getAdoptionCenter(adoptionCenterName).getAnimalList().remove(animal);
            }
        }
        getAdoptionCenter(adoptionCenterName).getAnimalList().removeAll(animalsToRemove);
    }// sends all animals from given Adoption Center to given Cleansing Center

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        List<Animal> animalsToRemove = new ArrayList<>();

        for (Animal animal : getAdoptionCenter(adoptionCenterName).getAnimalList()) {
            if (!animal.getCastrationStatus()) {
                getCastrationCenter(castrationCenterName).addAnimal(animal);
                animalsToRemove.add(animal);
            }
        }

        getAdoptionCenter(adoptionCenterName).getAnimalList().removeAll(animalsToRemove);
    }

    public void cleanse(String cleansingCenterName) {
        List<Animal> animalsToRemove = new ArrayList<>();

        for (Animal animal : getCleansingCenter(cleansingCenterName).getAnimalList()) {
            animal.setCleansingStatus(true);
            getAdoptionCenter(animal.getAdoptionCenterName()).addAnimal(animal);
            animalsToRemove.add(animal);
            cleansedAnimals.add(animal.getName());
        }

        getCleansingCenter(cleansingCenterName).getAnimalList().removeAll(animalsToRemove);
    }// cleanses all animals from given Cleansing Center and returns them to their Adoption Center

    public void adopt(String adoptionCenterName) {
        List<Animal> animalsToRemove = new ArrayList<>();

        for (Animal animal : getAdoptionCenter(adoptionCenterName).getAnimalList()) {
            if (animal.getCleansingStatus()) {
                animal.setAdoptionStatus(true);
                adoptedAnimals.add(animal.getName());
                animalsToRemove.add(animal);
            }
        }

        getAdoptionCenter(adoptionCenterName).getAnimalList().removeAll(animalsToRemove);
    }// adopts all animals and removes them from the Adoption Center

    public void castrate(String castrationCenterName) {
        List<Animal> animalsToRemove = new ArrayList<>();

        for (Animal animal : getCastrationCenter(castrationCenterName).getAnimalList()) {
            animal.setCastrationStatus(true);
            getAdoptionCenter(animal.getAdoptionCenterName()).addAnimal(animal);
            animalsToRemove.add(animal);
            castratedAnimals.add(animal.getName());
        }

        getCastrationCenter(castrationCenterName).getAnimalList().removeAll(animalsToRemove);
    }

    public void printStatistics() {
        System.out.println("Paw Incorporative Regular Statistics" + "\n" +
                "Adoption Centers: " + adoptionCenters.size() + "\n" + //works
                "Cleansing Centers: " + cleansingCenters.size() + "\n" + //works
                "Adopted Animals: " + getAdoptedAnimals() + "\n" +
                "Cleansed Animals: " + getCleansedAnimals() + "\n" +
                "Animals Awaiting Adoption: " + waitingForAdoption() + "\n" + //works
                "Animals Awaiting Cleansing: " + waitingForCleansing()); //works
    }// prints statistics

    public void castrationStatistics() {
        System.out.println("Paw Inc. Regular Castration Statistics" + "\n" +
                "Castration Centers: " + castrationCenters.size() + "\n" +
                "Castrated Animals: " + getCastratedAnimals());
    }

    public CleansingCenter getCleansingCenter(String cleansingCenterName) {
        for (CleansingCenter cleansingCenter : cleansingCenters) {
            if (cleansingCenter.getName().equals(cleansingCenterName)) {
                return cleansingCenter;
            }
        }
        return null;
    }

    public AdoptionCenter getAdoptionCenter(String adoptionCenterName) {
        for (AdoptionCenter adoptionCenter : adoptionCenters) {
            if (adoptionCenter.getName().equals(adoptionCenterName)) {
                return adoptionCenter;
            }
        }
        return null;
    }

    public CastrationCenter getCastrationCenter(String castrationCenterName) {
        for (CastrationCenter castrationCenter : castrationCenters) {
            if (castrationCenter.getName().equals(castrationCenterName)) {
                return castrationCenter;
            }
        }
        return null;
    }

    public List<String> orderAnimals (List<String> name) {
        return name.stream().sorted().collect(Collectors.toList());
    }

    public StringBuilder getCleansedAnimals() {
        List<String> orderedList = orderAnimals(cleansedAnimals);
        StringBuilder result = new StringBuilder();
        if (orderedList.size() > 0) {
            result.append(orderedList.get(0));
            if (orderedList.size() > 1) result.append(", ");
            for (int i = 1; i < orderedList.size(); i++) {
                result.append(orderedList.get(i));
                if (i != orderedList.size()-1) result.append(", ");
            }
        } else result.append("None");
        return result;
    }// returns all adopted animals

    public StringBuilder getAdoptedAnimals() {
        List<String> orderedList = orderAnimals(adoptedAnimals);
        StringBuilder result = new StringBuilder();
        if (orderedList.size() > 0) {
            result.append(orderedList.get(0));
            if (orderedList.size() > 1) result.append(", ");
            for (int i = 1; i < orderedList.size(); i++) {
                result.append(orderedList.get(i));
                if (i != orderedList.size()-1) result.append(", ");
            }
        } else result.append("None");
        return result;
    }// returns all adopted animals

    public StringBuilder getCastratedAnimals() {
        List<String> orderedList = orderAnimals(castratedAnimals);
        StringBuilder result = new StringBuilder();
        if (orderedList.size() > 0) {
            result.append(orderedList.get(0));
            if (orderedList.size() > 1) result.append(", ");
            for (int i = 1; i < orderedList.size(); i++) {
                result.append(orderedList.get(i));
                if (i != orderedList.size()-1) result.append(", ");
            }
        } else result.append("None");
        return result;
    }

    public int waitingForCleansing() {
        int forCleansing = 0;
        for (CleansingCenter cleansingCenter : cleansingCenters) {
            forCleansing += cleansingCenter.getAnimalList().size();
        }
        return forCleansing;
    }// returns number of animals waiting for cleansing

    public int waitingForAdoption() {
        int forAdoption = 0;
        for (AdoptionCenter adoptionCenter : adoptionCenters) {
            for (Animal animal : adoptionCenter.getAnimalList()) {
                if (animal.getCleansingStatus()) {
                    forAdoption++;
                }
            }
        }
        return forAdoption;
    }// returns all animals waiting for adoption
}

