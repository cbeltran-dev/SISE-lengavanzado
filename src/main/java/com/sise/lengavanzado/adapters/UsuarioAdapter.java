package com.sise.lengavanzado.adapters;

import com.sise.lengavanzado.entities.Rol;
import com.sise.lengavanzado.entities.Usuario;
import com.sise.lengavanzado.pyload.requests.UsuarioRequestInsert;
import com.sise.lengavanzado.pyload.requests.UsuarioRequestUpdate;
import com.sise.lengavanzado.pyload.requests.UsuarioRequestUpdateClave;
import com.sise.lengavanzado.utils.AdapterTemplate;

public class UsuarioAdapter implements AdapterTemplate<Usuario,UsuarioRequestInsert,UsuarioRequestUpdate>{

    @Override
    public Usuario insertToEntity(UsuarioRequestInsert insert) {
        Usuario entity = new Usuario();

        Rol rol = new Rol();
        rol.setIdRol(insert.getIdRol());

        entity.setRol(rol);
        entity.setUsername(insert.getUsername());
        entity.setCorreo(insert.getCorreo());
        entity.setClave(insert.getClave());
        return entity;
    }

    @Override
    public Usuario updateToEntity(UsuarioRequestUpdate update) {
        
        Usuario entity = new Usuario();

        Rol rol = new Rol();
        rol.setIdRol(update.getIdRol());
        
        entity.setRol(rol);
        entity.setCorreo(update.getCorreo());
        return entity;
    }

    public Usuario updateClaveToEntity(UsuarioRequestUpdateClave update) {
        
        Usuario entity = new Usuario();
        entity.setClave(update.getClave());
        return entity;
    }
    
}
