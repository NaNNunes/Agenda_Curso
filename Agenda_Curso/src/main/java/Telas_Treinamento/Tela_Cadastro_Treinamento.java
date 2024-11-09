/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_Treinamento;

import Telas_Equipe.Tela_Cadastro_Equipe;
import Telas_Equipe.Tela_Pesquisa_Equipe;
import Telas_Funcionario.Tela_Cadastro_Funcionario;
import Telas_Funcionario.Tela_Pesquisar_Funcionario;
import Telas_Iniciais.Tela_Login;
import Telas_configuracao.Popup_Opcoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author mathe
 */
public class Tela_Cadastro_Treinamento extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Adicionar_Treinamento
     */
    public Tela_Cadastro_Treinamento() {
        initComponents();
    }
    
    private String pegaIdInstrutor(String query) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        Connection connection = (Connection) DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
        String id = "";
        
        try {
            statement.execute();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                id = resultSet.getString("id_funcionario");
            }
        }
        catch (SQLException erro){
            System.out.println("Erro: " + erro.getMessage());
        }
        
        return id;
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
        Jpnl_Identificacao_CadTreino = new javax.swing.JPanel();
        Jlbl_Resumo_CadTreino = new javax.swing.JLabel();
        Jlbl_Treinamento_CadTreino = new javax.swing.JLabel();
        Jtxtf_Treinamento_CadTreino = new javax.swing.JTextField();
        Jlbl_Descricao_CadTreino = new javax.swing.JLabel();
        Jlbl_Carga_CadTreino = new javax.swing.JLabel();
        Jtxtf_Carga_CadTreino = new javax.swing.JTextField();
        Jlbl_Validade_CadTreino = new javax.swing.JLabel();
        Jtxtf_Validade_CadTreino = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtxta_Descricao_CadTreino = new javax.swing.JTextArea();
        Jbtn_Salvar_CadTreino = new javax.swing.JButton();
        Jbtn_Cancelar_CadTreino = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(243, 236, 196));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 797));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Adicionar Treinamento");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        Jpnl_Identificacao_CadTreino.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Identificacao_CadTreino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Identificacao_CadTreino.setPreferredSize(new java.awt.Dimension(780, 270));
        Jpnl_Identificacao_CadTreino.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Resumo_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Resumo_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Resumo_CadTreino.setText("Resumo");
        Jpnl_Identificacao_CadTreino.add(Jlbl_Resumo_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        Jlbl_Treinamento_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Treinamento_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Treinamento_CadTreino.setText("Treinamento: ");
        Jpnl_Identificacao_CadTreino.add(Jlbl_Treinamento_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        Jtxtf_Treinamento_CadTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Treinamento_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Jtxtf_Treinamento_CadTreino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jtxtf_Treinamento_CadTreino.setPreferredSize(new java.awt.Dimension(248, 30));
        Jtxtf_Treinamento_CadTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jtxtf_Treinamento_CadTreinoActionPerformed(evt);
            }
        });
        Jpnl_Identificacao_CadTreino.add(Jtxtf_Treinamento_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        Jlbl_Descricao_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Descricao_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Descricao_CadTreino.setText("Descrição: ");
        Jpnl_Identificacao_CadTreino.add(Jlbl_Descricao_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        Jlbl_Carga_CadTreino.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Jlbl_Carga_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Carga_CadTreino.setText("Carga Horaria:");
        Jpnl_Identificacao_CadTreino.add(Jlbl_Carga_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        Jtxtf_Carga_CadTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Carga_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Jtxtf_Carga_CadTreino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jtxtf_Carga_CadTreino.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Identificacao_CadTreino.add(Jtxtf_Carga_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        Jlbl_Validade_CadTreino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jlbl_Validade_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Validade_CadTreino.setText("Validade: ");
        Jpnl_Identificacao_CadTreino.add(Jlbl_Validade_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        Jtxtf_Validade_CadTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Validade_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Jtxtf_Validade_CadTreino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jtxtf_Validade_CadTreino.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Identificacao_CadTreino.add(Jtxtf_Validade_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        Jtxta_Descricao_CadTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jtxta_Descricao_CadTreino.setColumns(20);
        Jtxta_Descricao_CadTreino.setRows(5);
        Jtxta_Descricao_CadTreino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jScrollPane1.setViewportView(Jtxta_Descricao_CadTreino);

        Jpnl_Identificacao_CadTreino.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 250, 120));

        jPanel2.add(Jpnl_Identificacao_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        Jbtn_Salvar_CadTreino.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Salvar_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Jbtn_Salvar_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Salvar_CadTreino.setText("Salvar");
        Jbtn_Salvar_CadTreino.setPreferredSize(new java.awt.Dimension(151, 35));
        Jbtn_Salvar_CadTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Salvar_CadTreinoActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtn_Salvar_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 740, -1, -1));

        Jbtn_Cancelar_CadTreino.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Cancelar_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Jbtn_Cancelar_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Cancelar_CadTreino.setText("Cancelar");
        Jbtn_Cancelar_CadTreino.setPreferredSize(new java.awt.Dimension(151, 35));
        Jbtn_Cancelar_CadTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Cancelar_CadTreinoActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtn_Cancelar_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 740, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

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

        jPanel1.add(JPanel_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void Jbtn_Salvar_CadTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Salvar_CadTreinoActionPerformed
        Connection connection = null;
        PreparedStatement statement = null;
        
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        try {
            connection = DriverManager.getConnection(url, user, psswrd);
            String query = 
                "INSERT INTO treinamento"
                + "(nome_treinamento, descricao, carga_Horaria, validade)"
                + " VALUES(?,?,?,?)";
            statement = connection.prepareStatement(query);
            
            statement.setString(1, Jtxtf_Treinamento_CadTreino.getText());
            statement.setString(2, Jtxta_Descricao_CadTreino.getText());
            statement.setString(3, Jtxtf_Carga_CadTreino.getText());
            statement.setString(4, Jtxtf_Validade_CadTreino.getText());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Treinamento Cadastrado!");
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchiodos corretamente!");
            System.out.println("Erro: " + erro.getMessage());
        }
    }//GEN-LAST:event_Jbtn_Salvar_CadTreinoActionPerformed

    private void Jbtn_Cancelar_CadTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Cancelar_CadTreinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jbtn_Cancelar_CadTreinoActionPerformed

    private void Jtxtf_Treinamento_CadTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jtxtf_Treinamento_CadTreinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jtxtf_Treinamento_CadTreinoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

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
                Tela_Cadastro_Funcionario Tela_CadFunc = new Tela_Cadastro_Funcionario();
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
            case 1 -> {
                Tela_Pesquisa_Equipe Tela_SearchEqp = new Tela_Pesquisa_Equipe();
                Tela_SearchEqp.setVisible(true);
                this.dispose();
            }
            case 2 -> {
                Tela_Cadastro_Equipe Tela_CadEqp = new Tela_Cadastro_Equipe();
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
                Tela_Cadastro_Treinamento Tela_CadTreino = new Tela_Cadastro_Treinamento();
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
            java.util.logging.Logger.getLogger(Tela_Cadastro_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Cadastro_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Cadastro_Treinamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JPanel JPanel_logo_Barra_Lateral;
    private javax.swing.JButton Jbtn_Cancelar_CadTreino;
    private javax.swing.JButton Jbtn_Configuração_BarraLateral;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_Salvar_CadTreino;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_trocarUsuario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JLabel Jlbl_Carga_CadTreino;
    private javax.swing.JLabel Jlbl_Descricao_CadTreino;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_Resumo_CadTreino;
    private javax.swing.JLabel Jlbl_Treinamento_CadTreino;
    private javax.swing.JLabel Jlbl_Validade_CadTreino;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JPanel Jpnl_Identificacao_CadTreino;
    private javax.swing.JTextArea Jtxta_Descricao_CadTreino;
    private javax.swing.JTextField Jtxtf_Carga_CadTreino;
    private javax.swing.JTextField Jtxtf_Treinamento_CadTreino;
    private javax.swing.JTextField Jtxtf_Validade_CadTreino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
