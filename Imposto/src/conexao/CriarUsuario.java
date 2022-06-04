/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;
import backEnd.Pessoa;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
/**
 *
 * @author 125111345741
 */
public class CriarUsuario extends Pessoa{
    private Conexao conexao;
    
    public CriarUsuario(String nome, String email, String senha, Integer idTipo){
        this.conexao = new Conexao();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idTipoUsuario = idTipo;
    }
    
    public void inserir(){
        String sql = "insert into pessoa (nome, email, senha, idTipoUsuario) values (?,?,?,?)";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1, nome);
                sentenca.setString(2, email);
                sentenca.setString(3, senha);
                sentenca.setInt(4, idTipoUsuario);
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConnection().close();
            }
            
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}

    
    