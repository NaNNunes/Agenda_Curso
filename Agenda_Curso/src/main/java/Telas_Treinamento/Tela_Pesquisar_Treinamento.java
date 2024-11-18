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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class Tela_Pesquisar_Treinamento extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Pesquisar_Treinamento
     */
    public Tela_Pesquisar_Treinamento() {
        initComponents();
    }

    private void populaTabela(String query) throws SQLException{
        
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        Connection connection = (Connection) DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
        
        try {
            statement.execute();
            ResultSet resultSet = statement.executeQuery(query);
            
            DefaultTableModel model = (DefaultTableModel) Jtbl_ListaTreino.getModel();
            model.setNumRows(0);
            
            while(resultSet.next()){
                model.addRow(new Object[]{
                    resultSet.getString("id_treino"),
                    resultSet.getString("nome"),
                    resultSet.getString("carga_horaria"),
                    resultSet.getString("validade"),
                });
            }
            
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException erro){
            System.out.println("Erro: " + erro.getMessage());
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

        Jpnl_Fundo_SearchTreino = new javax.swing.JPanel();
        Jpnl_Conteiner_SearchTreino = new javax.swing.JPanel();
        Jlbl_Title_SearchTreino = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtbl_ListaTreino = new javax.swing.JTable();
        Jtxtf_consulta_SearchTreino = new javax.swing.JTextField();
        Jbtn_consulta = new javax.swing.JButton();
        Jbtn_Apagar_SearchFunc = new javax.swing.JButton();
        Jbtn_Editar_SearchTreino = new javax.swing.JButton();
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

        Jpnl_Fundo_SearchTreino.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Fundo_SearchTreino.setMaximumSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_SearchTreino.setMinimumSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_SearchTreino.setPreferredSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_SearchTreino.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpnl_Conteiner_SearchTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jpnl_Conteiner_SearchTreino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Conteiner_SearchTreino.setPreferredSize(new java.awt.Dimension(1000, 797));
        Jpnl_Conteiner_SearchTreino.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Title_SearchTreino.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Jlbl_Title_SearchTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Title_SearchTreino.setText("Treinamentos");
        Jpnl_Conteiner_SearchTreino.add(Jlbl_Title_SearchTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        Jtbl_ListaTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtbl_ListaTreino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "nome", "carga", "validade"
            }
        ));
        jScrollPane1.setViewportView(Jtbl_ListaTreino);

        Jpnl_Conteiner_SearchTreino.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 640, -1));

        Jtxtf_consulta_SearchTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_consulta_SearchTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxtf_consulta_SearchTreino.setMaximumSize(new java.awt.Dimension(90, 30));
        Jtxtf_consulta_SearchTreino.setMinimumSize(new java.awt.Dimension(90, 30));
        Jtxtf_consulta_SearchTreino.setPreferredSize(new java.awt.Dimension(90, 30));
        Jpnl_Conteiner_SearchTreino.add(Jtxtf_consulta_SearchTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 250, -1));

        Jbtn_consulta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_consulta.setText("Consultar");
        Jbtn_consulta.setMaximumSize(new java.awt.Dimension(100, 30));
        Jbtn_consulta.setMinimumSize(new java.awt.Dimension(100, 30));
        Jbtn_consulta.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_consultaActionPerformed(evt);
            }
        });
        Jpnl_Conteiner_SearchTreino.add(Jbtn_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        Jbtn_Apagar_SearchFunc.setText("Apagar");
        Jbtn_Apagar_SearchFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Apagar_SearchFuncActionPerformed(evt);
            }
        });
        Jpnl_Conteiner_SearchTreino.add(Jbtn_Apagar_SearchFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 720, -1, -1));

        Jbtn_Editar_SearchTreino.setText("Editar");
        Jbtn_Editar_SearchTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Editar_SearchTreinoActionPerformed(evt);
            }
        });
        Jpnl_Conteiner_SearchTreino.add(Jbtn_Editar_SearchTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 720, -1, -1));

        Jpnl_Fundo_SearchTreino.add(Jpnl_Conteiner_SearchTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

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
        Jcmbx_Treinamento_BarraLateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmbx_Treinamento_BarraLateralActionPerformed(evt);
            }
        });
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

        Jpnl_Fundo_SearchTreino.add(JPanel_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Fundo_SearchTreino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Fundo_SearchTreino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            this.populaTabela("SELECT * FROM vw_treinamento");
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Pesquisar_Treinamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void Jbtn_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_consultaActionPerformed
            try {
                String nomeTreino = Jtxtf_consulta_SearchTreino.getText();
                this.populaTabela("SELECT * FROM vw_treinamento "
                + "WHERE nome_treinamento LIKE '%"+nomeTreino+"%'");
            } catch (SQLException erro) {
                    System.out.println("Erro: " + erro.getMessage());
            }
    }//GEN-LAST:event_Jbtn_consultaActionPerformed

    private void Jbtn_Apagar_SearchFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Apagar_SearchFuncActionPerformed
        // delete funciona quando registro nao vinculado a tabela 3ª
        if (JOptionPane.showConfirmDialog(rootPane, "Tem certeza?") == 0){
            Connection connection = null;
            PreparedStatement statement = null;

            String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
            String user = "root";
            String psswrd = "";
            int linha = Jtbl_ListaTreino.getSelectedRow();
            int id_treino = Integer.parseInt(Jtbl_ListaTreino.getValueAt(linha, 0).toString());
            try {
                connection = DriverManager.getConnection(url,user,psswrd);
                String query = "DELETE FROM treinamento WHERE id_treinamento ="+id_treino;
                statement = connection.prepareStatement(query);
                statement.executeUpdate();
                this.populaTabela("SELECT * FROM vw_treinamento;");
                connection.close();
                statement.close();
            }
            catch (SQLException erro){
                System.out.println("erro: " + erro.getMessage());
            }
        }
    }//GEN-LAST:event_Jbtn_Apagar_SearchFuncActionPerformed

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

    private void Jcmbx_Funcionario_BarraLateralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcmbx_Funcionario_BarraLateralMouseClicked

    }//GEN-LAST:event_Jcmbx_Funcionario_BarraLateralMouseClicked

    private void Jcmbx_Funcionario_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmbx_Funcionario_BarraLateralActionPerformed
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
    }//GEN-LAST:event_Jcmbx_Funcionario_BarraLateralActionPerformed

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

    private void Jcmbx_Equipe_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmbx_Equipe_BarraLateralActionPerformed
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
    }//GEN-LAST:event_Jcmbx_Equipe_BarraLateralActionPerformed

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

    private void Jcmbx_Treinamento_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmbx_Treinamento_BarraLateralActionPerformed
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
    }//GEN-LAST:event_Jcmbx_Treinamento_BarraLateralActionPerformed

    private void Jbtn_Editar_SearchTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Editar_SearchTreinoActionPerformed
        Connection connection = null;
        PreparedStatement statement = null;

        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        int linha = Jtbl_ListaTreino.getSelectedRow();
        int id = Integer.parseInt(Jtbl_ListaTreino.getValueAt(linha, 0).toString());
        String[] dados = new String[5];
        try {
            connection = DriverManager.getConnection(url,user,psswrd);
            String query = "SELECT * FROM treinamento WHERE id_treinamento ="+ id;
            statement = connection.prepareStatement(query);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                dados[0] = resultSet.getString("id_treinamento");
                dados[1] = resultSet.getString("nome_treino");
                dados[2] = resultSet.getString("descricao");
                dados[3] = resultSet.getString("carga_horaria");
                dados[4] = resultSet.getString("validade");
            }
            
            Tela_Cadastro_Treinamento CadTreino = new Tela_Cadastro_Treinamento();
            CadTreino.editar_Treinamento(dados);
            CadTreino.setVisible(true);
            connection.close();
            statement.close();
            resultSet.close();
            this.dispose();
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }//GEN-LAST:event_Jbtn_Editar_SearchTreinoActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Pesquisar_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisar_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisar_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisar_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Pesquisar_Treinamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JPanel JPanel_logo_Barra_Lateral;
    private javax.swing.JButton Jbtn_Apagar_SearchFunc;
    private javax.swing.JButton Jbtn_Configuração_BarraLateral;
    private javax.swing.JButton Jbtn_Editar_SearchTreino;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_consulta;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_trocarUsuario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_Title_SearchTreino;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JPanel Jpnl_Conteiner_SearchTreino;
    private javax.swing.JPanel Jpnl_Fundo_SearchTreino;
    private javax.swing.JTable Jtbl_ListaTreino;
    private javax.swing.JTextField Jtxtf_consulta_SearchTreino;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
