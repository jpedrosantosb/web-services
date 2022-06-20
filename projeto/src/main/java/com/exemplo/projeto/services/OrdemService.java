package com.exemplo.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.projeto.entities.Ordem;
import com.exemplo.projeto.repositories.OrdemRepository;

@Service
public class OrdemService {

	@Autowired
	private OrdemRepository repository;

	public List<Ordem> findAll() {
		return repository.findAll();
	}

	public Ordem findById(Long id) {
		Optional<Ordem> obj = repository.findById(id);
		return obj.get();
	}
}
