package com.algaworks.api.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.algaworks.api.domain.entities.enun.TipoLancamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	@Column(name="data_vencimento")
	private LocalDateTime dataVencimento;
	
	@NotNull
	@Column(name="data_pagamento")
	private LocalDateTime dataPagamento;
	
	@NotNull
	private BigDecimal valor;
	
	@NotBlank
	private String observacao;
	
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;
	
	@NotNull
	@ManyToOne
	private Pessoa pessoa;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
