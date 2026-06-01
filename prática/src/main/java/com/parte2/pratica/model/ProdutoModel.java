package com.parte2.pratica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data //Gera automaticamente getters, setters, toString (Lombok)
@Entity //Diz que a classe representa uma tabela no banco de dados
public class ProdutoModel {

    @Id //Marca o campo como chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GeneratedValue o ID é gerado automaticamente pelo banco
    private Long id;
    private String nome;

    public ProdutoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}