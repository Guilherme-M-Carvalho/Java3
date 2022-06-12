/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import backEnd.Produto;
import backEnd.Pessoa;
import backEnd.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class UpdateProduto extends Produto {
    private Conexao conexao;
    private String newData;

    

    
    public UpdateProduto( Integer preco, String descricao, String nome, Integer codBarras, String data, Integer idStatusProduto, String newData){
        
        conexao = new Conexao();
        
        this.cod_barras = codBarras;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.DataCriacao = data;
        this.idStatusProduto = idStatusProduto;
        this.newData = newData;
        
    }
            
    public void update(){

    String sql = "UPDATE produto SET preco = ?, descricao = ?, nome = ?, data_criacao = ?, idStatusProduto = ? where cod_barras = ? and data_criacao = ? limit 1" ;

    try{
        if ( this.conexao.conectar() ) {
            
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            System.out.println(sentenca.toString());
            
            System.out.println(preco);
            System.out.println(descricao);
            System.out.println(nome);
            System.out.println(newData);
            System.out.println(idStatusProduto);
            System.out.println(DataCriacao);
            System.out.println(idStatusProduto);
            System.out.println(cod_barras);
            sentenca.setInt(1, preco);
            System.out.println(sentenca.toString());
            sentenca.setString(2, descricao);
            System.out.println(sentenca.toString());
            sentenca.setString(3, nome);
            System.out.println(sentenca.toString());
            sentenca.setString(4, newData);
            System.out.println(sentenca.toString());
            sentenca.setInt(5, idStatusProduto);
            System.out.println(sentenca.toString());
            sentenca.setInt(6, cod_barras);
            System.out.println(sentenca.toString());
            sentenca.setString(7, DataCriacao);
            System.out.println(sentenca.toString());
            sentenca.execute();
            sentenca.close();
            
            conexao.getConnection().close();
            
            
        }
    }catch (SQLException ex){
        throw new RuntimeException(ex);
    }
        
}

    
}
    
