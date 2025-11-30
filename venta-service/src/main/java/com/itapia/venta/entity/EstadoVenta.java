package com.itapia.venta.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_venta")
public class EstadoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_est_venta")
    private Long id;

    @Column(name = "nom_est_venta")
    private String nombre;

    @Column(name = "desc_est_venta")
    private String descripcion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
