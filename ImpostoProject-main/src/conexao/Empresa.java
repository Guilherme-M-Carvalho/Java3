/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author 55119
 */
public class Empresa {
    private Conexao conexao;
    
    public Empresa(){
        this.conexao = new Conexao();
    }
    
    public void inserir(){
        String sql = "insert into empresa (cnpj, nome_fantasia, razao_social, situacao) values (?,?,?,?)";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, 2123432);
                sentenca.setString(2, "EMPRESA TESTE");
                sentenca.setString(3, "RAZAO TESTE");
                sentenca.setString(4, "Ativo");
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConnection().close();
            }
            
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
