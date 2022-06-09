/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;
import backEnd.Pessoa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author pedro
 */
public class DeleteUsuarios extends Pessoa{
    private Conexao conexao;
    
    public DeleteUsuarios( int id){
        this.conexao = new Conexao();

        this.id = id;
    }
    
    public void delete(){

    String sql = "delete from pessoa WHERE id = ? ";

    try{
        if ( this.conexao.conectar() ) {
            
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            
            sentenca.setInt(1, this.id);
            sentenca.execute();
            sentenca.close();
            
            conexao.getConnection().close();
            
            
        }
    }catch (SQLException ex){
        throw new RuntimeException(ex);
    }
}
}
