package backend.model;

public class LoginRequest {
    private String login;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.login = username;
        this.password = password;
    }

    public String getNomeusuario() {
        return login;
    }

    public void setNomeusuario(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}