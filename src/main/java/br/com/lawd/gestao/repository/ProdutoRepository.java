package br.com.lawd.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lawd.gestao.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findByDescricao(String nomeProduto);

}
