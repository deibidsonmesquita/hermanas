package com.gdm.hermanas.telas;

import com.gdm.hermanas.model.Cliente;
import com.gdm.hermanas.repositorio.ClienteRepository;
import com.gdm.hermanas.repositorio.GenericDao;

import com.gdm.hermanas.util.ProcessRetorno;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaClientes extends javax.swing.JInternalFrame implements ProcessRetorno {

    private final GenericDao repository;
    private long id = 0L;

    public TelaClientes() {
        initComponents();

        repository = new ClienteRepository();
        listaClientes();
    }

    private void listaClientes() {

        List<Cliente> lista = (List<Cliente>) repository.lista(Cliente.class);

        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setNumRows(0);

        Object[] row = new Object[7];
        lista.forEach(i -> {

            row[0] = i.getCodigo();
            row[1] = i.getNome();
            row[2] = i.getTelefone1();
            row[3] = i.getTelefone2();
            row[4] = i.getCpf();
            row[5] = i.getSexo();
            row[6] = i.getNascimento();

            modelo.addRow(row);
        });

        if (lista.isEmpty()) {
            row[1] = "Nenhum cliente cadastrado";
            modelo.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtbusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMsn = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(156, 188, 253), 4, true));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setTitle("Clientes");

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Telefone 1", "Telefone 2", "CPF", "Sexo", "Aniversário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.setGridColor(new java.awt.Color(239, 248, 252));
        tabelaClientes.setRowHeight(32);
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);
        if (tabelaClientes.getColumnModel().getColumnCount() > 0) {
            tabelaClientes.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelaClientes.getColumnModel().getColumn(1).setMinWidth(220);
            tabelaClientes.getColumnModel().getColumn(5).setMinWidth(60);
            tabelaClientes.getColumnModel().getColumn(5).setMaxWidth(65);
        }

        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(204, 0, 0));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-lixo-24.png"))); // NOI18N
        btndelete.setText("Deletar cliente");
        btndelete.setBorderPainted(false);
        btndelete.setEnabled(false);
        btndelete.setOpaque(true);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("+ Novo Cadastro");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtbusca.setBackground(new java.awt.Color(252, 252, 238));
        txtbusca.setBorder(null);
        txtbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscaKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-24.png"))); // NOI18N
        jLabel1.setText("Procurar:");

        txtMsn.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMsn, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbusca)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMsn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaCadastroCliente cd = new TelaCadastroCliente(this);
        cd.setModal(true);
        cd.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        btndelete.setEnabled(true);
        id = (long) tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0);
        System.out.println(id);
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try {
            if (id > 0L) {
                repository.deleteById(Cliente.class, id);
                btndelete.setEnabled(false);
                listaClientes();
            }
        } catch (Exception ex) {
            txtMsn.setText("Cliente não pode ser excluido. Tem empréstimo em aberto.");
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtbuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaKeyTyped
        DefaultTableModel table = (DefaultTableModel) tabelaClientes.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tabelaClientes.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(txtbusca.getText().toUpperCase()));
    }//GEN-LAST:event_txtbuscaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JLabel txtMsn;
    private javax.swing.JTextField txtbusca;
    // End of variables declaration//GEN-END:variables

    @Override
    public void retorno(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        listaClientes();
    }
}
