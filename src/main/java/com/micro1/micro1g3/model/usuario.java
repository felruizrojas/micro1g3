package com.micro1.micro1g3.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // en una entidad de intersección se crearía una clase @Data sin @Entity y se le asignaría la tabla de intersección
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 13, nullable = false, unique = true)
    private String run;

    @Column(length = 50, nullable = false)
    private String nomPrimero;

    @Column(length = 50)
    private String nomSegundo;

    @Column(length = 50, nullable = false)
    private String apPaterno;

    @Column(length = 50, nullable = false)
    private String apMaterno;

    @Column(length = 100, nullable = false)
    private String correo;

    @Column(length = 250, nullable = false)
    private String direccion;

    @Column(length = 250, nullable = false)
    private String ciudad;

    @Column(length = 250, nullable = false)
    private String region;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Rol> roles;
}
