package com.sise.lengavanzado.entities;

import java.sql.Date;

import lombok.Data;
@Data
public class Usuario {
    private Integer idUsuario;
    private Rol rol;
    private String username;
    private String correo;
    private String clave;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
