package desafio.api.service;

import desafio.api.DTO.ProdutoRequest;
import desafio.api.DTO.ProdutoResponse;
import desafio.api.model.Produto;
import desafio.api.repository.ApiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApiService {

    private final ApiRepository repository;

    public ApiService(ApiRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoResponse> listarProdutos() {
        return repository.findAll()
                .stream()
                .map(produto -> new ProdutoResponse(
                        produto.getId(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getDescricao(),
                        produto.getImagem()
                ))
                .toList();
    }

    public ProdutoResponse buscarProdutoPorId(UUID id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getImagem()
        );
    }

    public ProdutoResponse criarProduto(ProdutoRequest request) {

        Produto produto = new Produto();
        produto.setId(UUID.randomUUID());
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setDescricao(request.getDescricao());
        produto.setImagem(request.getImagem());

        Produto salvo = repository.save(produto);

        return new ProdutoResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getPreco(),
                salvo.getDescricao(),
                salvo.getImagem()
        );
    }
}
