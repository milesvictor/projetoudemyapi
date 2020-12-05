/*
		Classe de recurso do usuário dentro do pacote resources (Recursos).
*/

package com.victor.projeto_afrodev.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victor.projeto_afrodev.domain.Post;
import com.victor.projeto_afrodev.services.PostService;


@RestController //Recurso Rest.
@RequestMapping(value = "/posts") //Caminho do endpoint.
public class PostResource {

	
	@Autowired
	private PostService service;
	
			
	@RequestMapping(value="/{id}", method=RequestMethod.GET) 
	public ResponseEntity<Post> findById(@PathVariable String id) { //Retorna um post pelo id.
		
		Post obj = service.findById(id);
				
		return ResponseEntity.ok().body(obj); 

	}
	
}
