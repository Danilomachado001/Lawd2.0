package br.com.lawd.gestao.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lawd.gestao.controller.dto.UsuarioDto;
import br.com.lawd.gestao.modelo.Usuario;
import br.com.lawd.gestao.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping("/usuarios")
	@ResponseBody
	public List<UsuarioDto> lista(String nomeUsuario) {
		if (nomeUsuario == null) {
			List<Usuario> usuarios = usuarioRepository.findAll();
			return UsuarioDto.converter(usuarios);
		} else {
			List<Usuario> usuarios = usuarioRepository.findByNome(nomeUsuario);
			return UsuarioDto.converter(usuarios);

		}
	}

}
