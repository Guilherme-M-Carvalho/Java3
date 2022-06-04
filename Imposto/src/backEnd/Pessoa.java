/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import conexao.CriarUsuario;
import conexao.BuscarPessoa;
import conexao.BuscarPessoa;
import conexao.Conexao;
import conexao.CriarUsuario;
import java.util.ArrayList;
/**
 *
 * @author 125111345741
 */
public class Pessoa{
    private Conexao conexao;
    private CriarUsuario criarUsuario;
    private BuscarPessoa buscarPessoa;
    public Integer id;
    public String nome;
    public String email;
    public String senha;
    public String dataCriacao;
    public String nomeTipo;
    public Integer idTipoUser;
    public Integer idUsuarioLogado;
    public Integer idTipoUsuarioLogado;
    public String nomeTipoLogado;
    
    public ArrayList<String> nomeLista;
    public ArrayList<String> emailLista;
    public ArrayList<String> senhaLista;
    public ArrayList<String> dataCriacaoLista;
    public ArrayList<Integer> idTipoUserLista;
    public ArrayList<Integer> idLista;
    public ArrayList<String> nomeTipoLista;

    
   
    public Pessoa(){
        this.criarUsuario = new CriarUsuario();
        this.buscarPessoa = new BuscarPessoa();
        this.idLista = new ArrayList<>();
        this.idTipoUserLista = new ArrayList<>();
        this.nomeLista = new ArrayList<>();
        this.emailLista = new ArrayList<>();
        this.senhaLista = new ArrayList<>();
        this.dataCriacaoLista = new ArrayList<>();
        this.nomeTipoLista = new ArrayList<>();
    }
    
    public void setIdTipoUser(int idTipoUser) {
        this.idTipoUser = idTipoUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
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
    
    public void buscarPessoa(){
        ArrayList<Pessoa> Pessoas = buscarPessoa.buscar();
        for(Pessoa p: Pessoas){
            this.idLista.add(p.id);
            this.idTipoUserLista.add(p.idTipoUser);
            this.nomeLista.add(p.nome);
            this.emailLista.add(p.email);
            this.senhaLista.add(p.senha);
            this.dataCriacaoLista.add(p.dataCriacao);
            this.nomeTipoLista.add(p.nomeTipo);
        }  
    }
}

