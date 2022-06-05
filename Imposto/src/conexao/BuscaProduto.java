/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import backEnd.Pessoa;
import backEnd.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 55119
 */
public class BuscaProduto extends Produto{
    private Conexao conexao;
    private ArrayList<Produto> listaProduto;
    private Produto produto;
   
    public BuscaProduto(){
        this.conexao = new Conexao();
        this.listaProduto = new ArrayList<>();
    }
    
    public ArrayList<Produto> buscar(){

        String sql = "select * from produto";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultado = sentenca.executeQuery();
                while(resultado.next()){
                    this.produto = new Produto();
                    produto.setId(resultado.getInt("id"));
                    produto.setCod_barras(resultado.getInt("cod_barras"));
                    produto.setPreco(resultado.getInt("preco"));
                    produto.setNome(resultado.getString("nome"));
                    produto.setDescricao(resultado.getString("descricao"));
                    produto.setImg(resultado.getString("img"));
                    produto.setId_pessoa(resultado.getInt("id_pessoa"));
                    listaProduto.add(produto);
                }
                sentenca.close();
                this.conexao.getConnection().close();
            }
            
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return listaProduto;
    }
}
