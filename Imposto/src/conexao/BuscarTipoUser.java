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
import backEnd.TipoUsuario;
/**
 *
 * @author 125111345741
 */
public class BuscarTipoUser {
    private Conexao conexao;
    private ArrayList<TipoUsuario> listaTipoUsuario;
    private TipoUsuario tipo;
    
    public BuscarTipoUser(){
        this.conexao = new Conexao();
        this.listaTipoUsuario = new ArrayList<>();
    }
    
    public ArrayList<TipoUsuario> buscar(){

        String sql = "select * from tipoUsuario";
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultado = sentenca.executeQuery();
                
                while(resultado.next()){
                    tipo = new TipoUsuario();
                    tipo.setIdTipoUsuario(resultado.getInt("id"));
                    tipo.setNomeTipoUsuario(resultado.getString("nome"));
                    listaTipoUsuario.add(tipo);
                }
                sentenca.close();
                
                this.conexao.getConnection().close();
            }
            
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return listaTipoUsuario;
    }
}
