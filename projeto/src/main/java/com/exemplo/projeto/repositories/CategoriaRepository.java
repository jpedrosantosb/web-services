package com.exemplo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.projeto.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
