package com.sise.lengavanzado.pyload.requests;
import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SucursalRequestInsert {
    
    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    @NotBlank
    private String direccion;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String telefono;

    @NotNull
    @NotBlank
    private String descripcion;

    @NotNull
    @NotBlank
    @URL
    private String imagenUrl;
}
