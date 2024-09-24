package backend.service;

import backend.model.Usuario;
import backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

     @Override
    public Usuario obterUsuarioAutenticado() {
        // Pega o principal (usuário autenticado) do contexto de segurança
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Verifica se o usuário autenticado é do tipo UserDetails (padrão do Spring Security)
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername(); // Nome do usuário autenticado
            return usuarioRepository.findByNomeUsuario(username); // Busca o usuário no banco
        } else {
            return null; // Caso não tenha um usuário autenticado
        }
    }
}
