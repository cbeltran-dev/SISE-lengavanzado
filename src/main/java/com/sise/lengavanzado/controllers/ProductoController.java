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
import com.sise.lengavanzado.entities.Producto;
import com.sise.lengavanzado.pyload.requests.ProductoRequest;
import com.sise.lengavanzado.services.ProductoService;
import com.sise.lengavanzado.shared.BaseResponse;
import com.sise.lengavanzado.utils.MappedUtil;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<BaseResponse> listarProductos() {
        try {
            List<Producto> producto = productoService.listarProductos();

            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(producto),
                    HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idProducto}")

    public ResponseEntity<BaseResponse> listarProductoPorId(@PathVariable Integer idProducto) {

        try {
            Producto producto = productoService.listarProductoPorId(idProducto);
            // return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
            if (producto == null) {
                return new ResponseEntity<BaseResponse>(
                        BaseResponse.errorNotFound(),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(producto),
                    HttpStatus.OK);
        } catch (Exception e) {
            // return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarProducto(@RequestBody ProductoRequest productoRequest) {
        try {
            Producto producto = productoService.insertarProducto(MappedUtil.toProductoEntity(productoRequest));
            // return BaseResponse.success(MappedUtil.toSucursalResponse(sucursal));
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(producto),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            // return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idRol}")
    public ResponseEntity<BaseResponse> actualizarProducto(@PathVariable Integer idProducto,
            @RequestBody ProductoRequest productoRequest) {
        try {
            Producto producto = MappedUtil.toProductoEntity(productoRequest);
            producto.setIdProducto(idProducto);

            Producto newProducto = productoService.actualizarProducto(producto);
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(newProducto),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/darbaja/{idRol}")
    public ResponseEntity<BaseResponse> darBajaSucursal(@PathVariable Integer idProducto) {
        try {
            productoService.darBajaProducto(idProducto);
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
