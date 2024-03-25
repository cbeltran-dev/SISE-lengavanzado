package com.sise.lengavanzado.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.lengavanzado.entities.Mesa;
import com.sise.lengavanzado.repositories.MesaRepository;
import com.sise.lengavanzado.services.MesaService;
@Service
public class MesaServiceImpl implements MesaService{

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public List<Mesa> listarMesas() {
        return mesaRepository.findByEstadoAuditoria("1");
    }

    @Override
    public Mesa listarMEsaPorId(Integer idMesa) {
        return mesaRepository.findOneByIdMesaAndEstadoAuditoria(idMesa, "1");
    }

    @Override
    public Mesa insertarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public Mesa actualizarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public void darBajaMesa(Integer idMesa) {
        mesaRepository.darBajaMesa(idMesa);
    }
    
}
