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
    
    public AddProduto(){
        criarProduto = new CriarProduto();
    }
    
    public Boolean inserirProduto(Integer cod_barras, String preco, String descricao, String nome, Integer qtd){
        if(!cod_barras.toString().isEmpty() && !preco.toString().isEmpty() && !descricao.isEmpty() && !nome.isEmpty() && !qtd.toString().isEmpty()){
            for (int i = 0; i < qtd; i++) {
                criarProduto.inserir();
                System.out.println(this.IdTipoUsuarioLogado);
            }
            this.mensage = qtd +" produtos inseridos!";
            return true;
        }
        this.mensage = "Erro, preencha todos os campos para inserir o produto";
        return false;
    }
}
