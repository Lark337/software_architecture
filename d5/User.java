package d5;

public class User {
    private String name;
    private Long phoneNumber;

    public User(String name, Long phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

}
