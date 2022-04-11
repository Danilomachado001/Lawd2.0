package br.com.lawd.gestao.controller.dto;

import br.com.lawd.gestao.modelo.Usuario;

public class DetalhesDoUsuarioDto {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	public DetalhesDoUsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	

}
