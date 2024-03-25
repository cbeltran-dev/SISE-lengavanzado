package com.sise.lengavanzado.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.lengavanzado.adapters.SucursalAdapter;
import com.sise.lengavanzado.entities.Sucursal;
import com.sise.lengavanzado.pyload.requests.SucursalRequestInsert;
import com.sise.lengavanzado.pyload.requests.SucursalRequestUpdate;
import com.sise.lengavanzado.services.SucursalService;
import com.sise.lengavanzado.shared.BaseResponse;
import com.sise.lengavanzado.utils.MappedUtil;
import com.sise.lengavanzado.utils.ValidationUtil;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;
    private SucursalAdapter sucursalAdapter;

    public SucursalController(){
        sucursalAdapter = new SucursalAdapter();
    }


    @GetMapping("")
    public ResponseEntity<BaseResponse> listarSucursales(){
        //Conversion de sucursalEntity a sucursalResponse
        try {
            List<Sucursal> sucursales = sucursalService.listarSucursal();
            /*  List<SucursalResponse> sucursalResponseList = new ArrayList<>();
            for (Sucursal sucursal : sucursales){
                sucursalResponseList.add(MappedUtil.toSucursalResponse(sucursal));
            }*/
            return new ResponseEntity<BaseResponse>(
                BaseResponse.success(sucursales),
                HttpStatus.OK);
            //return BaseResponse.success(sucursalResponseList);
        } catch (Exception e) {
            //return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                BaseResponse.error(e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idSucursal}")
    
    public ResponseEntity<BaseResponse> listarSucursalPorId(@PathVariable Integer idSucursal){

        try {
            Sucursal sucursal = sucursalService.listarSucursalPorId(idSucursal);
            //return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
            if (sucursal == null){
                return new ResponseEntity<BaseResponse>(
                BaseResponse.errorNotFound(),
                HttpStatus.NOT_FOUND  
                );
            }
            return new ResponseEntity<BaseResponse>(
                BaseResponse.success(sucursal),
                HttpStatus.OK);
        } catch (Exception e) {
            //return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                BaseResponse.error(e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarSucursal(
        @Valid @RequestBody SucursalRequestInsert sucursalRequestInsert, Errors errors){
        try {

            if(errors.hasErrors()){
                return new ResponseEntity<BaseResponse>(
                BaseResponse.error(ValidationUtil.getOneMessageFromErrors(errors.getFieldErrors())),
                //BaseResponse.success("Errores en request"),
                HttpStatus.BAD_REQUEST);
            }

            Sucursal sucursal = sucursalService.insertarSucursal(sucursalAdapter.insertToEntity(sucursalRequestInsert));
            //return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
            return new ResponseEntity<BaseResponse>(
                BaseResponse.success(sucursal),
                HttpStatus.CREATED);
        } catch (Exception e) {
            //return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                BaseResponse.error(e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idSucursal}")
    public ResponseEntity<BaseResponse> actualizarSucursal(@PathVariable Integer idSucursal,
        @RequestBody SucursalRequestUpdate sucursalRequestUpdate){
        try {
            Sucursal sucursal = sucursalAdapter.updateToEntity(sucursalRequestUpdate);
            sucursal.setIdSucursal(idSucursal);

            Sucursal newSucursal = sucursalService.actualizarSucursal(sucursal);

            return new ResponseEntity<BaseResponse>(
                BaseResponse.success(newSucursal),
                HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                BaseResponse.error(e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/darbaja/{idSucursal}")
    public ResponseEntity<BaseResponse> darBajaSucursal(@PathVariable Integer idSucursal){
        try {
            sucursalService.darBajaSucursal(idSucursal);
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
