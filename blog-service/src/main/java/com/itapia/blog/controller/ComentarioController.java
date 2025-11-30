package com.itapia.blog.controller;

import com.itapia.blog.entity.Comentario;
import com.itapia.blog.service.ComentarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) { this.service = service; }

    @PostMapping
    public Comentario crear(@RequestBody Comentario c) { return service.crear(c); }

    @GetMapping
    public List<Comentario> listar() { return service.listar(); }

    @GetMapping("/noticia/{idNoticia}")
    public List<Comentario> listarPorNoticia(@PathVariable Long idNoticia) {
        return service.listarPorNoticia(idNoticia);
    }

    @GetMapping("/{id}")
    public Comentario obtener(@PathVariable Long id) { return service.obtener(id); }

    @PutMapping("/{id}")
    public Comentario actualizar(@PathVariable Long id, @RequestBody Comentario c) {
        return service.actualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
