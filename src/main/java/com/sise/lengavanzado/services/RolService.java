package com.sise.lengavanzado.services;
import java.util.List;
import com.sise.lengavanzado.entities.Rol;

public interface RolService {
    
    List<Rol> listarRol();
    Rol listarRolPorId(Integer idRol);
    Rol insertarRol(Rol rol);
    Rol actualizarRol(Rol rol);
    void darBajaRol(Integer idRol);

}
