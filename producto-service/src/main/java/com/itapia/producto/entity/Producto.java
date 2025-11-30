package com.itapia.producto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nom_producto")
    private String nomProducto;

    @Column(name = "precio_producto")
    private Double precioProducto;

    @Column(name = "stock_producto")
    private Integer stockProducto;

    @Column(name = "estado_producto")
    private Integer estadoProducto;

    @Column(name = "img_producto")
    private String imgProducto;

    // RELACIONES
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    // GETTERS Y SETTERS

    public Long getIdProducto() { return idProducto; }
    public void setIdProducto(Long idProducto) { this.idProducto = idProducto; }

    public String getNomProducto() { return nomProducto; }
    public void setNomProducto(String nomProducto) { this.nomProducto = nomProducto; }

    public Double getPrecioProducto() { return precioProducto; }
    public void setPrecioProducto(Double precioProducto) { this.precioProducto = precioProducto; }

    public Integer getStockProducto() { return stockProducto; }
    public void setStockProducto(Integer stockProducto) { this.stockProducto = stockProducto; }

    public Integer getEstadoProducto() { return estadoProducto; }
    public void setEstadoProducto(Integer estadoProducto) { this.estadoProducto = estadoProducto; }

    public String getImgProducto() { return imgProducto; }
    public void setImgProducto(String imgProducto) { this.imgProducto = imgProducto; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }
}
