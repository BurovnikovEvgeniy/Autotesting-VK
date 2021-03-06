package TestBots;

public class User {
    private String login;
    private String password;
    private String FirstAndLastName;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.FirstAndLastName = name;
    }
    private User() {
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
    public static class UserBuilder {
        private final User user = new User();

        public UserBuilder addLogin(String login) {
            this.user.login = login;
            return this;
        }
        public UserBuilder addPassword(String password) {
            this.user.password = password;
            return this;
        }

        public UserBuilder addFirstAndLastName(String firstAndLastName) {
            this.user.FirstAndLastName = firstAndLastName;
            return this;
        }

        public User build() {
            return this.user;
        }
    }
}
