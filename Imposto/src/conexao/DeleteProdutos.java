/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;
import backEnd.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 12522132887
 */
public class DeleteProdutos extends Produto {

    private Conexao conexao;

    public DeleteProdutos(int id) {
        this.conexao = new Conexao();

        this.id = id;
    }

    public void delete() {

        String sql = "delete from produto WHERE id = ? ";

        try {
            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setInt(1, this.id);
                sentenca.execute();
                sentenca.close();

                conexao.getConnection().close();

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
