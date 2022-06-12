/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imposto;

import backEnd.DelProduto;
import backEnd.Produto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 12522132887
 */
public class DeleteProduto extends javax.swing.JFrame {

    private DefaultTableModel modelProduto;
    private DelProduto deletar;
    private Produto produto;
    private int idSelecionado;
    private Integer idUsuarioLogado;
    private Integer IdTipoUsuarioLogado;
    private String nomeTipoLogado;

    public DeleteProduto(Integer idUsuarioLogado,Integer IdTipoUsuarioLogado,String nomeTipoLogado) {
        initComponents();
        this.idUsuarioLogado = idUsuarioLogado;
        this.IdTipoUsuarioLogado = IdTipoUsuarioLogado;
        this.nomeTipoLogado = nomeTipoLogado;
        modelProduto = new DefaultTableModel();
        produto = new Produto();
        produto.getProdutos();
        listaProduto();

    }

    public void listaProduto() {
        Object[] row = new Object[4];
        TableProduto.setModel(modelProduto);

        Object[] column = {"Codigo de Barras", "Preço", "Descrição", "Nome"};
        modelProduto.setColumnIdentifiers(column);

        for (int i = 0; i < produto.idLista.size(); i++) {
            row[0] = produto.cod_barrasLista.get(i);
            row[1] = produto.precoLista.get(i);
            row[2] = produto.descricaoLista.get(i);
            row[3] = produto.nomeLista.get(i);
            modelProduto.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableProduto = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();

        TableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TableProduto);

        btnDelete.setText("Deletar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        idSelecionado = TableProduto.getSelectedRow();
        if (idSelecionado != -1) {
            deletar = new DelProduto(produto.idLista.get(idSelecionado));
            if (deletar.deletarProduto()) {
                JOptionPane.showMessageDialog(this, deletar.mensagem, "Sucesso", 1);
                hide();
                Menu m = new Menu(idUsuarioLogado, IdTipoUsuarioLogado, nomeTipoLogado);
                m.show();
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableProduto;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
