package com.victor.projeto_afrodev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.projeto_afrodev.domain.User;
import com.victor.projeto_afrodev.repository.UserRepository;

@Service
public class UserService { //O serviço conversa com o repositório
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
	
		return repo.findAll();
	}
}
