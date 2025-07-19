package CarRentalSystem.Entitiy;

public class Client {
    private String id;
    private String name;
    private String licenceId;
    private LicenceCategory licenceCategory;
    private char gender;
    private String phoneNumber;

    public Client(){}

    public Client(String id, String name, String licenceId, LicenceCategory licenceCategory, char gender, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.licenceId = licenceId;
        this.licenceCategory = licenceCategory;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }

    public LicenceCategory getLicenceCategory() {
        return licenceCategory;
    }

    public void setLicenceCategory(LicenceCategory licenceCategory) {
        this.licenceCategory = licenceCategory;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
