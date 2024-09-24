package backend.model;

import java.util.Set;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;    

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
    private Set<Usuario> usuarios;

}
