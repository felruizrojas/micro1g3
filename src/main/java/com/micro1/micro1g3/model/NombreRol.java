package com.micro1.micro1g3.model;

public enum NombreRol {
    ADMINISTRADOR_DE_SISTEMA("Administrador de sistema"),
    GERENTE_DE_TIENDA("Gerente de tienda"),
    ENCARGADO_DE_VENTAS("Encargado de ventas"),
    ENCARGADO_DE_LOGISTICA("Encargado de logística"),
    CLIENTE("Cliente");

    private final String displayName;

    NombreRol(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    //NombreRol.valueOf("ENCARGADO_DE_VENTAS")

}
