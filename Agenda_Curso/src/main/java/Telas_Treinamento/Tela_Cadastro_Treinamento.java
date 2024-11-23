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
import Telas_configuracao.Tela_Configuracoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author mathe
 */
public class Tela_Cadastro_Treinamento extends javax.swing.JFrame {

    private final String tipoUsuario;
    
    /**
     * Creates new form Tela_Adicionar_Treinamento
     */
    
    public Tela_Cadastro_Treinamento(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        initComponents();
        this.Jbtn_Editar_CadTreino.setVisible(false);
    }
    public void editar_Treinamento(String[] dados){
        this.Jbtn_Salvar_CadTreino.setVisible(false);
        this.Jbtn_Editar_CadTreino.setVisible(true);
        this.id_treinamento = Integer.parseInt(dados[0]);
        this.Jtxtf_Treinamento_CadTreino.setText(dados[1]);
        this.Jtxta_Descricao_CadTreino.setText(dados[2]);
        this.Jtxtf_Carga_CadTreino.setText(dados[3]);
        this.Jtxtf_Validade_CadTreino.setText(dados[4]);
    }
    private int id_treinamento;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpnl_Fundo_CadTreino = new javax.swing.JPanel();
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
        Jbtn_Editar_CadTreino = new javax.swing.JButton();
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

        Jpnl_Fundo_CadTreino.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Fundo_CadTreino.setMaximumSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_CadTreino.setMinimumSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_CadTreino.setPreferredSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_CadTreino.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(Jbtn_Salvar_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 700, -1, -1));

        Jbtn_Editar_CadTreino.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Editar_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Jbtn_Editar_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Editar_CadTreino.setText("Editar");
        Jbtn_Editar_CadTreino.setPreferredSize(new java.awt.Dimension(151, 35));
        Jbtn_Editar_CadTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Editar_CadTreinoActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtn_Editar_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 700, -1, -1));

        Jpnl_Fundo_CadTreino.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 17, -1, -1));

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

        Jpnl_Fundo_CadTreino.add(JPanel_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Fundo_CadTreino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Fundo_CadTreino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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
                + "(nome_treino, descricao, carga_Horaria, validade)"
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
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }//GEN-LAST:event_Jbtn_Salvar_CadTreinoActionPerformed

    private void Jbtn_Editar_CadTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Editar_CadTreinoActionPerformed
        Connection connection = null;
        PreparedStatement statement = null;

        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        try {
            connection = DriverManager.getConnection(url,user,psswrd);
            String query = "UPDATE treinamento set nome_treino = ?, descricao = ?, validade = ?, carga_horaria = ? "
                    + "WHERE id_treinamento =" + this.id_treinamento;
            statement = connection.prepareStatement(query);
            statement.setString(1, Jtxtf_Treinamento_CadTreino.getText());
            statement.setString(2, Jtxta_Descricao_CadTreino.getText());
            statement.setString(3, Jtxtf_Carga_CadTreino.getText());
            statement.setString(4, Jtxtf_Validade_CadTreino.getText());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Treinamento Atualizado");
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "erro: " + erro.getMessage());
        }
    }//GEN-LAST:event_Jbtn_Editar_CadTreinoActionPerformed

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
            private String tipoUsuario;
            public void run() {
                this.tipoUsuario = tipoUsuario;
                new Tela_Cadastro_Treinamento(tipoUsuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JButton Jbtn_Configuração_BarraLateral;
    private javax.swing.JButton Jbtn_Editar_CadTreino;
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
    private javax.swing.JLabel Jlbl_TipoUsuario;
    private javax.swing.JLabel Jlbl_Treinamento_CadTreino;
    private javax.swing.JLabel Jlbl_Validade_CadTreino;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JPanel Jpnl_Fundo_CadTreino;
    private javax.swing.JPanel Jpnl_Identificacao_CadTreino;
    private javax.swing.JTextArea Jtxta_Descricao_CadTreino;
    private javax.swing.JTextField Jtxtf_Carga_CadTreino;
    private javax.swing.JTextField Jtxtf_Treinamento_CadTreino;
    private javax.swing.JTextField Jtxtf_Validade_CadTreino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
