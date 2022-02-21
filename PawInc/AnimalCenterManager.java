import java.util.*;

public class AnimalCenterManager {

    public static void registerCleansingCenter(String name) {
        CleansingCenter.cleansingCenters.put(name, new ArrayList<>());
    }// registers Cleansing Center

    public static void registerAdoptionCenter(String name) {
        AdoptionCenter.adoptionCenters.put(name, new ArrayList<>());
    }// registers Adoption Center

    public static void registerCastrationCenter(String name) {
        CastrationCenter.castrationCenters.put(name, new ArrayList<>());
    }// registers Castration Center

    public static void registerDog(String name, int age, int commands, String adoptionCenterName) {
        AdoptionCenter.adoptionCenters.get(adoptionCenterName).add(new Dog(name, age, commands, adoptionCenterName));
    }// registers dog

    public static void registerCat(String name, int age, int intellect, String adoptionCenterName) {
        AdoptionCenter.adoptionCenters.get(adoptionCenterName).add(new Cat(name, age, intellect, adoptionCenterName));
    }// registers cat

    public static void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        for (int i = 0; i < AdoptionCenter.adoptionCenters.get(adoptionCenterName).size(); i++) {
            if (!AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i).cleansingStatus) {
                CleansingCenter.cleansingCenters.get(cleansingCenterName).add(AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i));
            }
        }
        for (int i = 0; i < AdoptionCenter.adoptionCenters.get(adoptionCenterName).size(); i++) {
            if (!AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i).cleansingStatus) {
                AdoptionCenter.adoptionCenters.get(adoptionCenterName).remove(AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i));
                i--;
            }
        }
    }// sends all animals from given Adoption Center to given Cleansing Center

    public static void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        for (int i = 0; i < AdoptionCenter.adoptionCenters.get(adoptionCenterName).size(); i++) {
            if (!AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i).castrationStatus) {
                CastrationCenter.castrationCenters.get(castrationCenterName).add(AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i));
            }
        }
        for (int i = 0; i < AdoptionCenter.adoptionCenters.get(adoptionCenterName).size(); i++) {
            if (!AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i).castrationStatus) {
                AdoptionCenter.adoptionCenters.get(adoptionCenterName).remove(AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i));
                i--;
            }
        }
    }

    public static void cleanse(String cleansingCenterName) {
        for (int i = 0; i < CleansingCenter.cleansingCenters.get(cleansingCenterName).size(); i++) {
            CleansingCenter.cleansingCenters.get(cleansingCenterName).get(i).cleansingStatus = true;
        }
        for (int i = 0; i < CleansingCenter.cleansingCenters.get(cleansingCenterName).size(); i++) {
            if (CleansingCenter.cleansingCenters.get(cleansingCenterName).get(i).cleansingStatus) {
                AdoptionCenter.adoptionCenters.get(CleansingCenter.cleansingCenters.get(cleansingCenterName).get(i).adoptionCenterName).add(CleansingCenter.cleansingCenters.get(cleansingCenterName).get(i));
                CleansingCenter.cleansedAnimals.add(CleansingCenter.cleansingCenters.get(cleansingCenterName).get(i).name);
                CleansingCenter.cleansingCenters.get(cleansingCenterName).remove(CleansingCenter.cleansingCenters.get(cleansingCenterName).get(i));
                i--;
            }
        }
    }// cleanses all animals from given Cleansing Center and returns them to their Adoption Center

    public static void adopt(String adoptionCenterName) {
        for (int i = 0; i < AdoptionCenter.adoptionCenters.get(adoptionCenterName).size(); i++) {
            if (AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i).cleansingStatus) {
                AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i).adoptionStatus = true;
                AdoptionCenter.adoptedAnimals.add(AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i).name);
            }
        }
        for (int i = 0; i < AdoptionCenter.adoptionCenters.get(adoptionCenterName).size(); i++) {
            if (AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i).cleansingStatus) {
                AdoptionCenter.adoptionCenters.get(adoptionCenterName).remove(AdoptionCenter.adoptionCenters.get(adoptionCenterName).get(i));
                i--;
            }
        }

    }// adopts all animals and removes them from the Adoption Center

    public static void castrate(String castrationCenterName) {
        for (int i = 0; i < CastrationCenter.castrationCenters.get(castrationCenterName).size(); i++) {
            CastrationCenter.castrationCenters.get(castrationCenterName).get(i).castrationStatus = true;
        }
        for (int i = 0; i < CastrationCenter.castrationCenters.get(castrationCenterName).size(); i++) {
            AdoptionCenter.adoptionCenters.get(CastrationCenter.castrationCenters.get(castrationCenterName).get(i).adoptionCenterName).add(CastrationCenter.castrationCenters.get(castrationCenterName).get(i));
            CastrationCenter.castratedAnimals.add(CastrationCenter.castrationCenters.get(castrationCenterName).get(i).name);
            CastrationCenter.castrationCenters.get(castrationCenterName).remove(CastrationCenter.castrationCenters.get(castrationCenterName).get(i));
            i--;
        }
    }

    public static StringBuilder getCleansedAnimals() {
        List<String> orderedList = Centers.orderAnimals(CleansingCenter.cleansedAnimals);
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

    public static StringBuilder getAdoptedAnimals() {
        List<String> orderedList = Centers.orderAnimals(AdoptionCenter.adoptedAnimals);
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

    public static StringBuilder getCastratedAnimals() {
        List<String> orderedList = Centers.orderAnimals(CastrationCenter.castratedAnimals);
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

    public static int waitingForCleansing() {
        int forCleansing = 0;
        for (Map.Entry<String, List<Animal>> entry : CleansingCenter.cleansingCenters.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (!entry.getValue().get(i).cleansingStatus) {
                    forCleansing ++;
                }
            }
        }
        return forCleansing;
    }// returns number of animals waiting for cleansing

    public static int waitingForAdoption() {
        int forAdoption = 0;
        for (Map.Entry<String, List<Animal>> entry : AdoptionCenter.adoptionCenters.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (!entry.getValue().get(i).adoptionStatus && entry.getValue().get(i).cleansingStatus) {
                    forAdoption ++;
                }
            }
        }
        return forAdoption;
    }// returns all animals waiting for adoption

    public static void printStatistics() {
        System.out.println("Paw Incorporative Regular Statistics" + "\n" +
                "Adoption Centers: " + AdoptionCenter.adoptionCenters.size() + "\n" + //works
                "Cleansing Centers: " + CleansingCenter.cleansingCenters.size() + "\n" + //works
                "Adopted Animals: " + getAdoptedAnimals() + "\n" +
                "Cleansed Animals: " + getCleansedAnimals() + "\n" +
                "Animals Awaiting Adoption: " + waitingForAdoption() + "\n" + //works
                "Animals Awaitng Cleansing: " + waitingForCleansing()); //works
    }// prints statistics

    public static void castrationStatistics() {
        System.out.println("Paw Inc. Regular Castration Statistics" + "\n" +
                "Castration Centers: " + CastrationCenter.castrationCenters.size() + "\n" +
                "Castrated Animals: " + getCastratedAnimals());
    }
}

