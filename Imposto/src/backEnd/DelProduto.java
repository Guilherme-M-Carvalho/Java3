/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;
import conexao.DeleteProdutos;

/**
 *
 * @author 12522132887
 */
public class DelProduto extends Produto{
    private DeleteProdutos deleteProduto;
    public String mensagem;
    
    public DelProduto(Integer id){
        this.deleteProduto = new DeleteProdutos(id);
    }
    
    public Boolean deletarProduto(){
        deleteProduto.delete();
        mensagem = "Produto deletado com sucesso!";
        return true;
    }
}
