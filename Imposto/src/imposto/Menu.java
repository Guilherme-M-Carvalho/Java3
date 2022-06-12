/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imposto;
import backEnd.ListarProduto;
import backEnd.MenuTipoUsuario;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import backEnd.Pessoa;
import backEnd.Produto;
/**
 *
 * @author 125111345741
 */
public class Menu extends javax.swing.JFrame {
    public Boolean administradoSimNao;
    public MenuTipoUsuario menu;
    protected Integer idUsuarioLogado;
    private ListarProduto produtor;
    private JPanel produto;
    private Pessoa pessoa;
    private Produto produtos;
    private Integer IdTipoUsuarioLogado;
    private String nomeTipoLogado;
//    private Produto produto;
    /**
     * Creates new form Menu
     */
    public Menu(Integer idUsuarioLogado, Integer IdTipoUsuarioLogado, String nomeTipoLogado) {
        initComponents();
        this.IdTipoUsuarioLogado = IdTipoUsuarioLogado;
        this.nomeTipoLogado = nomeTipoLogado;
        pessoa = new Pessoa();
        produtos = new Produto();
        produtor = new ListarProduto();
        crirGraficoPizza();
        this.idUsuarioLogado = idUsuarioLogado;
        this.menu = new MenuTipoUsuario(idUsuarioLogado, IdTipoUsuarioLogado, nomeTipoLogado);
        this.administradoSimNao = menu.validarUsuario();
        modificarTelaUsuarioComum(administradoSimNao);
        criarComLinha();

    }
    
    public void modificarTelaUsuarioComum(Boolean administradoSimNao){
        if(!administradoSimNao){
            item_novo.setVisible(false);
            item_editar.setVisible(false);
            menuDeletar.setVisible(false);
        }
    }


        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        public void criarComLinha(){
            produtos.getProdutosGrafico();
            for (int i =0; i < produtos.cod_barrasLista.size(); i++ ){
                dataset.addValue(produtos.precoLista.get(i)*produtos.qtdLista.get(i), "Lucro", produtos.nomeLista.get(i));
                dataset.addValue(produtos.precoLista.get(i), "Preço", produtos.nomeLista.get(i));
        }
        
        JFreeChart chart = ChartFactory.createLineChart(
            "Comparação de preço com lucro na venda",
            "Produtos",
            "Valor",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
                
        
        chart.setBackgroundPaint(Color.gray);
        chart.getTitle().setPaint(Color.blue);
        CategoryPlot p = chart.getCategoryPlot();
        p.setForegroundAlpha(0.9f);
        p.setRangeGridlinePaint(Color.red);
        p.setDomainGridlinesVisible(true);
        p.setDomainGridlinePaint(Color.BLACK);
        CategoryItemRenderer renderer = p.getRenderer();
        renderer.setSeriesPaint(1, Color.red);
        renderer.setSeriesPaint(0, Color.green);
        ChartPanel frame1 = new ChartPanel(chart);
        frame1.setVisible(true);
        frame1.setSize(600, 550);
        jPanel1.add(frame1);
        
    }
    
    public void crirGraficoPizza(){
        pessoa.buscarPessoa();
        DefaultPieDataset pizza = new DefaultPieDataset();
        Integer qtdAdm = 0;
        Integer qtdComum = 0;
        for(int i = 0; i < pessoa.nomeLista.size(); i++){
            if(pessoa.nomeTipoUserLista.get(i).equals("Administrador")){
                qtdAdm++;
            } else if (pessoa.nomeTipoUserLista.get(i).equals("Comum")){
                qtdComum++;
            }
        }
        System.out.println(qtdAdm+"/"+qtdComum);
        pizza.setValue("Administrador", qtdAdm);
        pizza.setValue("Comum", qtdComum);
        
        JFreeChart grafico = ChartFactory.createPieChart(
            "Usuários", 
            pizza, 
            true, 
            true, 
            false
        );
        
        PiePlot fatia = (PiePlot) grafico.getPlot();
        ChartPanel painel = new ChartPanel(grafico);
        painel.setVisible(true);
        painel.setSize(600,550 );
        graficoPizza.add(painel);
        
    }
    
    public void graficoComLinha(){
        var casos = new XYSeries("casos");
        var recuperados = new XYSeries("recuperados");
        
        int contador = 1;
        while(contador<=114){
            casos.add(contador, contador+3);
            recuperados.add(contador, contador+8);
            contador++;
        }
        
        var dataset = new XYSeriesCollection();
        dataset.addSeries(casos);
        dataset.addSeries(recuperados);
        
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Teste", 
            "Evolução", 
            "Num de ocorrencias", 
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        
        XYPlot plot = chart.getXYPlot();
        var render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.red);
        render.setSeriesStroke(0, new BasicStroke(5.0f));
        render.setSeriesPaint(0, Color.blue);
        render.setSeriesStroke(0, new BasicStroke(5.0f));

        
        plot.setRenderer(render);
        plot.setBackgroundPaint(Color.white);
        plot.setForegroundAlpha(0.9f);
        plot.setRangeGridlinePaint(Color.red);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.black);
        
        chart.getLegend().setFrame(BlockBorder.NONE);
        
        ChartFrame panel = new ChartFrame("Grafico",chart);
        panel.setVisible(true);
        panel.setSize(1200, 1200);
        
        
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        graficoPizza = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        item_novo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        item_editar = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        item_visualizar = new javax.swing.JMenu();
<<<<<<< HEAD
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuDeletar = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
=======
>>>>>>> fa63fa46f4f87a6b6a725c1c21c8791010eb248e

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        graficoPizza.setPreferredSize(new java.awt.Dimension(636, 650));

        javax.swing.GroupLayout graficoPizzaLayout = new javax.swing.GroupLayout(graficoPizza);
        graficoPizza.setLayout(graficoPizzaLayout);
        graficoPizzaLayout.setHorizontalGroup(
            graficoPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        graficoPizzaLayout.setVerticalGroup(
            graficoPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        item_novo.setText("Novo");

        jMenuItem1.setText("Adicionar usuário");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        item_novo.add(jMenuItem1);

        jMenuItem2.setText("Adicionar produto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        item_novo.add(jMenuItem2);
        item_novo.add(jMenuItem4);

        jMenuBar1.add(item_novo);

        item_editar.setText("Editar");

        jMenuItem3.setText("Editar usuário");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        item_editar.add(jMenuItem3);

        jMenuBar1.add(item_editar);

        item_visualizar.setText("Visualizar");
        jMenuBar1.add(item_visualizar);

<<<<<<< HEAD
        jMenu2.setText("Comprar");

        jMenuItem6.setText("Comprar produtos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        menuDeletar.setText("Deletar");

        jMenuItem9.setText("Deletar usuário");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuDeletar.add(jMenuItem9);

        jMenuItem10.setText("Deletar produto");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menuDeletar.add(jMenuItem10);

        jMenuBar1.add(menuDeletar);

=======
>>>>>>> fa63fa46f4f87a6b6a725c1c21c8791010eb248e
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graficoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graficoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(269, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AdicionarUsuario newUser = new AdicionarUsuario(idUsuarioLogado, IdTipoUsuarioLogado, nomeTipoLogado);
        newUser.show();
        hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AdicionarProduto newProduto = new AdicionarProduto(idUsuarioLogado, IdTipoUsuarioLogado, nomeTipoLogado);
        newProduto.show();
        hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
<<<<<<< Updated upstream
=======
       EditarPessoa editarPessoa = new EditarPessoa();
       editarPessoa.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        BuscarProduto buscarProd = new BuscarProduto();
        buscarProd.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ComprarProduto vProdutos = new ComprarProduto(idUsuarioLogado);
        vProdutos.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       
        EditarProduto editarProduto = new EditarProduto();
        
        editarProduto.show();
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
>>>>>>> Stashed changes
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        DeleteUsuario delUser = new DeleteUsuario(idUsuarioLogado, IdTipoUsuarioLogado, nomeTipoLogado);
        delUser.show();
        hide();
                
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
          DeleteProduto delProd = new DeleteProduto(idUsuarioLogado, IdTipoUsuarioLogado, nomeTipoLogado);
        delProd.show();
        hide();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graficoPizza;
    private javax.swing.JMenu item_editar;
    private javax.swing.JMenu item_novo;
    private javax.swing.JMenu item_visualizar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
<<<<<<< Updated upstream
    private javax.swing.JPanel jPanel2;
=======
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
<<<<<<< HEAD
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuDeletar;
=======
    private javax.swing.JPanel jPanel1;
>>>>>>> Stashed changes
>>>>>>> fa63fa46f4f87a6b6a725c1c21c8791010eb248e
    // End of variables declaration//GEN-END:variables
}
