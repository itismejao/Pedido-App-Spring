package com.example.PedidoAppSpring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmsiq
 */
@Entity
public class Produto {
    
    @Id
    private int codigo;
    private String nome;
    private double preco;
    private String img;
    private int qtd;
    private String atributos;
    private float avaliacao;
    
    public Produto(){
        
    }
    
    public Produto(String nome, double preco){
       setNome(nome);
       setPreco(preco);
    }
    
    public Produto(int codigo, String nome, double preco, String img){
       setCodigo(codigo);
       setNome(nome);
       setPreco(preco);
       setImg(img);
    }
   
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String toString(){
        return "Código: "+getCodigo()+"\n"+
                "Nome: "+getNome()+"\n"+
                "Preço: "+getPreco()+"\n"+
                "-------------------------\n";
    }    

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the atributos
     */
    public String getAtributos() {
        return atributos;
    }

    /**
     * @param atributos the atributos to set
     */
    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    /**
     * @return the avaliacao
     */
    public float getAvaliacao() {
        return avaliacao;
    }

    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
}