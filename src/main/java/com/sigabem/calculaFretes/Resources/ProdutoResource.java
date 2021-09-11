/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigabem.calculaFretes.Resources;

import com.sigabem.calculaFretes.Model.Produto;
import com.sigabem.calculaFretes.Repository.ProdutoRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tasso
 */
@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto getOneProduto(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping
    public HashMap<String, Object> saveProduto(@RequestBody Produto produto) {
        HashMap<String, Object> map = new HashMap<>();
        Produto prod = new Produto(
                produto.getNomeDestinatario(),
                produto.getPeso(),
                produto.getCepOrigem(),
                produto.getCepDestino()
        );
        try {
            produtoRepository.save(prod);
            map.put("vlTotalFrete", prod.getVlTotalFrete());
            map.put("dataPrevistaEntrega", prod.getDataPrevistaEntraga());
            map.put("cepOrigem", prod.getCepOrigem());
            map.put("cepDestino", prod.getCepDestino());
        } catch (Exception e) {
            map.put("Erro", e.getMessage());
        }
        return map;

    }

}
