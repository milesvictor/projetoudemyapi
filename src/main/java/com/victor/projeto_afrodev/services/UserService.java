/*
		Classe de serviços do usuário.
*/

package com.victor.projeto_afrodev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.projeto_afrodev.domain.User;
import com.victor.projeto_afrodev.dto.UserDTO;
import com.victor.projeto_afrodev.repository.UserRepository;
import com.victor.projeto_afrodev.services.exception.ObjectNotFoundException;

@Service
public class UserService { //O serviço conversa com o repositório
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() { //Método responsável por retornar todos os usuários do banco.
	
		return repo.findAll();
	}
	
	
	public User findById(String id) { //Método para retornar um usuário pelo ID.
		
		Optional<User> obj= repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public User insert(User obj) { //Método de inserção de um usuário.
		
		return repo.insert(obj);
	}
	
	
	public void delete(String id) {
		
		findById(id);
		
		repo.deleteById(id);
	}
	
	
	public User fromDTO(UserDTO objDto) { //Método que pega o DTO e transforma em usuário.
		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
