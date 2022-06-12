/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;
import conexao.AddCompra;
/**
 *
 * @author 55119
 */
public class CadCompra {
    private AddCompra addCompra;
    private Integer idPessoa;
    private String idProdutos;
    public String mensagem;
    
    public CadCompra(Integer idPessoa, String idProdutos){
        this.idPessoa = idPessoa;
        this.idProdutos = idProdutos;
    }
    
    public Boolean comprar(){
        
        addCompra = new AddCompra(idPessoa, idProdutos);
        addCompra.inserir();
        mensagem = "Compra realizada com sucesso";
        return true;
        
    }
    
    
}
