public class Cat extends Animal {

    private int intellect;

    public Cat(String name, int age, int intellect, String adoptionCenterName) {
        super(name, age, adoptionCenterName);
        this.intellect = intellect;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }
}
