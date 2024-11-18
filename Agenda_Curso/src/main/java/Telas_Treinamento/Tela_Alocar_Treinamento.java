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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author m.schmidt
 */
public class Tela_Alocar_Treinamento extends javax.swing.JFrame {

    private final String tipoUsuario;

    /**
     * Creates new form Tela_Alocar_Treinamento
     */
    public Tela_Alocar_Treinamento(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        initComponents();
    }
    
    private void popTabela(String query) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        Connection connection = (Connection) DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
        
        try {
            ResultSet resultSet = statement.executeQuery(query);
            
            DefaultTableModel model = (DefaultTableModel) Jtbl_Treinamento.getModel();
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
    
    private void popTableEqp(String query) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";

        Connection connection = DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = connection.prepareStatement(query);

        try {
            statement.execute();
            ResultSet resultSet = statement.executeQuery(query);
            
            DefaultTableModel model = (DefaultTableModel) Jtbl_Equipe_AlocaTreino.getModel();
            model.setNumRows(0);
            
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getString("id_equipe"),
                    resultSet.getString("nome_eqp"),
                    resultSet.getString("turno")
                });
            }
            
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    private void popTableInst(String query) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";

        Connection connection = DriverManager.getConnection(url, user, psswrd);
        PreparedStatement statement = connection.prepareStatement(query);

        try {
            statement.execute();
            ResultSet resultSet = statement.executeQuery(query);

            DefaultTableModel model = (DefaultTableModel) Jtbl_instrutor.getModel();
            model.setNumRows(0);
            
            while (resultSet.next()) {
                model.addRow(new Object[]{
                    resultSet.getString("id_funcionario"),
                    resultSet.getString("nome_completo"),
                });
            }
            
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }
    
    private boolean VerificaCadastro(int id_equipeSelec, int id_treino){
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        boolean isValid = true;
        
        try {
            connection = DriverManager.getConnection(url, user, psswrd);
            String query_GetIdEquipeByCadEqpTreino = "SELECT * FROM vw_CadEqpTreino WHERE id_treinamento = "+id_treino;
            statement = connection.prepareStatement(query_GetIdEquipeByCadEqpTreino);
            statement.execute();
            
            ResultSet resultSet = statement.executeQuery();
            int id_equipeEncontrada;
            
            while(resultSet.next()){
                id_equipeEncontrada = resultSet.getInt("id_equipe");
                if(id_equipeEncontrada == id_equipeSelec){
                    isValid = false;
                    break;
                }
            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
        
        return isValid;
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
        Jlbl_Selecionar_Tela_Alocar_Treinamento = new javax.swing.JLabel();
        Jpnl_Intrutor_Tela_Alocar_Treinamento = new javax.swing.JPanel();
        Jlbl_Equipe_Alocar_Treinamento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtbl_instrutor = new javax.swing.JTable();
        Jtxtf_Consulta_SearchFunc = new javax.swing.JTextField();
        Jbtn_ConsultaInst_AlocaTreino = new javax.swing.JButton();
        Jpnl_Identificacao_Tela_Alocar_Treinamento = new javax.swing.JPanel();
        Jlbl_Identificacao_Tela_Alocar_Treinamento = new javax.swing.JLabel();
        Jlbl_Data_Inicio_CadTreino = new javax.swing.JLabel();
        Jftxtf_prevInicion_CadTreino = new javax.swing.JFormattedTextField();
        Jlbl_Previsao_CadTreino = new javax.swing.JLabel();
        Jftxtf_prevFim_CadTreino = new javax.swing.JFormattedTextField();
        Jlbl_Formato_CadTreino = new javax.swing.JLabel();
        Jcmbx_Formato_CadTreino = new javax.swing.JComboBox<>();
        Jlbl_Status_CadTreino = new javax.swing.JLabel();
        Jcmbx_Status_CadTreino = new javax.swing.JComboBox<>();
        Jslpn_Equipe_Tela_Alocar_Treinamento = new javax.swing.JScrollPane();
        Jtbl_Treinamento = new javax.swing.JTable();
        Jpnl_Equipe_Tela_Alocar_Treinamento1 = new javax.swing.JPanel();
        Jlbl_Equipe_Alocar_Treinamento1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtbl_Equipe_AlocaTreino = new javax.swing.JTable();
        Jtxtf_ConsultaEqp_AlocaTreino = new javax.swing.JTextField();
        Jbtn_ConsultaEqp_AlocaTreino = new javax.swing.JButton();
        Jckbx_Certificado_CadTreino = new javax.swing.JCheckBox();
        Jckbx_Obrigatorio_CadTreino_ = new javax.swing.JCheckBox();
        Jbtn_Salvar_CadTreino = new javax.swing.JButton();
        Jbtn_Cancelar_CadTreino = new javax.swing.JButton();
        Jtxtf_consulta_SearchTreino = new javax.swing.JTextField();
        Jbtn_ConsultaTreino_AlocaTreino = new javax.swing.JButton();
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
        Jlbl_TipoUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(243, 236, 196));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 832));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 797));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Selecionar_Tela_Alocar_Treinamento.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Jlbl_Selecionar_Tela_Alocar_Treinamento.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Selecionar_Tela_Alocar_Treinamento.setText("Alocar Treinamento");
        Jlbl_Selecionar_Tela_Alocar_Treinamento.setPreferredSize(new java.awt.Dimension(351, 49));
        jPanel2.add(Jlbl_Selecionar_Tela_Alocar_Treinamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 320, -1));

        Jpnl_Intrutor_Tela_Alocar_Treinamento.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Intrutor_Tela_Alocar_Treinamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Intrutor_Tela_Alocar_Treinamento.setPreferredSize(new java.awt.Dimension(275, 73));
        Jpnl_Intrutor_Tela_Alocar_Treinamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Equipe_Alocar_Treinamento.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Equipe_Alocar_Treinamento.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Equipe_Alocar_Treinamento.setText("Intrutor:");
        Jpnl_Intrutor_Tela_Alocar_Treinamento.add(Jlbl_Equipe_Alocar_Treinamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1, -1, -1));

        Jtbl_instrutor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtbl_instrutor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Jtbl_instrutor);

        Jpnl_Intrutor_Tela_Alocar_Treinamento.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 350, 70));

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
        Jpnl_Intrutor_Tela_Alocar_Treinamento.add(Jtxtf_Consulta_SearchFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 240, -1));

        Jbtn_ConsultaInst_AlocaTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_ConsultaInst_AlocaTreino.setText("Consultar");
        Jbtn_ConsultaInst_AlocaTreino.setMaximumSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaInst_AlocaTreino.setMinimumSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaInst_AlocaTreino.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaInst_AlocaTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_ConsultaInst_AlocaTreinoActionPerformed(evt);
            }
        });
        Jpnl_Intrutor_Tela_Alocar_Treinamento.add(Jbtn_ConsultaInst_AlocaTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jPanel2.add(Jpnl_Intrutor_Tela_Alocar_Treinamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 380, 160));

        Jpnl_Identificacao_Tela_Alocar_Treinamento.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Identificacao_Tela_Alocar_Treinamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Identificacao_Tela_Alocar_Treinamento.setPreferredSize(new java.awt.Dimension(780, 171));
        Jpnl_Identificacao_Tela_Alocar_Treinamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Identificacao_Tela_Alocar_Treinamento.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Identificacao_Tela_Alocar_Treinamento.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Identificacao_Tela_Alocar_Treinamento.setText("Opercação");
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jlbl_Identificacao_Tela_Alocar_Treinamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        Jlbl_Data_Inicio_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Data_Inicio_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Data_Inicio_CadTreino.setText("Data de Inicio: ");
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jlbl_Data_Inicio_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        Jftxtf_prevInicion_CadTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jftxtf_prevInicion_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        try {
            Jftxtf_prevInicion_CadTreino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Jftxtf_prevInicion_CadTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jftxtf_prevInicion_CadTreino.setMaximumSize(new java.awt.Dimension(248, 30));
        Jftxtf_prevInicion_CadTreino.setMinimumSize(new java.awt.Dimension(248, 30));
        Jftxtf_prevInicion_CadTreino.setPreferredSize(new java.awt.Dimension(248, 30));
        Jftxtf_prevInicion_CadTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jftxtf_prevInicion_CadTreinoActionPerformed(evt);
            }
        });
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jftxtf_prevInicion_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        Jlbl_Previsao_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Previsao_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Previsao_CadTreino.setText("Previsão de Temino:");
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jlbl_Previsao_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        Jftxtf_prevFim_CadTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jftxtf_prevFim_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        try {
            Jftxtf_prevFim_CadTreino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Jftxtf_prevFim_CadTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jftxtf_prevFim_CadTreino.setMaximumSize(new java.awt.Dimension(248, 30));
        Jftxtf_prevFim_CadTreino.setMinimumSize(new java.awt.Dimension(248, 30));
        Jftxtf_prevFim_CadTreino.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jftxtf_prevFim_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        Jlbl_Formato_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Formato_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Formato_CadTreino.setText("Formato: ");
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jlbl_Formato_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        Jcmbx_Formato_CadTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jcmbx_Formato_CadTreino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hibrido", "Presencial", "Online" }));
        Jcmbx_Formato_CadTreino.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jcmbx_Formato_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        Jlbl_Status_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Status_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Status_CadTreino.setText("Status: ");
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jlbl_Status_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        Jcmbx_Status_CadTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jcmbx_Status_CadTreino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Jcmbx_Status_CadTreino.setPreferredSize(new java.awt.Dimension(248, 30));
        Jpnl_Identificacao_Tela_Alocar_Treinamento.add(Jcmbx_Status_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        jPanel2.add(Jpnl_Identificacao_Tela_Alocar_Treinamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, 180));

        Jtbl_Treinamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Jslpn_Equipe_Tela_Alocar_Treinamento.setViewportView(Jtbl_Treinamento);

        jPanel2.add(Jslpn_Equipe_Tela_Alocar_Treinamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, 780, 120));

        Jpnl_Equipe_Tela_Alocar_Treinamento1.setBackground(new java.awt.Color(243, 236, 196));
        Jpnl_Equipe_Tela_Alocar_Treinamento1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Jpnl_Equipe_Tela_Alocar_Treinamento1.setPreferredSize(new java.awt.Dimension(275, 73));
        Jpnl_Equipe_Tela_Alocar_Treinamento1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlbl_Equipe_Alocar_Treinamento1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jlbl_Equipe_Alocar_Treinamento1.setForeground(new java.awt.Color(0, 0, 0));
        Jlbl_Equipe_Alocar_Treinamento1.setText("Equipe:");
        Jpnl_Equipe_Tela_Alocar_Treinamento1.add(Jlbl_Equipe_Alocar_Treinamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1, -1, -1));

        Jtbl_Equipe_AlocaTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtbl_Equipe_AlocaTreino.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Jtbl_Equipe_AlocaTreino);

        Jpnl_Equipe_Tela_Alocar_Treinamento1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 350, 70));

        Jtxtf_ConsultaEqp_AlocaTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_ConsultaEqp_AlocaTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxtf_ConsultaEqp_AlocaTreino.setToolTipText("");
        Jtxtf_ConsultaEqp_AlocaTreino.setMaximumSize(new java.awt.Dimension(90, 30));
        Jtxtf_ConsultaEqp_AlocaTreino.setMinimumSize(new java.awt.Dimension(90, 30));
        Jtxtf_ConsultaEqp_AlocaTreino.setPreferredSize(new java.awt.Dimension(90, 30));
        Jtxtf_ConsultaEqp_AlocaTreino.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Jtxtf_ConsultaEqp_AlocaTreinoCaretUpdate(evt);
            }
        });
        Jtxtf_ConsultaEqp_AlocaTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jtxtf_ConsultaEqp_AlocaTreinoActionPerformed(evt);
            }
        });
        Jpnl_Equipe_Tela_Alocar_Treinamento1.add(Jtxtf_ConsultaEqp_AlocaTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 240, -1));

        Jbtn_ConsultaEqp_AlocaTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_ConsultaEqp_AlocaTreino.setText("Consultar");
        Jbtn_ConsultaEqp_AlocaTreino.setMaximumSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaEqp_AlocaTreino.setMinimumSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaEqp_AlocaTreino.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaEqp_AlocaTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_ConsultaEqp_AlocaTreinoActionPerformed(evt);
            }
        });
        Jpnl_Equipe_Tela_Alocar_Treinamento1.add(Jbtn_ConsultaEqp_AlocaTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jPanel2.add(Jpnl_Equipe_Tela_Alocar_Treinamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 380, 160));

        Jckbx_Certificado_CadTreino.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jckbx_Certificado_CadTreino.setForeground(new java.awt.Color(0, 0, 0));
        Jckbx_Certificado_CadTreino.setText("Certificado");
        jPanel2.add(Jckbx_Certificado_CadTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, -1, -1));

        Jckbx_Obrigatorio_CadTreino_.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Jckbx_Obrigatorio_CadTreino_.setForeground(new java.awt.Color(0, 0, 0));
        Jckbx_Obrigatorio_CadTreino_.setText("Obrigatorio");
        Jckbx_Obrigatorio_CadTreino_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jckbx_Obrigatorio_CadTreino_ActionPerformed(evt);
            }
        });
        jPanel2.add(Jckbx_Obrigatorio_CadTreino_, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, -1, -1));

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

        Jtxtf_consulta_SearchTreino.setBackground(new java.awt.Color(255, 255, 255));
        Jtxtf_consulta_SearchTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jtxtf_consulta_SearchTreino.setMaximumSize(new java.awt.Dimension(90, 30));
        Jtxtf_consulta_SearchTreino.setMinimumSize(new java.awt.Dimension(90, 30));
        Jtxtf_consulta_SearchTreino.setPreferredSize(new java.awt.Dimension(90, 30));
        jPanel2.add(Jtxtf_consulta_SearchTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 660, -1));

        Jbtn_ConsultaTreino_AlocaTreino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Jbtn_ConsultaTreino_AlocaTreino.setText("Consultar");
        Jbtn_ConsultaTreino_AlocaTreino.setMaximumSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaTreino_AlocaTreino.setMinimumSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaTreino_AlocaTreino.setPreferredSize(new java.awt.Dimension(100, 30));
        Jbtn_ConsultaTreino_AlocaTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_ConsultaTreino_AlocaTreinoActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtn_ConsultaTreino_AlocaTreino, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 540, -1, -1));

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
                                .addGap(210, 210, 210)
                                .addComponent(JPanel_logo_Barra_Lateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Jbtn_LogoutButton_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Jlbl_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addContainerGap()
                        .addComponent(Jbtn_LogoutButton_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanel_BarraLateralLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Jlbl_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(JPanel_logo_Barra_Lateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(JPanel_contentFuncionarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JPanel_contentEquipe_BarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Jpanel_contentTreinamento_Barra_Lateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Jckbx_Obrigatorio_CadTreino_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jckbx_Obrigatorio_CadTreino_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jckbx_Obrigatorio_CadTreino_ActionPerformed

    private void Jbtn_Salvar_CadTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Salvar_CadTreinoActionPerformed
        String url = "jdbc:mysql://localhost:3306/db_agenda_curso";
        String user = "root";
        String psswrd = "";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        int TreinoLine = Jtbl_Equipe_AlocaTreino.getSelectedRow();
        int id_equipeSelec = Integer.parseInt(Jtbl_Equipe_AlocaTreino.getValueAt(TreinoLine, 0).toString());
        
        int instLine = Jtbl_instrutor.getSelectedRow();
        int instId = Integer.parseInt(Jtbl_instrutor.getValueAt(instLine, 0).toString());
        
        int linha_TreinoSelec = Jtbl_Treinamento.getSelectedRow();
        int id_treino = Integer.parseInt(Jtbl_Treinamento.getValueAt(linha_TreinoSelec, 0).toString());
        
        String strInitDate = Jftxtf_prevInicion_CadTreino.getText();
        String strFinalDate = Jftxtf_prevFim_CadTreino.getText();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
         
        Date Initdate = null;
        Date Finaldate = null;
        
        try {
            Initdate = format.parse(strInitDate);
            Finaldate = format.parse(strFinalDate);
        } catch (ParseException ex) {
            Logger.getLogger(Tela_Alocar_Treinamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (Finaldate.compareTo(Initdate) >= 0){
            try {
                connection = DriverManager.getConnection(url, user, psswrd);

                if(VerificaCadastro(id_equipeSelec, id_treino)){
                    String query = 
                        ("INSERT INTO cadastro_equipe_treinamento"
                        + "(id_equipe, id_treinamento, id_instrutor, prev_comeco, prev_fim, formato) "
                        + "VALUES(?,?,?,?,?,?)");
                    statement = connection.prepareStatement(query);

                    String formato = (String) Jcmbx_Formato_CadTreino.getSelectedItem();

                    statement.setInt(1, id_equipeSelec);
                    statement.setInt(2, id_treino);
                    statement.setInt(3, instId);
                    statement.setString(4, Jftxtf_prevInicion_CadTreino.getText());
                    statement.setString(5, Jftxtf_prevFim_CadTreino.getText());
                    statement.setString(6, formato);
                    statement.execute();
                    JOptionPane.showMessageDialog(null, "Cadastro realizado");
                    
                    connection.close();
                    statement.close();
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Equipe Já cadastrada ao treinamento");
                }
            }
            catch (SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Datas não válidas");
        }
    }//GEN-LAST:event_Jbtn_Salvar_CadTreinoActionPerformed

    private void Jbtn_Cancelar_CadTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_Cancelar_CadTreinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jbtn_Cancelar_CadTreinoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            this.popTabela("SELECT * FROM vw_treinamento");
            this.popTableEqp("SELECT * FROM vw_equipe");
            this.popTableInst("SELECT * FROM vw_funcionario WHERE cargo LIKE 'instrutor'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Alocar_Treinamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void Jbtn_ConsultaTreino_AlocaTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_ConsultaTreino_AlocaTreinoActionPerformed
        try {
            String nomeTreino = Jtxtf_consulta_SearchTreino.getText();
            this.popTabela("SELECT * FROM vw_treinamento "
                + "WHERE nome LIKE '%"+nomeTreino+"%'");
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }//GEN-LAST:event_Jbtn_ConsultaTreino_AlocaTreinoActionPerformed

    private void Jtxtf_Consulta_SearchFuncCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Jtxtf_Consulta_SearchFuncCaretUpdate
        // TODO add your handling code here: DELETAR METODO
    }//GEN-LAST:event_Jtxtf_Consulta_SearchFuncCaretUpdate

    private void Jtxtf_Consulta_SearchFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jtxtf_Consulta_SearchFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jtxtf_Consulta_SearchFuncActionPerformed

    private void Jbtn_ConsultaInst_AlocaTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_ConsultaInst_AlocaTreinoActionPerformed

        String nome = Jtxtf_Consulta_SearchFunc.getText();

        try {
            this.popTableInst("SELECT * FROM vw_funcionario WHERE nome_completo LIKE'%" + nome + "%'");
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Alocar_Treinamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Jbtn_ConsultaInst_AlocaTreinoActionPerformed

    private void Jtxtf_ConsultaEqp_AlocaTreinoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Jtxtf_ConsultaEqp_AlocaTreinoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Jtxtf_ConsultaEqp_AlocaTreinoCaretUpdate

    private void Jtxtf_ConsultaEqp_AlocaTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jtxtf_ConsultaEqp_AlocaTreinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jtxtf_ConsultaEqp_AlocaTreinoActionPerformed

    private void Jbtn_ConsultaEqp_AlocaTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_ConsultaEqp_AlocaTreinoActionPerformed
        String nome = Jtxtf_Consulta_SearchFunc.getText();

        try {
            this.popTableEqp("SELECT * FROM vw_equipe WHERE nome_eqp LIKE'%" + nome + "%'");
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Alocar_Treinamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Jbtn_ConsultaEqp_AlocaTreinoActionPerformed

    private void Jftxtf_prevInicion_CadTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jftxtf_prevInicion_CadTreinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jftxtf_prevInicion_CadTreinoActionPerformed

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
        } else if ("operador".equals(tipoUsuario) || "supervisor".equals(tipoUsuario) || "instrutor".equals(tipoUsuario)) {
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
        } else if ("operador".equals(tipoUsuario) || "intrutor".equals(tipoUsuario)) {
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
        Popup_Opcoes popup_opcoes = new Popup_Opcoes();
        popup_opcoes.setVisible(true);
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
        } else if ("operador".equals(tipoUsuario) || "supervisor".equals(tipoUsuario)) {
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
            java.util.logging.Logger.getLogger(Tela_Alocar_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Alocar_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Alocar_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Alocar_Treinamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String tipoUsuario;
            public void run() {
                this.tipoUsuario = tipoUsuario;
                new Tela_Alocar_Treinamento(tipoUsuario).setVisible(true);
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
    private javax.swing.JButton Jbtn_ConsultaEqp_AlocaTreino;
    private javax.swing.JButton Jbtn_ConsultaInst_AlocaTreino;
    private javax.swing.JButton Jbtn_ConsultaTreino_AlocaTreino;
    private javax.swing.JButton Jbtn_IconeFuncionario_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_LogoutButton_BarraLateral;
    private javax.swing.JButton Jbtn_Salvar_CadTreino;
    private javax.swing.JButton Jbtn_iconeEquipe_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_iconeTreinamento_BarraLateral_CadEqp;
    private javax.swing.JButton Jbtn_trocarUsuario_BarraLateral;
    private javax.swing.JCheckBox Jckbx_Certificado_CadTreino;
    private javax.swing.JCheckBox Jckbx_Obrigatorio_CadTreino_;
    private javax.swing.JComboBox<String> Jcmbx_Equipe_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Formato_CadTreino;
    private javax.swing.JComboBox<String> Jcmbx_Funcionario_BarraLateral;
    private javax.swing.JComboBox<String> Jcmbx_Status_CadTreino;
    private javax.swing.JComboBox<String> Jcmbx_Treinamento_BarraLateral;
    private javax.swing.JFormattedTextField Jftxtf_prevFim_CadTreino;
    private javax.swing.JFormattedTextField Jftxtf_prevInicion_CadTreino;
    private javax.swing.JLabel Jlbl_Data_Inicio_CadTreino;
    private javax.swing.JLabel Jlbl_Equipe_Alocar_Treinamento;
    private javax.swing.JLabel Jlbl_Equipe_Alocar_Treinamento1;
    private javax.swing.JLabel Jlbl_Formato_CadTreino;
    private javax.swing.JLabel Jlbl_Identificacao_Tela_Alocar_Treinamento;
    private javax.swing.JLabel Jlbl_Logo_BarraLateral_Eqp;
    private javax.swing.JLabel Jlbl_Previsao_CadTreino;
    private javax.swing.JLabel Jlbl_Selecionar_Tela_Alocar_Treinamento;
    private javax.swing.JLabel Jlbl_Status_CadTreino;
    private javax.swing.JLabel Jlbl_TipoUsuario;
    private javax.swing.JPanel Jpanel_contentTreinamento_Barra_Lateral;
    private javax.swing.JPanel Jpnl_Equipe_Tela_Alocar_Treinamento1;
    private javax.swing.JPanel Jpnl_Identificacao_Tela_Alocar_Treinamento;
    private javax.swing.JPanel Jpnl_Intrutor_Tela_Alocar_Treinamento;
    private javax.swing.JScrollPane Jslpn_Equipe_Tela_Alocar_Treinamento;
    private javax.swing.JTable Jtbl_Equipe_AlocaTreino;
    private javax.swing.JTable Jtbl_Treinamento;
    private javax.swing.JTable Jtbl_instrutor;
    private javax.swing.JTextField Jtxtf_ConsultaEqp_AlocaTreino;
    private javax.swing.JTextField Jtxtf_Consulta_SearchFunc;
    private javax.swing.JTextField Jtxtf_consulta_SearchTreino;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
