package com.sise.lengavanzado.services;

import java.util.List;



import com.sise.lengavanzado.entities.Usuario;


public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Usuario listarUsuarioPorId(Integer id);
    Usuario insertarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Usuario usuario);
    void darBajaUsuario(Integer id);
    void cambiarClaveUsuario(Usuario usuario);
}
