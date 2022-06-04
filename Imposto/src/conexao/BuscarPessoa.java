/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import backEnd.Pessoa;
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
    private ArrayList<Pessoa> listaPessoa;
    private Pessoa pessoa;
    
    //tu e gay
    public BuscarPessoa(){
        this.conexao = new Conexao();
        this.listaPessoa = new ArrayList<>();
    }
    
    public ArrayList<Pessoa> buscar(){

        String sql = "select * from vw_pessoa";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultado = sentenca.executeQuery();
                while(resultado.next()){
                    this.pessoa = new Pessoa();
                    pessoa.setId(resultado.getInt("id"));
                    pessoa.setNome(resultado.getString("nome"));
                    pessoa.setEmail(resultado.getString("email"));
                    pessoa.setSenha(resultado.getString("senha"));
                    pessoa.setDataCriacao(resultado.getString("data_criacao"));
                    pessoa.setIdTipoUsuario(resultado.getInt("idTipoUsuario"));
                    pessoa.setNomeTipoUsuario(resultado.getString("nome_tipo_usuario"));
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
