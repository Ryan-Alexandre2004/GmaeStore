package com.generation.gamestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamestore.model.Categoria;
import com.generation.gamestore.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Categoria buscarPorId(@PathVariable Long id) {
		return categoriaRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public Categoria criar(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@PutMapping("/{id}")
	public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
		categoria.setId(id);
		return categoriaRepository.save(categoria);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
}
