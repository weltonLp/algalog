package com.algaworks.api.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.api.domain.entities.Lancamento;
import com.algaworks.api.domain.repositories.LancamentoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	
	private LancamentoRepository repository;
	
	@GetMapping
	public List<Lancamento> listar(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Lancamento inserir(@Valid @RequestBody Lancamento lancamento){
		
		return repository.save(lancamento);
		
	}
	
	
	
}
