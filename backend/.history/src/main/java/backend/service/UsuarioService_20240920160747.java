package backend.service;

import backend.model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listarTodos();
    Usuario cadastrar(Usuario usuario);
    Usuario atualizar(Long id, Usuario usuario);
    void deletar(Long id);
}
