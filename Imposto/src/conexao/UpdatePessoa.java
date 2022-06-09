/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import backEnd.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author pedro
 */
public class UpdatePessoa  extends Pessoa{
    private Conexao conexao;
    
    public UpdatePessoa( int id, String nome, String email, String senha, Integer idTipoUsuario){
        this.conexao = new Conexao();

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idTipoUsuario = idTipoUsuario;
    }
    
    public void update(){

    String sql = "UPDATE pessoa SET nome = ?, email = ?, senha = ? , idTipoUsuario = ?  WHERE id = ? ";

    try{
        if ( this.conexao.conectar() ) {
            
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            
            sentenca.setString(1, nome);
            sentenca.setString(2, email);
            sentenca.setString(3, nome);
            sentenca.setInt(4, idTipoUsuario);
            sentenca.setInt(5, id);
            
            sentenca.execute();
            sentenca.close();
            
            conexao.getConnection().close();
            
            
        }
    }catch (SQLException ex){
        throw new RuntimeException(ex);
    }
}
}
