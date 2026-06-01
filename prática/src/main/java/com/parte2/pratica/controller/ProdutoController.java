package com.parte2.pratica.controller;


import com.parte2.pratica.model.ProdutoModel;
import com.parte2.pratica.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/produtos") //Define a rota da base da classe, todos os endpoints desse controller serão acessados em /produtos.
@RestController //Diz que a classe é um controller que retorna JSON.
public class ProdutoController {

    @Autowired //Injeta o service automaticamente (sem usar new).
    private ProdutoService produtoService;

    @GetMapping //Responde requisições GET (buscar dados)
    public ResponseEntity<List<ProdutoModel>> findAllProduto(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}") //GET buscando por ID na url
    public ResponseEntity<ProdutoModel> buscarProduto(@PathVariable Long id){ //PathVariable pega o {id} da URL e usa no metodo.
        Optional<ProdutoModel> produto = produtoService.buscarPorId(id);

        if(produto.isPresent()){
            return  ResponseEntity.ok(produto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping //Responde requisições POST criar dados)
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel novo = produtoService.criarProduto(produtoModel);
        return  ResponseEntity.status(201).body(novo);
    }


}