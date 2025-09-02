package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setComentario(Integer comentario) {
        this.comentario = comentario;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setComentario_data_publicacao(Date comentario_data_publicacao) {
        this.comentario_data_publicacao = comentario_data_publicacao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @Column(name = "comentario_id")
    private Integer comentario;

    @Column(name = "comentario_texto")
    private String texto;

    @Column(name = "comentario_data_publicacao")
    private Date comentario_data_publicacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}

