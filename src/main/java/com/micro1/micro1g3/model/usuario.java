package com.micro1.micro1g3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(length = 13, nullable = false, unique = true)
    private String run;

    @Column(length = 50, nullable = false)
    private String nombrePrimero;

    @Column(length = 50, nullable = true)
    private String nombreSegundo;

    @Column(length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(length = 250, nullable = false)
    private String correo;

    @Column(length = 250, nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_rol") //@JoinColumn(referencedColumnName = "id")
    private Rol rol;
}
