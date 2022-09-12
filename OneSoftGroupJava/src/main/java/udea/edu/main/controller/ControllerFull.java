package udea.edu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udea.edu.main.modelos.Empresa;
import udea.edu.main.service.EmpresaService;

import java.util.List;

public class ControllerFull {
    @Autowired
    EmpresaService empresaService;


    @GetMapping({"/Empresas","/VerEmpresas"})
    public  String viewEmpresas(Model model){
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emplist",listaEmpresas);
        return "verEmpresas";
    }
}
