/*
		Classe de recurso do usuário dentro do pacote resources (Recursos).
*/

package com.victor.projeto_afrodev.resources;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victor.projeto_afrodev.domain.Post;
import com.victor.projeto_afrodev.resources.util.URL;
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
	
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET) 
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) { //Um post pelo titulo.
		
		text = URL.decodeParam(text);
		
		List<Post> list = service.findByTitle(text);
		
		return ResponseEntity.ok().body(list); 
	}
	
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET) 
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue="") String text, 
			@RequestParam(value="minDate", defaultValue="") String minDate, 
			@RequestParam(value="maxDate", defaultValue="") String maxDate) { //Um post pelo nome/post/comentário e data.
		
		
		text = URL.decodeParam(text);
		
		
		Date min = URL.convertDate(minDate,  new Date(0L));
		Date max = URL.convertDate(maxDate,  new Date());
		
		
		List<Post> list = service.fullSearch(text, min, max);
		
		
		return ResponseEntity.ok().body(list); 
	}
	
}
