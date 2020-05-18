public class Contact {
    private String mobileNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String email;
    private String dob;

    public Contact() {

    }

    public Contact(String mobileNumber, String group, String name, String gender, String address) {
        this.mobileNumber = mobileNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "mobileNumber= " + mobileNumber +
                ", group= '" + group + '\'' +
                ", name= '" + name + '\'' +
                ", gender= '" + gender + '\'' +
                ", address= '" + address + '\'' +
                ", email= '" + email + '\'' +
                ", dob= '" + dob + '\'' +
                '}';
    }
}
