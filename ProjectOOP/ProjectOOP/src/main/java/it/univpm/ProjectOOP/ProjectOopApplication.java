package it.univpm.ProjectOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication
public class ProjectOopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectOopApplication.class, args);
	}

}
