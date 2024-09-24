package backend.service;

import backend.model.Perfil;

import java.util.List;

public interface PerfilService {
    List<Perfil> listarTodos();
    Perfil cadastrar(Perfil perfil);
    Perfil atualizar(Long id, Perfil perfil);
    void deletar(Long id);
}
