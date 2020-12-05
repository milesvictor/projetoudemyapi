package com.victor.projeto_afrodev.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.projeto_afrodev.domain.User;
import com.victor.projeto_afrodev.dto.UserDTO;
import com.victor.projeto_afrodev.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	@Autowired
	private UserService service;
	
	@GetMapping //Método GET para mostrar os valores
	public ResponseEntity<List<UserDTO>> findAll() { //Retorna resposta http
		
		List<User> list = service.findAll();
		
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto); //Código com respota de sucesso junto com o list

	}
			
			
	
	
}
