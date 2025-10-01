package com.GraffAppBackend.GraffAppBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Curtida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curtida_id")
    private Integer curtida;

    @Column(name = "curtida_data")
    private Date data;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "grafite_id", nullable = false)
    private Grafite grafite;

    // Construtor padrão
    public Curtida() {}

    // Getters e Setters
    public Integer getCurtida() {
        return curtida;
    }

    public void setCurtida(Integer curtida) {
        this.curtida = curtida;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Grafite getGrafite() {
        return grafite;
    }

    public void setGrafite(Grafite grafite) {
        this.grafite = grafite;
    }
}