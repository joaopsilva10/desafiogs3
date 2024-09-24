package backend.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getters
@setters
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
}
