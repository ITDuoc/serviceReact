package com.itapia.producto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Long idMarca;

    @Column(name = "nom_marca")
    private String nomMarca;

    @Column(name = "estado_marca")
    private Integer estadoMarca;

    // GETTERS Y SETTERS
    public Long getIdMarca() { return idMarca; }
    public void setIdMarca(Long idMarca) { this.idMarca = idMarca; }

    public String getNomMarca() { return nomMarca; }
    public void setNomMarca(String nomMarca) { this.nomMarca = nomMarca; }

    public Integer getEstadoMarca() { return estadoMarca; }
    public void setEstadoMarca(Integer estadoMarca) { this.estadoMarca = estadoMarca; }
}
