package br.com.apptodolist.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@GetMapping
	public ModelAndView swaggerUi () {
			
		return new ModelAndView("redirect:/swagger-ui/");
		}
}
