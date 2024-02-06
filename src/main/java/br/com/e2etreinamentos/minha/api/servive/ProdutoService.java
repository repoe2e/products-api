package br.com.e2etreinamentos.minha.api.servive;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.e2etreinamentos.minha.api.model.Produto;

@Service
public class ProdutoService {

	private final List<Produto> produtos = new ArrayList<>();
	private long proxId = 1;

	public String cadastrarProduto(Produto produto) {
		produto.setId(proxId++);
		produtos.add(produto);
		return "Produto cadastrado com sucesso: " + produto.getNome();
	}

	public List<Object> listarProdutos() {
		if (produtos.isEmpty()) {
			List<Object> listaVazia = new ArrayList<Object>();
			listaVazia.add("Lista de produtos vazia.");
			return listaVazia;
		} else {
			return new ArrayList<>(produtos);
		}
	}

	public Produto removerProduto(Long id) {
		Produto produtoDeletado = produtos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

		if (produtoDeletado != null) {
			produtos.removeIf(p -> p.getId().equals(id));
		}

		return produtoDeletado;
	}

	public Optional<Produto> encontrarProdutoPorId(Long id) {
		return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
	}

	public void atualizarProduto(Long id, Produto produtoAtualizado) {
		encontrarProdutoPorId(id).ifPresent(produto -> {
			produto.setNome(produtoAtualizado.getNome());
			produto.setPreco(produtoAtualizado.getPreco());
		});
	}

}
