package com.UdeA.Ciclo3.Service;

import com.UdeA.Ciclo3.Models.MovimientoDinero;
import com.UdeA.Ciclo3.Repository.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientosService {
    @Autowired
    MovimientosRepository movimientosRepository;

    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimientosRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));
        return movimientosList;
    }

    public MovimientoDinero getMovimientoById(Integer id){ //Ver movimientos por id
        return movimientosRepository.findById(id).get();
    }

    public boolean saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){
        MovimientoDinero mov=movimientosRepository.save(movimientoDinero);
        if (movimientosRepository.findById(mov.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteMovimiento(Integer id){
        movimientosRepository.deleteById(id);
        if(this.movimientosRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) {
        return movimientosRepository.findByEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
        return movimientosRepository.findByEmpresa(id);
    }


    public Long obtenerSumaMontos(){
        return movimientosRepository.SumarMonto();
    }


    public Long MontosPorEmpleado(Integer id){
        return movimientosRepository.MontosPorEmpleado(id);
    }


    public Long MontosPorEmpresa(Integer id){
        return movimientosRepository.MontosPorEmpresa(id);
    }

}
