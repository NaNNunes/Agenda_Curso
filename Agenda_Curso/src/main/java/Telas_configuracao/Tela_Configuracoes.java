/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_configuracao;

import Telas_Equipe.Tela_Cadastro_Equipe;
import Telas_Equipe.Tela_Pesquisa_Equipe;
import Telas_Funcionario.Tela_Cadastro_Funcionario;
import Telas_Funcionario.Tela_Pesquisar_Funcionario;
import Telas_Iniciais.Tela_DashBoard_Inicial;
import Telas_Iniciais.Tela_FeedBack;
import Telas_Iniciais.Tela_Login;
import Telas_Setor.Tela_Cadastro_Setor;
import Telas_Treinamento.Tela_Cadastro_Treinamento;
import Telas_Treinamento.Tela_Pesquisar_Treinamento;
import javax.swing.JOptionPane;

/**
 *
 * @author mathe
 */
public class Tela_Configuracoes extends javax.swing.JFrame {

    private final String tipoUsuario;
    private final int userId = Tela_Login.id_usuario;

    /**
     * Creates new form Tela_Configuracoes
     */
    public Tela_Configuracoes(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Jlbl_Titulo = new javax.swing.JLabel();
        Jbtn_CadUsuario_popOp = new javax.swing.JButton();
        Jbtn_CredAcesso_popOp = new javax.swing.JButton();
        Jbtn_CadSet_popOp = new javax.swing.JButton();
        JPanel_BarraLateral = new javax.swing.JPanel();
        Jbtn_LogoutButton_BarraLateral = new javax.swing.JButton();
        JPanel_contentFuncionarioButton = new javax.swing.JPanel();
        Jbtn_IconeFuncionario_BarraLateral_CadEqp = new javax.swing.JButton();
        Jcmbx_Funcionario_BarraLateral = new javax.swing.JComboBox<>();
        JPanel_contentEquipe_BarraLateral = new javax.swing.JPanel();
        Jbtn_iconeEquipe_BarraLateral_CadEqp = new javax.swing.JButton();
        Jcmbx_Equipe_BarraLateral = new javax.swing.JComboBox<>();
        Jpanel_contentTreinamento_Barra_Lateral = new javax.swing.JPanel();
        Jbtn_iconeTreinamento_BarraLateral_CadEqp = new javax.swing.JButton();
        Jcmbx_Treinamento_BarraLateral = new javax.swing.JComboBox<>();
        Jlbl_TipoUsuario = new javax.swing.JLabel();
        Jlbl_Logo_BarraLateral_Eqp = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(243, 236, 196));
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 832));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 246, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Configurações");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jPanel3.setBackground(new java.awt.Color(243, 228, 188));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Titulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        Jlbl_Titulo.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Titulo.setText("Selecione Opções Abaixo");
        jPanel3.add(Jlbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        Jbtn_CadUsuario_popOp.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_CadUsuario_popOp.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Jbtn_CadUsuario_popOp.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_CadUsuario_popOp.setText("Cadastrar Usuário");
        Jbtn_CadUsuario_popOp.setMaximumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadUsuario_popOp.setMinimumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadUsuario_popOp.setPreferredSize(new java.awt.Dimension(550, 50));
        Jbtn_CadUsuario_popOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_CadUsuario_popOpActionPerformed(evt);
            }
        });
        jPanel3.add(Jbtn_CadUsuario_popOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        Jbtn_CredAcesso_popOp.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_CredAcesso_popOp.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Jbtn_CredAcesso_popOp.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_CredAcesso_popOp.setText("Credenciais de Acesso");
        Jbtn_CredAcesso_popOp.setMaximumSize(new java.awt.Dimension(230, 30));
        Jbtn_CredAcesso_popOp.setMinimumSize(new java.awt.Dimension(230, 30));
        Jbtn_CredAcesso_popOp.setPreferredSize(new java.awt.Dimension(550, 50));
        Jbtn_CredAcesso_popOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_CredAcesso_popOpActionPerformed(evt);
            }
        });
        jPanel3.add(Jbtn_CredAcesso_popOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        Jbtn_CadSet_popOp.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_CadSet_popOp.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Jbtn_CadSet_popOp.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_CadSet_popOp.setText("Cadastrar Setor");
        Jbtn_CadSet_popOp.setMaximumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadSet_popOp.setMinimumSize(new java.awt.Dimension(230, 30));
        Jbtn_CadSet_popOp.setPreferredSize(new java.awt.Dimension(550, 50));
        Jbtn_CadSet_popOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_CadSet_popOpActionPerformed(evt);
            }
        });
        jPanel3.add(Jbtn_CadSet_popOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 620, 300));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 681, 537));

        JPanel_BarraLateral.setBackground(new java.awt.Color(47, 63, 115));
        JPanel_BarraLateral.setPreferredSize(new java.awt.Dimension(232, 832));
        JPanel_BarraLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_LogoutButton_BarraLateral.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_LogoutButton_BarraLateral.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_LogoutButton_BarraLateral.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\TechNight\\Agenda_Curso\\Imagens\\IconeExitAgendaCurso.png")); // NOI18N
        Jbtn_LogoutButton_BarraLateral.setMaximumSize(new java.awt.Dimension(40, 40));
        Jbtn_LogoutButton_BarraLateral.setMinimumSize(new java.awt.Dimension(40, 40));
        Jbtn_LogoutButton_BarraLateral.setPreferredSize(new java.awt.Dimension(40, 40));
        Jbtn_LogoutButton_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_LogoutButton_BarraLateralActionPerformed(evt);
            }
        });
        JPanel_BarraLateral.add(Jbtn_LogoutButton_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        JPanel_contentFuncionarioButton.setBackground(new java.awt.Color(40, 54, 98));
        JPanel_contentFuncionarioButton.setPreferredSize(new java.awt.Dimension(232, 40));
        JPanel_contentFuncionarioButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_IconeFuncionario_BarraLateral_CadEqp.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_IconeFuncionario_BarraLateral_CadEqp.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\TechNight\\Agenda_Curso\\Imagens\\IconeFuncAgendaCurso.png")); // NOI18N
        Jbtn_IconeFuncionario_BarraLateral_CadEqp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed(evt);
            }
        });
        JPanel_contentFuncionarioButton.add(Jbtn_IconeFuncionario_BarraLateral_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 65, 46));

        Jcmbx_Funcionario_BarraLateral.setBackground(new java.awt.Color(47, 63, 115));
        Jcmbx_Funcionario_BarraLateral.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        Jcmbx_Funcionario_BarraLateral.setForeground(new java.awt.Color(255, 255, 255));
        Jcmbx_Funcionario_BarraLateral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Pesquisar", "Cadastrar" }));
        Jcmbx_Funcionario_BarraLateral.setMaximumSize(new java.awt.Dimension(160, 46));
        Jcmbx_Funcionario_BarraLateral.setMinimumSize(new java.awt.Dimension(160, 46));
        Jcmbx_Funcionario_BarraLateral.setPreferredSize(new java.awt.Dimension(160, 46));
        Jcmbx_Funcionario_BarraLateral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jcmbx_Funcionario_BarraLateralMouseClicked(evt);
            }
        });
        Jcmbx_Funcionario_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmbx_Funcionario_BarraLateralActionPerformed(evt);
            }
        });
        JPanel_contentFuncionarioButton.add(Jcmbx_Funcionario_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        JPanel_BarraLateral.add(JPanel_contentFuncionarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 277, 230, 46));

        JPanel_contentEquipe_BarraLateral.setBackground(new java.awt.Color(40, 54, 98));
        JPanel_contentEquipe_BarraLateral.setMaximumSize(new java.awt.Dimension(232, 46));
        JPanel_contentEquipe_BarraLateral.setMinimumSize(new java.awt.Dimension(232, 46));
        JPanel_contentEquipe_BarraLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_iconeEquipe_BarraLateral_CadEqp.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_iconeEquipe_BarraLateral_CadEqp.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\TechNight\\Agenda_Curso\\Imagens\\IconeEqpAgendaCurso.png")); // NOI18N
        Jbtn_iconeEquipe_BarraLateral_CadEqp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_iconeEquipe_BarraLateral_CadEqpActionPerformed(evt);
            }
        });
        JPanel_contentEquipe_BarraLateral.add(Jbtn_iconeEquipe_BarraLateral_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 65, 46));

        Jcmbx_Equipe_BarraLateral.setBackground(new java.awt.Color(47, 63, 115));
        Jcmbx_Equipe_BarraLateral.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        Jcmbx_Equipe_BarraLateral.setForeground(new java.awt.Color(255, 255, 255));
        Jcmbx_Equipe_BarraLateral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equipe", "Pesquisar", "Cadastrar" }));
        Jcmbx_Equipe_BarraLateral.setMaximumSize(new java.awt.Dimension(160, 46));
        Jcmbx_Equipe_BarraLateral.setMinimumSize(new java.awt.Dimension(160, 46));
        Jcmbx_Equipe_BarraLateral.setPreferredSize(new java.awt.Dimension(160, 46));
        Jcmbx_Equipe_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmbx_Equipe_BarraLateralActionPerformed(evt);
            }
        });
        JPanel_contentEquipe_BarraLateral.add(Jcmbx_Equipe_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        JPanel_BarraLateral.add(JPanel_contentEquipe_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 341, 230, -1));

        Jpanel_contentTreinamento_Barra_Lateral.setBackground(new java.awt.Color(40, 54, 98));
        Jpanel_contentTreinamento_Barra_Lateral.setMaximumSize(new java.awt.Dimension(232, 46));
        Jpanel_contentTreinamento_Barra_Lateral.setMinimumSize(new java.awt.Dimension(232, 46));
        Jpanel_contentTreinamento_Barra_Lateral.setPreferredSize(new java.awt.Dimension(232, 46));
        Jpanel_contentTreinamento_Barra_Lateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_iconeTreinamento_BarraLateral_CadEqp.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_iconeTreinamento_BarraLateral_CadEqp.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\TechNight\\Agenda_Curso\\Imagens\\IconeTrenAgendaCurso.png")); // NOI18N
        Jbtn_iconeTreinamento_BarraLateral_CadEqp.setPreferredSize(new java.awt.Dimension(65, 32));
        Jbtn_iconeTreinamento_BarraLateral_CadEqp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_iconeTreinamento_BarraLateral_CadEqpActionPerformed(evt);
            }
        });
        Jpanel_contentTreinamento_Barra_Lateral.add(Jbtn_iconeTreinamento_BarraLateral_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 45));

        Jcmbx_Treinamento_BarraLateral.setBackground(new java.awt.Color(47, 63, 115));
        Jcmbx_Treinamento_BarraLateral.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        Jcmbx_Treinamento_BarraLateral.setForeground(new java.awt.Color(255, 255, 255));
        Jcmbx_Treinamento_BarraLateral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Treinamento", "Pesquisar", "Cadastrar" }));
        Jcmbx_Treinamento_BarraLateral.setMaximumSize(new java.awt.Dimension(160, 46));
        Jcmbx_Treinamento_BarraLateral.setMinimumSize(new java.awt.Dimension(160, 46));
        Jcmbx_Treinamento_BarraLateral.setPreferredSize(new java.awt.Dimension(160, 46));
        Jcmbx_Treinamento_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmbx_Treinamento_BarraLateralActionPerformed(evt);
            }
        });
        Jpanel_contentTreinamento_Barra_Lateral.add(Jcmbx_Treinamento_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        JPanel_BarraLateral.add(Jpanel_contentTreinamento_Barra_Lateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 405, 231, -1));

        Jlbl_TipoUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Jlbl_TipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        JPanel_BarraLateral.add(Jlbl_TipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 16, 143, 21));

        Jlbl_Logo_BarraLateral_Eqp.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\TechNight\\Agenda_Curso\\Imagens\\LogoDashBoard.png")); // NOI18N
        JPanel_BarraLateral.add(Jlbl_Logo_BarraLateral_Eqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 143, 143));

        jButton1.setBackground(new java.awt.Color(47, 63, 115));
        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("FeedBack");
        jButton1.setPreferredSize(new java.awt.Dimension(160, 66));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        JPanel_BarraLateral.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 740, 210, 30));

        jButton2.setBackground(new java.awt.Color(47, 63, 115));
        jButton2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\TechNight\\Agenda_Curso\\Imagens\\IconeDashAgendaCruso.png")); // NOI18N
        jButton2.setText("DashBoard");
        jButton2.setPreferredSize(new java.awt.Dimension(160, 66));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        JPanel_BarraLateral.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 210, 40));

        jButton3.setBackground(new java.awt.Color(47, 63, 115));
        jButton3.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\TechNight\\Agenda_Curso\\Imagens\\IconeConsiguraçõesAgendaCurso.png")); // NOI18N
        jButton3.setText("Configurações");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        JPanel_BarraLateral.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 780, 210, 40));

        jPanel1.add(JPanel_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Jbtn_CadSet_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CadSet_popOpActionPerformed
        Tela_Adicionar_Setor Cad_Setor = new Tela_Adicionar_Setor(tipoUsuario);
        Cad_Setor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_CadSet_popOpActionPerformed

    private void Jbtn_CredAcesso_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CredAcesso_popOpActionPerformed
        Tela_Mudar_Credencial Credencial = new Tela_Mudar_Credencial(tipoUsuario);
        Credencial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_CredAcesso_popOpActionPerformed

    private void Jbtn_CadUsuario_popOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CadUsuario_popOpActionPerformed
        // TODO add your handling code here:
        Tela_Adicionar_Usuario add_user = new Tela_Adicionar_Usuario(tipoUsuario);
        add_user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_CadUsuario_popOpActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if (tipoUsuario.equals("admin")) {
            Jbtn_CadSet_popOp.setVisible(true);
            Jbtn_CadUsuario_popOp.setVisible(true);
        } else {
            Jbtn_CadSet_popOp.setVisible(false);
            Jbtn_CadUsuario_popOp.setVisible(false);
        }
        if ("supervisor".equals(tipoUsuario)) {
            Jlbl_TipoUsuario.setText("Supervisor");
        } else if ("operador".equals(tipoUsuario)) {
            Jlbl_TipoUsuario.setText("Operador");
        } else if ("instrutor".equals(tipoUsuario)) {
            Jlbl_TipoUsuario.setText("Instrutor");
        } else if ("admin".equals(tipoUsuario)) {
            Jlbl_TipoUsuario.setText("Administrador");
        } else {
            Jlbl_TipoUsuario.setText("Usuário Desconhecido");
        }
    }//GEN-LAST:event_formWindowOpened

    private void Jbtn_LogoutButton_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_LogoutButton_BarraLateralActionPerformed
        Tela_Login telaLogin = new Tela_Login();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_LogoutButton_BarraLateralActionPerformed

    private void Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed

    }//GEN-LAST:event_Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed

    private void Jcmbx_Funcionario_BarraLateralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcmbx_Funcionario_BarraLateralMouseClicked

    }//GEN-LAST:event_Jcmbx_Funcionario_BarraLateralMouseClicked

    private void Jcmbx_Funcionario_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmbx_Funcionario_BarraLateralActionPerformed
        if ("admin".equals(tipoUsuario)) {
            switch (Jcmbx_Funcionario_BarraLateral.getSelectedIndex()) {
                case 1 -> {
                    Tela_Pesquisar_Funcionario Tela_SearchFunc = new Tela_Pesquisar_Funcionario(tipoUsuario);
                    Tela_SearchFunc.setVisible(true);
                    this.dispose();
                }
                case 2 -> {
                    Tela_Cadastro_Funcionario Tela_CadFunc = new Tela_Cadastro_Funcionario(tipoUsuario);
                    Tela_CadFunc.setVisible(true);
                    this.dispose();
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Selecione uma opção disponível!");
                }
            }
        } else if ("supervisor".equals(tipoUsuario) || "instrutor".equals(tipoUsuario)) {
            switch (Jcmbx_Funcionario_BarraLateral.getSelectedIndex()) {
                case 1 -> {
                    Tela_Pesquisar_Funcionario Tela_SearchFunc = new Tela_Pesquisar_Funcionario(tipoUsuario);
                    Tela_SearchFunc.setVisible(true);
                    this.dispose();
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar essa opção!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de usuário não reconhecido!");
        }
    }//GEN-LAST:event_Jcmbx_Funcionario_BarraLateralActionPerformed

    private void Jbtn_iconeEquipe_BarraLateral_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_iconeEquipe_BarraLateral_CadEqpActionPerformed

    }//GEN-LAST:event_Jbtn_iconeEquipe_BarraLateral_CadEqpActionPerformed

    private void Jcmbx_Equipe_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmbx_Equipe_BarraLateralActionPerformed
        if ("supervisor".equals(tipoUsuario) || "admin".equals(tipoUsuario)) {
            switch (Jcmbx_Equipe_BarraLateral.getSelectedIndex()) {
                case 1 -> {
                    Tela_Pesquisa_Equipe Tela_SearchEqp = new Tela_Pesquisa_Equipe(tipoUsuario);
                    Tela_SearchEqp.setVisible(true);
                    this.dispose();
                }
                case 2 -> {
                    Tela_Cadastro_Equipe Tela_CadEqp = new Tela_Cadastro_Equipe(tipoUsuario);
                    Tela_CadEqp.setVisible(true);
                    this.dispose();
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Selecione uma opção disponível!");
                }
            }
        } else if ("intrutor".equals(tipoUsuario)) {
            switch (Jcmbx_Equipe_BarraLateral.getSelectedIndex()) {
                case 1 -> {
                    Tela_Pesquisa_Equipe Tela_SearchEqp = new Tela_Pesquisa_Equipe(tipoUsuario);
                    Tela_SearchEqp.setVisible(true);
                    this.dispose();
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar essa opção!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de usuário não reconhecido!");
        }
    }//GEN-LAST:event_Jcmbx_Equipe_BarraLateralActionPerformed

    private void Jbtn_iconeTreinamento_BarraLateral_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_iconeTreinamento_BarraLateral_CadEqpActionPerformed

    }//GEN-LAST:event_Jbtn_iconeTreinamento_BarraLateral_CadEqpActionPerformed

    private void Jcmbx_Treinamento_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmbx_Treinamento_BarraLateralActionPerformed
        if ("admin".equals(tipoUsuario) || "instrutor".equals(tipoUsuario)) {
            switch (Jcmbx_Treinamento_BarraLateral.getSelectedIndex()) {
                case 1 -> {
                    Tela_Pesquisar_Treinamento Tela_SearchTreino = new Tela_Pesquisar_Treinamento(tipoUsuario);
                    Tela_SearchTreino.setVisible(true);
                    this.dispose();
                }
                case 2 -> {
                    Tela_Cadastro_Treinamento Tela_CadTreino = new Tela_Cadastro_Treinamento(tipoUsuario);
                    Tela_CadTreino.setVisible(true);
                    this.dispose();
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Selecione uma opção disponível!");
                }
            }
        } else if ("supervisor".equals(tipoUsuario)) {
            switch (Jcmbx_Treinamento_BarraLateral.getSelectedIndex()) {
                case 1 -> {
                    Tela_Pesquisar_Treinamento Tela_SearchTreino = new Tela_Pesquisar_Treinamento(tipoUsuario);
                    Tela_SearchTreino.setVisible(true);
                    this.dispose();
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar essa opção!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de usuário não reconhecido!");
        }
    }//GEN-LAST:event_Jcmbx_Treinamento_BarraLateralActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Tela_FeedBack FeedBack = new Tela_FeedBack(tipoUsuario);
        FeedBack.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Tela_DashBoard_Inicial DashBoard = new Tela_DashBoard_Inicial(tipoUsuario, userId);
        DashBoard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Tela_Configuracoes Configuracoes = new Tela_Configuracoes(tipoUsuario);
        Configuracoes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String tipoUsuario;

            public void run() {
                this.tipoUsuario = tipoUsuario;
                new Tela_Configuracoes(tipoUsuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JButton Jbtn_CadSet_popOp;
    private javax.swing.JButton Jbtn_CadUsuario_popOp;
    private javax.swing.JButton Jbtn_CredAcesso_popOp;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_TipoUsuario;
    private javax.swing.JLabel Jlbl_Titulo;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
