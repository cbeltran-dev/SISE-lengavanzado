package com.sise.lengavanzado.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sise.lengavanzado.entities.Sucursal;

import jakarta.transaction.Transactional;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Sucursal s SET s.estadoAuditoria = '0' WHERE s.idSucursal = :id")
    void darBajaSucursal(@Param("id") Integer id);
}
