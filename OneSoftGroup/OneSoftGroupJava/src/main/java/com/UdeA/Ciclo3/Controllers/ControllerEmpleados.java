package com.UdeA.Ciclo3.Controllers;

import com.UdeA.Ciclo3.Models.Empleado;
import com.UdeA.Ciclo3.Models.Empresa;
import com.UdeA.Ciclo3.Service.EmpleadoService;
import com.UdeA.Ciclo3.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ControllerEmpleados {

    @Autowired
    EmpleadoService empleadoService;


    @GetMapping("/empleados")
    public List<Empleado> verEmpleados() {
        return empleadoService.getAllEmpleado();
    }

    @PostMapping("/empleados")
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl) {
        return Optional.ofNullable(this.empleadoService.saveOrUpdateEmpleado(empl));
    }

    @GetMapping(path = "empleados/{id}")
    public Optional<Empleado> empleadoPorID(@PathVariable("id") Integer id) {
        return this.empleadoService.getEmpleadoById(id);
    }

    @GetMapping("/enterprises/{id}/empleados")
    public ArrayList<Empleado> EmpleadoPorEmpresa(@PathVariable("id") Integer id) {
        return this.empleadoService.obtenerPorEmpresa(id);
    }

    @PatchMapping("/empleados/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        Empleado empl = empleadoService.getEmpleadoById(id).get();
        empl.setNombre(empleado.getNombre());
        empl.setCorreo(empleado.getCorreo());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRol(empleado.getRol());
        return empleadoService.saveOrUpdateEmpleado(empl);
    }

    @DeleteMapping("/empleados/{id}")
    public String DeleteEmpleado(@PathVariable("id") Integer id) {
        boolean respuesta = empleadoService.deleteEmpleado(id);
        if (respuesta) {
            return "Se pudo eliminar correctamente el empleado con id " + id;
        }//Si la respuesta booleana es false, no se eliminó
        return "No se puedo eliminar correctamente el empleado con id " + id;
    }
}