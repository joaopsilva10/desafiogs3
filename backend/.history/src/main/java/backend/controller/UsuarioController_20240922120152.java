package backend.controller;

import backend.model.Usuario;
import backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        
        List<Usuario> usuariosSemAdmin = usuarios.stream()
            .filter(usuario -> !usuario.isAdmin() && !usuario.getAuthToken().equals("")) 
            .collect(Collectors.toList());

        return usuariosSemAdmin;
    }

    @PostMapping("/cadastrarUsuario")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.cadastrar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.atualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuarioAutenticado/{authToken}")
    public ResponseEntity<String> obterUsuarioAutenticado(@PathVariable String authToken) {
        return authToken;
        //Usuario usuario = usuarioService.obterUsuarioAutenticado(authToken);

        //return ResponseEntity.ok(usuario);
    }        
}
