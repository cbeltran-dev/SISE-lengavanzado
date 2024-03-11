package com.sise.lengavanzado.pyload.requests;

import lombok.Data;

@Data
public class SucursalRequest {
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String imagenUrl;
}
