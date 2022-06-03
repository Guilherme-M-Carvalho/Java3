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
public class Quadrado extends FiguraGeometrica {
    private double lado;
    
    public Quadrado(String nome, double lado){
        super(nome);
        this.lado = lado;
    }
    
    @Override
    public double calcularArea(){
        return Math.pow(lado, 2);
    }
}
