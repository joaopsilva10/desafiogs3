package backend.model;

public class LoginRequest {
    private String login;
    private String senha;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.login = username;
        this.senha = password;
    }

    public String getNomeusuario() {
        return login;
    }

    public void setNomeusuario(String username) {
        this.login = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String password) {
        this.senha = password;
    }
}