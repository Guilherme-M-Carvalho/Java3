/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;
import conexao.BuscarPessoa;
import conexao.CriarUsuario;
import java.util.ArrayList;
/**
 *
 * @author 125111345741
 */
public class Pessoa extends TipoUsuario{
    private BuscarPessoa buscarPessoa;
    protected Integer id;
    protected String nome;
    protected String email;
    protected String senha;
    protected String dataCriacao;
    
    public ArrayList<Integer> idLista;
    public ArrayList<String> nomeLista;
    public ArrayList<String> emailLista;
    public ArrayList<String> senhaLista;
    public ArrayList<String> dataCriacaoLista;
   
    private ArrayList<Pessoa> pessoas;
    private CriarUsuario criarUsuario;

    public ArrayList<Pessoa> getPessoa(){
        return pessoas;
    }
     
     public ArrayList<Integer> getId(){
        return this.idLista;
    }
    
    
    public ArrayList<String> getNome(){
        return this.nomeLista;
    }
    
    public ArrayList<String> getEmail(){
        return this.emailLista;
    }
    
    public ArrayList<String> getSenha(){
        return this.senhaLista;
    }
    
    public Pessoa(){
        this.buscarPessoa = new BuscarPessoa();
        this.idLista = new ArrayList<>();
        this.nomeLista = new ArrayList<>();
        this.emailLista = new ArrayList<>();
        this.senhaLista = new ArrayList<>();
        this.dataCriacaoLista = new ArrayList<>();
    }
    
    public Pessoa(String nome, String email, String senha, Integer idTipo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idTipoUsuario = idTipo;
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
    
    public void buscarPessoa(){
        this.pessoas = buscarPessoa.buscar();
        for(Pessoa p: pessoas){
            this.idLista.add(p.id);
            this.nomeLista.add(p.nome);
            this.emailLista.add(p.email);
            this.senhaLista.add(p.senha);
            this.dataCriacaoLista.add(p.dataCriacao);
            this.idTipoUserLista.add(p.idTipoUsuario);
            this.nomeTipoUserLista.add(p.nomeTipoUsuario);
        }
    }
    
    public void inserirPessoa(){
        this.criarUsuario = new CriarUsuario(this.nome, this.email, this.senha, this.idTipoUsuario);
        criarUsuario.inserir();
    }
    
    
}

