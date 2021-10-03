/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdm.hermanas.telas;

import com.gdm.hermanas.model.Fornecedor;
import com.gdm.hermanas.repositorio.FornecedorRepository;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deibi
 */
public class TelaFornecedores extends javax.swing.JDialog {

   private final FornecedorRepository repository;
   
    public TelaFornecedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        repository = new FornecedorRepository();
        
        listagem();
    }

   private void listagem() {

        List<Fornecedor> lista = repository.lista(Fornecedor.class);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[5];
        lista.forEach(i -> {

            row[0] = i.getId();
            row[1] = i.getNome().toUpperCase();
            row[2] = i.getEmail();
            row[3] = i.getFone();
            row[4] = i.getRamo().toUpperCase();

            modelo.addRow(row);
        });

        if (lista.isEmpty()) {
            row[1] = "Nenhum fornecedor";
            modelo.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        fone = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRamo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fornecedores");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOME", "EMAIL", "TELEFONE", "RAMO"
            }
        ));
        tabela.setGridColor(new java.awt.Color(245, 239, 239));
        tabela.setRowHeight(25);
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(70);
            tabela.getColumnModel().getColumn(0).setMaxWidth(72);
            tabela.getColumnModel().getColumn(1).setMinWidth(200);
            tabela.getColumnModel().getColumn(1).setMaxWidth(220);
            tabela.getColumnModel().getColumn(2).setMinWidth(200);
            tabela.getColumnModel().getColumn(2).setMaxWidth(210);
            tabela.getColumnModel().getColumn(4).setMinWidth(120);
        }

        jLabel1.setText("Nome:");

        try {
            fone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Telefone:");

        jLabel3.setText("Email:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N

        txtRamo.setText("Ex ROUPAS, BIJU");
        txtRamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRamoMouseClicked(evt);
            }
        });

        jLabel5.setText("Ramo de Atividade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addComponent(nome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(fone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtRamo)))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRamo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fone)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Fornecedor f = new Fornecedor();
        f.setEmail(email.getText());
        f.setFone(fone.getText());
        f.setNome(nome.getText());
        f.setRamo(txtRamo.getText());
        
        repository.saveOrUpdate(f);
        listagem();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtRamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRamoMouseClicked
        txtRamo.setText("");
    }//GEN-LAST:event_txtRamoMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JFormattedTextField fone;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField nome;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtRamo;
    // End of variables declaration//GEN-END:variables
}
