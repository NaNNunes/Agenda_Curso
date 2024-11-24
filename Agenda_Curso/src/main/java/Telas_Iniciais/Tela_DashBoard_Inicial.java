/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_Iniciais;

import Telas_Equipe.Tela_Cadastro_Equipe;
import Telas_Equipe.Tela_Pesquisa_Equipe;
import Telas_Funcionario.Tela_Cadastro_Funcionario;
import Telas_Funcionario.Tela_Pesquisar_Funcionario;
import Telas_Iniciais.Tela_Login;
import Telas_Treinamento.Tela_Alocar_Treinamento;
import Telas_Treinamento.Tela_Cadastro_Treinamento;
import Telas_Treinamento.Tela_Pesquisar_Treinamento;
import Telas_configuracao.Popup_Opcoes;
import Telas_configuracao.Tela_Configuracoes;
import Telas_configuracao.Tela_Mudar_Credencial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class Tela_DashBoard_Inicial extends javax.swing.JFrame {

    private final String tipoUsuario;
    private final int userId = Tela_Login.id_usuario;
    
    /**
     * Creates new form Tela_DashBoard_Inicial
     */
    public Tela_DashBoard_Inicial(String tipoUsuario, int id) {
        this.tipoUsuario = tipoUsuario;
        initComponents();
    }

    private void procuraEqptreino(String sql, JTable Jtbl_EqpTreino) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_agenda_curso", "root", "");
            PreparedStatement banco = con.prepareStatement(sql);
            ResultSet resultado = banco.executeQuery();

            DefaultTableModel model = (DefaultTableModel) Jtbl_EqpTreino.getModel();
            model.setRowCount(0);

            while (resultado.next()) {
                System.out.println("Treinamento encontrado: " + resultado.getString("nome_treino"));
                model.addRow(new Object[]{
                    resultado.getInt("id_equipe"),
                    resultado.getString("nome_eqp"),
                    resultado.getString("turno"),
                    resultado.getString("nome_treino"),
                    resultado.getString("validade")
                });
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar equipes em treinamento: " + ex.getMessage());
        }
    }

    private void procuraEqpFunc(String sql, JTable Jtbl_EqpFunc) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_agenda_curso", "root", "");
            PreparedStatement banco = con.prepareStatement(sql);
            ResultSet resultado = banco.executeQuery();

            DefaultTableModel model = (DefaultTableModel) Jtbl_EqpFunc.getModel();
            model.setRowCount(0);

            while (resultado.next()) {
                System.out.println("Equipe encontrada: " + resultado.getString("nome_eqp"));
                model.addRow(new Object[]{
                    resultado.getInt("id_equipe"),
                    resultado.getString("nome_eqp"),
                    resultado.getString("turno")
                });
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar equipes: " + ex.getMessage());
        }
    }

    private boolean verificaPrimeiroAcesso(String sql) throws SQLException {
        boolean hasOldPassword = false;

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_agenda_curso", "root", "");
        PreparedStatement banco = con.prepareStatement(sql);
        ResultSet resultado = banco.executeQuery();

        if (resultado.next()) {
            String oldPasswd = resultado.getString("old_psswd");
            hasOldPassword = oldPasswd != null && !oldPasswd.trim().isEmpty();
        }

        con.close();
        return hasOldPassword;
    }

    private boolean comparaSenha(String query) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";

        Connection connection = DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = connection.prepareStatement(query);
        String[] passwd = new String[2];

        try {
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                passwd[0] = resultSet.getString("senha");
                passwd[1] = resultSet.getString("old_psswd");
            }
            resultSet.close();
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
        }
        connection.close();
        statement.close();

        return !passwd[0].equals(passwd[1]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Jbtn_AlocarTreino = new javax.swing.JButton();
        Jbtn_AlocarFuncEqp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtbl_EqpTreino = new javax.swing.JTable();
        Jlbl_EqpTreino_DashBrd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtbl_EqpFunc = new javax.swing.JTable();
        Jtbl_EqpFunc_DashBrd = new javax.swing.JLabel();
        Jlbl_Title_SearchTreino = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(243, 236, 196));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 797));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_AlocarTreino.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_AlocarTreino.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Jbtn_AlocarTreino.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_AlocarTreino.setText("Treinar Equipe");
        Jbtn_AlocarTreino.setPreferredSize(new java.awt.Dimension(170, 40));
        Jbtn_AlocarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_AlocarTreinoActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtn_AlocarTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 720, -1, -1));

        Jbtn_AlocarFuncEqp.setBackground(new java.awt.Color(47, 63, 115));
        Jbtn_AlocarFuncEqp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Jbtn_AlocarFuncEqp.setForeground(new java.awt.Color(255, 255, 255));
        Jbtn_AlocarFuncEqp.setText("Alocar Funcionários");
        Jbtn_AlocarFuncEqp.setPreferredSize(new java.awt.Dimension(170, 40));
        Jbtn_AlocarFuncEqp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_AlocarFuncEqpActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtn_AlocarFuncEqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 720, -1, -1));

        Jtbl_EqpTreino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Turno", "Treinamento", "Validade"
            }
        ));
        jScrollPane1.setViewportView(Jtbl_EqpTreino);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 97, 650, 284));

        Jlbl_EqpTreino_DashBrd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jlbl_EqpTreino_DashBrd.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_EqpTreino_DashBrd.setText("Equipes em treinamento");
        jPanel2.add(Jlbl_EqpTreino_DashBrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        Jtbl_EqpFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Turno"
            }
        ));
        jScrollPane2.setViewportView(Jtbl_EqpFunc);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 415, 640, 284));

        Jtbl_EqpFunc_DashBrd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Jtbl_EqpFunc_DashBrd.setForeground(new java.awt.Color(0, 0, 0));
        Jtbl_EqpFunc_DashBrd.setText("Equipes sem funcionários");
        jPanel2.add(Jtbl_EqpFunc_DashBrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, -1, -1));

        Jlbl_Title_SearchTreino.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Jlbl_Title_SearchTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Title_SearchTreino.setText("DashBoard");
        jPanel2.add(Jlbl_Title_SearchTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Jbtn_AlocarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_AlocarTreinoActionPerformed
        if ("supervisor".equals(tipoUsuario) || "admin".equals(tipoUsuario) || "operador".equals(tipoUsuario)) {
            Tela_Alocar_Treinamento CadEqp_Treino = new Tela_Alocar_Treinamento(tipoUsuario);
            CadEqp_Treino.setVisible(true);
            this.dispose();

        } else if ("instrutor".equals(tipoUsuario)) {
            Tela_Alocar_Treinamento CadEqp_Treino = new Tela_Alocar_Treinamento(tipoUsuario);
            CadEqp_Treino.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de usuário não reconhecido!");
        }
    }//GEN-LAST:event_Jbtn_AlocarTreinoActionPerformed

    private void Jbtn_AlocarFuncEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_AlocarFuncEqpActionPerformed
        if ("supervisor".equals(tipoUsuario) || "admin".equals(tipoUsuario) || "operador".equals(tipoUsuario)) {
            Cadastro_Funcionario_Equipe CadFunc_Treino = new Cadastro_Funcionario_Equipe(tipoUsuario);
            CadFunc_Treino.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Tipo de usuário não reconhecido!");
        }
    }//GEN-LAST:event_Jbtn_AlocarFuncEqpActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        if ("supervisor".equals(tipoUsuario)) {
            Jlbl_TipoUsuario.setText("Supervisor");
            Jbtn_AlocarTreino.setVisible(true);
            Jbtn_AlocarFuncEqp.setVisible(true);
        } else if ("operador".equals(tipoUsuario)) {
            Jlbl_TipoUsuario.setText("Operador");
            Jbtn_AlocarTreino.setVisible(true);
            Jbtn_AlocarFuncEqp.setVisible(true);
        } else if ("instrutor".equals(tipoUsuario)) {
            Jlbl_TipoUsuario.setText("Instrutor");
            Jbtn_AlocarTreino.setVisible(false);
            Jbtn_AlocarFuncEqp.setVisible(false);
        } else if ("admin".equals(tipoUsuario)) {
            Jlbl_TipoUsuario.setText("Administrador");
            Jbtn_AlocarTreino.setVisible(true);
            Jbtn_AlocarFuncEqp.setVisible(true);
        } else {
            Jlbl_TipoUsuario.setText("Usuário Desconhecido");
            Jbtn_AlocarTreino.setVisible(false);
            Jbtn_AlocarFuncEqp.setVisible(false);
        }

        try {
            boolean hasOldPassword = verificaPrimeiroAcesso("SELECT * FROM usuario WHERE id_usuario = " + this.userId);

            if (!hasOldPassword) {
                String msg = "Você ainda não configurou sua senha. Deseja configurá-la agora?";

                if (JOptionPane.showConfirmDialog(null, msg, "Trocar Senha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    new Tela_Mudar_Credencial(tipoUsuario).setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_DashBoard_Inicial.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao verificar senha: " + ex.getMessage());
        }

        String sqlfunc = "SELECT e.id_equipe, e.nome_eqp, e.turno "
                + "FROM equipe e "
                + "LEFT JOIN cadastro_funcionario_equipe cfe "
                + "ON e.id_equipe = cfe.id_equipe "
                + "WHERE cfe.id_funcionario IS NULL";
        procuraEqpFunc(sqlfunc, Jtbl_EqpFunc);

        String sqltrein = "SELECT e.id_equipe, e.nome_eqp, e.turno, "
                + "t.nome_treino, t.validade "
                + "FROM equipe e "
                + "INNER JOIN cadastro_equipe_treinamento cet "
                + "ON e.id_equipe = cet.id_equipe "
                + "INNER JOIN treinamento t "
                + "ON cet.id_treinamento = t.id_treinamento";
        procuraEqptreino(sqltrein, Jtbl_EqpTreino);

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
        if ("admin".equals(tipoUsuario) || "operador".equals(tipoUsuario)) {
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
            java.util.logging.Logger.getLogger(Tela_DashBoard_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_DashBoard_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_DashBoard_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_DashBoard_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String tipoUsuario;
            
            public void run() {
                this.tipoUsuario = tipoUsuario;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JButton Jbtn_AlocarFuncEqp;
    private javax.swing.JButton Jbtn_AlocarTreino;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JLabel Jlbl_EqpTreino_DashBrd;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_TipoUsuario;
    private javax.swing.JLabel Jlbl_Title_SearchTreino;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JTable Jtbl_EqpFunc;
    private javax.swing.JLabel Jtbl_EqpFunc_DashBrd;
    private javax.swing.JTable Jtbl_EqpTreino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
