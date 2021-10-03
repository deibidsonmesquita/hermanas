/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdm.hermanas.telas;

import com.gdm.hermanas.model.Venda;
import com.gdm.hermanas.repositorio.VendaRepository;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author deibi
 */
public class TelaVendas extends javax.swing.JDialog {

    private VendaRepository repository;

    public TelaVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        repository = new VendaRepository();
        listagemVendas();
        txtDataVenda.setDate(Calendar.getInstance().getTime());
    }
    
     public ImageIcon icone() {
        return new ImageIcon(getClass().getResource("/imagens/icons8-calendar-16.png"));
    }

    private void listagemVendas() {

        List<Venda> lista = repository.lista(Venda.class);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[5];
        lista.forEach(i -> {

            row[0] = i.getId();
            row[1] = i.getDataVenda().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            row[2] = i.getTotal();
            row[3] = i.getRepsonsavel();
            row[4] = i.getPgto();

            modelo.addRow(row);
        });

        if (lista.isEmpty()) {
            row[1] = "Nenhuma venda";
            modelo.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        busca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtDataVenda = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas Efetuadas");

        tabela.setAutoCreateRowSorter(true);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Total", "Responsável", "Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setGridColor(new java.awt.Color(236, 234, 234));
        tabela.setRowHeight(25);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(105);
            tabela.getColumnModel().getColumn(3).setMinWidth(200);
        }

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscaKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        jLabel2.setText("Filtro:");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-menos-16.png"))); // NOI18N
        btnDelete.setText("Remover Venda");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtDataVenda.setDateFormatString("dd/MM/yyyy");
        txtDataVenda.setIcon(icone());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(btnDelete))
                    .addComponent(txtDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabela.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabela.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(busca.getText().toUpperCase()));
    }//GEN-LAST:event_buscaKeyTyped

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        long id = Long.parseLong(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        new VendaRepository().deleteById(Venda.class, id);
        listagemVendas();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tabelaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaVendas dialog = new TelaVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField busca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private com.toedter.calendar.JDateChooser txtDataVenda;
    // End of variables declaration//GEN-END:variables
}
