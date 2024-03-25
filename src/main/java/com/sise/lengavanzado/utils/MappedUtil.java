package com.sise.lengavanzado.utils;

import com.sise.lengavanzado.entities.Mesa;
import com.sise.lengavanzado.entities.Producto;
import com.sise.lengavanzado.entities.Rol;
import com.sise.lengavanzado.entities.Sucursal;
import com.sise.lengavanzado.pyload.requests.MesaRequest;
import com.sise.lengavanzado.pyload.requests.ProductoRequest;
import com.sise.lengavanzado.pyload.requests.RolRequestInsert;
import com.sise.lengavanzado.pyload.requests.SucursalRequestInsert;
//import com.sise.lengavanzado.pyload.responses.SucursalResponse;

public class MappedUtil {

    public static Sucursal toSucursalEntity(SucursalRequestInsert sucursalRequest){
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalRequest.getNombre());
        sucursal.setDireccion(sucursalRequest.getDireccion());
        sucursal.setTelefono(sucursalRequest.getTelefono());
        sucursal.setDescripcion(sucursalRequest.getDescripcion());
        sucursal.setImagenUrl(sucursalRequest.getImagenUrl());
        return sucursal;
    }

    public static Rol toRolEntity(RolRequestInsert rolRequest){
        Rol rol = new Rol();
        rol.setNombre(rolRequest.getNombre());
        rol.setDescripcion(rolRequest.getDescripcion());
        return rol;
    }

    public static Producto toProductoEntity (ProductoRequest productoRequest){
        Producto producto = new Producto();
        producto.setNombre(productoRequest.getNombre());
        producto.setPrecioUnitario(productoRequest.getPrecioUnitario());
        return producto;
    }

    public static Mesa toMesaEntity (MesaRequest mesaRequest){
        Mesa mesa = new Mesa();
        mesa.setDescripcion(mesaRequest.getDescripcion());
        mesa.setCapacidad(mesaRequest.getCapacidad());
        return mesa;
    }

    
    /*public static SucursalResponse toSucursalResponse (Sucursal sucursal){
        SucursalResponse response = new SucursalResponse();
        response.setIdSucursal(sucursal.getIdSucursal());
        response.setNombre(sucursal.getNombre());
        response.setDireccion(sucursal.getDireccion());
        response.setTelefono(sucursal.getTelefono());
        response.setDescripcion(sucursal.getDescripcion());
        response.setImagenUrl(sucursal.getImagenUrl());
        return response;
    }*/
}
