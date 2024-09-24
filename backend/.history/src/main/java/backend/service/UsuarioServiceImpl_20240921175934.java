package backend.service;

import backend.model.Usuario;
import backend.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha())); // Criptografa a senha
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNome(usuario.getNome());
            if (usuario.getSenha() != null) {
                usuarioExistente.setSenha(passwordEncoder.encode(usuario.getSenha())); // Atualiza a senha se fornecida
            }
            return usuarioRepository.save(usuarioExistente);
        }
        return null; // Ou lance uma exceção apropriada
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario obterUsuarioAutenticado() {
        // Aqui você deve implementar a lógica para obter o usuário autenticado
        // Isso pode variar dependendo da sua implementação de segurança
        return null; // Implementação futura
    }
}
