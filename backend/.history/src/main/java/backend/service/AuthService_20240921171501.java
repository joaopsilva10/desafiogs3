package backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import backend.model.Usuario;
import backend.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario login(String username, String password) {
        Usuario usuario = usuarioRepository.findByNome(username);
        
        if (usuario != null && passwordEncoder.matches(password, usuario.getSenha())) {
            return usuario;
        } else {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}
