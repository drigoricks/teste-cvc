package br.com.teste.cvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "br.om.teste.cvc")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
