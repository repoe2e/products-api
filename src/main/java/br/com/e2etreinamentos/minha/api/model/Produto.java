package br.com.e2etreinamentos.minha.api.model;

import java.math.BigDecimal;

public class Produto {

	private Long id;
	private String nome;
	private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal d) {
		this.preco = d;
	}

}
