/*
	Classe de repositório do usuário. Operaçõpes como salvar, recuperar deletar, atualizar etc.
*/

package com.victor.projeto_afrodev.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victor.projeto_afrodev.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	
}
