/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imposto;

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

/**
 *
 * @author 125111345741
 */
public class Menu extends javax.swing.JFrame {
    public Boolean administradoSimNao;
    public MenuTipoUsuario menu;
    protected Integer idUsuarioLogado;

    private JPanel produto;
    /**
     * Creates new form Menu
     */
    public Menu(Integer idUsuarioLogado, Integer IdTipoUsuarioLogado, String nomeTipoLogado) {

        initComponents();
        
        this.idUsuarioLogado = idUsuarioLogado;
        this.menu = new MenuTipoUsuario(idUsuarioLogado, IdTipoUsuarioLogado, nomeTipoLogado);
        this.administradoSimNao = menu.validarUsuario();
        modificarTelaUsuarioComum(administradoSimNao);
        criarComLinha();
        graficoComLinha();

    }
    
    public void modificarTelaUsuarioComum(Boolean administradoSimNao){
        if(!administradoSimNao){
            item_novo.setVisible(false);
            item_editar.setVisible(false);
        }
    }

    public void criarComLinha(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(4, "Ciencias", "Kiko");
        dataset.addValue(7, "Matematica", "Kiko");
        dataset.addValue(1, "Ciencias", "Chaves");
        dataset.addValue(10, "Matematica", "Chaves");
        
        JFreeChart chart = ChartFactory.createLineChart(
            "Comparação de notas",
            "Alunos",
            "Notas",
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
        ChartFrame frame1 = new ChartFrame("Grafico de linhas", chart);
        frame1.setVisible(true);
        frame1.setSize(300, 300);
        
    }
    
    public void crirGraficoPizza(){
        DefaultPieDataset pizza = new DefaultPieDataset();
        pizza.setValue("Brasil", 5);
        pizza.setValue("Alemanha", 4);
        pizza.setValue("Italia", 4);
        pizza.setValue("Argentina", 2);
        pizza.setValue("França", 1);
        
        JFreeChart grafico = ChartFactory.createPieChart(
            "Campeoes mundiais", 
            pizza, 
            true, 
            true, 
            false
        );
        
        PiePlot fatia = (PiePlot) grafico.getPlot();
        fatia.setSectionPaint("Brasil", Color.YELLOW);
        ChartPanel painel = new ChartPanel(grafico);
        painel.setVisible(true);
        painel.setSize(500, 500);
        add(painel);
        
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
        jMenuBar1 = new javax.swing.JMenuBar();
        item_novo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        item_editar = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        item_visualizar = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jMenuItem7.setText("Editar produto");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        item_editar.add(jMenuItem7);

        jMenuBar1.add(item_editar);

        item_visualizar.setText("Visualizar");

        jMenuItem5.setText("Produtos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        item_visualizar.add(jMenuItem5);

        jMenuItem8.setText("Usuários");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        item_visualizar.add(jMenuItem8);

        jMenuBar1.add(item_visualizar);

        jMenu2.setText("Comprar");

        jMenuItem6.setText("Comprar produtos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Deletar");

        jMenuItem9.setText("Deletar usuário");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem11.setText("Deletar produto");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AdicionarUsuario newUser = new AdicionarUsuario();
        newUser.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AdicionarProduto newProduto = new AdicionarProduto(idUsuarioLogado);
        newProduto.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       EditarPessoa editarPessoa = new EditarPessoa();
       editarPessoa.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        BuscarProduto buscarProd = new BuscarProduto();
        buscarProd.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ComprarProduto vProdutos = new ComprarProduto();
        vProdutos.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       
        EditarProduto editarProduto = new EditarProduto();
        
        editarProduto.show();
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        BuscarUsuarios buscarUser = new BuscarUsuarios();
        buscarUser.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        DeleteUsuario del = new DeleteUsuario();
        del.show();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        DeleteProduto delp = new DeleteProduto();
        delp.show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu item_editar;
    private javax.swing.JMenu item_novo;
    private javax.swing.JMenu item_visualizar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
