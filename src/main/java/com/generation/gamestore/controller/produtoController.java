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

import com.generation.gamestore.model.Produto;
import com.generation.gamestore.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class produtoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return produtoRepository.findById(id).orElseThrow();
	}

	@PostMapping
	public Produto criar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		produto.setId(id);
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
}
