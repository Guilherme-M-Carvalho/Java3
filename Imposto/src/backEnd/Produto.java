/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

import conexao.BuscaProduto;
import conexao.BuscarProdutoGrafico;
import conexao.CriarProduto;
import java.util.ArrayList;

/**
 *
 * @author 55119
 */
public class Produto{
    protected Integer id;
    protected Integer cod_barras;
    protected Integer preco;
    protected String descricao;
    protected String nome;
    protected String img;
    protected Integer id_pessoa;
<<<<<<< Updated upstream
   
=======
    private Integer qtd;
    

>>>>>>> Stashed changes
    private CriarProduto criarProduto;
    private BuscaProduto buscarProduto;
    private BuscarProdutoGrafico produtoGrafico;
    
    public ArrayList<Produto> produtos;
    public ArrayList<Produto> p;
    public ArrayList<Integer> idLista;
    public ArrayList<Integer> cod_barrasLista;
    public ArrayList<Integer> precoLista;
    public ArrayList<String> descricaoLista;
    public ArrayList<String> nomeLista;
    public ArrayList<String> imgLista;
    public ArrayList<Integer> id_pessoaLista;
    public ArrayList<Integer> qtdLista;
    
    public Produto (){
        this.buscarProduto = new BuscaProduto();
        this.produtos = new ArrayList<>();
        qtdLista = new ArrayList<>();
        this.p = new ArrayList<>();
        this.idLista = new ArrayList<>();        
        this.cod_barrasLista = new ArrayList<>();
        this.precoLista = new ArrayList<>();
        this.descricaoLista = new ArrayList<>();
        this.nomeLista = new ArrayList<>();
        this.imgLista = new ArrayList<>();
        this.id_pessoaLista = new ArrayList<>();
        produtoGrafico = new BuscarProdutoGrafico();
    }
    
    public Produto(Integer idUsuarioLogado, Integer cod_barras, Integer preco, String descricao, String nome, String img){
        this.id_pessoa = idUsuarioLogado;
        this.cod_barras = cod_barras;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.img = img;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCod_barras(Integer cod_barras) {
        this.cod_barras = cod_barras;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    
    public void inserirProduto(){
        this.criarProduto = new CriarProduto(this.cod_barras, this.preco, this.descricao, this.nome, this.img, this.id_pessoa);
        criarProduto.inserir();
    }
    
    public void getProdutos(){
        this.produtos = buscarProduto.buscar();
        for(Produto p: produtos){
            this.idLista.add(p.id);
            this.cod_barrasLista.add(p.cod_barras);
            this.precoLista.add(p.preco);
            this.descricaoLista.add(p.descricao);
            this.nomeLista.add(p.nome);
            this.imgLista.add(p.img);
            this.id_pessoaLista.add(p.id_pessoa);
        }
    }
    
    public void getProdutosGrafico(){
        p = produtoGrafico.buscarP();
        for(Produto p: p){
            this.cod_barrasLista.add(p.cod_barras);
            this.precoLista.add(p.preco);
            this.nomeLista.add(p.nome);
            System.out.println(p.qtd);
            this.qtdLista.add(p.qtd);
        }
    }
    
}
