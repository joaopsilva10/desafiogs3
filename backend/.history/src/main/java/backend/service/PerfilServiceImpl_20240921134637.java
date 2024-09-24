package backend.service;

import backend.model.Perfil;
import backend.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {
    
    private PerfilRepository perfilRepository;

    @Override
    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil cadastrar(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil atualizar(Long id, Perfil perfil) {
        perfil.setId(id);
        return perfilRepository.save(perfil);
    }

    @Override
    public void deletar(Long id) {
        perfilRepository.deleteById(id);
    }
}
