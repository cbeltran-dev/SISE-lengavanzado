package com.sise.lengavanzado.entities;
import java.sql.Date;
import lombok.Data;

@Data
public class Sucursal {
    private Integer idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String descripcion;
    private String imagenUrl;
    private String estadoAuditoria;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
