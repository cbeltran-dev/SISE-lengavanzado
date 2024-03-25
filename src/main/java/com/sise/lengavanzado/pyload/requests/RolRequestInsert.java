package com.sise.lengavanzado.pyload.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RolRequestInsert {

    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    @NotBlank
    private String descripcion;
    
}
