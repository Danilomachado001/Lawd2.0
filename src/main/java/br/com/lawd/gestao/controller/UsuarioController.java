package br.com.lawd.gestao.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lawd.gestao.modelo.Usuario;
import br.com.lawd.gestao.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/usuarios")
	@ResponseBody
	public List<Usuario> lista() {
		Usuario usuario = new Usuario("Danilo","danilo@gmail.com","123456");
		
		return Arrays.asList(usuario, usuario);
	}

}
