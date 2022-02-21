public class Animal {
    int age;
    String name;
    String adoptionCenterName;
    boolean cleansingStatus = false;
    boolean adoptionStatus = false;
    boolean castrationStatus = false;

    public Animal(String name, int age, String adoptionCenterName) {
        this.age = age;
        this.name = name;
        this.adoptionCenterName = adoptionCenterName;
    }
}
