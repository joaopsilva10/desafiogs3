package backend.controller;

import backend.model.Perfil;
import backend.model.Usuario;
import backend.service.PerfilService;
import backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/usuario/perfil")
    public ResponseEntity<Usuario> perfilUsuario(@PathVariable String authToken) {
        Usuario usuario = usuarioService.obterUsuarioAutenticado(authToken);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
    
    @GetMapping("/listarPerfis")
    public List<Perfil> listarPerfis() {
        return perfilService.listarTodos();
    }
    
    @PostMapping("/cadastrarPerfil")
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
