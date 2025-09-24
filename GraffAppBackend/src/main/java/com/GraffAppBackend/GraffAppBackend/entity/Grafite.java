package com.GraffAppBackend.GraffAppBackend.entity;

import jakarta.persistence.*;

@Entity
public class Grafite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grafite_id")
    private int id;

    @Column(name = "grafite_titulo", columnDefinition = "TEXT")
    private String titulo;

    // Construtor padrão (obrigatório para JPA)
    public Grafite() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
