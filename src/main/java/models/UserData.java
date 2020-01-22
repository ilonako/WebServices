package models;

public class UserData {

    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public UserData(String email, String first_name,  String last_name, String avatar) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }
}
