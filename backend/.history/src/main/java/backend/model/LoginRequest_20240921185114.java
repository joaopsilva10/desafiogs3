package backend.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String login;
    private String senha;
    
    public LoginRequest() {}

    public LoginRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getNomeusuario() {
        return login;
    }

    public void setNomeusuario(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String password) {
        this.senha = password;
    }
}