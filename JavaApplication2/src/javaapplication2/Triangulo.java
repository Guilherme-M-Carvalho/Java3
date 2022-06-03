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
public class Triangulo extends FiguraGeometrica {

    private double base;
    private double altura;
    
    public Triangulo(String nome, double base, double altura){
        super(nome);
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea(){
        return base * altura;
    }
}
