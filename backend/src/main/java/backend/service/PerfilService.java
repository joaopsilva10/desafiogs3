package backend.service;

import backend.model.Perfil;
import backend.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;
    
    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }
    
    public Perfil cadastrar(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
    
    public Perfil atualizar(Long id, Perfil perfilAtualizado) {
        Optional<Perfil> perfilOptional = perfilRepository.findById(id);
        if (perfilOptional.isPresent()) {
            Perfil perfil = perfilOptional.get();
            perfil.setNome(perfilAtualizado.getNome());
            return perfilRepository.save(perfil);
        } else {
            throw new RuntimeException("Perfil não encontrado");
        }
    }
    
    public void deletar(Long id) {
        perfilRepository.deleteById(id);
    }
}
