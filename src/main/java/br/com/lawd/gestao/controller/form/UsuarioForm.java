package br.com.lawd.gestao.controller.form;

import com.sun.istack.NotNull;

import br.com.lawd.gestao.modelo.Usuario;

public class UsuarioForm {
	@NotNull
	//falta acrescentar @NotEmpty e @Length(min = 5) NÃO ESTA CRIANDO O IMPORT
	private String nome;
	@NotNull
	private String email;
	@NotNull
	private String senha;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario converter() {
		
		return new Usuario(nome, email, senha);
	}
	
	
	

}
