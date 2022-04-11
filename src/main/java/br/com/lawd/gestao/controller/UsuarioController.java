package br.com.lawd.gestao.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lawd.gestao.controller.dto.UsuarioDto;
import br.com.lawd.gestao.controller.form.UsuarioForm;
import br.com.lawd.gestao.modelo.Usuario;
import br.com.lawd.gestao.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//MÉTODO LISTAR USUARIOS
	@GetMapping
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
	
	//MÉTODO CADASTRAR USUARIOS
	@PostMapping
	//INSERIR A ANOTAÇÃO @Valid depois do @RequestBody
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
		
	}

}
