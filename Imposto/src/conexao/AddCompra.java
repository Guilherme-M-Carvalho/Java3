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
public class AddCompra {
    private Conexao conexao;
    private Integer idPessoa;
    private String idProdutos;
    
    public AddCompra(Integer idPessoa, String idProdutos){
        this.conexao = new Conexao();
        this.idPessoa = idPessoa;
        this.idProdutos = idProdutos;
    }
    
    public void inserir(){
        String sql = "insert into compra (idPessoa , idProdutos) values (?,?)";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, idPessoa);
                sentenca.setString(2, idProdutos);
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConnection().close();
            }
            
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
