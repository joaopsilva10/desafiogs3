package backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import backend.model.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    /*@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        
        if ("admin".equals(username) && "admin".equals(password)) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas.");
        }
    }*/

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            // Criar um token de autenticação a partir das credenciais
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            // Se a autenticação for bem-sucedida, o contexto de segurança é atualizado
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Retornar uma mensagem de sucesso (ou token JWT em sistemas mais complexos)
            return ResponseEntity.ok("Login realizado com sucesso!");

        } catch (Exception e) {
            // Retornar erro se a autenticação falhar
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
        }
    }
}
