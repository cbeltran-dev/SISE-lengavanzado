package com.sise.lengavanzado.pyload.responses;
//clase para que controlar los datos que se envian a la aplicación cliente
import lombok.Data;

@Data
public class SucursalResponse {
    
    private Integer idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String imagenUrl;

}
