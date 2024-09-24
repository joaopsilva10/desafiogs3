package backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import backend.model.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        
        if ("admin".equals(username) && "admin".equals(password)) {
            String authToken = UUID.randomUUID().toString();
            Map<String, String> response = new HashMap<>();
            response.put("authToken", authToken);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas.");
        }
    }
}
