package com.UdeA.Ciclo3.Controllers;

import com.UdeA.Ciclo3.Models.Empresa;
import com.UdeA.Ciclo3.Repository.MovimientosRepository;
import com.UdeA.Ciclo3.Service.EmpleadoService;
import com.UdeA.Ciclo3.Service.EmpresaService;
import com.UdeA.Ciclo3.Service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@RestController
public class ControllerEmpresas {
    @Autowired
    EmpresaService  empresaService;

    @GetMapping("/enterprises")
    public List<Empresa> verEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @PostMapping("/enterprises")
    public Empresa guardarEmpresa(@RequestBody Empresa emp) {

        return this.empresaService.saveOrUpdateEmpresa(emp);
    }

    @GetMapping(path = "enterprises/{id}")
    public Empresa empresaPorID(@PathVariable("id") Integer id) {
        return this.empresaService.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
        Empresa emp = empresaService.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());
        return empresaService.saveOrUpdateEmpresa(emp);

    }

    @DeleteMapping(path = "enterprises/{id}")
    public String DeleteEmpresa(@PathVariable("id") Integer id) {
        boolean respuesta = this.empresaService.deleteEmpresa(id);
        if (respuesta) {  //Si respuesta es true?
            return "Se elimino la empresa con id" + id;
        } else {
            return "No se pudo eliminar la empresa con id" + id;
        }
    }
}
