package com.sise.lengavanzado.services;

import java.util.List;

import com.sise.lengavanzado.entities.Mesa;



public interface MesaService {
    List<Mesa> listarMesas();
    Mesa listarMEsaPorId(Integer idMesa);
    Mesa insertarMesa(Mesa mesa);
    Mesa actualizarMesa(Mesa mesa);
    void darBajaMesa(Integer idMesa);
}
