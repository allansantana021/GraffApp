package entity;

import jakarta.persistence.*;

@Entity
public class Grafite {
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "grafite_id")
    private int id;

    @Column(name = "grafite_titulo", columnDefinition = "TEXT")
    private String titulo;


}
