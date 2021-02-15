class User {
    protected String Username;
    protected String Password;

    User() {

    }

    static int counter = 0;

    User(String n, String j) {
        Password = j;
        Username = n;
        counter++;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return Username;
    }
}
