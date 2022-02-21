public class Dog extends Animal{

    private int commands;
    private String adoptionCenterName;

    public Dog(String name, int age, int commands, String adoptionCenterName){
        super(name, age, adoptionCenterName);
        this.commands = commands;
        this.adoptionCenterName = adoptionCenterName;


    }

}
