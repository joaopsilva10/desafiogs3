package backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import backend.model.LoginRequest;
import backend.model.Usuario;
import backend.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String login = loginRequest.getLogin();
        String senha = loginRequest.getSenha();
        String authToken = "";
        Usuario user = this.authService.login(login, senha);

        if(user != null){
            authToken = UUID.randomUUID().toString();
            this.authService.atualizarAuthToken(user.getId(), authToken);
        } 
        
        if (user != null && user.isAdmin()) {
            Map<String, String> response = new HashMap<>();
            response.put("authToken", authToken);
            response.put("isAdmin", "true");
            return ResponseEntity.ok(response);
        } else if(user != null && !user.isAdmin()) {
            Map<String, String> response = new HashMap<>();
            response.put("authToken", authToken);
            response.put("isAdmin", "false");
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.ok("Credenciais inválidas");
        }
    }

    @PutMapping("/logout/{id}")
    public ResponseEntity<String> logout(@PathVariable Long id) {
        /* essa função apenas limpa o  novoAuthToken para realizar o logout no sistema*/
        try {
            authService.logout(id);
            return ResponseEntity.ok("Logout realizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
