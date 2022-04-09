package br.com.lawd.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lawd.gestao.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByNome(String nomeUsuario);
	

}
