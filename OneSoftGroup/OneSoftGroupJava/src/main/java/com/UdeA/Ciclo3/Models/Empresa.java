package com.UdeA.Ciclo3.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties({"empleado"})
    private int emp_id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;

    @OneToMany(targetEntity = Empleado.class ,fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE},orphanRemoval = true)
    @JoinColumn(name = "empresa_id", referencedColumnName = "emp_id" )
    private List<Empleado> empleados = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String telefono, String NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    public int getId() {
        return emp_id;
    }

    public void setId(int id) {
        this.emp_id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
}


