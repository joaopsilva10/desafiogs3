package backend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginRequest {
    private String login;
    private String senha;
    
    public LoginRequest() {}

    public LoginRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
}