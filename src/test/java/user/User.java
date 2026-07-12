package user;

public class User {
    private String name;
    private String paassword;

    public User(String name, String paassword) {
        this.name = name;
        this.paassword = paassword;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return paassword;
    }
}
