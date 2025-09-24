package com.GraffAppBackend.GraffAppBackend.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int id;

    @Column(name = "usuario_email")
    private String email;

    @Column(name = "usuario_senha")
    private String senha;

    @Column(name = "usuario_foto_perfil")
    private String fotoPerfil;

    @Column(name= "usuario_bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "usuario_data_criacao")
    private Date dataCriacao;

    // Construtor padrão
    public Usuario() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}