package com.algaworks.api.domain.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.api.domain.entities.Pessoa;
import com.algaworks.api.domain.repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@GetMapping
	public List<Pessoa> listar(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa inserir(@Valid @RequestBody Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long id){
		
		return repository.findById(id)
				.map(pessoa -> ResponseEntity.ok(pessoa))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/buscaPorNome/{nome}")
	public ResponseEntity<Pessoa> buscarPorNome(@PathVariable String nome){
		
		Optional<Pessoa> opt = Optional.ofNullable(repository.findByNome(nome));
		
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
			
		}else {
			repository.deleteById(id);
		
			return ResponseEntity.noContent().build();
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa){
		
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
			
		}else {
			pessoa.setId(id);
			repository.save(pessoa);
			return ResponseEntity.ok(pessoa);
		}
	}
	
	
	
}










