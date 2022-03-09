public class Animal {
    private int age;
    private String name;
    private String adoptionCenterName;
    private boolean cleansingStatus = false;
    private boolean adoptionStatus = false;
    private boolean castrationStatus = false;

    public Animal(String name, int age, String adoptionCenterName) {
        this.age = age;
        this.name = name;
        this.adoptionCenterName = adoptionCenterName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdoptionCenterName() {
        return adoptionCenterName;
    }

    public void setAdoptionCenterName(String adoptionCenterName) {
        this.adoptionCenterName = adoptionCenterName;
    }

    public boolean getCleansingStatus() {
        return cleansingStatus;
    }

    public void setCleansingStatus(boolean cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }

    public boolean getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(boolean adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public boolean getCastrationStatus() {
        return castrationStatus;
    }

    public void setCastrationStatus(boolean castrationStatus) {
        this.castrationStatus = castrationStatus;
    }
}
