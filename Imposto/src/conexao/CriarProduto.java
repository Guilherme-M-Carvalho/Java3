/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import backEnd.Produto;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 55119
 */
public class CriarProduto extends Produto{
    private Conexao conexao;
    
    public CriarProduto(Integer cod_barras, Integer preco, String descricao, String nome, String img, Integer idUsuarioLogado, Integer idStatusProduto, String data){
        this.conexao = new Conexao();
        this.id_pessoa = idUsuarioLogado;
        this.cod_barras = cod_barras;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.img = img;
        this.idStatusProduto = idStatusProduto;
        this.DataCriacao = data;
    }
    
    public void inserir(){
        String sql = "insert into produto (cod_barras, preco, descricao, nome, img, id_pessoa, idStatusProduto, data_criacao) values (?,?,?,?,?,?,?,?)";
        
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, cod_barras);
                sentenca.setInt(2, preco);
                sentenca.setString(3, descricao);
                sentenca.setString(4, nome);
                sentenca.setString(5, img);
                sentenca.setInt(6, id_pessoa);
                sentenca.setInt(7, idStatusProduto);
                sentenca.setString(8, DataCriacao);
                System.out.println(DataCriacao);
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConnection().close();
            }
            
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
