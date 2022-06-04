/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;
import conexao.CriarProduto;
/**
 *
 * @author 55119
 */
public class AddProduto extends Produto {
    public CriarProduto criarProduto;
    public String mensage;
    protected Integer qtd;
    
    public AddProduto(){
        
    }
    
    public AddProduto(Integer idUsuarioLogado, Integer cod_barras, Integer preco, String descricao, String nome, String img, Integer qtd){
        this.id_pessoa = idUsuarioLogado;
        this.cod_barras = cod_barras;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.qtd = qtd;
        this.img = img;
        this.criarProduto = new CriarProduto(this.cod_barras, this.preco, this.descricao, this.nome, this.img, this.id_pessoa);;
    }
    
    public Boolean validarCampos(String cod_barras, String preco, String descricao, String nome){
        if(!cod_barras.isEmpty() && !preco.isEmpty() && !descricao.isEmpty() && !nome.isEmpty()){
            return true;
        }
        this.mensage = "Erro, preencha todos os campos para inserir o produto";
        return false;
    }
    
    public Boolean inserirProduto(){
        if(!cod_barras.toString().isEmpty() && !preco.toString().isEmpty() && !descricao.isEmpty() && !nome.isEmpty() && !qtd.toString().isEmpty()){
            for (int i = 0; i < qtd; i++) {
                criarProduto.inserir();
            }
            this.mensage = qtd +" produtos inseridos!";
            return true;
        }
        this.mensage = "Erro, preencha todos os campos para inserir o produto";
        return false;
    }
}
