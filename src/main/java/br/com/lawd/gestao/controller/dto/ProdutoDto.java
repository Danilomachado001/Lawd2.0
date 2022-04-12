package br.com.lawd.gestao.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lawd.gestao.modelo.Produto;

public class ProdutoDto {
	
	private Long id;
	private String descricao;
	private String marca;
	private String precoDeVenda;
	
	
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.marca = produto.getDescricao();
		this.precoDeVenda = produto.getPrecoDeVenda();
	}
		
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getMarca() {
		return marca;
	}
	public String getPrecoDeVenda() {
		return precoDeVenda;
	}

	public static List<ProdutoDto> converter(List<Produto> produto) {
		return produto.stream().map(ProdutoDto::new).collect(Collectors.toList());
				
		
	}
	
	

}
