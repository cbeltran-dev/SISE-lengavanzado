package com.sise.lengavanzado.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.lengavanzado.entities.Usuario;
import com.sise.lengavanzado.repositories.UsuarioRepository;
import com.sise.lengavanzado.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findByEstadoAuditoria("1");
    }

    @Override
    public Usuario listarUsuarioPorId(Integer id) {
        return usuarioRepository.findOneByIdUsuarioAndEstadoAuditoria(id, "1");
    }

    @Override
    public Usuario insertarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(usuario.getIdUsuario(), usuario.getRol(), usuario.getCorreo()); 
        return usuarioRepository.findOneByIdUsuarioAndEstadoAuditoria(usuario.getIdUsuario(), "1");
    }

    @Override
    public void darBajaUsuario(Integer id) {
        usuarioRepository.darBajaUsuario(id);
    }

    @Override
    public void cambiarClaveUsuario(Usuario usuario) {
        usuarioRepository.cambiarClaveUsuario(usuario.getIdUsuario(), usuario.getClave());
    }
    
}
