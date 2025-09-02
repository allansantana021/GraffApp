package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Grafite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "grafite_id")
    private int id;

    @Column(name = "grafite_titulo", columnDefinition = "TEXT")
    private String titulo;


}
