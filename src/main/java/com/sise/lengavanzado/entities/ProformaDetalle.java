package com.sise.lengavanzado.entities;

import java.sql.Date;

import lombok.Data;
@Data
public class ProformaDetalle {
    private Integer idProformaDetalle;
    private Proforma proforma;
    private Producto producto;
    private Integer cantidad;
    private String nombreProducto;
    private Float precioUnitario;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
