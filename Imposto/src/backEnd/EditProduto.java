/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;
import conexao.UpdateProduto;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class EditProduto extends Produto {
    
    public UpdateProduto updateProduto;
    public String mensagem;
    private String data;
    
    public EditProduto( Integer codBarras, Integer preco, String nome, String descricao, String data, Integer idStatusProduto){
        
        this.cod_barras = codBarras;
        this.descricao = descricao;
        this.preco = preco; 
        this.nome = nome;
        this.DataCriacao = data;
        this.idStatusProduto = idStatusProduto;
        Date dataa = new Date(System.currentTimeMillis()); 
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        this.data = formatarDate.format(dataa).toString();
        System.out.print(this.data);
        this.updateProduto = new UpdateProduto(this.preco, this.descricao, this.nome, this.cod_barras, this.DataCriacao, this.idStatusProduto, this.data);
        
    }
    
    public boolean validaUpdate(){
        if( !this.cod_barras.toString().isEmpty() && !this.descricao.isEmpty() && !this.nome.isEmpty() && !this.preco.toString().isEmpty()){
            
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
