package com.UdeA.Ciclo3.Models;

import javax.persistence.*;

@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String correo;
    @ManyToOne(targetEntity = Empresa.class , fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id", referencedColumnName = "emp_id" )
    private Empresa empresa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role rol;

    public Empleado() {
    }

    public Empleado(String nombre, String correo, Empresa empresa, Role rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
