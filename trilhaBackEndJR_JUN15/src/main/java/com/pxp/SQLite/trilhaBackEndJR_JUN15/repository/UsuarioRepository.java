package com.pxp.SQLite.trilhaBackEndJR_JUN15.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.napoleao.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	Optional<UsuarioEntity> findByLogin(String login);
}
