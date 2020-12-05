/*
		Classe de recurso do usuário dentro do pacote resources (Recursos).
*/

package com.victor.projeto_afrodev.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victor.projeto_afrodev.domain.User;
import com.victor.projeto_afrodev.dto.UserDTO;
import com.victor.projeto_afrodev.services.UserService;


@RestController //Recurso Rest.
@RequestMapping(value = "/users") //Caminho do endpoint.
public class UserResource {

	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(method=RequestMethod.GET)//Método GET para mostrar os valores
	public ResponseEntity<List<UserDTO>> findAll() { //Retorna uma lista de usuários.
		
		
		List<User> list = service.findAll();
		
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //Instrução lambda.
		
		return ResponseEntity.ok().body(listDto); //Código com respota de sucesso junto com o list

	}	
			
	@RequestMapping(value="/{id}", method=RequestMethod.GET) 
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { //Retorna o usuário pelo id.
		
		User obj = service.findById(id);
				
		return ResponseEntity.ok().body(new UserDTO(obj)); 

	}
	
}
