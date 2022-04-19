package br.com.lawd.gestao.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.lawd.gestao.modelo.Produto;

public class ProdutoForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	@NotNull @NotEmpty @Length(min = 8)
	private String precoDeVenda;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(String precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	
	public Produto converter() {
		
			return new Produto(descricao, precoDeVenda);
		
	}
	
	

}
