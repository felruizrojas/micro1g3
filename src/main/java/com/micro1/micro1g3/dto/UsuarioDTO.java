package com.micro1.micro1g3.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UsuarioDTO {
    
    private String run; // Asumiendo que este campo es necesario para la creación del usuario
    private String nomPrimero;
    private String nomSegundo;
    private String apPaterno;
    private String apMaterno;
    private String correo;
    private String direccion;
    private String ciudad;
    private String region;
    private String rolNombre; // Asumiendo que este campo es necesario para la creación del usuario
    
}
