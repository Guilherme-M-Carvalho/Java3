/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imposto;

import backEnd.DelUsuario;
import backEnd.Pessoa;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 12522132887
 */
public class DeleteUsuario extends javax.swing.JFrame {
    
    private DefaultTableModel modelUsuario;
    private DelUsuario deletar;
    private Pessoa pessoa;
    private int idSelecionado;
<<<<<<< HEAD
    private Integer idUsuarioLogado;
    private Integer IdTipoUsuarioLogado;
    private String nomeTipoLogado;
    /**
     * Creates new form DeleteUsuario
     */
    public DeleteUsuario(Integer idUsuarioLogado,Integer IdTipoUsuarioLogado,String nomeTipoLogado) {
        initComponents();
        this.idUsuarioLogado = idUsuarioLogado;
        this.IdTipoUsuarioLogado = IdTipoUsuarioLogado;
        this.nomeTipoLogado = nomeTipoLogado;
=======
    /**
     * Creates new form DeleteUsuario
     */
    public DeleteUsuario() {
        initComponents();
>>>>>>> fa63fa46f4f87a6b6a725c1c21c8791010eb248e
        modelUsuario = new DefaultTableModel();
        pessoa = new Pessoa();
        pessoa.buscarPessoa();
        listaUsuario();
    }
    
    public void listaUsuario(){
        Object[] row = new Object[5];
        TableUsuario.setModel(modelUsuario);

        Object[] column = {"Nome", "Email","Senha", "Data criação", "Nivel"};
        modelUsuario.setColumnIdentifiers(column);

        for(int i = 0 ; i < pessoa.idLista.size() ; i++){
            row[0] = pessoa.nomeLista.get(i);
            row[1] = pessoa.emailLista.get(i);
            row[2] = pessoa.senhaLista.get(i);
            row[3] = pessoa.dataCriacaoLista.get(i);
            row[4] = pessoa.nomeTipoUserLista.get(i);
            modelUsuario.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuario = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();

        TableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TableUsuario);

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
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        idSelecionado = TableUsuario.getSelectedRow();
        if(idSelecionado != -1){
            deletar = new DelUsuario(pessoa.idLista.get(idSelecionado));
            if(deletar.deletarUsuario()){
                JOptionPane.showMessageDialog(this, deletar.mensagem, "Sucesso", 1);
<<<<<<< HEAD
                hide();
                Menu m = new Menu(idUsuarioLogado, IdTipoUsuarioLogado, nomeTipoLogado);
                m.show();
=======
>>>>>>> fa63fa46f4f87a6b6a725c1c21c8791010eb248e
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableUsuario;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
