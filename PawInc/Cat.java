public class Cat extends Animal {

    private int intellect;
    private String adoptionCenterName;

    public Cat(String name, int age, int intellect, String adoptionCenterName) {
        super(name, age, adoptionCenterName);
        this.intellect = intellect;
        this.adoptionCenterName = adoptionCenterName;
    }
}
