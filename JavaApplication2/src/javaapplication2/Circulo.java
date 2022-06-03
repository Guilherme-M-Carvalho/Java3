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
public class Circulo extends FiguraGeometrica{
    private double raio;
    
    public Circulo(String nome, double raio){
        super(nome);
        this.raio = raio;
    }
    
    @Override 
    public double calcularArea(){
        return Math.PI * raio * raio;
    }
    
    
}
