/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexao.Conexao;
/**
 *
 * @author 125111345741
 */
public class BuscarPessoa {
    private Conexao conexao;
    
    
    public BuscarPessoa(){
        this.conexao = new Conexao();
    }
    
    public ArrayList<Pessoa> buscar(){

        ArrayList<Pessoa> listaPessoa = new ArrayList<>();
        String sql = "select * from pessoa";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultado = sentenca.executeQuery();
                
                while(resultado.next()){
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(resultado.getInt("id"));
                    pessoa.setNome(resultado.getString("nome"));
                    pessoa.setEmail(resultado.getString("email"));
                    pessoa.setSenha(resultado.getString("senha"));
                    pessoa.setDataCriacao(resultado.getString("data_criacao"));
                    pessoa.setIdTipoUser(resultado.getInt("idTipoUsuario"));
                    listaPessoa.add(pessoa);
                }
                
                
                sentenca.close();
                
                this.conexao.getConnection().close();
            }
            
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return listaPessoa;
    }
}
