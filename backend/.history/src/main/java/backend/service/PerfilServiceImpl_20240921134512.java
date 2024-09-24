package backend.service;

import backend.model.Perfil;
import backend.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;
    
    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }
    
    public Perfil cadastrar(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
    
    public Perfil atualizar(Long id, Perfil perfil) {
        perfil.setId(id);
        return perfilRepository.save(perfil);
    }
    
    public void deletar(Long id) {
        perfilRepository.deleteById(id);
    }
}
