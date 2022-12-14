package com.UdeA.Ciclo3.Service;

import com.UdeA.Ciclo3.Models.Empleado;
import com.UdeA.Ciclo3.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    @Service
    public class EmpleadoService {

        @Autowired
        EmpleadoRepository empleadoRepository;


        public List<Empleado> getAllEmpleado(){
            List<Empleado> empleadoList= new ArrayList<>();
            empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));
            return empleadoList;
        }


        public Optional<Empleado> getEmpleadoById(Integer id){

            return empleadoRepository.findById(id);
        }


        public ArrayList<Empleado> obtenerPorEmpresa(Integer id){
            return empleadoRepository.findByEmpresa(id);
        }

        public boolean saveOrUpdateEmpleado(Empleado empl){
            Empleado emp=empleadoRepository.save(empl);
            if (empleadoRepository.findById(emp.getId())!=null){
                return true;
            }
            return false;
        }

        public boolean deleteEmpleado(Integer id){
            empleadoRepository.deleteById(id);
            if(this.empleadoRepository.findById(id).isPresent()){
                return false;
            }
            return true;
        }

    }
