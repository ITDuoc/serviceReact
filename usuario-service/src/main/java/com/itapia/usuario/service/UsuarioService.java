package com.itapia.usuario.service;

import com.itapia.usuario.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Long id);
    List<Usuario> listarUsuarios();
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);

    Usuario buscarPorCorreo(String correo);
}
