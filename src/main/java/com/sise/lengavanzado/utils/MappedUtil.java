package com.sise.lengavanzado.utils;

import com.sise.lengavanzado.entities.Sucursal;
import com.sise.lengavanzado.pyload.requests.SucursalRequest;
import com.sise.lengavanzado.pyload.responses.SucursalResponse;

public class MappedUtil {

    public static Sucursal toSucursalEntity(SucursalRequest sucursalRequest){
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalRequest.getNombre());
        sucursal.setDireccion(sucursalRequest.getDireccion());
        sucursal.setTelefono(sucursalRequest.getTelefono());
        sucursal.setDescripcion(sucursalRequest.getDescripcion());
        sucursal.setImagenUrl(sucursalRequest.getImagenUrl());
        return sucursal;
    }

    public static SucursalResponse toSucursalResponse (Sucursal sucursal){
        SucursalResponse response = new SucursalResponse();
        response.setIdSucursal(sucursal.getIdSucursal());
        response.setNombre(sucursal.getNombre());
        response.setDireccion(sucursal.getDireccion());
        response.setTelefono(sucursal.getTelefono());
        response.setDescripcion(sucursal.getDescripcion());
        response.setImagenUrl(sucursal.getImagenUrl());
        return response;
    }
}
