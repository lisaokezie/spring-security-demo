package com.crudexampleproject.springbootcrudexample;

import com.crudexampleproject.springbootcrudexample.domain.security.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@CrossOrigin(origins = "*")
public class SpringbootCrudExampleApplication {

	/* @GetMapping("/")
	public String login(){
		return "authenticated successfully";
	}*/

	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public String validateLogin() {
		return "validate login";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudExampleApplication.class, args);
	}

}
