package com.itapia.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_comentario")
    private Date fechaComentario;

    @Column(name = "det_comentario", columnDefinition = "TEXT")
    private String detComentario;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_noticia")
    @JsonBackReference
    private Noticia noticia;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getFechaComentario() { return fechaComentario; }
    public void setFechaComentario(Date fechaComentario) { this.fechaComentario = fechaComentario; }

    public String getDetComentario() { return detComentario; }
    public void setDetComentario(String detComentario) { this.detComentario = detComentario; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Noticia getNoticia() { return noticia; }
    public void setNoticia(Noticia noticia) { this.noticia = noticia; }
}
