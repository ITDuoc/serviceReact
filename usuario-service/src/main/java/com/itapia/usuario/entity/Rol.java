package com.itapia.usuario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "nom_rol")
    private String nomRol;

    // getters y setters
    public Long getIdRol() { return idRol; }
    public void setIdRol(Long idRol) { this.idRol = idRol; }

    public String getNomRol() { return nomRol; }
    public void setNomRol(String nomRol) { this.nomRol = nomRol; }
}
