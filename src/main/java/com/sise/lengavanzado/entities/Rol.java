package com.sise.lengavanzado.entities;
import java.sql.Date;
import lombok.Data;

@Data
public class Rol {
    private Integer idRol;
    private String nombrel;
    private String descripcion;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
