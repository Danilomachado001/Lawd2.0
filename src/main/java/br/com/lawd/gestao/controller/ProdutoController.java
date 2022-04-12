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

import br.com.lawd.gestao.controller.dto.DetalhesDoProdutoDto;
import br.com.lawd.gestao.controller.dto.ProdutoDto;
import br.com.lawd.gestao.controller.form.AtualizacaoProdutoForm;
import br.com.lawd.gestao.controller.form.ProdutoForm;
import br.com.lawd.gestao.modelo.Produto;
import br.com.lawd.gestao.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
			
		@Autowired
		private ProdutoRepository produtoRepository;
		
		//MÉTODO LISTAR PRODUTOS
		@GetMapping
		@ResponseBody
		public List<ProdutoDto> lista(String descricaoProduto) {
			if (descricaoProduto == null) {
				List<Produto> produtos = produtoRepository.findAll();
				return ProdutoDto.converter(produtos);
			} else {
				List<Produto> produtos = produtoRepository.findByDescricao(descricaoProduto);
				return ProdutoDto.converter(produtos);

			}
		}
		
		//MÉTODO CADASTRAR PRODUTOS
		@PostMapping
		@Transactional
		public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
			Produto produto = form.converter();
			produtoRepository.save(produto);
			
			URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
			return ResponseEntity.created(uri).body(new ProdutoDto(produto));
			
		}
		
		//METODO DETALHAR PRODUTOS
		@GetMapping("/{id}")
		public ResponseEntity<DetalhesDoProdutoDto> detalhar(@PathVariable Long id) {
			Optional <Produto> produto = produtoRepository.findById(id);
			if (produto.isPresent()) {
				return ResponseEntity.ok(new DetalhesDoProdutoDto (produto.get()));	
			}
			return ResponseEntity.notFound().build();
			
		}
		
		//METODO ATUALIZAR PRODUTOS
		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoProdutoForm form ){
			Optional <Produto> Optional = produtoRepository.findById(id);
			if (Optional.isPresent()) {
			
			Produto produto = form.atualizar(id, produtoRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
			return ResponseEntity.notFound().build();
		
		}
		
		//METODO EXCLUIR PRODUTOS
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> remover(@PathVariable Long id){
			Optional <Produto> Optional = produtoRepository.findById(id);
			if (Optional.isPresent()) {
				produtoRepository.deleteById(id);
				return ResponseEntity.ok().build(); 
			}
			return ResponseEntity.notFound().build();
			
			
		}

	}
