public class Dog extends Animal{

    private int commands;

    public Dog(String name, int age, int commands, String adoptionCenterName){
        super(name, age, adoptionCenterName);
        this.commands = commands;
    }

    public int getCommands() {
        return commands;
    }

    public void setCommands(int commands) {
        this.commands = commands;
    }
}
