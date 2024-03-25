package com.sise.lengavanzado.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.lengavanzado.entities.Sucursal;
import com.sise.lengavanzado.repositories.SucursalRepository;
import com.sise.lengavanzado.services.SucursalService;
@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private SucursalRepository sucursalRepository;
    

    
    @Override
    public List<Sucursal> listarSucursal() {
        //return sucursalRepository.findAll();
        return sucursalRepository.findByEstadoAuditoria("1");
    }

    @Override
    public Sucursal listarSucursalPorId(Integer id) {
        //return sucursalRepository.findById(id).orElse(null);
        return sucursalRepository.findOneByIdSucursalAndEstadoAuditoria(id, "1");
    }
    
    @Override
    public Sucursal insertarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal actualizarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public void darBajaSucursal(Integer id) {
        sucursalRepository.darBajaSucursal(id);

    }



}
