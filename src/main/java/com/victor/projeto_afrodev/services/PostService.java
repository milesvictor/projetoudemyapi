/*
		Classe de serviços do usuário.
*/

package com.victor.projeto_afrodev.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.projeto_afrodev.domain.Post;
import com.victor.projeto_afrodev.repository.PostRepository;
import com.victor.projeto_afrodev.services.exception.ObjectNotFoundException;

@Service
public class PostService { //O serviço conversa com o repositório
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) { //Método para retornar o post pelo ID.
		
		Optional<Post> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public List<Post> findByTitle(String text) {
		
		return repo.searchTitle(text);
	}
	
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); //Arredonda pra 24h do dia do post 
		
		return repo.fullSearch(text, minDate, maxDate);
		
	}
}
