package br.com.e2etreinamentos.minha.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.e2etreinamentos.minha.api.model.Produto;
import br.com.e2etreinamentos.minha.api.servive.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	  
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@PostMapping
	public ResponseEntity<String> cadastrarProduto(@RequestBody Produto produto) {
		String mensagem = produtoService.cadastrarProduto(produto);
		return ResponseEntity.ok(mensagem);	
	}
	
	@GetMapping
	public List<Object> listarProdutos(){
		return produtoService.listarProdutos();
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		produtoService.removerProduto(id);
	}
	
	@PutMapping("/{id}")
    public void atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        produtoService.atualizarProduto(id, produtoAtualizado);
    }
}
