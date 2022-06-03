/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.Scanner;

/**
 *
 * @author 125111345741
 */
public class main {

     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite o nome do circulo");
        String nomeCirculo = entrada.next();
        System.out.println("Digite o raio do circulo");
        Double raioCirculo = entrada.nextDouble();
        
        System.out.println("\nDigite o nome do triangulo");
        String nomeTriangulo = entrada.next();
        System.out.println("Digite a base do triangulo");
        Double baseTriangulo = entrada.nextDouble();
        System.out.println("\nDigite a altura do triangulo");
        Double alturaTriangulo = entrada.nextDouble();

        System.out.println("Digite o nome do quadrado");
        String nomeQuadrado = entrada.next();
        System.out.println("\nDigite o lado do quadrado");
        Double ladoQuadrado = entrada.nextDouble();
        
        Circulo c1 = new Circulo(nomeCirculo, raioCirculo); 
        Triangulo t1 = new Triangulo(nomeTriangulo, baseTriangulo, alturaTriangulo);
        Quadrado q1 = new Quadrado(nomeQuadrado, ladoQuadrado);
        
        System.out.println(q1.calcularArea());
        
    }
}
