package com.exemplo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.projeto.entities.Ordem;

public interface OrdemRepository extends JpaRepository<Ordem, Long> {

}
