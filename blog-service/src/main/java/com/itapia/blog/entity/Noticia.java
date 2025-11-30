package com.itapia.blog.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "noticia")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private Long id;

    @Column(name = "nom_noticia")
    private String nomNoticia;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_noticia")
    private Date fechaNoticia;

    @Column(name = "img_noticia")
    private String imgNoticia;

    @Column(name = "det_noticia", columnDefinition = "TEXT")
    private String detNoticia;

    @OneToMany(mappedBy = "noticia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comentario> comentarios;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomNoticia() { return nomNoticia; }
    public void setNomNoticia(String nomNoticia) { this.nomNoticia = nomNoticia; }

    public Date getFechaNoticia() { return fechaNoticia; }
    public void setFechaNoticia(Date fechaNoticia) { this.fechaNoticia = fechaNoticia; }

    public String getImgNoticia() { return imgNoticia; }
    public void setImgNoticia(String imgNoticia) { this.imgNoticia = imgNoticia; }

    public String getDetNoticia() { return detNoticia; }
    public void setDetNoticia(String detNoticia) { this.detNoticia = detNoticia; }

    public List<Comentario> getComentarios() { return comentarios; }
    public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }
}
