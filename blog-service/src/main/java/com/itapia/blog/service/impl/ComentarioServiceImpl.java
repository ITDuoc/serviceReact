package com.itapia.blog.service.impl;

import com.itapia.blog.entity.Comentario;
import com.itapia.blog.entity.Noticia;
import com.itapia.blog.repository.ComentarioRepository;
import com.itapia.blog.repository.NoticiaRepository;
import com.itapia.blog.service.ComentarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final NoticiaRepository noticiaRepository;

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository, NoticiaRepository noticiaRepository) {
        this.comentarioRepository = comentarioRepository;
        this.noticiaRepository = noticiaRepository;
    }

    @Override
    public Comentario crear(Comentario c) {
        // Si solo viene el ID de la noticia, asociarlo
        if (c.getNoticia() != null && c.getNoticia().getId() != null) {
            Noticia noticia = noticiaRepository.findById(c.getNoticia().getId()).orElse(null);
            c.setNoticia(noticia);
        } else {
            c.setNoticia(null);
        }
        return comentarioRepository.save(c);
    }

    @Override
    public List<Comentario> listar() {
        return comentarioRepository.findAll();
    }

    @Override
    public List<Comentario> listarPorNoticia(Long idNoticia) {
        return comentarioRepository.findByNoticiaId(idNoticia);
    }

    @Override
    public Comentario obtener(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    @Override
    public Comentario actualizar(Long id, Comentario c) {
        return comentarioRepository.findById(id).map(existing -> {
            existing.setDetComentario(c.getDetComentario());
            existing.setFechaComentario(c.getFechaComentario());
            existing.setIdUsuario(c.getIdUsuario());

            if (c.getNoticia() != null && c.getNoticia().getId() != null) {
                Noticia noticia = noticiaRepository.findById(c.getNoticia().getId()).orElse(null);
                existing.setNoticia(noticia);
            }

            return comentarioRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        comentarioRepository.deleteById(id);
    }
}
