package com.exemplo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.projeto.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
