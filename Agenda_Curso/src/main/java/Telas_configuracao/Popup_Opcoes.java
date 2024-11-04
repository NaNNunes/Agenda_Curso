/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_configuracao;

import Telas_Salas_Treinamento.Tela_Cadastro_Sala;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Jbtn_CredAcesso_popOp = new javax.swing.JButton();
        Jbtn_CadSala_popOp = new javax.swing.JButton();
        Jbtn_CadSet_popOp = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(243, 236, 196));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorRemoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selecione Opções Abaixo");

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

        Jbtn_CadSala_popOp.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_CadSala_popOp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_CadSala_popOp.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_CadSala_popOp.setText("Cadastrar Sala");
        Jbtn_CadSala_popOp.setMaximumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadSala_popOp.setMinimumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadSala_popOp.setPreferredSize(new java.awt.Dimension(230, 30));
        Jbtn_CadSala_popOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_CadSala_popOpActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jbtn_CadSet_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Jbtn_CredAcesso_popOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jbtn_CadSala_popOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(Jbtn_CredAcesso_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Jbtn_CadSet_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(Jbtn_CadSala_popOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        
    }//GEN-LAST:event_jPanel1AncestorAdded

    private void jPanel1AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorRemoved
       
    }//GEN-LAST:event_jPanel1AncestorRemoved

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    private void Jbtn_CredAcesso_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CredAcesso_popOpActionPerformed
        // add tela de modificar credenciais
    }//GEN-LAST:event_Jbtn_CredAcesso_popOpActionPerformed

    private void Jbtn_CadSet_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CadSet_popOpActionPerformed
       Tela_Cadastro_Setor Cad_Setor = new Tela_Cadastro_Setor();
       Cad_Setor.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Jbtn_CadSet_popOpActionPerformed

    private void Jbtn_CadSala_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CadSala_popOpActionPerformed
       Tela_Cadastro_Sala Cad_Sala = new Tela_Cadastro_Sala();
       Cad_Sala.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_Jbtn_CadSala_popOpActionPerformed

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
    private javax.swing.JButton Jbtn_CadSala_popOp;
    private javax.swing.JButton Jbtn_CadSet_popOp;
    private javax.swing.JButton Jbtn_CredAcesso_popOp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
