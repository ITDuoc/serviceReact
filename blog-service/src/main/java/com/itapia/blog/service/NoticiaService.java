package com.itapia.blog.service;

import com.itapia.blog.entity.Noticia;
import java.util.List;

public interface NoticiaService {
    Noticia crear(Noticia n);
    List<Noticia> listar();
    Noticia obtener(Long id);
    Noticia actualizar(Long id, Noticia n);
    void eliminar(Long id);
}
