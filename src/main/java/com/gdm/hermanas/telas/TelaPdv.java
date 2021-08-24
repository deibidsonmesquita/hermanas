package com.gdm.hermanas.telas;

import com.gdm.hermanas.model.Item;
import com.gdm.hermanas.model.Produto;
import com.gdm.hermanas.model.Venda;
import com.gdm.hermanas.repositorio.ProdutoRepository;
import com.gdm.hermanas.repositorio.VendaRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaPdv extends javax.swing.JInternalFrame {

    private final List<Item> itensVenda = new ArrayList<>();

    public TelaPdv() {
        initComponents();

        txtCodigoBar.requestFocus();
        tabMaster.setSelectedIndex(1);
    }

    private void addItenVenda(Item item) {
        itensVenda.add(item);
        listaItensVenda();
    }

    private void listaItensVenda() {

        DefaultTableModel modelo = (DefaultTableModel) tabelaCupom.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[5];

        itensVenda.forEach(it -> {

            row[0] = it.getProduto().getId();
            row[1] = it.getProduto().getNome();
            row[2] = it.getQtde();
            row[3] = it.getProduto().getValorVenda();
            row[4] = it.getProduto().getValorVenda().multiply(new BigDecimal(it.getQtde()));
            modelo.addRow(row);

        });

        txtTotalVenda.setValue(
                itensVenda
                        .stream()
                        .map(it -> it.getSubtotal())
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtDesc = new javax.swing.JTextField();
        tabMaster = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCupom = new javax.swing.JTable();
        txtTotalVenda = new com.gdm.pantoja.app.util.JNumberFormatField();
        txtCodigoBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtQtde = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtPrecoUnt = new com.gdm.pantoja.app.util.JNumberFormatField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();

        setBackground(new java.awt.Color(44, 75, 98));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Venda PDV");
        setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(44, 75, 98));

        txtDesc.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtDesc.setForeground(new java.awt.Color(51, 51, 51));
        txtDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDesc.setText("CAIXA LIVRE");
        txtDesc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 6, true));

        tabMaster.setForeground(new java.awt.Color(102, 102, 102));
        tabMaster.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextArea1.setBackground(new java.awt.Color(255, 255, 246));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        tabMaster.addTab("Cupom", jPanel1);

        tabelaCupom.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        tabelaCupom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "Descrição", "Qtde", "Unit.", "SubTotal"
            }
        ));
        tabelaCupom.setGridColor(new java.awt.Color(250, 250, 250));
        tabelaCupom.setRowHeight(25);
        tabelaCupom.setShowVerticalLines(true);
        tabelaCupom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCupomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCupom);
        if (tabelaCupom.getColumnModel().getColumnCount() > 0) {
            tabelaCupom.getColumnModel().getColumn(0).setMinWidth(70);
            tabelaCupom.getColumnModel().getColumn(0).setMaxWidth(75);
            tabelaCupom.getColumnModel().getColumn(1).setMinWidth(200);
            tabelaCupom.getColumnModel().getColumn(1).setMaxWidth(210);
            tabelaCupom.getColumnModel().getColumn(2).setMinWidth(70);
            tabelaCupom.getColumnModel().getColumn(2).setMaxWidth(75);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        tabMaster.addTab("Tabela", jPanel2);

        txtTotalVenda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 8, true));
        txtTotalVenda.setForeground(new java.awt.Color(0, 51, 102));
        txtTotalVenda.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N

        txtCodigoBar.setBackground(new java.awt.Color(255, 255, 243));
        txtCodigoBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(253, 253, 239), 6, true));
        txtCodigoBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Código de Barras / Código do Produto");

        jButton1.setText("Cancelar Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton2.setText("Finalizar Venda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtQtde.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtQtde.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Quantidade:");

        txtPrecoUnt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Preço Unitário:");

        jButton3.setText("Fechar Caixa");

        btnDeleteItem.setText("Remover Produto");
        btnDeleteItem.setEnabled(false);
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Total da Venda:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(224, 222, 222));
        jLabel5.setText("GDM SISTEMAS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 1087, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTotalVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodigoBar)
                                .addComponent(jLabel1)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPrecoUnt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtQtde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tabMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecoUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnDeleteItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        jMenuBar1.setOpaque(true);

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Minhas Vendas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Meu Estoque");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Funções");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jMenuItem4.setText("Finalizar Venda");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);
        jMenu2.add(jSeparator3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem5.setText("Cancelar Venda");
        jMenu2.add(jMenuItem5);
        jMenu2.add(jSeparator2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem3.setText("Fechar Caixa");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Venda venda = new Venda();
        venda.setDataVenda(LocalDate.now());
        venda.setRepsonsavel("Deibidson");
        venda.setTotal(txtTotalVenda.getValue());
        venda.setItens(itensVenda);
        venda.setPgto(FormaPgto.DINHEIRO);

        new VendaRepository().saveOrUpdate(venda);
        JOptionPane.showMessageDialog(rootPane, "Venda efetuada com sucesso.", " Venda confirmada", 1);

        resetPdv();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void resetPdv() {
        itensVenda.clear();
        listaItensVenda();
        txtTotalVenda.setValue(BigDecimal.ZERO);
        txtPrecoUnt.setValue(BigDecimal.ZERO);
        txtQtde.setValue(1);
        txtCodigoBar.setText("");

        txtDesc.setText("CAIXA LIVRE");
        txtCodigoBar.requestFocus();

    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaVendas tv = new TelaVendas(null, closable);
        tv.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtCodigoBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarActionPerformed
        
        long codigo = Long.parseLong(txtCodigoBar.getText());

        Produto produto = new ProdutoRepository().find(Produto.class, codigo);

        if (produto != null) {
            txtDesc.setText(produto.getNome());
            txtPrecoUnt.setValue(produto.getValorVenda());

            Item item = new Item((Integer) txtQtde.getValue());
            item.setProduto(produto);
            item.setVenda(null);
            item.setSubtotal(produto.getValorVenda().multiply(new BigDecimal(item.getQtde())));

            addItenVenda(item);
            txtCodigoBar.setText("");
            txtCodigoBar.requestFocus();
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Produto não encontrado.", "Código inexistente", 0);
            txtCodigoBar.setText("");
            txtCodigoBar.requestFocus();
        }
        
        
    }//GEN-LAST:event_txtCodigoBarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Venda venda = new Venda();
        venda.setDataVenda(LocalDate.now());
        venda.setRepsonsavel("Deibidson");
        venda.setTotal(txtTotalVenda.getValue());
        venda.setItens(itensVenda);
        venda.setPgto(FormaPgto.DINHEIRO);

        new VendaRepository().saveOrUpdate(venda);
        JOptionPane.showMessageDialog(rootPane, "Venda efetuada com sucesso.", " Venda confirmada", 1);

        resetPdv();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        if (tabelaCupom.getSelectedRow() != -1) {
            long id = (long) tabelaCupom.getValueAt(tabelaCupom.getSelectedRow(), 0);
            itensVenda.removeIf(it -> it.getProduto().getId() == id);
            listaItensVenda();
            btnDeleteItem.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o item na tabela a ser removido.", " Selecione", 0);
        }

    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void tabelaCupomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCupomMouseClicked
        btnDeleteItem.setEnabled(true);
    }//GEN-LAST:event_tabelaCupomMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetPdv();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTabbedPane tabMaster;
    private javax.swing.JTable tabelaCupom;
    public javax.swing.JTextField txtCodigoBar;
    private javax.swing.JTextField txtDesc;
    private com.gdm.pantoja.app.util.JNumberFormatField txtPrecoUnt;
    private javax.swing.JSpinner txtQtde;
    private com.gdm.pantoja.app.util.JNumberFormatField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}
