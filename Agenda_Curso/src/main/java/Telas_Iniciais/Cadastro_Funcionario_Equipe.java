/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_Iniciais;

import Telas_Equipe.Tela_Cadastro_Equipe;
import Telas_Equipe.Tela_Pesquisa_Equipe;
import Telas_Funcionario.Tela_Cadastro_Funcionario;
import Telas_Funcionario.Tela_Pesquisar_Funcionario;
import Telas_Treinamento.Tela_Cadastro_Treinamento;
import Telas_Treinamento.Tela_Pesquisar_Treinamento;
import Telas_configuracao.Popup_Opcoes;
import Telas_configuracao.Tela_Configuracoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author renan_8tvcd4n
 */
public class Cadastro_Funcionario_Equipe extends javax.swing.JFrame {

    private final String tipoUsuario;

    /**
     * Creates new form Cadastro_Funcionario_Equipe
     */
    public Cadastro_Funcionario_Equipe(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        initComponents();
    }

    private void popTblFuncionario(String query) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        Connection connection = (Connection) DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
        
        try{
            ResultSet resultSet = statement.executeQuery(query);
            DefaultTableModel tableModel = (DefaultTableModel) Jtbl_Funcionarios.getModel();
            tableModel.setNumRows(0);

            while(resultSet.next()){
                tableModel.addRow(new Object[]{
                    resultSet.getString("id_funcionario"),
                    resultSet.getString("nome_completo"),
                    resultSet.getString("turno"),
                    resultSet.getString("Setor")
                });
            }

            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }
    
    private void popTblEquipe(String query) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        Connection connection = (Connection) DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
        try{
            ResultSet resultSet = statement.executeQuery(query);
            DefaultTableModel tableModel = (DefaultTableModel) Jtbl_Equipe.getModel();
            tableModel.setNumRows(0);

            while(resultSet.next()){
                tableModel.addRow(new Object[]{ //mudar
                    resultSet.getString("id_equipe"),
                    resultSet.getString("nome_eqp"),
                    resultSet.getString("turno"),
                });
            }
            
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtbl_Equipe = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Jtbl_Funcionarios = new javax.swing.JTable();
        Jbtn_Incluir = new javax.swing.JButton();
        Jtxtf_PesquisaFunc_CdFE = new javax.swing.JTextField();
        Jbtn_ConsultaFunc_CdFE = new javax.swing.JButton();
        Jbtn_ConsultaEqp_CdFE = new javax.swing.JButton();
        Jtxtf_PesquisaEqp_CdFE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Jlbl_TipoUsuario = new javax.swing.JLabel();
        JPanel_BarraLateral = new javax.swing.JPanel();
        Jbtn_LogoutButton_BarraLateral = new javax.swing.JButton();
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
        Jlbl_TipoUsuario2 = new javax.swing.JLabel();
        Jlbl_Logo_BarraLateral_Eqp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(243, 236, 196));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(243, 236, 196));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jtbl_Equipe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtbl_Equipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "nome", "turno"
            }
        ));
        jScrollPane2.setViewportView(Jtbl_Equipe);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 256, -1, -1));

        Jtbl_Funcionarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtbl_Funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "nome", "turno", "setor"
            }
        ));
        jScrollPane3.setViewportView(Jtbl_Funcionarios);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 256, -1, -1));

        Jbtn_Incluir.setText("Incluir");
        Jbtn_Incluir.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_IncluirActionPerformed(evt);
            }
        });
        jPanel1.add(Jbtn_Incluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 728, -1, -1));

        Jtxtf_PesquisaFunc_CdFE.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_PesquisaFunc_CdFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxtf_PesquisaFunc_CdFE.setForeground(new java.awt.Color(0, 0, 0));
        Jtxtf_PesquisaFunc_CdFE.setText("id, nome, turno, setor do funcionário.");
        Jtxtf_PesquisaFunc_CdFE.setMaximumSize(new java.awt.Dimension(300, 30));
        Jtxtf_PesquisaFunc_CdFE.setMinimumSize(new java.awt.Dimension(300, 30));
        Jtxtf_PesquisaFunc_CdFE.setPreferredSize(new java.awt.Dimension(300, 30));
        Jtxtf_PesquisaFunc_CdFE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtxtf_PesquisaFunc_CdFEMouseClicked(evt);
            }
        });
        jPanel1.add(Jtxtf_PesquisaFunc_CdFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 181, -1, -1));

        Jbtn_ConsultaFunc_CdFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_ConsultaFunc_CdFE.setText("Pesquisar");
        Jbtn_ConsultaFunc_CdFE.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaFunc_CdFE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_ConsultaFunc_CdFEActionPerformed(evt);
            }
        });
        jPanel1.add(Jbtn_ConsultaFunc_CdFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 181, -1, -1));

        Jbtn_ConsultaEqp_CdFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_ConsultaEqp_CdFE.setText("Pesquisar");
        Jbtn_ConsultaEqp_CdFE.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaEqp_CdFE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_ConsultaEqp_CdFEActionPerformed(evt);
            }
        });
        jPanel1.add(Jbtn_ConsultaEqp_CdFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1149, 181, -1, -1));

        Jtxtf_PesquisaEqp_CdFE.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_PesquisaEqp_CdFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxtf_PesquisaEqp_CdFE.setForeground(new java.awt.Color(0, 0, 0));
        Jtxtf_PesquisaEqp_CdFE.setText("id, nome, turno da equipe");
        Jtxtf_PesquisaEqp_CdFE.setMaximumSize(new java.awt.Dimension(300, 30));
        Jtxtf_PesquisaEqp_CdFE.setMinimumSize(new java.awt.Dimension(300, 30));
        Jtxtf_PesquisaEqp_CdFE.setPreferredSize(new java.awt.Dimension(300, 30));
        Jtxtf_PesquisaEqp_CdFE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtxtf_PesquisaEqp_CdFEMouseClicked(evt);
            }
        });
        jPanel1.add(Jtxtf_PesquisaEqp_CdFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 181, 306, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cadastro Funcionario Equipe");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 53, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Funcionario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 147, -1, -1));
        jPanel1.add(Jlbl_TipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 41, 143, 21));

        JPanel_BarraLateral.setBackground(new java.awt.Color(47, 63, 115));
        JPanel_BarraLateral.setPreferredSize(new java.awt.Dimension(232, 832));
        JPanel_BarraLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        JPanel_BarraLateral.add(Jbtn_LogoutButton_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

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
        JPanel_contentFuncionarioButton.add(Jcmbx_Funcionario_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 160, -1));

        JPanel_BarraLateral.add(JPanel_contentFuncionarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 277, 230, 46));

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
        Jcmbx_Equipe_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmbx_Equipe_BarraLateralActionPerformed(evt);
            }
        });
        JPanel_contentEquipe_BarraLateral.add(Jcmbx_Equipe_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        JPanel_BarraLateral.add(JPanel_contentEquipe_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 341, 230, -1));

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
        JPanel_BarraLateral.add(Jbtn_trocarUsuario_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 786, -1, -1));

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
        JPanel_BarraLateral.add(Jbtn_Configuração_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 786, -1, -1));

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
        Jcmbx_Treinamento_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmbx_Treinamento_BarraLateralActionPerformed(evt);
            }
        });
        Jpanel_contentTreinamento_Barra_Lateral.add(Jcmbx_Treinamento_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        JPanel_BarraLateral.add(Jpanel_contentTreinamento_Barra_Lateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 405, 231, -1));
        JPanel_BarraLateral.add(Jlbl_TipoUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 16, 143, 21));
        JPanel_BarraLateral.add(Jlbl_Logo_BarraLateral_Eqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 133, 143));

        jPanel1.add(JPanel_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            this.popTblFuncionario("SELECT * FROM vw_funcionario WHERE status_func = 1;");
            this.popTblEquipe("SELECT * FROM vw_Equipe WHERE status_eqp = 1;");
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro_Funcionario_Equipe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void Jbtn_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_IncluirActionPerformed
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        Connection connection = null;
        PreparedStatement statement = null; 
        int id_funcionario = Integer.parseInt(Jtbl_Funcionarios.getValueAt(Jtbl_Funcionarios.getSelectedRow(), 0).toString());
        int id_equipe = Integer.parseInt(Jtbl_Equipe.getValueAt(Jtbl_Equipe.getSelectedRow(), 0).toString());
        try {
            connection = DriverManager.getConnection(url, user, psswrd);
            
            // verificar se funcionario ja esta incluso na equipe
                // tentativa de sintese de metodo retornou constrains fails
            String queryVW =  "SELECT id_equipe FROM vw_CadFuncEqp WHERE id_funcionario = "+ id_funcionario;
            statement = connection.prepareStatement(queryVW);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            
            int id_equipeEncontrada = 0;
            while(resultSet.next()){
                id_equipeEncontrada =  resultSet.getInt("id_equipe");
                if(id_equipeEncontrada == id_equipe){
                    break;
                }
            }
            resultSet.close();
            
            if (id_equipe == id_equipeEncontrada){
                JOptionPane.showMessageDialog(null, "Funcionario ja cadastrado na equipe");
            }
            else{
                // relacao equipe funcionario
                String query = "INSERT INTO cadastro_funcionario_equipe(id_funcionario, id_equipe) VALUES(?,?)";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_funcionario);
                statement.setInt(2, id_equipe);
                statement.execute();
                JOptionPane.showMessageDialog(null, "Cadastro realizado");

                this.popTblEquipe("SELECT * FROM vw_Equipe WHERE status_eqp = 1;");
                this.popTblFuncionario("SELECT * FROM vw_funcionario WHERE status_func = 1;");
            }
            connection.close();
            statement.close();
            
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getLocalizedMessage());
        }
        catch (ArrayIndexOutOfBoundsException erro){
            JOptionPane.showMessageDialog(null, "Necessário definir o funcionario e a equipe para realizar cadastro.");
        }
    }//GEN-LAST:event_Jbtn_IncluirActionPerformed

    private void Jbtn_ConsultaFunc_CdFEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_ConsultaFunc_CdFEActionPerformed
        try {
            String search = Jtxtf_PesquisaFunc_CdFE.getText();
            this.popTblFuncionario("SELECT * FROM vw_funcionario "
                    + "WHERE (id_funcionario = '"+search+"' OR `nome_completo` LIKE '%"+search+"%' "
                    + "OR cpf LIKE '"+search+"' OR setor LIKE '%"+search+"%' "
                    + "OR turno LIKE '%"+search+"%' OR cargo LIKE '%"+search+"%' "
                    + "OR telefone LIKE '%"+search+"%' OR email LIKE '%"+search+"%') AND status_func = 1");
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro_Funcionario_Equipe.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_Jbtn_ConsultaFunc_CdFEActionPerformed

    private void Jbtn_ConsultaEqp_CdFEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_ConsultaEqp_CdFEActionPerformed
        
        try {
            String search = Jtxtf_PesquisaEqp_CdFE.getText();
            this.popTblEquipe("SELECT * FROM vw_equipe "
                    + "WHERE (id_equipe = '"+search+"' OR nome_eqp LIKE '%"+search+"%' "
                    + "OR turno LIKE '%"+search+"%') AND status_eqp = 1");
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro_Funcionario_Equipe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jbtn_ConsultaEqp_CdFEActionPerformed
    
    private void Jtxtf_PesquisaFunc_CdFEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtxtf_PesquisaFunc_CdFEMouseClicked
        this.Jtxtf_PesquisaFunc_CdFE.selectAll();
    }//GEN-LAST:event_Jtxtf_PesquisaFunc_CdFEMouseClicked

    private void Jtxtf_PesquisaEqp_CdFEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtxtf_PesquisaEqp_CdFEMouseClicked
        this.Jtxtf_PesquisaEqp_CdFE.selectAll();
    }//GEN-LAST:event_Jtxtf_PesquisaEqp_CdFEMouseClicked

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

    private void Jbtn_trocarUsuario_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_trocarUsuario_BarraLateralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jbtn_trocarUsuario_BarraLateralActionPerformed

    private void Jbtn_Configuração_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Configuração_BarraLateralActionPerformed
        Tela_Configuracoes Configuracoes = new Tela_Configuracoes(tipoUsuario);
        Configuracoes.setVisible(true);
    }//GEN-LAST:event_Jbtn_Configuração_BarraLateralActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro_Funcionario_Equipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Funcionario_Equipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Funcionario_Equipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Funcionario_Equipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String tipoUsuario;
            public void run() {
                this.tipoUsuario = tipoUsuario;
                new Cadastro_Funcionario_Equipe(tipoUsuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JButton Jbtn_Configuração_BarraLateral;
    private javax.swing.JButton Jbtn_ConsultaEqp_CdFE;
    private javax.swing.JButton Jbtn_ConsultaFunc_CdFE;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_Incluir;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_trocarUsuario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_TipoUsuario;
    private javax.swing.JLabel Jlbl_TipoUsuario2;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JTable Jtbl_Equipe;
    private javax.swing.JTable Jtbl_Funcionarios;
    private javax.swing.JTextField Jtxtf_PesquisaEqp_CdFE;
    private javax.swing.JTextField Jtxtf_PesquisaFunc_CdFE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
