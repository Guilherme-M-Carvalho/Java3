/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 55119
 */
public class CriarProduto {
    private Conexao conexao;
    
    public CriarProduto(){
        this.conexao = new Conexao();
    }
    
    public void inserir(){
        String sql = "insert into produto (cod_barras, preco, descricao, nome, img, id_pessoa) values (?,?,?,?,?,?)";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, 2);
                sentenca.setInt(2, 200);
                sentenca.setString(3, "Teste");
                sentenca.setString(4, "Teste nomr");
                sentenca.setString(5, "");
                sentenca.setInt(6, 1);
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConnection().close();
            }
            
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
