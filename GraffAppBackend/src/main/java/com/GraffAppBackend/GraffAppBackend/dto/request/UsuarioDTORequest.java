package com.GraffAppBackend.GraffAppBackend.dto.request;

import java.util.Date;

public class UsuarioDTORequest {

    private String email;
    private String senha;
    private String fotoPerfil;
    private String bio;
    private Date dataCriacao;


    public UsuarioDTORequest() {}


    public UsuarioDTORequest(String email, String senha, String fotoPerfil, String bio, Date dataCriacao) {
        this.email = email;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
        this.bio = bio;
        this.dataCriacao = dataCriacao;
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