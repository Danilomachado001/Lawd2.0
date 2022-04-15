package br.com.lawd.gestao.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusProduto status = StatusProduto.ATIVO;
	private String fabricante;
	private String marca;
	private String familia;
	private String codigoDeBarras;
	private String precoDeFabrica;
	private String precoDeVenda;
	private String precoPromocional;
	private String observacao;
	//private LocalDateTime dataCriacao;
	@ManyToOne
	private Usuario usuario;
		
	public Produto() {
	}
	
	public Produto(@NotEmpty String descricao, @NotEmpty String precoDeVenda) {
	}

	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public StatusProduto getStatus() {
		return status;
	}

	public void setStatus(StatusProduto status) {
		this.status = status;
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



	public String getObservação() {
		return observacao;
	}



	public void setObservação(String observação) {
		this.observacao = observação;
	}



	/*	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}



	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
*/


	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public String getPrecoPromocional() {
		return precoPromocional;
	}



	public void setPrecoPromocional(String precoPromocional) {
		this.precoPromocional = precoPromocional;
	}
	

}
