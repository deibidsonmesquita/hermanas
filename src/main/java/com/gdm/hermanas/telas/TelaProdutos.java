package com.gdm.hermanas.telas;

import com.gdm.hermanas.model.Produto;
import com.gdm.hermanas.repositorio.GenericDao;
import com.gdm.hermanas.repositorio.ProdutoRepository;
import com.gdm.hermanas.util.ColorColumnRenderer;
import com.gdm.hermanas.util.ProcessRetorno;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaProdutos extends javax.swing.JInternalFrame implements ProcessRetorno {

    private final GenericDao repository;
    private final NumberFormat formt = NumberFormat.getCurrencyInstance();

    public TelaProdutos() {
        initComponents();

        this.repository = new ProdutoRepository();
        listagemProdutos();
    }

    private void listagemProdutos() {

        List<Produto> lista = repository.lista(Produto.class);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        
       // tabela.setDefaultRenderer(Object.class, new ColorColumnRenderer());

        Object[] row = new Object[9];
        lista.forEach(i -> {

            row[0] = i.getId();
            row[1] = i.getNome();
            row[2] = formt.format(i.getValorVenda());
            row[3] = i.getEstoque().getInicial();
            row[4] = i.getEstoque().getInicial() - i.getEstoque().getAtual();
            row[5] = formt.format(i.getValorPromo());
            row[6] = i.getCor();
            row[7] = i.getTamanho();
            row[8] = i.getMargen() + "%";

            modelo.addRow(row);
        });

        if (lista.isEmpty()) {
            row[1] = "Nenhum produto cadastrado";
            modelo.addRow(row);
        }
    }

    private void listagemProdutosSemEstoque() {

        List<Produto> lista = repository.lista(Produto.class);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        
        tabela.setDefaultRenderer(Object.class, new ColorColumnRenderer());

        Object[] row = new Object[9];
        var contatdor = 0;
        for(Produto  i : lista) {
            if (i.getEstoque().getInicial() == (i.getEstoque().getInicial() - i.getEstoque().getAtual())) {
                row[0] = i.getId();
                row[1] = i.getNome();
                row[2] = formt.format(i.getValorVenda());
                row[3] = i.getEstoque().getInicial();
                row[4] = i.getEstoque().getInicial() - i.getEstoque().getAtual();
                row[5] = formt.format(i.getValorPromo());
                row[6] = i.getCor();
                row[7] = i.getTamanho();
                row[8] = i.getMargen() + "%";

                modelo.addRow(row);
                contatdor++;
                
            }
        }

        if (contatdor == 0) {
            row[1] = "Nenhum produto sem estoque";
            modelo.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        busca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setTitle("Produtos");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+ Novo Produto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOME", "PREÇO VENDA", "ESTOQUE", "VENDAS", "PROMOÇÃO", "COR", "TAMANHO", "MARGEM (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setGridColor(new java.awt.Color(239, 248, 252));
        tabela.setRowHeight(32);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(110);
            tabela.getColumnModel().getColumn(1).setMinWidth(200);
            tabela.getColumnModel().getColumn(3).setMinWidth(80);
            tabela.getColumnModel().getColumn(3).setMaxWidth(85);
            tabela.getColumnModel().getColumn(4).setMinWidth(80);
            tabela.getColumnModel().getColumn(4).setMaxWidth(85);
            tabela.getColumnModel().getColumn(7).setMinWidth(90);
            tabela.getColumnModel().getColumn(7).setMaxWidth(95);
            tabela.getColumnModel().getColumn(8).setMinWidth(90);
            tabela.getColumnModel().getColumn(8).setMaxWidth(95);
        }

        busca.setBackground(new java.awt.Color(255, 255, 232));
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/share.png"))); // NOI18N
        jMenu1.setText("Arquivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-list-16.png"))); // NOI18N
        jMenuItem1.setText("Ver Produtos sem Estoque");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-list-16.png"))); // NOI18N
        jMenuItem2.setText("Ver Todos os Produtos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(busca)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaCadastroProduto tp = new TelaCadastroProduto(null, closable, this);
        tp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabela.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabela.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

        if (evt.getClickCount() > 1) {
            long id = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);

            TelaCadastroProduto tc = new TelaCadastroProduto(null, closable, this, id);
            tc.setVisible(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        listagemProdutos();
    }//GEN-LAST:event_formComponentShown

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       listagemProdutosSemEstoque();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        listagemProdutos();
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    @Override
    public void retorno(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   

    @Override
    public void update() {
        listagemProdutos();
    }
}
