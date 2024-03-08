package com.sise.lengavanzado.entities;

import java.sql.Date;

import lombok.Data;
@Data
public class Producto {
    private Integer idProducto;
    private String nombre;
    private Float precioUnitario;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
