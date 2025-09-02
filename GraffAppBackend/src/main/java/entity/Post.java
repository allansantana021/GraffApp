package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Post {
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTopico(Integer topico) {
        this.topico = topico;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public void setCurtida(Curtida curtida) {
        this.curtida = curtida;
    }

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


}
