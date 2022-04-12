package br.com.lawd.gestao.controller.form;

import br.com.lawd.gestao.modelo.Produto;
import br.com.lawd.gestao.repository.ProdutoRepository;

public class AtualizacaoProdutoForm {

	private String descricao;
	private String fabricante;
	private String marca;
	private String familia;
	private String codigoDeBarras;
	private String precoDeFabrica;
	private String precoDeVenda;
	private String precoPromocional;
	private String observação;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public String getPrecoDeFabrica() {
		return precoDeFabrica;
	}
	public void setPrecoDeFabrica(String precoDeFabrica) {
		this.precoDeFabrica = precoDeFabrica;
	}
	public String getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(String precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	public String getPrecoPromocional() {
		return precoPromocional;
	}
	public void setPrecoPromocional(String precoPromocional) {
		this.precoPromocional = precoPromocional;
	}
	public String getObservação() {
		return observação;
	}
	public void setObservação(String observação) {
		this.observação = observação;
	}
	
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto= produtoRepository.getOne(id);
		
		produto.setDescricao(this.descricao);
		produto.setFabricante(this.fabricante);
		produto.setMarca(this.marca);
		produto.setCodigoDeBarras(this.codigoDeBarras);
		produto.setPrecoDeFabrica(this.precoDeFabrica);
		produto.setPrecoDeVenda(this.precoDeVenda);
		produto.setPrecoPromocional(this.precoPromocional);
		produto.setObservação(this.observação);
		
				
		return produto;
	}

	
}
