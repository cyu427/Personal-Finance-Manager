package net.personalfinancemanager.backend;

import net.personalfinancemanager.backend.dao.CategoryDAO;
import net.personalfinancemanager.backend.model.CategoryModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

	}

}
