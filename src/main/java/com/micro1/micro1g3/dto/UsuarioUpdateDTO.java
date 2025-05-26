package com.micro1.micro1g3.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UsuarioUpdateDTO {
    private String nomPrimero;
    private String nomSegundo;
    private String apPaterno;
    private String apMaterno;
    private String correo;
    private String direccion;
    private String ciudad;
    private String region;
}
