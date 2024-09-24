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

    // Listar todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Cadastrar um novo usuário
    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Atualizar um usuário existente
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            // Atualiza os campos necessários
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setLogin(usuarioAtualizado.getLogin());
            usuario.setSenha(usuarioAtualizado.getSenha());
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    // Deletar um usuário pelo ID
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Obter o usuário autenticado
    public Usuario obterUsuarioAutenticado() {
        // Aqui você deve implementar a lógica para obter o usuário autenticado,
        // normalmente através do Spring Security. Por enquanto, um exemplo simples:
        return usuarioRepository.findByLogin("admin"); // Exemplo, deve ser substituído por autenticação real
    }
}
