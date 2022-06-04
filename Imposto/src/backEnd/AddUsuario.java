/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;
import conexao.CriarUsuario;

/**
 *
 * @author 55119
 */
public class AddUsuario extends Pessoa{
    private CriarUsuario criarUsuario;
    public String mensagem;
    
    public AddUsuario(){
        this.criarUsuario = new CriarUsuario();
    }
    
    public Boolean emailExite(String emailForm){
        this.buscarPessoa();
        for (String email : emailLista){
            if(email.equals(emailForm)){
                return true;
            }
        }
        return false;
    }   
    
    public Boolean validarCB(Integer valor){
        if(valor > 0){
            return true;
        } 
        return false;
    }
    
    public boolean inserirUsuario(String nome, String email, String senha, Integer idTipo){
        if(!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !idTipo.toString().isEmpty()){
            if(validarCB(idTipo)){
                if(!emailExite(email)){
                    criarUsuario.inserir(nome, email, senha, idTipo);
                    this.mensagem = "Usuário "+ nome +" cadastrado com sucesso!";
                    return true;
                } else {
                    this.mensagem = "Erro email já cadastrado!";
                    return false;
                }
            } else {
                this.mensagem = "Erro selecione um tipo de usuário!";
                return false;
            }
        }
        this.mensagem = "Erro preencha todos campos!";
        return false;
    }
    
}
