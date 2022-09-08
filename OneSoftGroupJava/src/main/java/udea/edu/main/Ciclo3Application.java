package udea.edu.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import udea.edu.main.modelos.Empresa;

//@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {

    @GetMapping("/hello")
    public  String hello(){
        return "Hola Ciclo 3";
    }

    @GetMapping("/test")
    public  String test(){
        Empresa emp = new Empresa("SOLAR SAS","Calle 55a sur","3213213211","80022134-3");
        emp.setNombre("SOLAR LTDA");
        return emp.getNombre();
    }


    public  static void main(String[] args) {
        SpringApplication.run(Ciclo3Application.class, args);
    }
}
