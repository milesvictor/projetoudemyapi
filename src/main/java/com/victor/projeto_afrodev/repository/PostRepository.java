/*
	Classe de repositório da postagem. Operaçõpes como salvar, recuperar deletar, atualizar etc.
*/

package com.victor.projeto_afrodev.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victor.projeto_afrodev.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
