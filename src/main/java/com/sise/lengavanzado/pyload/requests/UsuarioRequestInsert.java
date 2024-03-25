package com.sise.lengavanzado.pyload.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class UsuarioRequestInsert {

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    @Email
    private String correo;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 20)
    private String clave;

    @NotNull
    @Positive
    private Integer idRol;
}
