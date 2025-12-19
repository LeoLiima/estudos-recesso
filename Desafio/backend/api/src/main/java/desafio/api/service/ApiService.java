package desafio.api.service;

import desafio.api.model.Produto;
import desafio.api.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {

    @Autowired
    private final ApiRepository repository;

    public ApiService(ApiRepository repository) {
        this.repository = repository;
    }

    public List<Produto> getProdutos(){
        return repository.findAll();
    }

    public Optional<Produto> getProdutosPorId(Long id) {
        return repository.findById(id);
    }

    public Produto postProduto(Produto prod){
        return repository.save(prod);
    }

}
