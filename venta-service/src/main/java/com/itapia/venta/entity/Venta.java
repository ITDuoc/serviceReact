package com.itapia.venta.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_venta")
    private Date fechaVenta;

    @Column(name = "dir_envio")
    private String dirEnvio;

    @Column(name = "total_venta")
    private Double totalVenta;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_met_pago")
    private Long idMetodoPago;

    @Column(name = "id_est_venta")
    private Long idEstadoVenta;

    // Relación con detalles de venta
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DetalleVenta> detalles;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(Date fechaVenta) { this.fechaVenta = fechaVenta; }

    public String getDirEnvio() { return dirEnvio; }
    public void setDirEnvio(String dirEnvio) { this.dirEnvio = dirEnvio; }

    public Double getTotalVenta() { return totalVenta; }
    public void setTotalVenta(Double totalVenta) { this.totalVenta = totalVenta; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdMetodoPago() { return idMetodoPago; }
    public void setIdMetodoPago(Long idMetodoPago) { this.idMetodoPago = idMetodoPago; }

    public Long getIdEstadoVenta() { return idEstadoVenta; }
    public void setIdEstadoVenta(Long idEstadoVenta) { this.idEstadoVenta = idEstadoVenta; }

    public List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }
}
