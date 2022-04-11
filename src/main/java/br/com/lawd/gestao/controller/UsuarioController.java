package br.com.lawd.gestao.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lawd.gestao.controller.dto.DetalhesDoUsuarioDto;
import br.com.lawd.gestao.controller.dto.UsuarioDto;
import br.com.lawd.gestao.controller.form.AtualizacaoUsuarioForm;
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
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
		
	}
	
	//METODO DETALHAR USUARIO
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoUsuarioDto> detalhar(@PathVariable Long id) {
		Optional <Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoUsuarioDto (usuario.get()));	
		}
		return ResponseEntity.notFound().build();
		
	}
	
	//METODO ATUALIZAR USUARIO
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuarioForm form ){
		Optional <Usuario> Optional = usuarioRepository.findById(id);
		if (Optional.isPresent()) {
		
		Usuario usuario = form.atualizar(id, usuarioRepository);
		return ResponseEntity.ok(new UsuarioDto(usuario));
	}
		return ResponseEntity.notFound().build();
	
	}
	
	//METODO EXCLUIR USUARIO
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional <Usuario> Optional = usuarioRepository.findById(id);
		if (Optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.notFound().build();
		
		
	}

}
