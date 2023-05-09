package com.algaworks.api.domain.handler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Problema {
	
	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	
	private List<Campo> campos = new ArrayList<>();

	public Problema(Integer status, OffsetDateTime dataHora, String titulo) {
		super();
		this.status = status;
		this.dataHora = dataHora;
		this.titulo = titulo;
		
	}
	
	
	
}
