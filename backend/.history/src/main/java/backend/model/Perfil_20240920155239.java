package backend.model;

import javax.persistence.*;
import java.util.Set;

@Getters
@Setters
@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @OneToMany(mappedBy = "perfil")
    private Set<Usuario> usuarios;
    
}
