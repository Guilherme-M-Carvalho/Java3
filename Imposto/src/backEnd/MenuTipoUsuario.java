/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

/**
 *
 * @author 55119
 */
public class MenuTipoUsuario extends TipoUsuario{
    protected Integer idUsuarioLogado;

    public MenuTipoUsuario (Integer idUsuarioLogado,Integer IdTipoUsuarioLogado, String nomeTipoLogado){
        this.idUsuarioLogado = idUsuarioLogado;
        this.idTipoUsuario = IdTipoUsuarioLogado;
        this.nomeTipoUsuario = nomeTipoLogado;
    }
    
    public Boolean validarUsuario(){
        if(this.nomeTipoUsuario.equals("Administrador")){
            return true;
        } else if(this.nomeTipoUsuario.equals("Comum")){
            return false;
        }
        return false;
    }
    
    
}
