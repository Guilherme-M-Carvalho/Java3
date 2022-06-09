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
    

    
    public UpdateProduto( Integer preco, String descricao, String nome, Integer id){
        
        conexao = new Conexao();
        
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        
    }
            
    public void update(){

    String sql = "UPDATE produto SET preco = ?, descricao = ?, nome = ?  WHERE id = ? ";

    try{
        if ( this.conexao.conectar() ) {
            
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            
            sentenca.setInt(1, preco);
            sentenca.setString(2, descricao);
            sentenca.setString(3, nome);
            sentenca.setInt(4, id);
            
            sentenca.execute();
            sentenca.close();
            
            conexao.getConnection().close();
            
            
        }
    }catch (SQLException ex){
        throw new RuntimeException(ex);
    }
        
}

    
}
    
