/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.gdm.hermanas.telas;

import com.gdm.hermanas.app.App;
import com.gdm.hermanas.model.Caixa;
import com.gdm.hermanas.model.Item;
import com.gdm.hermanas.model.Produto;
import com.gdm.hermanas.model.Venda;
import com.gdm.hermanas.repositorio.CaixaRepository;
import com.gdm.hermanas.repositorio.ProdutoRepository;
import com.gdm.hermanas.repositorio.VendaRepository;
import com.gdm.hermanas.util.ProcessRetorno;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deibi
 */
public class TelaPdvMain extends javax.swing.JInternalFrame implements ProcessRetorno{
    
    private final List<Item> itensVenda = new ArrayList<>();
    
    public TelaPdvMain() {
        initComponents();
        
        txtCodigoBar.requestFocus();
        tabMaster.setSelectedIndex(1);
    }
    
    private void addItenVenda(Item item) {
        
        Optional<Item> itm = itensVenda.stream().filter(i -> i.getProduto().getId() == item.getProduto().getId()).findFirst();
        
        if (itm.isPresent()) {
            itm.get().setQtde(itm.get().getQtde() + item.getQtde());
            itm.get().setSubtotal(itm.get().getSubtotal().add(item.getSubtotal()));
            
            itensVenda.removeIf(it -> it.getProduto().getId() == item.getProduto().getId()
                    || it.getProduto().getCodbar().equals(item.getProduto().getCodbar()));
            
            itensVenda.add(itm.get());
        } else {
            itensVenda.add(item);
        }
        
        listaItensVenda();
    }
    
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
    
    private void listaItensVenda() {
        
        DefaultTableModel modelo = (DefaultTableModel) tabelaCupom.getModel();
        modelo.setNumRows(0);
        
        Object[] row = new Object[5];
        
        itensVenda.forEach(it -> {
            
            row[0] = it.getProduto().getId();
            row[1] = it.getProduto().getNome();
            row[2] = it.getQtde();
            if (opcPromocional.isSelected()) {
                row[3] = it.getProduto().getValorPromo();
                row[4] = it.getProduto().getValorPromo().multiply(new BigDecimal(it.getQtde()));
            } else {
                row[3] = it.getProduto().getValorVenda();
                row[4] = it.getProduto().getValorVenda().multiply(new BigDecimal(it.getQtde()));
            }
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
        jLabel1 = new javax.swing.JLabel();
        txtCodigoBar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQtde = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        txtPrecoUnt = new com.gdm.hermanas.util.JNumberFormatField();
        tabMaster = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCupom = new javax.swing.JTable();
        txtDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalVenda = new com.gdm.hermanas.util.JNumberFormatField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        opcPromocional = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("PDV");

        jPanel3.setBackground(new java.awt.Color(191, 216, 232));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Código de Barras / Código do Produto");

        txtCodigoBar.setBackground(new java.awt.Color(255, 255, 243));
        txtCodigoBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(253, 253, 239), 6, true));
        txtCodigoBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Qtde:");

        txtQtde.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtQtde.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Preço Unitário:");

        txtPrecoUnt.setForeground(new java.awt.Color(0, 51, 0));
        txtPrecoUnt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        tabMaster.addTab("Tabela", jPanel2);

        txtDesc.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        txtDesc.setForeground(new java.awt.Color(51, 51, 51));
        txtDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDesc.setText("CAIXA LIVRE");
        txtDesc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 6, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Total da Venda:");

        txtTotalVenda.setForeground(new java.awt.Color(0, 51, 102));
        txtTotalVenda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton2.setText("Finalizar Venda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-menos-16.png"))); // NOI18N
        jButton1.setText("Cancelar Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lock.png"))); // NOI18N
        jButton3.setText("Fechar Caixa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnDeleteItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-lixo-24.png"))); // NOI18N
        btnDeleteItem.setText("Remover Produto");
        btnDeleteItem.setEnabled(false);
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("GDMSISTEMAS");

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Foto Produto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        opcPromocional.setBackground(new java.awt.Color(191, 216, 232));
        opcPromocional.setForeground(new java.awt.Color(51, 51, 51));
        opcPromocional.setText("Valor Promocional");
        opcPromocional.setToolTipText("Cuidado: Utiliza apenas o preço promocional cadastrado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrecoUnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQtde, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(opcPromocional)))
                            .addComponent(txtCodigoBar)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(tabMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDesc)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecoUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(opcPromocional))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tabMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jMenu1.setText("Atalhos");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jMenuItem1.setText("Finalizar Venda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-menos-16.png"))); // NOI18N
        jMenuItem2.setText("Cancelar Venda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-impressão-16.png"))); // NOI18N
        jMenuItem3.setText("Minhas Vendas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaCupomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCupomMouseClicked
        btnDeleteItem.setEnabled(true);
    }//GEN-LAST:event_tabelaCupomMouseClicked

    private void txtCodigoBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarActionPerformed
        
        long codigo = Long.parseLong(txtCodigoBar.getText());
        
        Produto produto = new ProdutoRepository().find(Produto.class, codigo);
        
        if (produto != null) {
            txtDesc.setText(produto.getNome());
            
            Item item = new Item((Integer) txtQtde.getValue());
            item.setProduto(produto);
            
            if (opcPromocional.isSelected()) {
                txtPrecoUnt.setValue(produto.getValorPromo());
                item.setSubtotal(produto.getValorPromo().multiply(new BigDecimal(item.getQtde())));
            } else {
                txtPrecoUnt.setValue(produto.getValorVenda());
                item.setSubtotal(produto.getValorVenda().multiply(new BigDecimal(item.getQtde())));
            }
            
            item.setVenda(null);
            
            addItenVenda(item);
            txtCodigoBar.setText("");
            txtCodigoBar.requestFocus();
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Produto não encontrado.", "Código inexistente", 0);
            txtCodigoBar.setText("");
            txtCodigoBar.requestFocus();
        }

    }//GEN-LAST:event_txtCodigoBarActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        if (tabelaCupom.getSelectedRow() != -1) {
            long id = (long) tabelaCupom.getValueAt(tabelaCupom.getSelectedRow(), 0);
            itensVenda.removeIf(it -> it.getProduto().getId() == id);
            listaItensVenda();
            btnDeleteItem.setEnabled(false);
            txtCodigoBar.requestFocus();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o item na tabela a ser removido.", " Selecione", 0);
        }
    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetPdv();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtTotalVenda.getValue().intValue() > 0) {
            Venda venda = new Venda();
            venda.setDataVenda(LocalDate.now());
            venda.setRepsonsavel(App.nomeUser.getText());
            venda.setTotal(txtTotalVenda.getValue());
            venda.setItens(itensVenda);
          
            
            TelaFinalizaVenda fn = new TelaFinalizaVenda(null, closable, venda, this);
            fn.setVisible(true);
            
            resetPdv();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Venda não concluida.", " Venda com valor 0", 0);
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (txtTotalVenda.getValue().intValue() > 0) {
            Venda venda = new Venda();
            venda.setDataVenda(LocalDate.now());
            venda.setRepsonsavel(App.nomeUser.getText());
            venda.setTotal(txtTotalVenda.getValue());
            venda.setItens(itensVenda);
          
            
            TelaFinalizaVenda fn = new TelaFinalizaVenda(null, closable, venda, this);
            fn.setVisible(true);
            
            resetPdv();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Venda não concluida.", " Venda com valor 0", 0);
            
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        resetPdv();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaVendas tv = new TelaVendas(null, closable);
        tv.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int opc = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente fechar o caixa de hoje?", "Confirme", JOptionPane.OK_CANCEL_OPTION);
        if (opc == 0) {
            BigDecimal total = new VendaRepository().total(LocalDate.now());
            new CaixaRepository().saveOrUpdate(new Caixa(LocalDateTime.now(), total, App.nomeUser.getText()));
            JOptionPane.showMessageDialog(rootPane, "Sucesso caixa encerrado\nData " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "  Total R$" + total, "Confirmado", JOptionPane.OK_CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JCheckBox opcPromocional;
    private javax.swing.JTabbedPane tabMaster;
    private javax.swing.JTable tabelaCupom;
    public javax.swing.JTextField txtCodigoBar;
    private javax.swing.JTextField txtDesc;
    private com.gdm.hermanas.util.JNumberFormatField txtPrecoUnt;
    private javax.swing.JSpinner txtQtde;
    private com.gdm.hermanas.util.JNumberFormatField txtTotalVenda;
    // End of variables declaration//GEN-END:variables

    @Override
    public void retorno(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        resetPdv();
    }
}
