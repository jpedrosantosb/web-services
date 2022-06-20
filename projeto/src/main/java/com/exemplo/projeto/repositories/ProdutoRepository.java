package com.exemplo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.projeto.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
