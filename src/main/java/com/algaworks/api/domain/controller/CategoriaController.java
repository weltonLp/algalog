package com.algaworks.api.domain.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.api.domain.entities.Categoria;
import com.algaworks.api.domain.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public List<Categoria> listar(){
		return repository.findAll();
	}
	
	@GetMapping("/buscaPorNome/{nome}")
	public ResponseEntity<Categoria> buscaPorNome(@PathVariable String nome){
		
		Optional<Categoria>opt = Optional.ofNullable(repository.findByNome(nome));
		
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	
		
	}
	
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria inserir(@Valid @RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
	
}










