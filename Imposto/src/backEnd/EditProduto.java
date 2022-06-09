/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;
import conexao.UpdateProduto;

/**
 *
 * @author pedro
 */
public class EditProduto extends Produto {
    
    public UpdateProduto updateProduto;
    public String mensagem;
    
    public EditProduto( Integer id, Integer preco, String nome, String descricao  ){
        
        this.id = id;
        this.descricao = descricao;
        this.preco = preco; 
        this.nome = nome;
        
        this.updateProduto = new UpdateProduto(this.preco, this.descricao, this.nome, this.id);
        
    }
    
    public boolean validaUpdate(){
        if( !this.id.toString().isEmpty() && !this.descricao.isEmpty() && !this.nome.isEmpty() && !this.preco.toString().isEmpty()){
            
            return true;
            
        }
        
        this.mensagem = "Por favor, preencha todos os campos!";
        return false;
          
    }
    
    public boolean update(){
        
        if(validaUpdate()) {
            updateProduto.update();
            this.mensagem = "Sucesso!";
            
            return true;
            
        }
        
        return false;
        
    }
    
}
