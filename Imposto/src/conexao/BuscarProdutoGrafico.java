/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import backEnd.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 55119
 */
public class BuscarProdutoGrafico {
    private Conexao conexao;
    private ArrayList<Produto> listaProduto;
    private Produto produto;
   
    public BuscarProdutoGrafico(){
        this.conexao = new Conexao();
        this.listaProduto = new ArrayList<>();
    }
    
    public ArrayList<Produto> buscarP(){

        String sql = "select distinct cod_barras, preco, nome, count(cod_barras) from produto group by cod_barras";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultado = sentenca.executeQuery();
                while(resultado.next()){
                    this.produto = new Produto();
                    produto.setCod_barras(resultado.getInt("cod_barras"));
                    produto.setPreco(resultado.getInt("preco"));
                    produto.setNome(resultado.getString("nome"));
                    produto.setQtd(resultado.getInt("count(cod_barras)"));
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