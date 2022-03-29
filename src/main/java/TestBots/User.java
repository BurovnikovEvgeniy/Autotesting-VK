package TestBots;

public class User {
    private final String login;
    private final String password;
    private final String FirstAndLastName;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.FirstAndLastName = name;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstAndLastName() {
        return FirstAndLastName;
    }

    public String getPassword() {
        return password;
    }
}
