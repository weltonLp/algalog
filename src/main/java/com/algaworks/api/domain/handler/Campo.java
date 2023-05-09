package com.algaworks.api.domain.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Campo {
	private String nome;
	private String mensagem;
	
	public Campo(String nome, String mensagem) {
		super();
		this.nome = nome;
		this.mensagem = mensagem;
	}
	
	
}
