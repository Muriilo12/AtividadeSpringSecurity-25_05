package com.parte2.pratica.controller;


import com.parte2.pratica.model.ProdutoModel;
import com.parte2.pratica.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/produtos")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAllProduto(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarProduto(@PathVariable Long id){
        Optional<ProdutoModel> produto = produtoService.buscarPorId(id);

        if(produto.isPresent()){
            return  ResponseEntity.ok(produto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel novo = produtoService.criarProduto(produtoModel);
        return  ResponseEntity.status(201).body(novo);
    }


}