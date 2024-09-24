package backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.exception.AuthenticationException;
import backend.model.Usuario;
import backend.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String login, String senha) {
        Usuario usuario = usuarioRepository.findByLogin(login); 
        if (usuario != null && senha.equals(usuario.getSenha())) {
            return usuario;
        } else {
            throw new AuthenticationException("Credenciais inválidas");
        }
    }
}
