package com.itapia.producto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "nom_categoria")
    private String nomCategoria;

    @Column(name = "desc_categoria")
    private String descCategoria;

    @Column(name = "img_categoria")
    private String imgCategoria;

    @Column(name = "estado_categoria")
    private Integer estadoCategoria;

    // GETTERS Y SETTERS
    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }

    public String getNomCategoria() { return nomCategoria; }
    public void setNomCategoria(String nomCategoria) { this.nomCategoria = nomCategoria; }

    public String getDescCategoria() { return descCategoria; }
    public void setDescCategoria(String descCategoria) { this.descCategoria = descCategoria; }

    public String getImgCategoria() { return imgCategoria; }
    public void setImgCategoria(String imgCategoria) { this.imgCategoria = imgCategoria; }

    public Integer getEstadoCategoria() { return estadoCategoria; }
    public void setEstadoCategoria(Integer estadoCategoria) { this.estadoCategoria = estadoCategoria; }
}
