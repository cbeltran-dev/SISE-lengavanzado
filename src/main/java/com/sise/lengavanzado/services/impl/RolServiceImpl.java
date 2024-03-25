package com.sise.lengavanzado.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.lengavanzado.entities.Rol;
import com.sise.lengavanzado.repositories.RolRepository;
import com.sise.lengavanzado.services.RolService;
@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listarRol() {
        return rolRepository.findByEstadoAuditoria("1");
    }

    @Override
    public Rol listarRolPorId(Integer idRol) {
        return rolRepository.findOneByIdRolAndEstadoAuditoria(idRol, "1");
        
    }

    @Override
    public Rol insertarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol actualizarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void darBajaRol(Integer idRol) {
        rolRepository.darBajaRol(idRol);
    }

    
    
}
