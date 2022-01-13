/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PedidoAppSpring.controller;

import com.example.PedidoAppSpring.model.Produto;
import com.example.PedidoAppSpring.model.ProdutoRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADM-TI
 */
@CrossOrigin
@RestController
@RequestMapping({"/produto"})
public class ProdutoController {
    
    private ProdutoRepository produtoRepository;
    
    ProdutoController(ProdutoRepository produtoRepository) {
       this.produtoRepository = produtoRepository;
   }
    
    @GetMapping
    public List findAll(){
       return produtoRepository.findAll();
    }
    
    @GetMapping(path = {"/{codigo}"})
    public ResponseEntity findById(@PathVariable int codigo){
       return produtoRepository.findById(codigo)
               .map(record -> ResponseEntity.ok().body(record))
               .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Produto create(@RequestBody Produto produto){
       return produtoRepository.save(produto);
    }
    
    @PutMapping(value="/{codigo}")
    public ResponseEntity update(@PathVariable("codigo") int codigo,
                                          @RequestBody Produto produto) {
       return produtoRepository.findById(codigo)
               .map(record -> {
                   record.setNome(produto.getNome());
                   record.setCodigo(produto.getCodigo());
                   record.setPreco(produto.getPreco());

                   Produto updated = produtoRepository.save(record);
                   return ResponseEntity.ok().body(updated);
               }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(path ={"/{codigo}"})
    public ResponseEntity <?> delete(@PathVariable int codigo) {
       return produtoRepository.findById(codigo)
               .map(record -> {
                   produtoRepository.deleteById(codigo);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
    
}
