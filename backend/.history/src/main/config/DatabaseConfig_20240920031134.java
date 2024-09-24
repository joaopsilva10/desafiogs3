package backend.config;

import backend.model.Perfil;
import backend.model.Usuario;
import backend.repository.PerfilRepository;
import backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            Perfil adminPerfil = new Perfil();
            adminPerfil.setDescricao("Administrador");
            perfilRepository.save(adminPerfil);

            Usuario admin = new Usuario();
            admin.setNome("admin");
            admin.setSenha("admin");
            admin.setPerfil(adminPerfil);
            usuarioRepository.save(admin);
        };
    }
}
