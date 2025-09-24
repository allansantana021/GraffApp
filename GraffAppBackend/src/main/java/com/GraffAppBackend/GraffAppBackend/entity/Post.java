package com.GraffAppBackend.GraffAppBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(name = "post_texto")
    private String texto;

    @Column(name = "post_data")
    private Date data;

    @Column(name = "post_topico")
    private Integer topico;

    @Column(name = "post_status")
    private Integer status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "comentario_id", nullable = false)
    private Comentario comentario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curtida_id", nullable = false)
    private Curtida curtida;

    // Construtor padrão
    public Post() {}

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getTopico() {
        return topico;
    }

    public void setTopico(Integer topico) {
        this.topico = topico;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Curtida getCurtida() {
        return curtida;
    }

    public void setCurtida(Curtida curtida) {
        this.curtida = curtida;
    }
}