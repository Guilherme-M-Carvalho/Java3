/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

/**
 *
 * @author 55119
 */
public class MenuTipoUsuario {
    public Integer idUsuarioLogado;
    public Integer IdTipoUsuarioLogado;
    public String nomeTipoLogado;
    /**
     * Creates new form Menu
     */

//        this.IdTipoUsuarioLogado = IdTipoUsuarioLogado;
//        this.idUsuarioLogado = IdTipoUsuarioLogado;
//        this.nomeTipoLogado = nomeTipoLogado;
    public boolean validarUsuario(Integer idUsuarioLogado,Integer IdTipoUsuarioLogado, String nomeTipoLogado){
        this.idUsuarioLogado = idUsuarioLogado;
        this.IdTipoUsuarioLogado = IdTipoUsuarioLogado;
        this.nomeTipoLogado = nomeTipoLogado;
        
        if(this.nomeTipoLogado.equals("Administrador")){
            return true;
        } else if(this.nomeTipoLogado.equals("Comum")){
            return false;
        }
        return false;
    }
    
    
}
