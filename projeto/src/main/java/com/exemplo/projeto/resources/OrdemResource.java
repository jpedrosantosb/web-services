package com.exemplo.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.projeto.entities.Ordem;
import com.exemplo.projeto.services.OrdemService;

@RestController
@RequestMapping(value = "/ordens")
public class OrdemResource {

	@Autowired
	private OrdemService service;

	@GetMapping
	public ResponseEntity<List<Ordem>> findAll() {
		List<Ordem> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ordem> findById(@PathVariable Long id) {
		Ordem obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
