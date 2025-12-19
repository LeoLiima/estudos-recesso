package desafio.api.controller;

import desafio.api.DTO.ProdutoRequest;
import desafio.api.DTO.ProdutoResponse;
import desafio.api.model.Produto;
import desafio.api.service.ApiService;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/produtos")
public class ApiController {

    @Autowired
    private final ApiService service;

    public ApiController(ApiService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> getProd() {
        List<Produto> produtos = service.getProdutos();
        List<ProdutoResponse> response = new ArrayList<>();

        for (Produto p : produtos) {
            ProdutoResponse dto = new ProdutoResponse(
                    p.getNome(),
                    p.getPreco(),
                    p.getDescricao(),
                    p.getImagemUrl()
            );
            response.add(dto);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProduto(@PathVariable Long id) {
        // Aqui você já tem o ID da URL disponível
        Optional<Produto> produto = service.getProdutosPorId(id);

        if (produto.isPresent()) {
            Produto p = produto.get();
            ProdutoResponse response = new ProdutoResponse(
                    p.getNome(),
                    p.getPreco(),
                    p.getDescricao(),
                    p.getImagemUrl()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> postProduto(@RequestBody @Valid ProdutoRequest request) {
        // Converter DTO de request para Entity
        Produto produto = new Produto();
        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setDescricao(request.getDescricao());
        produto.setImagemUrl(request.getImagemUrl());

        // Salvar no banco via Service
        Produto salvo = service.postProduto(produto);

        // Converter Entity para DTO de resposta
        ProdutoResponse response = new ProdutoResponse(
                salvo.getNome(),
                salvo.getPreco(),
                salvo.getDescricao(),
                salvo.getImagemUrl()
        );

        // Retorna o body com os dados do produto salvo
        return ResponseEntity.ok(response);
    }


}
