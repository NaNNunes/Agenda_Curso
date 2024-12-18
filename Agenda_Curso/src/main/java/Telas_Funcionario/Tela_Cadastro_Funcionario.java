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
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mathe
 */

public class Tela_Cadastro_Funcionario extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Adicionar_Funcionario
     */
    
    private int id_funcionario;
    
    public Tela_Cadastro_Funcionario() {
        initComponents();
        this.mascaraCombox();
        this.Jbtn_Treinos_CadFunc.setVisible(false);
        this.Jbtn_AddEquipe_cadFunc.setVisible(false);
        this.Jbtn_Editar_CadFunc.setVisible(false);
        this.Jbtn_Salvar_CadFunc.setVisible(true);
    }
    
    public void Editar_CadFunc(String[] dados){
        this.Jbtn_Treinos_CadFunc.setVisible(true);
        this.Jbtn_AddEquipe_cadFunc.setVisible(true);
        this.Jbtn_Editar_CadFunc.setVisible(true);
        this.Jbtn_Salvar_CadFunc.setVisible(false);
        
        this.id_funcionario = Integer.parseInt(dados[0]);
        this.Jftxtf_CPF_CadFunc.setText(dados[1]);
        this.Jftxtf_CPF_CadFunc.setEditable(false);
        this.Jftxtf_CPF_CadFunc.setForeground(Color.gray);
        this.Jtxtf_Nome_CadFunc.setText(dados[2]);
        this.Jtxtf_Sobrenome_CadFunc.setText(dados[3]);
        this.Jftxtf_Telefone_CadFunc.setText(dados[4]);
        this.Jtxtf_Email_CadFunc.setText(dados[5]);
        this.Jcmbx_Turno_CadFunc.getModel().setSelectedItem(dados[6]);
        this.Jcmbx_Cargo_CadFunc.getModel().setSelectedItem(dados[7]);
        this.Jcmbx_Setor_CadFunc.getModel().setSelectedItem(dados[8]);
    }
    
    private void mascaraCombox() {
        this.Jcmbx_Setor_CadFunc.getModel().setSelectedItem("-- selecione --");
        this.Jcmbx_Cargo_CadFunc.getModel().setSelectedItem("-- selecione --");
        this.Jcmbx_Turno_CadFunc.getModel().setSelectedItem("-- selecione --");
    }

    private int pegaIdSetor(String query) { // bind FK id_setor at employee table
        Connection connection = null;
        PreparedStatement statement = null;

        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        int id = 0;

        try {
            connection = DriverManager.getConnection(url, user, psswrd);
            statement = connection.prepareStatement(query);

            statement.execute();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                id = resultSet.getInt("id_setor");
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }

        return id;
    }

    private void popCmBoxSetor(String query) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";

        Connection connection = (Connection) DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);

        try {
            statement.execute();
            ResultSet resultSet = statement.executeQuery(query);

            DefaultComboBoxModel cBoxModel = (DefaultComboBoxModel) Jcmbx_Setor_CadFunc.getModel();
            cBoxModel.removeAllElements();
            cBoxModel.setSelectedItem("-- selecione --");
            while (resultSet.next()) {
                cBoxModel.addElement(resultSet.getString("sigla"));
            }

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }
    
    private boolean procuraCPF(String query) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        boolean isRegistered = true;
        
        Connection connection = (Connection) DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
        
        try{
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next()){
                isRegistered = false;
            }
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        
        return isRegistered;
    }
    
    private boolean validadorCPF(String cpf){
        int[] digito = new int[cpf.length() - 3];
        int c = 0;
        int n = 0;
        int digJ = 0;
        int digK = 0;
        int restJ = 0;
        int restK = 0;
        String strDigito;
        
        for (int i = 0; i < cpf.length(); i++) {
            if((cpf.charAt(i) != '.') && (cpf.charAt(i) != '-')){
                strDigito = Character.toString(cpf.charAt(i));
                digito[c] = Integer.parseInt(strDigito);
                c++;
            }
        }
        // primeiro digito
        n = 10;
        for (int i = 0; i < 9; i++) {
            restJ += digito[i] * n--;
        }
        restJ = restJ % 11;
        digJ = (restJ == 0 || restJ == 1) ? 0 : (11 - restJ);
        // segundo digito
        n = 11;
        for (int i = 0; i < 10; i++) {
            restK += digito[i] * n--; 
        }
        restK = restK % 11;
        digK = (restK == 0 || restK == 1) ? 0 : (11 - restK);
        
        return (digJ == digito[9] && digK == digito[10]);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpnl_Fundo_CadFunc = new javax.swing.JPanel();
        Jpnl_Container_CadFunc = new javax.swing.JPanel();
        Jlbl_Cadastrar_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jpnl_Identificacao_Tela_Adicionar_Funcionario = new javax.swing.JPanel();
        Jlbl_Title_identificacao = new javax.swing.JLabel();
        Jlbl_Nome_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jtxtf_Nome_CadFunc = new javax.swing.JTextField();
        Jlbl_CPF_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jlbl_Sobrenome_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jtxtf_Sobrenome_CadFunc = new javax.swing.JTextField();
        Jftxtf_CPF_CadFunc = new javax.swing.JFormattedTextField();
        Jpnl_Contato_Tela_Adicionar_Funcionario = new javax.swing.JPanel();
        Jlbl_Contato_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jlbl_Numero_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jtxtf_Email_CadFunc = new javax.swing.JTextField();
        Jlbl_Email_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jftxtf_Telefone_CadFunc = new javax.swing.JFormattedTextField();
        Jpnl_Area_Tela_Adicionar_Funcionario = new javax.swing.JPanel();
        Jlbl_Area_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jlbl_Codigo_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jlbl_Cargo_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jlbl_Turno_Tela_Adicionar_Funcionario = new javax.swing.JLabel();
        Jcmbx_Cargo_CadFunc = new javax.swing.JComboBox<>();
        Jcmbx_Turno_CadFunc = new javax.swing.JComboBox<>();
        Jcmbx_Setor_CadFunc = new javax.swing.JComboBox<>();
        Jbtn_Treinos_CadFunc = new javax.swing.JButton();
        Jbtn_AddEquipe_cadFunc = new javax.swing.JButton();
        Jbtn_Editar_CadFunc = new javax.swing.JButton();
        Jbtn_Salvar_CadFunc = new javax.swing.JButton();
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
        setMaximumSize(new java.awt.Dimension(1280, 832));
        setMinimumSize(new java.awt.Dimension(1280, 832));
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Jpnl_Fundo_CadFunc.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Fundo_CadFunc.setMaximumSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_CadFunc.setMinimumSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_CadFunc.setPreferredSize(new java.awt.Dimension(1280, 832));
        Jpnl_Fundo_CadFunc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpnl_Container_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jpnl_Container_CadFunc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Container_CadFunc.setPreferredSize(new java.awt.Dimension(1000, 797));
        Jpnl_Container_CadFunc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Cadastrar_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Jlbl_Cadastrar_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Cadastrar_Tela_Adicionar_Funcionario.setText("Cadastrar Funcionário");
        Jlbl_Cadastrar_Tela_Adicionar_Funcionario.setPreferredSize(new java.awt.Dimension(351, 49));
        Jpnl_Container_CadFunc.add(Jlbl_Cadastrar_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        Jpnl_Identificacao_Tela_Adicionar_Funcionario.setBackground(new java.awt.Color(243, 228, 188));
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.setPreferredSize(new java.awt.Dimension(780, 171));
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Title_identificacao.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Title_identificacao.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Title_identificacao.setText("Identificação");
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.add(Jlbl_Title_identificacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        Jlbl_Nome_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Nome_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Nome_Tela_Adicionar_Funcionario.setText("Nome: ");
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.add(Jlbl_Nome_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        Jtxtf_Nome_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Nome_CadFunc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Jtxtf_Nome_CadFunc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jtxtf_Nome_CadFunc.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.add(Jtxtf_Nome_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        Jlbl_CPF_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_CPF_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_CPF_Tela_Adicionar_Funcionario.setText("CPF:");
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.add(Jlbl_CPF_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        Jlbl_Sobrenome_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Sobrenome_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Sobrenome_Tela_Adicionar_Funcionario.setText("Sobrenome: ");
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.add(Jlbl_Sobrenome_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        Jtxtf_Sobrenome_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Sobrenome_CadFunc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Jtxtf_Sobrenome_CadFunc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jtxtf_Sobrenome_CadFunc.setPreferredSize(new java.awt.Dimension(248, 30));
        Jtxtf_Sobrenome_CadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jtxtf_Sobrenome_CadFuncActionPerformed(evt);
            }
        });
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.add(Jtxtf_Sobrenome_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        Jftxtf_CPF_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jftxtf_CPF_CadFunc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jftxtf_CPF_CadFunc.setForeground(new java.awt.Color(0, 0, 0));
        try {
            Jftxtf_CPF_CadFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Jftxtf_CPF_CadFunc.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Identificacao_Tela_Adicionar_Funcionario.add(Jftxtf_CPF_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        Jpnl_Container_CadFunc.add(Jpnl_Identificacao_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        Jpnl_Contato_Tela_Adicionar_Funcionario.setBackground(new java.awt.Color(243, 228, 188));
        Jpnl_Contato_Tela_Adicionar_Funcionario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Contato_Tela_Adicionar_Funcionario.setPreferredSize(new java.awt.Dimension(780, 114));
        Jpnl_Contato_Tela_Adicionar_Funcionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Contato_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Contato_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Contato_Tela_Adicionar_Funcionario.setText("Contato");
        Jpnl_Contato_Tela_Adicionar_Funcionario.add(Jlbl_Contato_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        Jlbl_Numero_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Numero_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Numero_Tela_Adicionar_Funcionario.setText("Celular:");
        Jpnl_Contato_Tela_Adicionar_Funcionario.add(Jlbl_Numero_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        Jtxtf_Email_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_Email_CadFunc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Jtxtf_Email_CadFunc.setForeground(new java.awt.Color(0, 0, 0));
        Jtxtf_Email_CadFunc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jtxtf_Email_CadFunc.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Contato_Tela_Adicionar_Funcionario.add(Jtxtf_Email_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        Jlbl_Email_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Email_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Email_Tela_Adicionar_Funcionario.setText("Email:");
        Jpnl_Contato_Tela_Adicionar_Funcionario.add(Jlbl_Email_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        Jftxtf_Telefone_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jftxtf_Telefone_CadFunc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jftxtf_Telefone_CadFunc.setForeground(new java.awt.Color(0, 0, 0));
        try {
            Jftxtf_Telefone_CadFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Jftxtf_Telefone_CadFunc.setToolTipText("");
        Jftxtf_Telefone_CadFunc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jftxtf_Telefone_CadFunc.setMaximumSize(new java.awt.Dimension(248, 30));
        Jftxtf_Telefone_CadFunc.setMinimumSize(new java.awt.Dimension(248, 30));
        Jftxtf_Telefone_CadFunc.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Contato_Tela_Adicionar_Funcionario.add(Jftxtf_Telefone_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        Jpnl_Container_CadFunc.add(Jpnl_Contato_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        Jpnl_Area_Tela_Adicionar_Funcionario.setBackground(new java.awt.Color(243, 228, 188));
        Jpnl_Area_Tela_Adicionar_Funcionario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Area_Tela_Adicionar_Funcionario.setPreferredSize(new java.awt.Dimension(780, 171));
        Jpnl_Area_Tela_Adicionar_Funcionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Area_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Area_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Area_Tela_Adicionar_Funcionario.setText("Área/Atuação");
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jlbl_Area_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        Jlbl_Codigo_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Codigo_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Codigo_Tela_Adicionar_Funcionario.setText("Setor: ");
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jlbl_Codigo_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        Jlbl_Cargo_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Cargo_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Cargo_Tela_Adicionar_Funcionario.setText("Cargo: ");
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jlbl_Cargo_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        Jlbl_Turno_Tela_Adicionar_Funcionario.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Turno_Tela_Adicionar_Funcionario.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Turno_Tela_Adicionar_Funcionario.setText("Turno: ");
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jlbl_Turno_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        Jcmbx_Cargo_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jcmbx_Cargo_CadFunc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Jcmbx_Cargo_CadFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "supervisor", "instrutor", "operador" }));
        Jcmbx_Cargo_CadFunc.setSelectedIndex(-1);
        Jcmbx_Cargo_CadFunc.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jcmbx_Cargo_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        Jcmbx_Turno_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jcmbx_Turno_CadFunc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jcmbx_Turno_CadFunc.setForeground(new java.awt.Color(0, 0, 0));
        Jcmbx_Turno_CadFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Noturno" }));
        Jcmbx_Turno_CadFunc.setSelectedIndex(-1);
        Jcmbx_Turno_CadFunc.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jcmbx_Turno_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        Jcmbx_Setor_CadFunc.setBackground(new java.awt.Color(255, 255, 255));
        Jcmbx_Setor_CadFunc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jcmbx_Setor_CadFunc.setPreferredSize(new java.awt.Dimension(250, 30));
        Jcmbx_Setor_CadFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jcmbx_Setor_CadFuncMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Jcmbx_Setor_CadFuncMouseEntered(evt);
            }
        });
        Jcmbx_Setor_CadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jcmbx_Setor_CadFuncActionPerformed(evt);
            }
        });
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jcmbx_Setor_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 250, -1));

        Jbtn_Treinos_CadFunc.setText("Treinamentos");
        Jbtn_Treinos_CadFunc.setMaximumSize(new java.awt.Dimension(130, 40));
        Jbtn_Treinos_CadFunc.setMinimumSize(new java.awt.Dimension(130, 40));
        Jbtn_Treinos_CadFunc.setPreferredSize(new java.awt.Dimension(130, 40));
        Jbtn_Treinos_CadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Treinos_CadFuncActionPerformed(evt);
            }
        });
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jbtn_Treinos_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, -1, -1));

        Jbtn_AddEquipe_cadFunc.setText("Adicionar Equipe");
        Jbtn_AddEquipe_cadFunc.setMaximumSize(new java.awt.Dimension(130, 40));
        Jbtn_AddEquipe_cadFunc.setMinimumSize(new java.awt.Dimension(130, 40));
        Jbtn_AddEquipe_cadFunc.setPreferredSize(new java.awt.Dimension(130, 40));
        Jbtn_AddEquipe_cadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_AddEquipe_cadFuncActionPerformed(evt);
            }
        });
        Jpnl_Area_Tela_Adicionar_Funcionario.add(Jbtn_AddEquipe_cadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        Jpnl_Container_CadFunc.add(Jpnl_Area_Tela_Adicionar_Funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, -1));

        Jbtn_Editar_CadFunc.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Editar_CadFunc.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Jbtn_Editar_CadFunc.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Editar_CadFunc.setText("Editar");
        Jbtn_Editar_CadFunc.setPreferredSize(new java.awt.Dimension(151, 35));
        Jbtn_Editar_CadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Editar_CadFuncActionPerformed(evt);
            }
        });
        Jpnl_Container_CadFunc.add(Jbtn_Editar_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 710, -1, -1));

        Jbtn_Salvar_CadFunc.setBackground(new java.awt.Color(243, 236, 196));
        Jbtn_Salvar_CadFunc.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Jbtn_Salvar_CadFunc.setForeground(new java.awt.Color(0, 0, 0));
        Jbtn_Salvar_CadFunc.setText("Salvar");
        Jbtn_Salvar_CadFunc.setPreferredSize(new java.awt.Dimension(151, 35));
        Jbtn_Salvar_CadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_Salvar_CadFuncActionPerformed(evt);
            }
        });
        Jpnl_Container_CadFunc.add(Jbtn_Salvar_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 710, -1, -1));

        Jpnl_Fundo_CadFunc.add(Jpnl_Container_CadFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

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

        Jpnl_Fundo_CadFunc.add(JPanel_BarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Fundo_CadFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpnl_Fundo_CadFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Jbtn_Editar_CadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Editar_CadFuncActionPerformed
        Connection connection = null;
        PreparedStatement statement = null;

        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";

        try {
            connection = DriverManager.getConnection(url, user, psswrd);
            String query = "UPDATE funcionario set CPF = ?, nome_func = ?, sobrenome = ?, "
                + "Telefone = ?, email = ?, turno = ?, cargo = ?, id_setor = ? "
                + "WHERE id_funcionario = "+id_funcionario;
            statement = connection.prepareStatement(query);

            String turno = (String) Jcmbx_Turno_CadFunc.getSelectedItem();
            String cargo = (String) Jcmbx_Cargo_CadFunc.getSelectedItem();
            int setor = this.pegaIdSetor("SELECT * FROM setor WHERE sigla = '"
                + Jcmbx_Setor_CadFunc.getSelectedItem()+"'"); // tem que ter esse fechamento no final, top 10 sintaxes
            
            statement.setString(1, Jftxtf_CPF_CadFunc.getText());
            statement.setString(2, Jtxtf_Nome_CadFunc.getText());
            statement.setString(3, Jtxtf_Sobrenome_CadFunc.getText());
            statement.setString(4, Jftxtf_Telefone_CadFunc.getText());
            statement.setString(5, Jtxtf_Email_CadFunc.getText());
            statement.setString(6, turno);
            statement.setString(7, cargo);
            statement.setInt(8, setor);

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado editado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchiodos corretamente!");
            System.out.println(erro);
            System.out.println("Erro: " + erro.getMessage());
        }
    }//GEN-LAST:event_Jbtn_Editar_CadFuncActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void Jcmbx_Setor_CadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jcmbx_Setor_CadFuncActionPerformed
        
    }//GEN-LAST:event_Jcmbx_Setor_CadFuncActionPerformed

    private void Jbtn_LogoutButton_BarraLateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_LogoutButton_BarraLateralActionPerformed
        Tela_Login telaLogin = new Tela_Login();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_LogoutButton_BarraLateralActionPerformed

    private void Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_IconeFuncionario_BarraLateral_CadEqpActionPerformed

        switch (Jcmbx_Funcionario_BarraLateral.getSelectedIndex()) {
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
        switch (Jcmbx_Funcionario_BarraLateral.getSelectedIndex()) {
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
        switch (Jcmbx_Equipe_BarraLateral.getSelectedIndex()) {
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
        switch (Jcmbx_Equipe_BarraLateral.getSelectedIndex()) {
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
        switch (Jcmbx_Treinamento_BarraLateral.getSelectedIndex()) {
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
        switch (Jcmbx_Treinamento_BarraLateral.getSelectedIndex()) {
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

    private void Jtxtf_Sobrenome_CadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jtxtf_Sobrenome_CadFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jtxtf_Sobrenome_CadFuncActionPerformed

    private void Jbtn_Treinos_CadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Treinos_CadFuncActionPerformed
        PopUp_Treinamentos_Funcionario treinoFunc = new PopUp_Treinamentos_Funcionario();
        try {
            treinoFunc.populaTabela(id_funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Cadastro_Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        treinoFunc.setVisible(true);
        
    }//GEN-LAST:event_Jbtn_Treinos_CadFuncActionPerformed

    private void Jbtn_Salvar_CadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Salvar_CadFuncActionPerformed
        Connection connection = null;
        PreparedStatement statement = null;

        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        String cpfInserido = Jftxtf_CPF_CadFunc.getText();
        try {
            if(validadorCPF(cpfInserido)){
                if(procuraCPF("SELECT cpf FROM vw_funcionario WHERE cpf LIKE '"+cpfInserido+"';")){

                    connection = DriverManager.getConnection(url, user, psswrd);
                    String query = "INSERT INTO funcionario "
                        + "(CPF, nome_func, sobrenome, Telefone, "
                        + "email, turno, cargo, id_setor) "
                        + "values(?, ?, ?, ?, ?, ?, ?, ?)";
                    statement = connection.prepareStatement(query);

                    String turno = (String) Jcmbx_Turno_CadFunc.getSelectedItem();
                    String cargo = (String) Jcmbx_Cargo_CadFunc.getSelectedItem();

                    statement.setString(1, cpfInserido);
                    statement.setString(2, Jtxtf_Nome_CadFunc.getText());
                    statement.setString(3, Jtxtf_Sobrenome_CadFunc.getText());
                    statement.setString(4, Jftxtf_Telefone_CadFunc.getText());
                    statement.setString(5, Jtxtf_Email_CadFunc.getText());
                    statement.setString(6, turno);
                    statement.setString(7, cargo);

                    statement.setInt(8, this.pegaIdSetor("SELECT * FROM setor WHERE sigla = '" + Jcmbx_Setor_CadFunc.getSelectedItem() + "'"));

                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Funcinario Cadastrado!");
                } else {
                    JOptionPane.showMessageDialog(null, "CPF já Cadastrado");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "CPF Inválido");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchiodos corretamente!");
            System.out.println(erro);
            System.out.println("Erro: " + erro.getMessage());
        }
    }//GEN-LAST:event_Jbtn_Salvar_CadFuncActionPerformed
    
    // tela de inserir funcionario à equipe
    private void Jbtn_AddEquipe_cadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_AddEquipe_cadFuncActionPerformed
        Cadastro_Funcionario_Equipe Cad_FuncEqp = new Cadastro_Funcionario_Equipe();
        Cad_FuncEqp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_AddEquipe_cadFuncActionPerformed

    private void Jcmbx_Setor_CadFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcmbx_Setor_CadFuncMouseClicked
        
    }//GEN-LAST:event_Jcmbx_Setor_CadFuncMouseClicked

    private void Jcmbx_Setor_CadFuncMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jcmbx_Setor_CadFuncMouseEntered
        try {
            this.popCmBoxSetor("SELECT * FROM setor");
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Cadastro_Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jcmbx_Setor_CadFuncMouseEntered

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
        java.util.logging.Logger.getLogger(Tela_Cadastro_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Tela_Cadastro_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Tela_Cadastro_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Tela_Cadastro_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Tela_Cadastro_Funcionario().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_BarraLateral;
    private javax.swing.JPanel JPanel_contentEquipe_BarraLateral;
    private javax.swing.JPanel JPanel_contentFuncionarioButton;
    private javax.swing.JPanel JPanel_logo_Barra_Lateral;
    private javax.swing.JButton Jbtn_AddEquipe_cadFunc;
    private javax.swing.JButton Jbtn_Configuração_BarraLateral;
    private javax.swing.JButton Jbtn_Editar_CadFunc;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_Salvar_CadFunc;
    private javax.swing.JButton Jbtn_Treinos_CadFunc;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_trocarUsuario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Cargo_CadFunc;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Setor_CadFunc;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Turno_CadFunc;
    private javax.swing.JFormattedTextField Jftxtf_CPF_CadFunc;
    private javax.swing.JFormattedTextField Jftxtf_Telefone_CadFunc;
    private javax.swing.JLabel Jlbl_Area_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_CPF_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Cadastrar_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Cargo_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Codigo_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Contato_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Email_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_Nome_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Numero_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Sobrenome_Tela_Adicionar_Funcionario;
    private javax.swing.JLabel Jlbl_Title_identificacao;
    private javax.swing.JLabel Jlbl_Turno_Tela_Adicionar_Funcionario;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JPanel Jpnl_Area_Tela_Adicionar_Funcionario;
    private javax.swing.JPanel Jpnl_Container_CadFunc;
    private javax.swing.JPanel Jpnl_Contato_Tela_Adicionar_Funcionario;
    private javax.swing.JPanel Jpnl_Fundo_CadFunc;
    private javax.swing.JPanel Jpnl_Identificacao_Tela_Adicionar_Funcionario;
    private javax.swing.JTextField Jtxtf_Email_CadFunc;
    private javax.swing.JTextField Jtxtf_Nome_CadFunc;
    private javax.swing.JTextField Jtxtf_Sobrenome_CadFunc;
    // End of variables declaration//GEN-END:variables

}
