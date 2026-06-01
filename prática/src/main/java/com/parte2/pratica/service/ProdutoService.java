package com.parte2.pratica.service;

import com.parte2.pratica.model.ProdutoModel;
import com.parte2.pratica.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca a classe como camada de serviço (regras de negócio)
public class ProdutoService {

    @Autowired //Inejeta o ProdutoRepository automaticamente
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public Optional<ProdutoModel> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
}