package br.com.ifpe.tads.projetoCasamentoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.tads.projetoCasamentoWeb.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
