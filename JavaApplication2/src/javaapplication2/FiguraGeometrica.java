/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author 125111345741
 */
public abstract class FiguraGeometrica {
    
    private String nome;
    
    public FiguraGeometrica(String nome){
        this.nome = nome;
    }
    
    public double calcularArea(){
        return 0;
    }
    
    public String getNome(){
        return this.nome;
    }
}
