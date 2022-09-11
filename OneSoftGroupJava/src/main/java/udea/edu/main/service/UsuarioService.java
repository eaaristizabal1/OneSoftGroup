package udea.edu.main.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.main.modelos.Empleado;
import udea.edu.main.repo.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

   public List<Empleado> getAllUsuario(){
       List<Empleado> ListEmpleado = new ArrayList<>();
       usuarioRepository.findAll().forEach(Empleado -> ListEmpleado.add(Empleado));
       return ListEmpleado;
   }

   public Empleado getEmpleadoById(Integer id){
       return usuarioRepository.findById(id).get();
   }

   public boolean UpdateOrSaveEmpleado(Empleado empleado){
       Empleado employee=usuarioRepository.save(empleado);
       if (usuarioRepository.findById(employee.getId())!=null){
           return true;
        }
            return false;
   }

   public boolean deleteEmpleado(Integer id){
       usuarioRepository.deleteById(id);
       if (getEmpleadoById(id)!=null){
           return false;
       }
       return true;
   }
}