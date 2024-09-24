package backend.model;

import javax.persistence.*;

@Entity
@Getters
@Setters
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome = "admin";
    private String senha = "admin";

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
}
