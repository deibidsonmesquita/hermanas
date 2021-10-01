package com.gdm.hermanas.telas;

import com.gdm.hermanas.model.Produto;
import com.gdm.hermanas.repositorio.GenericDao;
import com.gdm.hermanas.repositorio.ProdutoRepository;
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

        Object[] row = new Object[8];
        lista.forEach(i -> {

            row[0] = i.getId();
            row[1] = i.getNome();
            row[2] = formt.format(i.getValorVenda());
            row[3] = i.getEstoque().getInicial();
            row[4] = formt.format(i.getValorPromo());
            row[5] = i.getCor();
            row[6] = i.getTamanho();
            row[7] = i.getMargen() + "%";

            modelo.addRow(row);
        });

        if (lista.isEmpty()) {
            row[1] = "Nenhum produto cadastrado";
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

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setTitle("Produtos");

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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOME", "PREÇO VENDA", "ESTOQUE", "PROMOÇÃO", "COR", "TAMANHO", "MARGEM (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            tabela.getColumnModel().getColumn(6).setMinWidth(90);
            tabela.getColumnModel().getColumn(6).setMaxWidth(95);
            tabela.getColumnModel().getColumn(7).setMinWidth(90);
            tabela.getColumnModel().getColumn(7).setMaxWidth(95);
        }

        busca.setBackground(new java.awt.Color(255, 255, 232));
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
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
        if(evt.getClickCount() > 1){
            long id = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
            
            TelaCadastroProduto tc = new TelaCadastroProduto(null, closable, this, id);
            tc.setVisible(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
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
