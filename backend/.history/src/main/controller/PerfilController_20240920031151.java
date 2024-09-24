package backend.controller;

import backend.model.Perfil;
import backend.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> listarPerfis() {
        return perfilService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Perfil> cadastrarPerfil(@RequestBody Perfil perfil) {
        return ResponseEntity.ok(perfilService.cadastrar(perfil));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> atualizarPerfil(@PathVariable Long id, @RequestBody Perfil perfil) {
        return ResponseEntity.ok(perfilService.atualizar(id, perfil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfil(@PathVariable Long id) {
        perfilService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
