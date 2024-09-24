package backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import backend.exception.AuthenticationException;
import backend.model.Usuario;
import backend.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario login(String login, String senha) {
        Usuario usuario = usuarioRepository.findByNome(login); 
        if (usuario != null && passwordEncoder.matches(senha, usuario.getSenha())) {
            return usuario;
        } else {
            throw new AuthenticationException("Credenciais inválidas");
        }
    }
}
