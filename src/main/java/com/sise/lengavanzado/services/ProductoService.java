package com.sise.lengavanzado.services;

import java.util.List;

import com.sise.lengavanzado.entities.Producto;


public interface ProductoService {
    
    List<Producto> listarProductos();
    Producto listarProductoPorId(Integer idProducto);
    Producto insertarProducto(Producto producto);
    Producto actualizarProducto(Producto producto);
    void darBajaProducto(Integer idProductol);
}
