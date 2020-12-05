/*
		Classe usuário dentro do pacote domain (Dominios).
*/

package com.victor.projeto_afrodev.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="user") //Informa que se trata de uma coleção ("tabela") do MongoDB.
public class User implements Serializable { //Serializable necessário para conversão dos objetos em bytes e assim possa trafegar em redes, gravados em arquivos etc.

	
	private static final long serialVersionUID = 1L; // Número de versão padrão do Serializable.
	
	@Id
	private String id;
	private String name;
	private String email;
	
	
	public User() {
	
	}

	
	public User(String id, String name, String email) {
		
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}


	public String getId() {
		
		return id;
	}
	
	
	public void setId(String id) {
		
		this.id = id;
	}
	
	
	public String getName() {
		
		return name;
	}
	
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	
	public String getEmail() {
		
		return email;
	}
	
	
	public void setEmail(String email) {
		
		this.email = email;
	}

	//Métodos hashCode e equals para que os objetos possam ser comparáveis.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
