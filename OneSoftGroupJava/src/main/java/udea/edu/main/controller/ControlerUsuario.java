package udea.edu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udea.edu.main.modelos.Empresa;
import udea.edu.main.service.EmpresaService;

import java.util.List;


public class ControllerFull {
    @Autowired
    EmpresaService empresaService;

        //EMPLEADOS
        @GetMapping("/usuario") //Ver json de todas los empleados
        public List<Empleado> verEmpleados(){
            return usuarioService.getAllEmpleado();
        }

    @PostMapping("/empleados") //Guardar un empleado nuevo
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl){
        return Optional.ofNullable(this.empleadoService.saveOrUpdateEmpleado(empl));
    }
    @GetMapping(path = "empleados/{id}")//Consultar empleado por ID
    public Optional<Empleado> empleadoPorID(@PathVariable("id") Integer id){
        return this.empleadoService.getEmpleadoById(id);
    }

    @GetMapping("/enterprises/{id}/empleados")// Consultar empleados por empresa
    public ArrayList<Empleado> EmpleadoPorEmpresa(@PathVariable("id") Integer id){
        return this.empleadoService.obtenerPorEmpresa(id);
    }

    @PatchMapping("/empleados/{id}")
    public Empleado actualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario){
        Empleado empl=empleadoService.getEmpleadoById(id).get();
        empl.setNombre(usuario.getNombre());
        empl.setCorreo(usuario.getCorreo());
        empl.setEmpresa(usuario.getEmpresa());
        empl.setRol(usuario.getRol());
        return usuarioService.saveOrUpdateEmpleado(empl);
    }

    @DeleteMapping("/empleados/{id}") //Metodo para eliminar usuarios por id
    public String DeleteEmpleado(@PathVariable("id") Integer id){
        boolean respuesta=usuarioService.deleteUsuario(id); //eliminamos usando el servicio de nuestro service
        if (respuesta){ //si la respuesta booleana es true, si se eliminò
            return "Se pudo eliminar correctamente el empleado con id "+id;
        }//Si la respuesta booleana es false, no se eliminó
        return "No se puedo eliminar correctamente el empleado con id "+id;
    }

}
