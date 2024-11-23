/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_Iniciais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author renan_8tvcd4n
 */
public class Tela_Login extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Login
     */
    public Tela_Login() {
        initComponents();
    }
    
    public static int id_usuario;
    
    private void verificarLogin() throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;

        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        String usuario = Text_login.getText();
        String senha = Text_senha_login.getText();

        try {
            connection = DriverManager.getConnection(url, user, psswrd);
            String query = "SELECT * FROM usuario WHERE login_usuario = ? AND senha = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, usuario);
            statement.setString(2, senha);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id_usuario = resultSet.getInt("id_usuario");
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                String tipoUsuario = resultSet.getString("tipo_usuario");
                Tela_DashBoard_Inicial Tela_DashBoard = new Tela_DashBoard_Inicial(tipoUsuario, id_usuario);
                Tela_DashBoard.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
            }

            resultSet.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.");
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }

        connection.close();
        statement.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Imagem_login = new javax.swing.JLabel();
        Login_login = new javax.swing.JLabel();
        Text_login = new javax.swing.JTextField();
        Senha_login = new javax.swing.JLabel();
        Esqueceu_senha_login = new javax.swing.JLabel();
        Acessar_login = new javax.swing.JButton();
        Text_senha_login = new javax.swing.JPasswordField();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(1048, 832));
        jPanel3.setMinimumSize(new java.awt.Dimension(1048, 832));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(47, 63, 115));
        jPanel4.setMaximumSize(new java.awt.Dimension(600, 570));
        jPanel4.setMinimumSize(new java.awt.Dimension(600, 570));
        jPanel4.setPreferredSize(new java.awt.Dimension(600, 570));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 832));
        setMinimumSize(new java.awt.Dimension(1280, 832));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(243, 236, 196));
        jPanel2.setMaximumSize(new java.awt.Dimension(1048, 832));
        jPanel2.setMinimumSize(new java.awt.Dimension(1048, 832));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel5.setBackground(new java.awt.Color(249, 246, 226));
        jPanel5.setMaximumSize(new java.awt.Dimension(1280, 832));
        jPanel5.setMinimumSize(new java.awt.Dimension(1280, 832));
        jPanel5.setPreferredSize(new java.awt.Dimension(1280, 832));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(47, 63, 115));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 570));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 570));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 571));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Imagem_login.setForeground(new java.awt.Color(255, 255, 255));
        Imagem_login.setText("Logo");
        Imagem_login.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel1.add(Imagem_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        Login_login.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Login_login.setForeground(new java.awt.Color(255, 255, 255));
        Login_login.setText("Login:");
        jPanel1.add(Login_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        Text_login.setBackground(new java.awt.Color(255, 255, 255));
        Text_login.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Text_login.setForeground(new java.awt.Color(0, 0, 0));
        Text_login.setPreferredSize(new java.awt.Dimension(323, 24));
        jPanel1.add(Text_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, 30));

        Senha_login.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Senha_login.setForeground(new java.awt.Color(255, 255, 255));
        Senha_login.setText("Senha:");
        jPanel1.add(Senha_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        Esqueceu_senha_login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Esqueceu_senha_login.setForeground(new java.awt.Color(234, 242, 5));
        Esqueceu_senha_login.setText("Esqueceu a senha?");
        jPanel1.add(Esqueceu_senha_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, 20));

        Acessar_login.setBackground(new java.awt.Color(255, 255, 255));
        Acessar_login.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Acessar_login.setForeground(new java.awt.Color(0, 0, 0));
        Acessar_login.setText("Acessar");
        Acessar_login.setPreferredSize(new java.awt.Dimension(220, 52));
        Acessar_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acessar_loginActionPerformed(evt);
            }
        });
        jPanel1.add(Acessar_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        Text_senha_login.setBackground(new java.awt.Color(255, 255, 255));
        Text_senha_login.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Text_senha_login.setPreferredSize(new java.awt.Dimension(323, 25));
        jPanel1.add(Text_senha_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, 30));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, 520));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Acessar_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acessar_loginActionPerformed
        try {
            verificarLogin();
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Acessar_loginActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acessar_login;
    private javax.swing.JLabel Esqueceu_senha_login;
    private javax.swing.JLabel Imagem_login;
    private javax.swing.JLabel Login_login;
    private javax.swing.JLabel Senha_login;
    private javax.swing.JTextField Text_login;
    private javax.swing.JPasswordField Text_senha_login;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
