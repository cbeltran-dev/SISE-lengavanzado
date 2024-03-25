package com.sise.lengavanzado.adapters;

import com.sise.lengavanzado.entities.Sucursal;
import com.sise.lengavanzado.pyload.requests.SucursalRequestInsert;
import com.sise.lengavanzado.pyload.requests.SucursalRequestUpdate;
import com.sise.lengavanzado.utils.AdapterTemplate;

public class SucursalAdapter implements AdapterTemplate<Sucursal,SucursalRequestInsert,SucursalRequestUpdate> {

    @Override
    public Sucursal insertToEntity(SucursalRequestInsert insert) {
        Sucursal entity = new Sucursal();
        entity.setNombre(insert.getNombre());
        entity.setDireccion(insert.getDireccion());
        entity.setTelefono(insert.getTelefono());
        entity.setDescripcion(insert.getDescripcion());
        entity.setImagenUrl(insert.getImagenUrl());
        return entity;
    }

    @Override
    public Sucursal updateToEntity(SucursalRequestUpdate update) {
        Sucursal entity = new Sucursal();
        entity.setNombre(update.getNombre());
        entity.setDireccion(update.getDireccion());
        entity.setTelefono(update.getTelefono());
        entity.setDescripcion(update.getDescripcion());
        entity.setImagenUrl(update.getImagenUrl());
        return entity;
    }

    
}