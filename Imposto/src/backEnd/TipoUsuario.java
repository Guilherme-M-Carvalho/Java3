/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;
import conexao.BuscarTipoUser;
import java.util.ArrayList;
/**
 *
 * @author 125111345741
 */
public class TipoUsuario{
    private BuscarTipoUser tipoUser;    
    protected Integer idTipoUsuario;
    protected String nomeTipoUsuario;
    
 
    public ArrayList<Integer> idTipoUserLista;
    public ArrayList<String> nomeTipoUserLista;
    private ArrayList<TipoUsuario> tipoDeUsuarios;
    
    public TipoUsuario(){
        this.tipoUser = new BuscarTipoUser();
        this.idTipoUserLista = new ArrayList<>();
        this.nomeTipoUserLista = new ArrayList<>();
    }
    
    public void setIdTipoUsuario(Integer id) {
        this.idTipoUsuario = id;
    }

    public void setNomeTipoUsuario(String nome) {
        this.nomeTipoUsuario = nome;
    }
    
    public void getTipoUsuario(){
        this.tipoDeUsuarios = tipoUser.buscar();
        for(TipoUsuario usuario: this.tipoDeUsuarios){
            idTipoUserLista.add(usuario.idTipoUsuario);;
            nomeTipoUserLista.add(usuario.nomeTipoUsuario);
        }
    }
}
