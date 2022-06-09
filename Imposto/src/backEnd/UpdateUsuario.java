/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

import conexao.UpdatePessoa;

/**
 *
 * @author pedro
 */
public class UpdateUsuario extends Pessoa{
    
    public UpdatePessoa updatePessoa;
    public String mensagem;
    
    public UpdateUsuario( String nome, String email, String senha, Integer id, Integer idTipoUsuario ){
        
        this.id = id;
        this.senha= senha;
        this.email = email;
        this.nome= nome;
        this.idTipoUsuario = idTipoUsuario;
        
        
        this.updatePessoa = new UpdatePessoa(id, nome, email, senha, idTipoUsuario);
        
    }
    
    public boolean validaUpdate(){
        if( !this.id.toString().isEmpty() && !this.senha.isEmpty() && !this.email.isEmpty() && !this.nome.isEmpty() && !this.idTipoUsuario.toString().isEmpty()){
            
            return true;
            
        }
        
        this.mensagem = "Por favor, preencha todos os campos!";
        return false;
          
    }
    
    public boolean update(){
        
        if(validaUpdate()) {
            
            updatePessoa.update();
            this.mensagem = "Sucesso!";

            return true;
            
        }
        
        return false;
        
    }
    
}
