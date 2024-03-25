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
import com.sise.lengavanzado.adapters.RolAdapter;
import com.sise.lengavanzado.entities.Rol;
import com.sise.lengavanzado.pyload.requests.RolRequestInsert;
import com.sise.lengavanzado.pyload.requests.RolRequestUpdate;
import com.sise.lengavanzado.services.RolService;
import com.sise.lengavanzado.shared.BaseResponse;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;
    private RolAdapter rolAdapter;

    public RolController(){
        rolAdapter = new RolAdapter();
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse> listarRoles() {
        try {
            List<Rol> rol = rolService.listarRol();

            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(rol),
                    HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idRol}")

    public ResponseEntity<BaseResponse> listarRolPorId(@PathVariable Integer idRol) {

        try {
            Rol rol = rolService.listarRolPorId(idRol);
            // return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
            if (rol == null) {
                return new ResponseEntity<BaseResponse>(
                        BaseResponse.errorNotFound(),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(rol),
                    HttpStatus.OK);
        } catch (Exception e) {
            // return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarRol(@RequestBody RolRequestInsert rolRequest) {
        try {
            Rol rol = rolService.insertarRol(rolAdapter.insertToEntity(rolRequest));
            // return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(rol),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            // return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idRol}")
    public ResponseEntity<BaseResponse> actualizarRol(@PathVariable Integer idRol,
        @RequestBody RolRequestUpdate rolRequestUpdate) {
        try {
            Rol rol = rolAdapter.updateToEntity(rolRequestUpdate);
            rol.setIdRol(idRol);

            Rol newRol = rolService.actualizarRol(rol);

            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(newRol),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/darbaja/{idRol}")
    public ResponseEntity<BaseResponse> darBajaRol(@PathVariable Integer idRol) {
        try {
            rolService.darBajaRol(idRol);
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
