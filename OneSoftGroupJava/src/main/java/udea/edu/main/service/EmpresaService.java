package udea.edu.main.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.main.modelos.Empresa;
import udea.edu.main.repo.EmpresaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;
// Metodo de retorno de la lista de empresas usando el metodo heredado de jpaRepository
    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa)); //se recorre el iterable para regresar con el FindAll
        return empresaList;
    }
    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();
    }
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);
        if (empresaRepository.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);
        if(getEmpresaById(id)!=null){
            return false;
        }
        return true;
    }
}
