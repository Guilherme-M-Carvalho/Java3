/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;
import backEnd.Pessoa;
import java.util.ArrayList;
/**
 *
 * @author 55119
 */
public class EfetuarLogin extends Pessoa{
    public String menssagem;
    public Integer idUsuarioLogado;
    public Integer idTipoUsuarioLogado;
    public String nomeTipoLogado;
    
    public Boolean vLogin(String email, String senha){
        this.buscarPessoa();
        if(!email.isEmpty() && !senha.isEmpty()){;
            for (int i = 0; i < idLista.size(); i++) {
                if(emailLista.get(i).equals(email)  && senhaLista.get(i).equals(senha)){
                    this.idUsuarioLogado = idLista.get(i);
                    this.idTipoUsuarioLogado = idTipoUserLista.get(i);
                    this.nomeTipoLogado = nomeTipoUserLista.get(i);
                    this.menssagem = "Bem vindo "+nomeLista.get(i)+"!";
                    return true;
                }
            }
            this.menssagem = "Erro, email ou senha invalidos!";
            return false;
        }        
        this.menssagem = "Erro, preencha todos os campos para efetuar o login!";
        return false;
    }
}
