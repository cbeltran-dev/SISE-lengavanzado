package com.sise.lengavanzado.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sise.lengavanzado.entities.Rol;
import com.sise.lengavanzado.entities.Usuario;

import jakarta.transaction.Transactional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.estadoAuditoria = '0' WHERE u.idUsuario = :id")
    void darBajaUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.correo = :correo, u.rol = :rol WHERE u.idUsuario = :id")
    void actualizarUsuario(@Param("id") Integer id, @Param("rol") Rol rol, @Param("correo") String correo);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.clave = :clave WHERE u.idUsuario = :id")
    void cambiarClaveUsuario(@Param("id") Integer id, @Param("clave") String clave);

    List<Usuario> findByEstadoAuditoria(String estadoAuditoria);
    Usuario findOneByIdUsuarioAndEstadoAuditoria(Integer idUsuario, String estadoAuditoria);
}
