package com.gdm.hermanas.app;

import com.gdm.hermanas.model.Cliente;
import com.gdm.hermanas.repositorio.ClienteRepository;
import com.gdm.hermanas.telas.TelaAjuda;
import com.gdm.hermanas.telas.TelaAniversariantes;
import com.gdm.hermanas.telas.TelaClientes;
import com.gdm.hermanas.telas.TelaFornecedores;
import com.gdm.hermanas.telas.TelaMasterLogin;
import com.gdm.hermanas.telas.TelaPdvMain;
import com.gdm.hermanas.telas.TelaProdutos;
import com.gdm.hermanas.telas.TelaRelatorio;
import com.gdm.hermanas.telas.TelaUsuarios;
import java.awt.Dimension;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public final class App extends javax.swing.JFrame {

    private TelaClientes telaClientes;
    private TelaProdutos telaProdutos;
    public static int privacity = 0;
    private List<Cliente> lista = new ArrayList<>();

    private TelaPdvMain telaPdv;

    public App() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);

        showAniversariantesDoDia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        txtAniversariantesAlert = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nomeUser = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hermanas  v1.0");

        toolbar.setBackground(new java.awt.Color(0, 0, 0));
        toolbar.setFloatable(false);
        toolbar.setRollover(true);
        toolbar.setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/consumer_1.png"))); // NOI18N
        jButton1.setText(" Meus Clientes ");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        toolbar.add(jButton1);
        toolbar.add(jSeparator1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produto.png"))); // NOI18N
        jButton2.setText(" Meus Produtos ");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        toolbar.add(jButton2);
        toolbar.add(jSeparator2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calculadora.png"))); // NOI18N
        jButton3.setText(" Calculadora ");
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        toolbar.add(jButton3);
        toolbar.add(jSeparator3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lock_security.png"))); // NOI18N
        jButton5.setText(" Privacidade");
        jButton5.setBorderPainted(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        toolbar.add(jButton5);
        toolbar.add(jSeparator4);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-report-file-48.png"))); // NOI18N
        jButton6.setText(" Relatórios ");
        jButton6.setBorderPainted(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        toolbar.add(jButton6);
        toolbar.add(jSeparator5);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/barcode.png"))); // NOI18N
        jButton7.setText(" Vendas PDV ");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        toolbar.add(jButton7);
        toolbar.add(jSeparator6);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-menos-48.png"))); // NOI18N
        jButton4.setText(" Fechar ");
        jButton4.setBorderPainted(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        toolbar.add(jButton4);

        desktop.setBackground(new java.awt.Color(217, 233, 249));

        txtAniversariantesAlert.setForeground(new java.awt.Color(145, 143, 143));
        txtAniversariantesAlert.setText("-");
        txtAniversariantesAlert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtAniversariantesAlert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAniversariantesAlertMouseClicked(evt);
            }
        });

        desktop.setLayer(txtAniversariantesAlert, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtAniversariantesAlert)
                .addContainerGap())
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAniversariantesAlert)
                .addContainerGap(504, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Usuário:");

        nomeUser.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        nomeUser.setForeground(new java.awt.Color(102, 102, 102));
        nomeUser.setText("NomeUser");

        jMenu1.setText("Cadastros");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lock_security.png"))); // NOI18N
        jMenuItem1.setText("Usuários do Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator7);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/consumer.png"))); // NOI18N
        jMenuItem2.setText("Meus Fornecedores");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator8);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/consumer_1.png"))); // NOI18N
        jMenuItem3.setText("Meus Clientes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator9);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produto.png"))); // NOI18N
        jMenuItem4.setText("Meus Produtos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem5.setText("Informações");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
            .addComponent(desktop)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desktop)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeUser))
                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (telaClientes == null) {
            telaClientes = new TelaClientes();
            desktop.add(telaClientes);
        }
        telaClientes.setLocation(40, 40);
        telaClientes.setVisible(true);
        telaClientes.toFront();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showTelaProdutos();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void showAniversariantesDoDia() {
       List<Cliente> listagem = new ClienteRepository().lista(Cliente.class);

        listagem.forEach(c -> {
            if (!c.getNascimento().equals("  /  /    ") && !c.getNascimento().isBlank()) {
                int dia =  Integer.parseInt(c.getNascimento().split("/")[0]);
                int mes = Integer.parseInt(c.getNascimento().split("/")[1]);
                
                if (dia == LocalDate.now().getDayOfMonth() && mes == LocalDate.now().getMonthValue()) {
                    lista.add(c);
                }
            }
        });

        if (!lista.isEmpty()) {
            txtAniversariantesAlert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/aniversario.png")));
            txtAniversariantesAlert.setText("Aniversariante(s) do dia");
        }
    }

    public void showTelaProdutos() {
        if (telaProdutos == null) {
            telaProdutos = new TelaProdutos();
            desktop.add(telaProdutos);
        }
        telaProdutos.setVisible(true);
        telaProdutos.toFront();

        Dimension desktopSize = desktop.getSize();
        Dimension screenSize = telaProdutos.getSize();
        telaProdutos.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Runtime rt = Runtime.getRuntime();

        try {
            rt.exec("calc");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No Windows:Erro ao tentar executar calculadora!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        hideFrames();

        TelaMasterLogin master = new TelaMasterLogin(this);
        master.setAlwaysOnTop(true);
        master.setVisible(true);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        TelaRelatorio tr = new TelaRelatorio(null, rootPaneCheckingEnabled);
        tr.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (telaPdv == null) {
            telaPdv = new TelaPdvMain();
            desktop.add(telaPdv);
        }

        telaPdv.setVisible(true);
        telaPdv.toFront();

        Dimension desktopSize = desktop.getSize();
        Dimension screenSize = telaPdv.getSize();
        telaPdv.setLocation((desktopSize.width - screenSize.width) / 2, (desktopSize.height - screenSize.height) / 2);
        telaPdv.txtCodigoBar.requestFocus();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaFornecedores fn = new TelaFornecedores(this, rootPaneCheckingEnabled);

        fn.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaUsuarios user = new TelaUsuarios(this, rootPaneCheckingEnabled);
        user.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        showTelaProdutos();

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (telaClientes == null) {
            telaClientes = new TelaClientes();
            desktop.add(telaClientes);
        }
        telaClientes.setLocation(40, 40);
        telaClientes.setVisible(true);
        telaClientes.toFront();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txtAniversariantesAlertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAniversariantesAlertMouseClicked
        DefaultListModel<String> model = new DefaultListModel();
        
        lista.forEach(it -> model.addElement(it.getNome()+" - "+it.getTelefone1()));
        
        TelaAniversariantes ta = new TelaAniversariantes(model);
        desktop.add(ta);
        ta.setLocation(desktop.getWidth() - 300, 10);
        
        ta.setVisible(true);
        
        
        
    }//GEN-LAST:event_txtAniversariantesAlertMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TelaAjuda aj = new TelaAjuda(this, rootPaneCheckingEnabled);
        aj.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    public void hideFrames() {
        for (JInternalFrame tela : desktop.getAllFrames()) {
            tela.hide();
        }

        privacity = 1;
    }

    public void showFrames() {
        for (JInternalFrame tela : desktop.getAllFrames()) {
            tela.show();
        }

        privacity = 0;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {

        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    public static javax.swing.JLabel nomeUser;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JLabel txtAniversariantesAlert;
    // End of variables declaration//GEN-END:variables
}
