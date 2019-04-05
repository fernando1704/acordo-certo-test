package org.acordo.certo.test.web.config;

import org.acordo.certo.test.web.controller.ClienteController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackageClasses = ClienteController.class)
@EnableJpaRepositories(basePackages = {"org.acordo.certo.test.domain.repository"})
@EntityScan(basePackages = {"org.acordo.certo.test.domain.entity"})
@ComponentScan(basePackages = { "org.acordocerto.test.service"})
public class AcordoCertoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcordoCertoApplication.class, args); 
	}
}
