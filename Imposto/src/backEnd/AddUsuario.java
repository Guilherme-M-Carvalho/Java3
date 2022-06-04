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
    
    public AddUsuario(String nome, String email, String senha, Integer idTipo){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idTipoUsuario = idTipo;
        this.criarUsuario = new CriarUsuario(this.nome, this.email, this.senha, this.idTipoUsuario);
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
    
    public boolean inserirUsuario(){
        if(!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !idTipoUsuario.toString().isEmpty()){
            if(validarCB(idTipoUsuario)){
                if(!emailExite(email)){
                    criarUsuario.inserir();
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
