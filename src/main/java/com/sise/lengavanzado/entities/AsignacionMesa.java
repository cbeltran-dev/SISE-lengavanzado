package com.sise.lengavanzado.entities;

import java.sql.Date;

import lombok.Data;
@Data
public class AsignacionMesa {
    private Integer idAsignacionMesa;
    private Sucursal sucursal;
    private Mesa mesa;
    private Usuario usuario;
    private String turno;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
