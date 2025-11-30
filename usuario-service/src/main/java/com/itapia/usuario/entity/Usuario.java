package com.itapia.usuario.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nom_usuario")
    private String nomUsuario;

    @Column(name = "ape_usuario")
    private String apeUsuario;

    @Column(name = "correo_usuario", unique = true)
    private String correoUsuario;

    @Column(name = "pass_usuario")
    private String passUsuario;

    @Column(name = "fecha_nac_usuario")
    @Temporal(TemporalType.DATE)
    private Date fechaNacUsuario;

    @Column(name = "estado_usuario")
    private Integer estadoUsuario;

    @Column(name = "img_usuario")
    private String imgUsuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<Rol> roles = new HashSet<>();

    // getters y setters
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getNomUsuario() { return nomUsuario; }
    public void setNomUsuario(String nomUsuario) { this.nomUsuario = nomUsuario; }

    public String getApeUsuario() { return apeUsuario; }
    public void setApeUsuario(String apeUsuario) { this.apeUsuario = apeUsuario; }

    public String getCorreoUsuario() { return correoUsuario; }
    public void setCorreoUsuario(String correoUsuario) { this.correoUsuario = correoUsuario; }

    public String getPassUsuario() { return passUsuario; }
    public void setPassUsuario(String passUsuario) { this.passUsuario = passUsuario; }

    public Date getFechaNacUsuario() { return fechaNacUsuario; }
    public void setFechaNacUsuario(Date fechaNacUsuario) { this.fechaNacUsuario = fechaNacUsuario; }

    public Integer getEstadoUsuario() { return estadoUsuario; }
    public void setEstadoUsuario(Integer estadoUsuario) { this.estadoUsuario = estadoUsuario; }

    public String getImgUsuario() { return imgUsuario; }
    public void setImgUsuario(String imgUsuario) { this.imgUsuario = imgUsuario; }

    public Set<Rol> getRoles() { return roles; }
    public void setRoles(Set<Rol> roles) { this.roles = roles; }
}
