package com.sise.lengavanzado.entities;

import java.sql.Date;

import lombok.Data;
@Data
public class Mesa {
    private Integer idMesa;
    private String descripcion;
    private Integer capacidad;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
