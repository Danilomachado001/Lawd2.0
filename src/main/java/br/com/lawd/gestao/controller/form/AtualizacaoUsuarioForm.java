package br.com.lawd.gestao.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.lawd.gestao.modelo.Usuario;
import br.com.lawd.gestao.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
//	@NotNull @NotEmpty @Length(min = 10)
//	private String email;
	@NotNull @NotEmpty @Length(min = 8)
	private String senha;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		
		usuario.setNome(this.nome);
		usuario.setSenha(this.senha);
		
		return usuario;
	}

	
}
