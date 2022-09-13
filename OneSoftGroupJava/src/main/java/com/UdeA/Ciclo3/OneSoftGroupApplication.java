package com.UdeA.Ciclo3;

import com.UdeA.Ciclo3.Models.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication (exclude ={SecurityAutoConfiguration.class})
public class OneSoftGroupApplication {

	@GetMapping("/hello")
	public String hello(){
		return "Hola Ciclo 3!";
	}

	@GetMapping("/test")
	public String test(){
		Empresa emp = new Empresa("OneSoftMarket LTDA", "Calle 44a Sur", "3044667968","800212002-3");
		emp.setNombre("OneSoftMarket LTDA");
		return emp.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(OneSoftGroupApplication.class, args);
	}

}
