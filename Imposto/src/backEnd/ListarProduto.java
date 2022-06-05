/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author 55119
 */
public class ListarProduto{
    protected JLabel txt_nome;
    protected JLabel txt_preco;
    protected JTextArea txt_descricao;
    protected JPanel produto;
    protected JScrollPane jScrollPane1;
    
    public ListarProduto(){
        produto = new javax.swing.JPanel();
        txt_nome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descricao = new javax.swing.JTextArea();
        txt_preco = new javax.swing.JLabel();
    }
    
    
    
    public JPanel criarPanelProduto(){
        txt_nome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_nome.setText("jLabel1");

        txt_descricao.setColumns(20);
        txt_descricao.setRows(5);
        txt_descricao.setEnabled(false);
        jScrollPane1.setViewportView(txt_descricao);

        txt_preco.setText("jLabel1");

        javax.swing.GroupLayout produtoLayout = new javax.swing.GroupLayout(produto);
        produto.setLayout(produtoLayout);
        produtoLayout.setHorizontalGroup(
            produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(produtoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGroup(produtoLayout.createSequentialGroup()
                        .addComponent(txt_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_preco)))
                .addContainerGap())
        );
        produtoLayout.setVerticalGroup(
            produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(produtoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome)
                    .addComponent(txt_preco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        
        produto.setBackground(Color.red);
        produto.setVisible(true);
        return produto;
    }  
}
