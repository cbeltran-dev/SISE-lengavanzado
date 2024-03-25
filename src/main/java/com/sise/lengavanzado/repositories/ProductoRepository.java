package com.sise.lengavanzado.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sise.lengavanzado.entities.Producto;


import jakarta.transaction.Transactional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Producto p SET p.estadoAuditoria = '0' WHERE p.idProducto = :id")
    void darBajaProducto(@Param("id") Integer id);
    List<Producto> findByEstadoAuditoria(String estadoAuditoria);
    Producto findOneByIdProductoAndEstadoAuditoria(Integer idProducto, String estadoAuditoria);
    
}