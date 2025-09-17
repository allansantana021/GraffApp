package dto.response;

import java.util.Date;

public class UsuarioDTOResponse
{

    private int id;
    private String email;
    private String fotoPerfil;
    private String bio;
    private Date dataCriacao;

    public UsuarioDTOResponse() {}

    public UsuarioDTOResponse(int id, String email, String fotoPerfil, String bio, Date dataCriacao) {
        this.id = id;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
        this.bio = bio;
        this.dataCriacao = dataCriacao;
    }

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