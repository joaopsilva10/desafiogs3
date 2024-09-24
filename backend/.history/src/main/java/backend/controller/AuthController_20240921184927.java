package backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
        String login = loginRequest.getNomeusuario();
        String senha = loginRequest.getSenha();
        
        Usuario user = this.authService.login(login, senha);


        if (user.isAdmin()) {
            String authToken = UUID.randomUUID().toString();
            Map<String, String> response = new HashMap<>();
            response.put("authToken", authToken);
            response.put("isAdmin", "true");
            return ResponseEntity.ok(response);
        } else {
            String authToken = UUID.randomUUID().toString();
            Map<String, String> response = new HashMap<>();
            response.put("authToken", authToken);
            response.put("isAdmin", "false");
            return ResponseEntity.ok(response);
        }
    }
}
