/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;
import com.mysql.cj.util.StringUtils;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import conexao.CriarUsuario;
import conexao.BuscarPessoa;
import java.util.ArrayList;
/**
 *
 * @author 125111345741
 */
public class Pessoa {
    private Conexao conexao;
    private CriarUsuario criarUsuario;
    private BuscarPessoa buscarPessoa;
    public Integer id;
    public String nome;
    public String email;
    public String senha;
    public String dataCriacao;
    public Integer idTipoUser;
    public ArrayList<String> nomeLista;
    public ArrayList<String> emailLista;
    public ArrayList<String> senhaLista;
    public ArrayList<String> dataCriacaoLista;
    public ArrayList<Integer> idTipoUserLista;
    public ArrayList<Integer> idLista;

    
   
    public Pessoa(){
        this.criarUsuario = new CriarUsuario();
        this.buscarPessoa = new BuscarPessoa();
    }
    
    public void setIdTipoUser(int idTipoUser) {
        this.idTipoUser = idTipoUser;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public boolean inserirUsuario(String nome, String email, String senha, Integer idTipo){
        if(!StringUtils.isNullOrEmpty(nome) && !StringUtils.isNullOrEmpty(email) && !StringUtils.isNullOrEmpty(senha) && !StringUtils.isNullOrEmpty(idTipo.toString())){
            criarUsuario.inserir(nome, email, senha, idTipo);
            return true;
        }
        return false;
    }
    
    public boolean validarCB(Integer valor){
        if(valor > 0){
            return true;
        } 
        return false;
    }
    
    public void buscarPessoa(){
        BuscarPessoa p1 = new BuscarPessoa();
        ArrayList<Pessoa> Pessoas = p1.buscar();
        idLista = new ArrayList<>();
        idTipoUserLista = new ArrayList<>();
        nomeLista = new ArrayList<>();
        emailLista = new ArrayList<>();
        senhaLista = new ArrayList<>();
        dataCriacaoLista = new ArrayList<>();
        
        
        for(Pessoa p: Pessoas){
            this.idLista.add(p.id);
            this.idTipoUserLista.add(p.idTipoUser);
            this.nomeLista.add(p.nome);
            this.emailLista.add(p.email);
            this.senhaLista.add(p.senha);
            this.dataCriacaoLista.add(p.dataCriacao);
   
        }  
    }
    
    public boolean vLogin(String email, String senha){
        buscarPessoa();
        if(!StringUtils.isNullOrEmpty(email) && !StringUtils.isNullOrEmpty(senha)){
            for (int i = 0; i < idLista.size(); i++) {
                if(emailLista.get(i).equals(email)  && senhaLista.get(i).equals(senha)){
                    return true;
                }

            }
        }
        return false;
    }
}

