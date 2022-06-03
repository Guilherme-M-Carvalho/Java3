/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author 55119
 */
public class Pessoa {
    private Conexao conexao;
    public String nome;
    public String telefone;
    public String administrador;
    public String idEmpresa;
    
    public Pessoa(){
        this.conexao = new Conexao();
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    public ArrayList<Pessoa> login(String email, String senha){

        ArrayList<Pessoa> listaPessoa = new ArrayList<>();
        String sql = "select * from pessoa";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultado = sentenca.executeQuery();
                
                while(resultado.next()){
                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome(resultado.getString("nome"));
                    pessoa.setTelefone(resultado.getString("telefone"));
                    pessoa.setAdministrador(resultado.getString("administrador"));
                    pessoa.setIdEmpresa(resultado.getString("idEmpresa"));
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
