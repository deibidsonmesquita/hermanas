package com.gdm.hermanas.app;

import com.gdm.hermanas.telas.TelaMasterLogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Splash extends JWindow {

    private static final long serialVersionUID = 1L;

    private final int duration;

    private Splash(int d) {
        duration = d;
    }

    public void showSplash() {

        JPanel content = (JPanel) getContentPane();
        JProgressBar progress = new JProgressBar();
        progress.setIndeterminate(true);
        progress.setBorderPainted(false);

        content.setBackground(Color.white);
        int width = 780;
        int height = 405;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        JLabel label = new JLabel();

        label.setIcon(new ImageIcon(getClass().getResource("/imagens/bg.png")));
        content.add(label, "Center");
        content.add(progress, BorderLayout.SOUTH);

        setVisible(true);

        //-----inicio hibernate & update parcelas status------
     
        //-----fim update parcelas status------

        try {
            Thread.sleep(duration);

        } catch (InterruptedException e) {
        }
        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();
        System.exit(0);
    }

    public static void main(String args[]) throws IOException, SQLException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Splash splash = new Splash(1500);
        splash.showSplash();

        try {
            ////Verifica se o sistema ja esta em execução
            @SuppressWarnings("unused")
            ServerSocket socket = null;
            socket = new ServerSocket(2216);

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                //Windows, Metal, Nimbus
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);

        } catch (BindException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, "A aplicação já está em execução!");
            System.exit(0);

        }

        TelaMasterLogin login = new TelaMasterLogin();
        login.setVisible(true);

    }

}
