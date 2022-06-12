/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;
import conexao.CriarProduto;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author 55119
 */
public class AddProduto extends Produto {
    public CriarProduto criarProduto;
    public String mensage;
    protected Integer qtd;
    protected String data;
    
    public AddProduto(){
    }
    
    public AddProduto(Integer idUsuarioLogado, Integer cod_barras, Integer preco, String descricao, String nome, String img, Integer qtd, Integer idStatusProduto){
        this.id_pessoa = idUsuarioLogado;
        this.cod_barras = cod_barras;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.qtd = qtd;
        this.img = img;
        this.idStatusProduto = idStatusProduto;
        Date data = new Date(System.currentTimeMillis()); 
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        this.data = formatarDate.format(data).toString();
        System.out.print(this.data);
        
       
    }
    
    public Boolean validarCampos(String cod_barras, String preco, String descricao, String nome){
        if(!cod_barras.isEmpty() && !preco.isEmpty() && !descricao.isEmpty() && !nome.isEmpty()){
            return true;
        }
        this.mensage = "Erro, preencha todos os campos para inserir o produto";
        return false;
    }
    
    public Boolean cadastrarProduto(){
        if(!cod_barras.toString().isEmpty() && !preco.toString().isEmpty() && !descricao.isEmpty() && !nome.isEmpty() && !qtd.toString().isEmpty()){
            criarProduto = new CriarProduto(this.cod_barras, this.preco, this.descricao, this.nome, this.img, this.id_pessoa, this.idStatusProduto, data);
            for (int i = 0; i < qtd; i++) {
                criarProduto.inserirProduto();
                System.out.print(data);
            }
            this.mensage = qtd +" produtos inseridos!";
            return true;
        }
        this.mensage = "Erro, preencha todos os campos para inserir o produto";
        return false;
    }
}
