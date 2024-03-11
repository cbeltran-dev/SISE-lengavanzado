package com.sise.lengavanzado.services;
import java.util.List;
import com.sise.lengavanzado.entities.Sucursal;

public interface SucursalService {
    List<Sucursal> listarSucursal();
    Sucursal listarSucursalPorId(Integer id);
    Sucursal insertarSucursal(Sucursal sucursal);
    Sucursal actualizarSucursal(Sucursal sucursal);
    void darBajaSucursal(Integer id);
    
}
