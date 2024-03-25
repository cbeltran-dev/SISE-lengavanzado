package com.sise.lengavanzado.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sise.lengavanzado.entities.Rol;


import jakarta.transaction.Transactional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Rol r SET r.estadoAuditoria = '0' WHERE r.idRol = :id")
    void darBajaRol(@Param("id") Integer id);

    List<Rol> findByEstadoAuditoria(String estadoAuditoria);
    Rol findOneByIdRolAndEstadoAuditoria(Integer idRol, String estadoAuditoria);


}
