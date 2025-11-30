package com.itapia.zona.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudades")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_ciudad")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Region getRegion() { return region; }
    public void setRegion(Region region) { this.region = region; }
}
