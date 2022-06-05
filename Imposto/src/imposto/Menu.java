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
    /**
     * Creates new form Menu
     */
    public Menu(Integer idUsuarioLogado, Integer IdTipoUsuarioLogado, String nomeTipoLogado) {

        initComponents();
        
        produtor = new ListarProduto();
        produto = produtor.criarPanelProduto();
        System.out.println(produto);
        add(produto);
        jPanel2.add(produto);
        
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
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        item_novo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        item_editar = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        item_visualizar = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu item_editar;
    private javax.swing.JMenu item_novo;
    private javax.swing.JMenu item_visualizar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
