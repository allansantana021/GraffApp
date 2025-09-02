package entity;

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

    public void setCurtida(Integer curtida) {
        this.curtida = curtida;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setGrafite(Grafite grafite) {
        this.grafite = grafite;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "grafite_id", nullable = false)
    private Grafite grafite;

}
