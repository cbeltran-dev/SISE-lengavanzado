package com.sise.lengavanzado.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sise.lengavanzado.entities.Mesa;
import com.sise.lengavanzado.pyload.requests.MesaRequest;
import com.sise.lengavanzado.services.MesaService;
import com.sise.lengavanzado.shared.BaseResponse;
import com.sise.lengavanzado.utils.MappedUtil;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping("")
    public ResponseEntity<BaseResponse> listarMesas() {
        try {
            List<Mesa> mesa = mesaService.listarMesas();
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(mesa), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/{idMesa}")
    public ResponseEntity<BaseResponse> listarMesaPorId(@PathVariable Integer idMesa) {
        try {
            Mesa mesa = mesaService.listarMEsaPorId(idMesa);
            if (mesa == null) {
                return new ResponseEntity<BaseResponse>(
                        BaseResponse.errorNotFound(),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(mesa),
                    HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarMesa(@RequestBody MesaRequest mesaRequest) {
        try {
            Mesa mesa = mesaService.insertarMesa(MappedUtil.toMesaEntity(mesaRequest));
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(mesa),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idMesa}")
    public ResponseEntity<BaseResponse> actualizarMesa(@PathVariable Integer idMesa,
            @RequestBody MesaRequest mesaRequest) {
        try {
            Mesa mesa = MappedUtil.toMesaEntity(mesaRequest);
            mesa.setIdMesa(idMesa);

            Mesa newMesa = mesaService.actualizarMesa(mesa);
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(newMesa),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/darbaja/{idMesa}")
    public ResponseEntity<BaseResponse> darBajaMesa(@PathVariable Integer idMesa) {
        try {
            mesaService.darBajaMesa(idMesa);
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(null),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
