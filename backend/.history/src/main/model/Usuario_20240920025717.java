package com.backend.model;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    // Getters e Setters
}
