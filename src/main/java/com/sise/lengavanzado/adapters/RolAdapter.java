package com.sise.lengavanzado.adapters;

import com.sise.lengavanzado.entities.Rol;

import com.sise.lengavanzado.pyload.requests.RolRequestInsert;
import com.sise.lengavanzado.pyload.requests.RolRequestUpdate;
import com.sise.lengavanzado.utils.AdapterTemplate;

public class RolAdapter implements AdapterTemplate <Rol,RolRequestInsert,RolRequestUpdate> {

    @Override
    public Rol insertToEntity(RolRequestInsert insert) {
        Rol entity = new Rol();
        entity.setNombre(insert.getNombre());
        entity.setDescripcion(insert.getDescripcion());
        return entity;
    }

    @Override
    public Rol updateToEntity(RolRequestUpdate update) {
        Rol entity = new Rol();
        entity.setNombre(update.getNombre());
        entity.setDescripcion(update.getDescripcion());
        return entity;
    }

    
}