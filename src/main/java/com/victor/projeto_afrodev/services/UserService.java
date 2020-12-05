/*
		Classe de serviços do usuário.
*/

package com.victor.projeto_afrodev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.projeto_afrodev.domain.User;
import com.victor.projeto_afrodev.repository.UserRepository;
import com.victor.projeto_afrodev.services.exception.ObjectNotFoundException;

@Service
public class UserService { //O serviço conversa com o repositório
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() { //Método responsável por retornar todos os usuários do banco.
	
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> obj= repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
