package backend.service;

import backend.model.Usuario;
import backend.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    
    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setLogin(usuarioAtualizado.getLogin());
            usuario.setSenha(usuarioAtualizado.getSenha());
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
    
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    
    public Usuario obterUsuarioAutenticado() {
        return usuarioRepository.findByLogin("admin"); 
    }
}
