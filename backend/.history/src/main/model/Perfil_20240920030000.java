package com.backend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getters
@Setters
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @OneToMany(mappedBy = "perfil")
    private Set<Usuario> usuarios;

    // Getters e Setters
}
