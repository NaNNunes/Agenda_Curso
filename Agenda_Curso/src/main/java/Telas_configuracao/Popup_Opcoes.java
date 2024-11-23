/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_configuracao;

import Telas_Setor.Tela_Cadastro_Setor;

/**
 *
 * @author renan_8tvcd4n
 */
public class Popup_Opcoes extends javax.swing.JFrame {

    /**
     * Creates new form Popup_Opcoes
     */
    public Popup_Opcoes() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Jpnl_Conteiner = new javax.swing.JPanel();
        Jlbl_Titulo = new javax.swing.JLabel();
        Jbtn_CredAcesso_popOp = new javax.swing.JButton();
        Jbtn_CadSet_popOp = new javax.swing.JButton();
        Jbtn_CadUsuario_popOp = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Jpnl_Conteiner.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Conteiner.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Jpnl_ConteinerAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                Jpnl_ConteinerAncestorRemoved(evt);
            }
        });

        Jlbl_Titulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jlbl_Titulo.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Titulo.setText("Selecione Opções Abaixo");

        Jbtn_CredAcesso_popOp.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_CredAcesso_popOp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_CredAcesso_popOp.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_CredAcesso_popOp.setText("Credenciais de Acesso");
        Jbtn_CredAcesso_popOp.setMaximumSize(new java.awt.Dimension(230, 30));
        Jbtn_CredAcesso_popOp.setMinimumSize(new java.awt.Dimension(230, 30));
        Jbtn_CredAcesso_popOp.setPreferredSize(new java.awt.Dimension(230, 30));
        Jbtn_CredAcesso_popOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_CredAcesso_popOpActionPerformed(evt);
            }
        });

        Jbtn_CadSet_popOp.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_CadSet_popOp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_CadSet_popOp.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_CadSet_popOp.setText("Cadastrar Setor");
        Jbtn_CadSet_popOp.setMaximumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadSet_popOp.setMinimumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadSet_popOp.setPreferredSize(new java.awt.Dimension(230, 30));
        Jbtn_CadSet_popOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_CadSet_popOpActionPerformed(evt);
            }
        });

        Jbtn_CadUsuario_popOp.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_CadUsuario_popOp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_CadUsuario_popOp.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_CadUsuario_popOp.setText("Cadastrar Usuário");
        Jbtn_CadUsuario_popOp.setMaximumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadUsuario_popOp.setMinimumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadUsuario_popOp.setPreferredSize(new java.awt.Dimension(230, 30));
        Jbtn_CadUsuario_popOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_CadUsuario_popOpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Jpnl_ConteinerLayout = new javax.swing.GroupLayout(Jpnl_Conteiner);
        Jpnl_Conteiner.setLayout(Jpnl_ConteinerLayout);
        Jpnl_ConteinerLayout.setHorizontalGroup(
            Jpnl_ConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpnl_ConteinerLayout.createSequentialGroup()
                .addGroup(Jpnl_ConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpnl_ConteinerLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(Jpnl_ConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jbtn_CadUsuario_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jbtn_CadSet_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jbtn_CredAcesso_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Jpnl_ConteinerLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(Jlbl_Titulo)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        Jpnl_ConteinerLayout.setVerticalGroup(
            Jpnl_ConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpnl_ConteinerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Jlbl_Titulo)
                .addGap(18, 18, 18)
                .addComponent(Jbtn_CadSet_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(Jbtn_CredAcesso_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Jbtn_CadUsuario_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Conteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Conteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Jpnl_ConteinerAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Jpnl_ConteinerAncestorAdded
        
    }//GEN-LAST:event_Jpnl_ConteinerAncestorAdded

    private void Jpnl_ConteinerAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Jpnl_ConteinerAncestorRemoved
       
    }//GEN-LAST:event_Jpnl_ConteinerAncestorRemoved

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    private void Jbtn_CredAcesso_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CredAcesso_popOpActionPerformed
        Credencial popCred = new Credencial();
        popCred.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_CredAcesso_popOpActionPerformed

    private void Jbtn_CadSet_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CadSet_popOpActionPerformed
       Tela_Cadastro_Setor Cad_Setor = new Tela_Cadastro_Setor();
       Cad_Setor.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Jbtn_CadSet_popOpActionPerformed

    private void Jbtn_CadUsuario_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CadUsuario_popOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jbtn_CadUsuario_popOpActionPerformed

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
            java.util.logging.Logger.getLogger(Popup_Opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Popup_Opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Popup_Opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Popup_Opcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Popup_Opcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbtn_CadSet_popOp;
    private javax.swing.JButton Jbtn_CadUsuario_popOp;
    private javax.swing.JButton Jbtn_CredAcesso_popOp;
    private javax.swing.JLabel Jlbl_Titulo;
    private javax.swing.JPanel Jpnl_Conteiner;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
