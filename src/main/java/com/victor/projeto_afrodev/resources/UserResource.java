package com.victor.projeto_afrodev.resources;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.projeto_afrodev.domain.User;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping //Método GET para mostrar os valores
	public ResponseEntity<List<User>> findAll() { //Retorna resposta http
		
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(list); //Código com respota de sucesso junto com o list

	}
			
			
	
	
}
