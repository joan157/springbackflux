package edu.cibertec.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"edu.cibertec"})
@EntityScan(basePackages = "edu.cibertec.entity")
@EnableR2dbcRepositories(basePackages = "edu.cibertec.repository")
//@EnableJpaRepositories(basePackages = "edu.cibertec.repository") //identificar los repositorios
public class ReactivaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ReactivaApplication.class, args);
	}

}
