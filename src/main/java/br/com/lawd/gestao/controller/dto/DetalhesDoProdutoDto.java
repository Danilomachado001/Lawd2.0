package br.com.lawd.gestao.controller.dto;

import java.time.LocalDateTime;

import br.com.lawd.gestao.modelo.Produto;


public class DetalhesDoProdutoDto {
	
		private Long id;
		private String descricao;
		private String fabricante;
		private String marca;
		private String familia;
		private String codigoDeBarras;
		private String precoDeFabrica;
		private String precoDeVenda;
		private String precoPromocional;
		private String observação;
		private LocalDateTime dataCriacao;
		
		
		public DetalhesDoProdutoDto(Produto produto) {
			this.id = produto.getId();
			this.descricao = produto.getDescricao();
			this.fabricante = produto.getFabricante();
			this.marca = produto.getMarca();
			this.familia = produto.getFamilia();
			this.codigoDeBarras = produto.getCodigoDeBarras();
			this.precoDeVenda = produto.getPrecoDeVenda();
			this.precoPromocional = produto.getPrecoPromocional();
			this.observação = produto.getObservação();
	//		this.dataCriacao = produto.getDataCriacao();
			
			
			
			
			
		}


		public Long getId() {
			return id;
		}


		public String getDescricao() {
			return descricao;
		}


		public String getFabricante() {
			return fabricante;
		}


		public String getMarca() {
			return marca;
		}


		public String getFamilia() {
			return familia;
		}


		public String getCodigoDeBarras() {
			return codigoDeBarras;
		}


		public String getPrecoDeFabrica() {
			return precoDeFabrica;
		}


		public String getPrecoDeVenda() {
			return precoDeVenda;
		}


		public String getPrecoPromocional() {
			return precoPromocional;
		}


		public String getObservação() {
			return observação;
		}


		public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}


}
