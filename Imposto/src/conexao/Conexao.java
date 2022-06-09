/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author 125111345741
 */
public class Conexao {
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;
    
    public Conexao(){
        this.servidor = "localhost";
        this.banco = "sistema";
        this.usuario = "root";
        this.senha = "admin";
    }
    
    public boolean conectar(){
        try{
            this.conexao = DriverManager.getConnection("jdbc:mysql://"+this.servidor+"/"+this.banco,this.usuario,this.senha);
            return true;
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Connection getConnection(){
        return conexao;
    }
}
