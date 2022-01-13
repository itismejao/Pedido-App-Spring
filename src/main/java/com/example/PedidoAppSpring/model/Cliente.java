package com.example.PedidoAppSpring.model;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ADM-TI
 */
@Entity
public class Cliente {
    //private static final long serialVersionUID = -3327205615000527032L; //Corrigir erro
    
    @Id
    private String cpf;

    private String nome;
    private String endereco;
    private String email;

    public Cliente(){
        
    }
    
    public Cliente(String cpf, String nome, String endereco, String contato) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.email = contato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", email=" + email + '}';
    }
}
