package backend.service;

import backend.model.Usuario;
import backend.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNome(nome);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + nome);
        }
        return Usuario.withUsername(usuario.getNome())
                   .password(usuario.getSenha())
                   .authorities(Collections.emptyList())
                   .build();
    }
}
