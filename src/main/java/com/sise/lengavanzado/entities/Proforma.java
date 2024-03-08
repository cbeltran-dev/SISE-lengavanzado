package com.sise.lengavanzado.entities;

import java.sql.Date;

import lombok.Data;
@Data
public class Proforma {
    private Integer idProforma;
    private AsignacionMesa asignacionMesa;
    private String codigoProforma;
    private String nombreCliente;
    private Float precioTotal;
    private String observaciones;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
