package com.UdeA.Ciclo3.Controllers;

import com.UdeA.Ciclo3.Models.Empleado;
import com.UdeA.Ciclo3.Models.Empresa;
import com.UdeA.Ciclo3.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerEmpleados {

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    EmpresaService empresaService;

    @GetMapping ("/VerEmpleados")
    public String viewEmpleados(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Empleado> listaEmpleados=empleadoService.getAllEmpleado();
        model.addAttribute("emplelist",listaEmpleados);
        model.addAttribute("mensaje",mensaje);
        return "verEmpleados"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpleado")
    public String nuevoEmpleado(Model model, @ModelAttribute("mensaje") String mensaje){
        Empleado empl= new Empleado();
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje",mensaje);
        List<Empresa> listaEmpresas= empresaService.getAllEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "agregarEmpleado";
    }

    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado empl, RedirectAttributes redirectAttributes){
        if(empleadoService.saveOrUpdateEmpleado(empl)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpleado";
    }

    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empleado empl=empleadoService.getEmpleadoById(id).get();
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> listaEmpresas= empresaService.getAllEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "editarEmpleado";
    }

    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("empl") Empleado empl, RedirectAttributes redirectAttributes){
        if(empleadoService.saveOrUpdateEmpleado(empl)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpleado/"+empl.getId();

    }

    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empleadoService.deleteEmpleado(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleados";
    }

    @GetMapping("/Empresa/{id}/Empleados")
    public String verEmpleadosPorEmpresa(@PathVariable("id") Integer id, Model model){
        List<Empleado> listaEmpleados = empleadoService.obtenerPorEmpresa(id);
        model.addAttribute("emplelist",listaEmpleados);
        return "verEmpleados";
    }
}
