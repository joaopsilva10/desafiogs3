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
    private UsuarioService usuarioService; // Injetar o UsuarioService

    // Endpoint para obter o perfil do usuário autenticado
    @GetMapping("/usuario/perfil")
    public ResponseEntity<Usuario> perfilUsuario() {
        Usuario usuario = usuarioService.obterUsuarioAutenticado();
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(404).body(null); // Caso o usuário não esteja autenticado
        }
    }

    // Listar todos os perfis
    @GetMapping
    public List<Perfil> listarPerfis() {
        return perfilService.listarTodos();
    }

    // Cadastrar um novo perfil
    @PostMapping
    public ResponseEntity<Perfil> cadastrarPerfil(@RequestBody Perfil perfil) {
        return ResponseEntity.ok(perfilService.cadastrar(perfil));
    }

    // Atualizar um perfil existente
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> atualizarPerfil(@PathVariable Long id, @RequestBody Perfil perfil) {
        return ResponseEntity.ok(perfilService.atualizar(id, perfil));
    }

    // Deletar um perfil por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPerfil(@PathVariable Long id) {
        perfilService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
