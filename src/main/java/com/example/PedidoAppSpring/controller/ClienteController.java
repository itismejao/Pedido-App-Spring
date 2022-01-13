/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PedidoAppSpring.controller;

import com.example.PedidoAppSpring.model.Cliente;
import com.example.PedidoAppSpring.model.ClienteRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping({"/cliente"})
public class ClienteController {
    
    private ClienteRepository clienteRepository;
    
    ClienteController(ClienteRepository clienteRepository) {
       this.clienteRepository = clienteRepository;
   }
    
    @GetMapping
    public List findAll(){
       return clienteRepository.findAll();
    }
    
    @GetMapping(path = {"/{cpf}"})
    public ResponseEntity findById(@PathVariable String cpf){
       return clienteRepository.findById(cpf)
               .map(record -> ResponseEntity.ok().body(record))
               .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente){
       return clienteRepository.save(cliente);
    }
    
    @PutMapping(value="/{cpf}")
    public ResponseEntity update(@PathVariable("cpf") String cpf,
                                          @RequestBody Cliente cliente) {
       return clienteRepository.findById(cpf)
               .map(record -> {
                   record.setNome(cliente.getNome());
                   record.setEndereco(cliente.getEndereco());
                   record.setEmail(cliente.getEmail());

                   Cliente updated = clienteRepository.save(record);
                   return ResponseEntity.ok().body(updated);
               }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(path ={"/{cpf}"})
    public ResponseEntity <?> delete(@PathVariable String cpf) {
       return clienteRepository.findById(cpf)
               .map(record -> {
                   clienteRepository.deleteById(cpf);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
}
