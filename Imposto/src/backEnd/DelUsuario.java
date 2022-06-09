/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;

import conexao.DeleteUsuarios;

/**
 *
 * @author 12522132887
 */
public class DelUsuario extends Pessoa{
    private DeleteUsuarios deletarUser;
    public String mensagem;
    
    public DelUsuario(Integer id){
        this.deletarUser = new DeleteUsuarios(id);
    }
    
    public Boolean deletarUsuario(){
        deletarUser.delete();
        mensagem = "Usuario deletado com sucesso!";
        return true;
    }
    
}
