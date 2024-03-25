package com.sise.lengavanzado.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sise.lengavanzado.entities.Mesa;
import jakarta.transaction.Transactional;

@Repository
public interface MesaRepository extends JpaRepository<Mesa,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Mesa m SET m.estadoAuditoria = '0' WHERE m.idMesa = :id")
    void darBajaMesa(@Param("id") Integer idMesa);
    List<Mesa> findByEstadoAuditoria(String estadoAuditoria);
    Mesa findOneByIdMesaAndEstadoAuditoria(Integer idMesa, String estadoAuditoria);
}
