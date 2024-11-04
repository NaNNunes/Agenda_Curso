/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_Equipe;

import Telas_Funcionario.Tela_Adicionar_Funcionario;
import Telas_Funcionario.Tela_Pesquisar_Funcionario;
import Telas_Iniciais.Tela_Login;
import Telas_Treinamento.Tela_Adicionar_Treinamento;
import Telas_Treinamento.Tela_Pesquisar_Treinamento;
import Telas_configuracao.Popup_Opcoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author r.nunes
 */
public class Tela_Adicionar_Equipe extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Cadastro_Equipe
     */
    public Tela_Adicionar_Equipe() {
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

        jPanel2 = new javax.swing.JPanel();
        Jpanel_Fundo_CadEqp = new javax.swing.JPanel();
        Jlbl_Titulo_CadEqp = new javax.swing.JLabel();
        Jpanel_Conteiner_CadEqp = new javax.swing.JPanel();
        Jlbl_Header_Conteiner_CadEqp = new javax.swing.JLabel();
        Jlbl_Nome_CadEqp = new javax.swing.JLabel();
        Jtxtf_Nome_CadEqp = new javax.swing.JTextField();
        Jlbl_Supervisor_CadEqp = new javax.swing.JLabel();
        Jlbl_Turno_CadEqp = new javax.swing.JLabel();
        Jlbl_Setor_CadEqp = new javax.swing.JLabel();
        Jcmbx_Setor_CadEqp = new javax.swing.JComboBox<>();
        Jcmbx_Turno_CadEqp = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtxta_descricao_CadEqp = new javax.swing.JTextArea();
        Jlbl_Descricao_CadEqp = new javax.swing.JLabel();
        Jtxtf_Supervisor_CadEqp = new javax.swing.JTextField();
        Jpanel_Conteiner_Dados = new javax.swing.JPanel();
        Jbtn_Cadastro_CadEqp = new javax.swing.JButton();
        Jbtn_Editar_CadEqp = new javax.swing.JButton();
        Jbtn_Apagar_CadEqp = new javax.swing.JButton();
        JPanel_BarraLateral = new javax.swing.JPanel();
        Jbtn_LogoutButton_BarraLateral = new javax.swing.JButton();
        JPanel_logo_Barra_Lateral = new javax.swing.JPanel();
        Jlbl_Logo_BarraLateral_Eqp = new javax.swing.JLabel();
        JPanel_contentFuncionarioButton = new javax.swing.JPanel();
        Jbtn_IconeFuncionario_BarraLateral_CadEqp = new javax.swing.JButton();
        Jcmbx_Funcionario_BarraLateral = new javax.swing.JComboBox<>();
        JPanel_contentEquipe_BarraLateral = new javax.swing.JPanel();
        Jbtn_iconeEquipe_BarraLateral_CadEqp = new javax.swing.JButton();
        Jcmbx_Equipe_BarraLateral = new javax.swing.JComboBox<>();
        Jbtn_trocarUsuario_BarraLateral = new javax.swing.JButton();
        Jbtn_Configuração_BarraLateral = new javax.swing.JButton();
        Jpanel_contentTreinamento_Barra_Lateral = new javax.swing.JPanel();
        Jbtn_iconeTreinamento_BarraLateral_CadEqp = new javax.swing.JButton();
        Jcmbx_Treinamento_BarraLateral = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpanel_Fundo_CadEqp.setBackground(new java.awt.Color(249, 246, 226));

        Jlbl_Titulo_CadEqp.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Jlbl_Titulo_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Titulo_CadEqp.setText("Adicionar Equipe");

        Jpanel_Conteiner_CadEqp.setBackground(new java.awt.Color(243, 228, 188));
        Jpanel_Conteiner_CadEqp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpanel_Conteiner_CadEqp.setPreferredSize(new java.awt.Dimension(780, 300));
        Jpanel_Conteiner_CadEqp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Header_Conteiner_CadEqp.setBackground(new java.awt.Color(0, 0, 0));
        Jlbl_Header_Conteiner_CadEqp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jlbl_Header_Conteiner_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Header_Conteiner_CadEqp.setText("Identificação");
        Jpanel_Conteiner_CadEqp.add(Jlbl_Header_Conteiner_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Jlbl_Nome_CadEqp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jlbl_Nome_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Nome_CadEqp.setText("Nome:");
        Jpanel_Conteiner_CadEqp.add(Jlbl_Nome_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, 30));

        Jtxtf_Nome_CadEqp.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Nome_CadEqp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxtf_Nome_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jtxtf_Nome_CadEqp.setMaximumSize(new java.awt.Dimension(240, 30));
        Jtxtf_Nome_CadEqp.setMinimumSize(new java.awt.Dimension(240, 30));
        Jtxtf_Nome_CadEqp.setPreferredSize(new java.awt.Dimension(240, 30));
        Jtxtf_Nome_CadEqp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jtxtf_Nome_CadEqpActionPerformed(evt);
            }
        });
        Jpanel_Conteiner_CadEqp.add(Jtxtf_Nome_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        Jlbl_Supervisor_CadEqp.setBackground(new java.awt.Color(0, 0, 0));
        Jlbl_Supervisor_CadEqp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jlbl_Supervisor_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Supervisor_CadEqp.setText("Supervisor Responsavel:");
        Jpanel_Conteiner_CadEqp.add(Jlbl_Supervisor_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, 30));

        Jlbl_Turno_CadEqp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jlbl_Turno_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Turno_CadEqp.setText("Turno:");
        Jpanel_Conteiner_CadEqp.add(Jlbl_Turno_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, 30));

        Jlbl_Setor_CadEqp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jlbl_Setor_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Setor_CadEqp.setText("Setor:");
        Jpanel_Conteiner_CadEqp.add(Jlbl_Setor_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, 30));

        Jcmbx_Setor_CadEqp.setBackground(new java.awt.Color(255, 255, 255));
        Jcmbx_Setor_CadEqp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jcmbx_Setor_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jcmbx_Setor_CadEqp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione --", "ADM", "RH", "ATM", "ESC" }));
        Jcmbx_Setor_CadEqp.setMaximumSize(new java.awt.Dimension(240, 30));
        Jcmbx_Setor_CadEqp.setMinimumSize(new java.awt.Dimension(240, 30));
        Jcmbx_Setor_CadEqp.setPreferredSize(new java.awt.Dimension(240, 30));
        Jpanel_Conteiner_CadEqp.add(Jcmbx_Setor_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        Jcmbx_Turno_CadEqp.setBackground(new java.awt.Color(255, 255, 255));
        Jcmbx_Turno_CadEqp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jcmbx_Turno_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jcmbx_Turno_CadEqp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione --", "Matutino", "Vespertino", "Noturno" }));
        Jcmbx_Turno_CadEqp.setMaximumSize(new java.awt.Dimension(240, 30));
        Jcmbx_Turno_CadEqp.setMinimumSize(new java.awt.Dimension(240, 30));
        Jcmbx_Turno_CadEqp.setPreferredSize(new java.awt.Dimension(240, 30));
        Jpanel_Conteiner_CadEqp.add(Jcmbx_Turno_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        Jtxta_descricao_CadEqp.setBackground(new java.awt.Color(255, 255, 255));
        Jtxta_descricao_CadEqp.setColumns(20);
        Jtxta_descricao_CadEqp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxta_descricao_CadEqp.setRows(5);
        jScrollPane1.setViewportView(Jtxta_descricao_CadEqp);

        Jpanel_Conteiner_CadEqp.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        Jlbl_Descricao_CadEqp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jlbl_Descricao_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Descricao_CadEqp.setText("Descrição:");
        Jpanel_Conteiner_CadEqp.add(Jlbl_Descricao_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        Jtxtf_Supervisor_CadEqp.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Supervisor_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jtxtf_Supervisor_CadEqp.setMaximumSize(new java.awt.Dimension(240, 30));
        Jtxtf_Supervisor_CadEqp.setMinimumSize(new java.awt.Dimension(240, 30));
        Jtxtf_Supervisor_CadEqp.setPreferredSize(new java.awt.Dimension(240, 30));
        Jpanel_Conteiner_CadEqp.add(Jtxtf_Supervisor_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        Jpanel_Conteiner_Dados.setBackground(new java.awt.Color(249, 246, 226));
        Jpanel_Conteiner_Dados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_Cadastro_CadEqp.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Cadastro_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Cadastro_CadEqp.setText("Cadastrar");
        Jbtn_Cadastro_CadEqp.setMaximumSize(new java.awt.Dimension(120, 45));
        Jbtn_Cadastro_CadEqp.setMinimumSize(new java.awt.Dimension(120, 45));
        Jbtn_Cadastro_CadEqp.setPreferredSize(new java.awt.Dimension(120, 45));
        Jbtn_Cadastro_CadEqp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Cadastro_CadEqpActionPerformed(evt);
            }
        });
        Jpanel_Conteiner_Dados.add(Jbtn_Cadastro_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        Jbtn_Editar_CadEqp.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Editar_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Editar_CadEqp.setText("Editar");
        Jbtn_Editar_CadEqp.setMaximumSize(new java.awt.Dimension(100, 30));
        Jbtn_Editar_CadEqp.setMinimumSize(new java.awt.Dimension(100, 30));
        Jbtn_Editar_CadEqp.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_Editar_CadEqp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Editar_CadEqpActionPerformed(evt);
            }
        });
        Jpanel_Conteiner_Dados.add(Jbtn_Editar_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        Jbtn_Apagar_CadEqp.setBackground(new java.awt.Color(234, 151, 151));
        Jbtn_Apagar_CadEqp.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Apagar_CadEqp.setText("Apagar");
        Jbtn_Apagar_CadEqp.setMaximumSize(new java.awt.Dimension(100, 30));
        Jbtn_Apagar_CadEqp.setMinimumSize(new java.awt.Dimension(100, 30));
        Jbtn_Apagar_CadEqp.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_Apagar_CadEqp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Apagar_CadEqpActionPerformed(evt);
            }
        });
        Jpanel_Conteiner_Dados.add(Jbtn_Apagar_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        JPanel_BarraLateral.setBackground(new java.awt.Color(47, 63, 115));
        JPanel_BarraLateral.setPreferredSize(new java.awt.Dimension(232, 832));

        Jbtn_LogoutButton_BarraLateral.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_LogoutButton_BarraLateral.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_LogoutButton_BarraLateral.setMaximumSize(new java.awt.Dimension(40, 40));
        Jbtn_LogoutButton_BarraLateral.setMinimumSize(new java.awt.Dimension(40, 40));
        Jbtn_LogoutButton_BarraLateral.setPreferredSize(new java.awt.Dimension(40, 40));
        Jbtn_LogoutButton_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_LogoutButton_BarraLateralActionPerformed(evt);
            }
        });

        JPanel_logo_Barra_Lateral.setBackground(new java.awt.Color(47, 63, 115));
        JPanel_logo_Barra_Lateral.setPreferredSize(new java.awt.Dimension(133, 143));

        javax.swing.GroupLayout JPanel_logo_Barra_LateralLayout = new javax.swing.GroupLayout(JPanel_logo_Barra_Lateral);
        JPanel_logo_Barra_Lateral.setLayout(JPanel_logo_Barra_LateralLayout);
        JPanel_logo_Barra_LateralLayout.setHorizontalGroup(
            JPanel_logo_Barra_LateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jlbl_Logo_BarraLateral_Eqp, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        JPanel_logo_Barra_LateralLayout.setVerticalGroup(
            JPanel_logo_Barra_LateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jlbl_Logo_BarraLateral_Eqp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );

        JPanel_contentFuncionarioButton.setBackground(new java.awt.Color(40, 54, 98));
        JPanel_contentFuncionarioButton.setPreferredSize(new java.awt.Dimension(232, 40));
        JPanel_contentFuncionarioButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_IconeFuncionario_BarraLateral_CadEqp.setBackground(new java.awt.Color(243, 236, 196));
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
        JPanel_contentFuncionarioButton.add(Jcmbx_Funcionario_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 160, -1));

        JPanel_contentEquipe_BarraLateral.setBackground(new java.awt.Color(40, 54, 98));
        JPanel_contentEquipe_BarraLateral.setMaximumSize(new java.awt.Dimension(232, 46));
        JPanel_contentEquipe_BarraLateral.setMinimumSize(new java.awt.Dimension(232, 46));
        JPanel_contentEquipe_BarraLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_iconeEquipe_BarraLateral_CadEqp.setBackground(new java.awt.Color(243, 236, 196));
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
        JPanel_contentEquipe_BarraLateral.add(Jcmbx_Equipe_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        Jbtn_trocarUsuario_BarraLateral.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_trocarUsuario_BarraLateral.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_trocarUsuario_BarraLateral.setMaximumSize(new java.awt.Dimension(80, 40));
        Jbtn_trocarUsuario_BarraLateral.setMinimumSize(new java.awt.Dimension(80, 40));
        Jbtn_trocarUsuario_BarraLateral.setPreferredSize(new java.awt.Dimension(80, 40));
        Jbtn_trocarUsuario_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_trocarUsuario_BarraLateralActionPerformed(evt);
            }
        });

        Jbtn_Configuração_BarraLateral.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Configuração_BarraLateral.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Configuração_BarraLateral.setMaximumSize(new java.awt.Dimension(90, 40));
        Jbtn_Configuração_BarraLateral.setMinimumSize(new java.awt.Dimension(90, 40));
        Jbtn_Configuração_BarraLateral.setPreferredSize(new java.awt.Dimension(90, 40));
        Jbtn_Configuração_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Configuração_BarraLateralActionPerformed(evt);
            }
        });

        Jpanel_contentTreinamento_Barra_Lateral.setBackground(new java.awt.Color(40, 54, 98));
        Jpanel_contentTreinamento_Barra_Lateral.setMaximumSize(new java.awt.Dimension(232, 46));
        Jpanel_contentTreinamento_Barra_Lateral.setMinimumSize(new java.awt.Dimension(232, 46));
        Jpanel_contentTreinamento_Barra_Lateral.setPreferredSize(new java.awt.Dimension(232, 46));
        Jpanel_contentTreinamento_Barra_Lateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_iconeTreinamento_BarraLateral_CadEqp.setBackground(new java.awt.Color(243, 236, 196));
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
        Jpanel_contentTreinamento_Barra_Lateral.add(Jcmbx_Treinamento_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        javax.swing.GroupLayout JPanel_BarraLateralLayout = new javax.swing.GroupLayout(JPanel_BarraLateral);
        JPanel_BarraLateral.setLayout(JPanel_BarraLateralLayout);
        JPanel_BarraLateralLayout.setHorizontalGroup(
            JPanel_BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel_contentFuncionarioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPanel_contentEquipe_BarraLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                .addGroup(JPanel_BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Jbtn_trocarUsuario_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jbtn_Configuração_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                        .addGroup(JPanel_BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(JPanel_logo_Barra_Lateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Jbtn_LogoutButton_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                .addComponent(Jpanel_contentTreinamento_Barra_Lateral, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPanel_BarraLateralLayout.setVerticalGroup(
            JPanel_BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                .addGroup(JPanel_BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(JPanel_logo_Barra_Lateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(JPanel_contentFuncionarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JPanel_contentEquipe_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Jbtn_LogoutButton_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Jpanel_contentTreinamento_Barra_Lateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addGroup(JPanel_BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jbtn_Configuração_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jbtn_trocarUsuario_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout Jpanel_Fundo_CadEqpLayout = new javax.swing.GroupLayout(Jpanel_Fundo_CadEqp);
        Jpanel_Fundo_CadEqp.setLayout(Jpanel_Fundo_CadEqpLayout);
        Jpanel_Fundo_CadEqpLayout.setHorizontalGroup(
            Jpanel_Fundo_CadEqpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_Fundo_CadEqpLayout.createSequentialGroup()
                .addComponent(JPanel_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(Jpanel_Fundo_CadEqpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpanel_Fundo_CadEqpLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Jpanel_Fundo_CadEqpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Jpanel_Conteiner_CadEqp, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                            .addComponent(Jpanel_Conteiner_Dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(141, 141, 141))
                    .addGroup(Jpanel_Fundo_CadEqpLayout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(Jlbl_Titulo_CadEqp)
                        .addContainerGap(395, Short.MAX_VALUE))))
        );
        Jpanel_Fundo_CadEqpLayout.setVerticalGroup(
            Jpanel_Fundo_CadEqpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_Fundo_CadEqpLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(Jlbl_Titulo_CadEqp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jpanel_Conteiner_CadEqp, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(Jpanel_Conteiner_Dados, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(Jpanel_Fundo_CadEqpLayout.createSequentialGroup()
                .addComponent(JPanel_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(Jpanel_Fundo_CadEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Jbtn_Cadastro_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Cadastro_CadEqpActionPerformed
        Connection connection = null;
        PreparedStatement statement = null;
        
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        try {
            connection = DriverManager.getConnection(url, user, psswrd);
            String query = "INSERT INTO equipe(nome ,descricao, setor, turno) values(?, ?, ?, ?)"; // adicionar tambem id instrutor
            statement = connection.prepareStatement(query);
            
            String setor = (String) Jcmbx_Setor_CadEqp.getSelectedItem();
            String turno = (String) Jcmbx_Turno_CadEqp.getSelectedItem();
            
            statement.setString(1, Jtxtf_Nome_CadEqp.getText());
            statement.setString(2, Jtxta_descricao_CadEqp.getText());
            statement.setString(3, setor);
            statement.setString(4, turno);
            //statement.setString(3, Jtxtf_Supervisor_CadEqp.getText());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipe Criada");
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchiodos corretamente!");
        }
    }//GEN-LAST:event_Jbtn_Cadastro_CadEqpActionPerformed

    private void Jbtn_Editar_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Editar_CadEqpActionPerformed
        Connection connection = null;
        PreparedStatement statement = null;
        
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "";
        String psswrd = "";
    }//GEN-LAST:event_Jbtn_Editar_CadEqpActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void Jbtn_Apagar_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Apagar_CadEqpActionPerformed
    JOptionPane.showConfirmDialog(null, "Atenção!\n Ao Prosseguir no ato irá excluir permanentemente os dados a seguir.");
      
    }//GEN-LAST:event_Jbtn_Apagar_CadEqpActionPerformed

    private void Jtxtf_Nome_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jtxtf_Nome_CadEqpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jtxtf_Nome_CadEqpActionPerformed

    private void Jbtn_LogoutButton_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_LogoutButton_BarraLateralActionPerformed
        Tela_Login telaLogin = new Tela_Login();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_LogoutButton_BarraLateralActionPerformed

    private void Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed

        switch (Jcmbx_Funcionario_BarraLateral.getSelectedIndex()){
            case 1 -> {
                Tela_Pesquisar_Funcionario Tela_SearchFunc = new Tela_Pesquisar_Funcionario();
                Tela_SearchFunc.setVisible(true);
                this.dispose();
            }
            case 2 -> {
                Tela_Adicionar_Funcionario Tela_CadFunc = new Tela_Adicionar_Funcionario();
                Tela_CadFunc.setVisible(true);
                this.dispose();
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Selecione uma opção disponivel!");
            }
        }
    }//GEN-LAST:event_Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed

    private void Jbtn_iconeEquipe_BarraLateral_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_iconeEquipe_BarraLateral_CadEqpActionPerformed
        switch (Jcmbx_Equipe_BarraLateral.getSelectedIndex()){
            /*case 1 -> {
                Tela_Pesquisar_Equipe Tela_SearchEqp = new Tela_Pesquisar_Equipe();
                Tela_SearchEqp.setVisible(true);
                this.dispose();
            }*/
            case 2 -> {
                Tela_Adicionar_Equipe Tela_CadEqp = new Tela_Adicionar_Equipe();
                Tela_CadEqp.setVisible(true);
                this.dispose();
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Selecione uma opção disponivel!");
            }
        }
    }//GEN-LAST:event_Jbtn_iconeEquipe_BarraLateral_CadEqpActionPerformed

    private void Jbtn_trocarUsuario_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_trocarUsuario_BarraLateralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jbtn_trocarUsuario_BarraLateralActionPerformed

    private void Jbtn_Configuração_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Configuração_BarraLateralActionPerformed
        Popup_Opcoes popup_opcoes = new Popup_Opcoes();
        popup_opcoes.setVisible(true);

    }//GEN-LAST:event_Jbtn_Configuração_BarraLateralActionPerformed

    private void Jbtn_iconeTreinamento_BarraLateral_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_iconeTreinamento_BarraLateral_CadEqpActionPerformed
        switch (Jcmbx_Treinamento_BarraLateral.getSelectedIndex()){
            case 1 -> {
                Tela_Pesquisar_Treinamento Tela_SearchTreino = new Tela_Pesquisar_Treinamento();
                Tela_SearchTreino.setVisible(true);
                this.dispose();
            }
            case 2 -> {
                Tela_Adicionar_Treinamento Tela_CadTreino = new Tela_Adicionar_Treinamento();
                Tela_CadTreino.setVisible(true);
                this.dispose();
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Selecione uma opção disponivel!");
            }
        }
    }//GEN-LAST:event_Jbtn_iconeTreinamento_BarraLateral_CadEqpActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Adicionar_Equipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Adicionar_Equipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Adicionar_Equipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Adicionar_Equipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Adicionar_Equipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JPanel JPanel_logo_Barra_Lateral;
    private javax.swing.JButton Jbtn_Apagar_CadEqp;
    private javax.swing.JButton Jbtn_Cadastro_CadEqp;
    private javax.swing.JButton Jbtn_Configuração_BarraLateral;
    private javax.swing.JButton Jbtn_Editar_CadEqp;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_trocarUsuario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Setor_CadEqp;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Turno_CadEqp;
    private javax.swing.JLabel Jlbl_Descricao_CadEqp;
    private javax.swing.JLabel Jlbl_Header_Conteiner_CadEqp;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_Nome_CadEqp;
    private javax.swing.JLabel Jlbl_Setor_CadEqp;
    private javax.swing.JLabel Jlbl_Supervisor_CadEqp;
    private javax.swing.JLabel Jlbl_Titulo_CadEqp;
    private javax.swing.JLabel Jlbl_Turno_CadEqp;
    private javax.swing.JPanel Jpanel_Conteiner_CadEqp;
    private javax.swing.JPanel Jpanel_Conteiner_Dados;
    private javax.swing.JPanel Jpanel_Fundo_CadEqp;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JTextArea Jtxta_descricao_CadEqp;
    private javax.swing.JTextField Jtxtf_Nome_CadEqp;
    private javax.swing.JTextField Jtxtf_Supervisor_CadEqp;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
