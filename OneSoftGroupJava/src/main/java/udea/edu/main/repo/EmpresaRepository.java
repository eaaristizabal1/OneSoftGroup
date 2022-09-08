package udea.edu.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udea.edu.main.modelos.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
