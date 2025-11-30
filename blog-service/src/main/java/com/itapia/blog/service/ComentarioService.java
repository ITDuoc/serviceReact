package com.itapia.blog.service;

import com.itapia.blog.entity.Comentario;

import java.util.List;

public interface ComentarioService {

    Comentario crear(Comentario c);

    List<Comentario> listar();

    List<Comentario> listarPorNoticia(Long idNoticia);

    Comentario obtener(Long id);

    Comentario actualizar(Long id, Comentario c);

    void eliminar(Long id);
}
