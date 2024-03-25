package com.sise.lengavanzado.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.lengavanzado.entities.Producto;
import com.sise.lengavanzado.repositories.ProductoRepository;
import com.sise.lengavanzado.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findByEstadoAuditoria("1");
    }

    @Override
    public Producto listarProductoPorId(Integer idProducto) {
        return productoRepository.findOneByIdProductoAndEstadoAuditoria(idProducto, "1");
    }

    @Override
    public Producto insertarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void darBajaProducto(Integer idProductol) {
        productoRepository.darBajaProducto(idProductol);
    }
    
}
