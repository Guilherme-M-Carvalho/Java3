/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;
import conexao.BuscarTipoUser;
import conexao.BuscarTipoUser;
import java.util.ArrayList;
/**
 *
 * @author 125111345741
 */
public class TipoUsuario {
    private Integer id;
    private String nome;
    private BuscarTipoUser tipoUser;
    public ArrayList<Integer> idLista;
    public ArrayList<String> nomeLista;
    

    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void getTipoUsuario(){
        idLista = new ArrayList<>();
        nomeLista = new ArrayList<>();
        this.tipoUser = new BuscarTipoUser();
        ArrayList<TipoUsuario> usuarios = this.tipoUser.buscar();
        for(TipoUsuario usuario: usuarios){
            idLista.add(usuario.id);;
            nomeLista.add(usuario.nome);

        }
    }
}
