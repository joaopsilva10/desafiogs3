package backend.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String authToken;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    public boolean isAdmin() {
        return perfil != null && perfil.getId() == 1;
    }
}
