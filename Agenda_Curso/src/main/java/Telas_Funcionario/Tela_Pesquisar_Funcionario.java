/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas_Funcionario;

import Telas_Equipe.Tela_Cadastro_Equipe;
import Telas_Equipe.Tela_Pesquisa_Equipe;
import Telas_Iniciais.Cadastro_Funcionario_Equipe;
import Telas_Iniciais.Tela_Login;
import Telas_Treinamento.Tela_Cadastro_Treinamento;
import Telas_Treinamento.Tela_Pesquisar_Treinamento;
import Telas_configuracao.Popup_Opcoes;
import Telas_configuracao.Tela_Configuracoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author m.schmidt //PopularJTableFuncionario
 */
public class Tela_Pesquisar_Funcionario extends javax.swing.JFrame {

    private final String tipoUsuario;

    /**
     * Creates new form Tela_Pesquisar_Funcionario
     */
    public Tela_Pesquisar_Funcionario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        initComponents();
    }

    private void PopularJTableFuncionario(String sql, JTable jTbl_Funcionario) {
        try {
            // Conexão com o banco de dados
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_agenda_curso", "root", "");
            PreparedStatement banco = con.prepareStatement(sql);
            ResultSet resultado = banco.executeQuery();


            if (!resultado.isBeforeFirst()) { 
                JOptionPane.showMessageDialog(null,
                        "Nenhum funcionário encontrado.",
                        "Nenhum Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                DefaultTableModel model = (DefaultTableModel) jTbl_Funcionario.getModel();
                model.setNumRows(0);

                while (resultado.next()) {
                    model.addRow(new Object[]{
                        resultado.getString("id_funcionario"),
                        resultado.getString("CPF"),
                        resultado.getString("nome_completo"),
                        resultado.getString("Telefone"),
                        resultado.getString("email"),
                        resultado.getString("turno"),
                        resultado.getString("cargo"),
                        resultado.getString("setor")
                    });
                }
            }
        } catch (SQLException erro) {
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

        Jpnl_Fundo_SearchFunc = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtbl_Funcionario = new javax.swing.JTable();
        Jbtn_Editar_SerachFunc = new javax.swing.JButton();
        Jbtn_Apagar_SearchFunc = new javax.swing.JButton();
        Jtxtf_Consulta_SearchFunc = new javax.swing.JTextField();
        Jbtn_Consulta_SearchFunc = new javax.swing.JButton();
        Jbtn_Treinos_CadFunc = new javax.swing.JButton();
        Jbtn_AddEquipe_cadFunc = new javax.swing.JButton();
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
        Jlbl_TipoUsuario = new javax.swing.JLabel();
        Jlbl_Logo_BarraLateral_Eqp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Jpnl_Fundo_SearchFunc.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Fundo_SearchFunc.setMaximumSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_SearchFunc.setMinimumSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_SearchFunc.setPreferredSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_SearchFunc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 797));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Pesquisa Funcionario");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        Jtbl_Funcionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CPF", "Nome", "Telefone", "Email", "Turno", "Cargo", "Setor"
            }
        ));
        Jtbl_Funcionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtbl_FuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Jtbl_Funcionario);
        if (Jtbl_Funcionario.getColumnModel().getColumnCount() > 0) {
            Jtbl_Funcionario.getColumnModel().getColumn(0).setMinWidth(50);
            Jtbl_Funcionario.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 880, 440));

        Jbtn_Editar_SerachFunc.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Editar_SerachFunc.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Jbtn_Editar_SerachFunc.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Editar_SerachFunc.setText("Editar");
        Jbtn_Editar_SerachFunc.setPreferredSize(new java.awt.Dimension(151, 35));
        Jbtn_Editar_SerachFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Editar_SerachFuncActionPerformed(evt);
            }
        });
        jPanel3.add(Jbtn_Editar_SerachFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 710, -1, -1));

        Jbtn_Apagar_SearchFunc.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Apagar_SearchFunc.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Jbtn_Apagar_SearchFunc.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Apagar_SearchFunc.setText("Apagar");
        Jbtn_Apagar_SearchFunc.setPreferredSize(new java.awt.Dimension(151, 35));
        Jbtn_Apagar_SearchFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Apagar_SearchFuncActionPerformed(evt);
            }
        });
        jPanel3.add(Jbtn_Apagar_SearchFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 710, -1, -1));

        Jtxtf_Consulta_SearchFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Consulta_SearchFunc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxtf_Consulta_SearchFunc.setToolTipText("");
        Jtxtf_Consulta_SearchFunc.setMaximumSize(new java.awt.Dimension(90, 30));
        Jtxtf_Consulta_SearchFunc.setMinimumSize(new java.awt.Dimension(90, 30));
        Jtxtf_Consulta_SearchFunc.setPreferredSize(new java.awt.Dimension(90, 30));
        Jtxtf_Consulta_SearchFunc.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Jtxtf_Consulta_SearchFuncCaretUpdate(evt);
            }
        });
        Jtxtf_Consulta_SearchFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jtxtf_Consulta_SearchFuncActionPerformed(evt);
            }
        });
        jPanel3.add(Jtxtf_Consulta_SearchFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 270, -1));
        Jtxtf_Consulta_SearchFunc.getAccessibleContext().setAccessibleName("");

        Jbtn_Consulta_SearchFunc.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Consulta_SearchFunc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_Consulta_SearchFunc.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Consulta_SearchFunc.setText("Consultar");
        Jbtn_Consulta_SearchFunc.setMaximumSize(new java.awt.Dimension(100, 30));
        Jbtn_Consulta_SearchFunc.setMinimumSize(new java.awt.Dimension(100, 30));
        Jbtn_Consulta_SearchFunc.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_Consulta_SearchFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Consulta_SearchFuncActionPerformed(evt);
            }
        });
        jPanel3.add(Jbtn_Consulta_SearchFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        Jbtn_Treinos_CadFunc.setText("Treinamentos");
        Jbtn_Treinos_CadFunc.setMaximumSize(new java.awt.Dimension(130, 40));
        Jbtn_Treinos_CadFunc.setMinimumSize(new java.awt.Dimension(130, 40));
        Jbtn_Treinos_CadFunc.setPreferredSize(new java.awt.Dimension(130, 40));
        Jbtn_Treinos_CadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Treinos_CadFuncActionPerformed(evt);
            }
        });
        jPanel3.add(Jbtn_Treinos_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 710, -1, -1));

        Jbtn_AddEquipe_cadFunc.setText("Adicionar Equipe");
        Jbtn_AddEquipe_cadFunc.setMaximumSize(new java.awt.Dimension(130, 40));
        Jbtn_AddEquipe_cadFunc.setMinimumSize(new java.awt.Dimension(130, 40));
        Jbtn_AddEquipe_cadFunc.setPreferredSize(new java.awt.Dimension(130, 40));
        Jbtn_AddEquipe_cadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_AddEquipe_cadFuncActionPerformed(evt);
            }
        });
        jPanel3.add(Jbtn_AddEquipe_cadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 710, -1, -1));

        Jpnl_Fundo_SearchFunc.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

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
        JPanel_BarraLateral.add(Jlbl_TipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 16, 143, 21));
        JPanel_BarraLateral.add(Jlbl_Logo_BarraLateral_Eqp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 133, 143));

        Jpnl_Fundo_SearchFunc.add(JPanel_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Fundo_SearchFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Fundo_SearchFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.PopularJTableFuncionario("SELECT * FROM vw_funcionario;", Jtbl_Funcionario);
    }//GEN-LAST:event_formWindowOpened

    private void Jbtn_Editar_SerachFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Editar_SerachFuncActionPerformed
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";

        Connection connection = null;
        PreparedStatement statement = null;

        int linha = Jtbl_Funcionario.getSelectedRow();
        int id_funcionario = Integer.parseInt(Jtbl_Funcionario.getValueAt(linha, 0).toString());

        try {
            connection = DriverManager.getConnection(url, user, psswrd);
            String query = "SELECT * FROM vw_dadosFuncionario WHERE id_funcionario = " + id_funcionario;
            statement = connection.prepareStatement(query);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();

            String[] dados = new String[9];
            
            if (resultSet.next()) {
                dados[0] = resultSet.getString("id_funcionario");
                dados[1] = resultSet.getString("cpf");
                dados[2] = resultSet.getString("nome_func");
                dados[3] = resultSet.getString("sobrenome");
                dados[4] = resultSet.getString("telefone");
                dados[5] = resultSet.getString("email");
                dados[6] = resultSet.getString("turno");
                dados[7] = resultSet.getString("cargo");
                dados[8] = resultSet.getString("setor");
            }

            Tela_Cadastro_Funcionario tela_funcionario = new Tela_Cadastro_Funcionario(tipoUsuario);
            tela_funcionario.Editar_CadFunc(dados);
            tela_funcionario.setVisible(true);
            this.dispose();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
    }//GEN-LAST:event_Jbtn_Editar_SerachFuncActionPerformed

    private void Jbtn_Apagar_SearchFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Apagar_SearchFuncActionPerformed
        // delete funciona quando registro nao vinculado a tabela 3ª
        if (JOptionPane.showConfirmDialog(rootPane, "Tem certeza?") == 0) {
            Connection connection = null;
            PreparedStatement statement = null;

            String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
            String user = "root";
            String psswrd = "";
            int id_funcionario = Integer.parseInt(Jtbl_Funcionario.getValueAt(Jtbl_Funcionario.getSelectedRow(), 0).toString());
            try {
                connection = DriverManager.getConnection(url, user, psswrd);
                
                String query = "DELETE FROM funcionario WHERE id_funcionario ="+id_funcionario+";";
                statement = connection.prepareStatement(query);
                statement.execute();
                this.PopularJTableFuncionario("SELECT * FROM vw_funcionario;", Jtbl_Funcionario);
                connection.close();
                statement.close();
            } catch (SQLException erro) {
                System.out.println("erro: " + erro.getMessage());
                System.out.println("erro: " + erro.getSQLState());
            }
        }
    }//GEN-LAST:event_Jbtn_Apagar_SearchFuncActionPerformed

    private void Jbtn_Consulta_SearchFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Consulta_SearchFuncActionPerformed
        String nome = Jtxtf_Consulta_SearchFunc.getText();
        this.PopularJTableFuncionario("SELECT * FROM vw_funcionario WHERE nome_completo LIKE'%" + nome + "%'", Jtbl_Funcionario);
    }//GEN-LAST:event_Jbtn_Consulta_SearchFuncActionPerformed

    private void Jtbl_FuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtbl_FuncionarioMouseClicked

    }//GEN-LAST:event_Jtbl_FuncionarioMouseClicked

    private void Jtxtf_Consulta_SearchFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jtxtf_Consulta_SearchFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jtxtf_Consulta_SearchFuncActionPerformed

    private void Jtxtf_Consulta_SearchFuncCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Jtxtf_Consulta_SearchFuncCaretUpdate
        // TODO add your handling code here: DELETAR METODO
    }//GEN-LAST:event_Jtxtf_Consulta_SearchFuncCaretUpdate

    private void Jbtn_Treinos_CadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Treinos_CadFuncActionPerformed
        int id_funcionario = Integer.parseInt(Jtbl_Funcionario.getValueAt(Jtbl_Funcionario.getSelectedRow(), NORMAL).toString());
        PopUp_Treinamentos_Funcionario treinoFunc = new PopUp_Treinamentos_Funcionario();
        try {
            treinoFunc.populaTabela(id_funcionario);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        treinoFunc.setVisible(true);

    }//GEN-LAST:event_Jbtn_Treinos_CadFuncActionPerformed

    private void Jbtn_AddEquipe_cadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_AddEquipe_cadFuncActionPerformed
        Cadastro_Funcionario_Equipe Cad_FuncEqp = new Cadastro_Funcionario_Equipe(tipoUsuario);
        Cad_FuncEqp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_AddEquipe_cadFuncActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Pesquisar_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisar_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisar_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Pesquisar_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JButton Jbtn_AddEquipe_cadFunc;
    private javax.swing.JButton Jbtn_Apagar_SearchFunc;
    private javax.swing.JButton Jbtn_Configuração_BarraLateral;
    private javax.swing.JButton Jbtn_Consulta_SearchFunc;
    private javax.swing.JButton Jbtn_Editar_SerachFunc;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_Treinos_CadFunc;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_trocarUsuario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_TipoUsuario;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JPanel Jpnl_Fundo_SearchFunc;
    private javax.swing.JTable Jtbl_Funcionario;
    private javax.swing.JTextField Jtxtf_Consulta_SearchFunc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
