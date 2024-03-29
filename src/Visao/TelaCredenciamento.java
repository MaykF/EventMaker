/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controller.ControllerCredenciamento;
import Controller.ControllerEvento;
import Controller.ControllerInscricao;
import Controller.ControllerPessoa;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Maycon
 */
public class TelaCredenciamento extends javax.swing.JFrame {

    
    private JSONObject jsonRetorno;
    /**
     * Creates new form TelaCredenciamento
     */
    public TelaCredenciamento() {
        initComponents();
        this.setLocationRelativeTo(null);
        jTextFieldNome.setEditable(true);
        jFormattedTextFieldCPF.setEditable(true);
        jFormattedTextFieldRG.setEditable(true);
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
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jFormattedTextFieldRG = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInscricoes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Credenciamento");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Consulta credenciamentos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(421, 421, 421))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jLabel7))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeFocusLost(evt);
            }
        });
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
        });

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFormattedTextFieldCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldCPFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldCPFFocusLost(evt);
            }
        });
        jFormattedTextFieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCPFActionPerformed(evt);
            }
        });
        jFormattedTextFieldCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldCPFKeyPressed(evt);
            }
        });

        try {
            jFormattedTextFieldRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldRG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jFormattedTextFieldRG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldRGFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldRGFocusLost(evt);
            }
        });
        jFormattedTextFieldRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldRGActionPerformed(evt);
            }
        });
        jFormattedTextFieldRG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldRGKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("CPF");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("RG");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        jButtonPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonPesquisarKeyPressed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Selecione nome, CPF ou RG para realizar o credenciamento");

        jTableInscricoes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableInscricoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo inscrição", "Codigo evento", "Nome evento", "Codigo pessoa", "Nome pessoa"
            }
        ));
        jTableInscricoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableInscricoesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableInscricoes);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Verifique abaixo e Selecione o evento que esta inscrito e confirme o credenciamento");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel6)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jButtonConfirmar)
                .addGap(119, 119, 119)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonPesquisar)
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        this.RealizaCredenciamento();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTableInscricoesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableInscricoesKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //DefaultTableModel modelo = (DefaultTableModel) jTableInscricoes.getModel();
            this.RealizaCredenciamento();
        }
    }//GEN-LAST:event_jTableInscricoesKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonPesquisarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.buscarInscricoes();
            DefaultTableModel modelo = (DefaultTableModel) jTableInscricoes.getModel();
            jTableInscricoes.requestFocus();
        }
    }//GEN-LAST:event_jButtonPesquisarKeyPressed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        this.buscarInscricoes();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jFormattedTextFieldRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldRGActionPerformed
        jTextFieldNome.setEditable(false);
        jTextFieldNome.setText("");
        jFormattedTextFieldCPF.setEditable(false);
        jFormattedTextFieldCPF.setText("");
    }//GEN-LAST:event_jFormattedTextFieldRGActionPerformed

    private void jFormattedTextFieldRGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldRGFocusLost
        jTextFieldNome.setEditable(true);
        jFormattedTextFieldCPF.setEditable(true);
        jFormattedTextFieldRG.setEditable(true);
    }//GEN-LAST:event_jFormattedTextFieldRGFocusLost

    private void jFormattedTextFieldRGFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldRGFocusGained
        jTextFieldNome.setEditable(false);
        jTextFieldNome.setText("");
        jFormattedTextFieldCPF.setEditable(false);
        jFormattedTextFieldCPF.setText("");
    }//GEN-LAST:event_jFormattedTextFieldRGFocusGained

    private void jFormattedTextFieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFActionPerformed
        jTextFieldNome.setEditable(false);
        jTextFieldNome.setText("");
        jFormattedTextFieldRG.setEditable(false);
        jFormattedTextFieldRG.setText("");
    }//GEN-LAST:event_jFormattedTextFieldCPFActionPerformed

    private void jFormattedTextFieldCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFFocusLost
        jTextFieldNome.setEditable(true);
        jFormattedTextFieldCPF.setEditable(true);
        jFormattedTextFieldRG.setEditable(true);
    }//GEN-LAST:event_jFormattedTextFieldCPFFocusLost

    private void jFormattedTextFieldCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFFocusGained
        jTextFieldNome.setEditable(false);
        jTextFieldNome.setText("");
        jFormattedTextFieldRG.setEditable(false);
        jFormattedTextFieldRG.setText("");
    }//GEN-LAST:event_jFormattedTextFieldCPFFocusGained

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButtonPesquisar.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        jFormattedTextFieldCPF.setEditable(false);
        jFormattedTextFieldCPF.setText("");
        jFormattedTextFieldRG.setEditable(false);
        jFormattedTextFieldRG.setText("");
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeFocusLost
        jTextFieldNome.setEditable(true);
        jFormattedTextFieldCPF.setEditable(true);
        jFormattedTextFieldRG.setEditable(true);
    }//GEN-LAST:event_jTextFieldNomeFocusLost

    private void jTextFieldNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeFocusGained
        jFormattedTextFieldCPF.setEditable(false);
        jFormattedTextFieldCPF.setText("");
        jFormattedTextFieldRG.setEditable(false);
        jFormattedTextFieldRG.setText("");
    }//GEN-LAST:event_jTextFieldNomeFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsultaCredenciamento C = new ConsultaCredenciamento();
        C.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jFormattedTextFieldCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCPFKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButtonPesquisar.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextFieldCPFKeyPressed

    private void jFormattedTextFieldRGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldRGKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButtonPesquisar.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextFieldRGKeyPressed

    private JSONArray aplicafiltroInscricao(List<Integer> codigosfiltro){
    
        ControllerInscricao I = new ControllerInscricao();
        
        if(codigosfiltro.isEmpty()){
                JOptionPane.showMessageDialog(null, "Registro nao encontrado");
                return null;                                                        // Se nao retornou nada na consulta
            }
            
            String parametros2[][] = new String[codigosfiltro.size()][2];                              // Seta o parametro da coluna que sera consultada chave primaria de pessoas
            //JOptionPane.showMessageDialog(null, codigosfiltro.get(0));
            for(int i = 0; i< codigosfiltro.size(); i++){
                parametros2[i][0] = "pessoa_id";
                parametros2[i][1] = String.valueOf(codigosfiltro.get(i));
            }
        return I.RecuperarPorCodigos(parametros2);
    }
    
    private JSONArray parametrosdeconsulta(){  
        ControllerInscricao I = new ControllerInscricao();
        ControllerPessoa P = new ControllerPessoa();
        
        List<Integer> codigosfiltro;
 
        String parametros[][] = new String[1][2];   // PRIMEIRO PARAMETRO NOME DA TABELA NO BANCO, SEGUNDO VALOR PARA CONSULTA
         
        
        if(!jTextFieldNome.getText().equals("")){
            parametros[0][0] = "nome";
            parametros[0][1] = "'" + jTextFieldNome.getText() + "'"; 
            codigosfiltro = P.RecuperarTodosCodigos(parametros);
            
            if(codigosfiltro.size() > 0)
                jsonRetorno = P.Recuperar(codigosfiltro.get(0));
            return this.aplicafiltroInscricao(codigosfiltro);
      
        }else if(!jFormattedTextFieldCPF.getText().equals("   .   .   -  ")){
            parametros[0][0] = "CPF";
            parametros[0][1] = "'" + jFormattedTextFieldCPF.getText() + "'"; 
            codigosfiltro = P.RecuperarTodosCodigos(parametros);
            
            if(codigosfiltro.size() > 0)
                jsonRetorno = P.Recuperar(codigosfiltro.get(0));
            return this.aplicafiltroInscricao(codigosfiltro);
        }else if(!jFormattedTextFieldRG.getText().equals("  .   .   ")){
            parametros[0][0] = "RG";
            parametros[0][1] = "'" + jFormattedTextFieldRG.getText() + "'"; 
            codigosfiltro = P.RecuperarTodosCodigos(parametros);
            if(codigosfiltro.size() > 0)
                jsonRetorno = P.Recuperar(codigosfiltro.get(0));
            
            return this.aplicafiltroInscricao(codigosfiltro);
        }
    
        return I.RecuperarTodos(parametros);
    }
    
    private String buscaDescricaoEvento(int evento){
        ControllerEvento E = new ControllerEvento();
        
        return (String) E.Recuperar(evento).get("descricao");
    }
    
    private void LimpaTabela(){
        DefaultTableModel modelo = (DefaultTableModel) jTableInscricoes.getModel();
        while (jTableInscricoes.getModel().getRowCount() > 0) {             // REMOVE POSSIVEIS ITENS NA TABELA
            modelo.removeRow(0);
        }
    }
    
    private void buscarInscricoes(){
                       
        JSONArray dados = this.parametrosdeconsulta();    // CHAMA A FUNÇÃO PARA VERIFICAR OS PARAMETROS ESCOLHIDOS
        
        //JOptionPane.showMessageDialog(null, dados);
        DefaultTableModel modelo = (DefaultTableModel) jTableInscricoes.getModel();
        this.LimpaTabela();
        //System.out.println(dados.size());
        
        if(dados != null){
            Iterator i = dados.iterator();

            while (i.hasNext()) {
                JSONObject jsonObj = (JSONObject) i.next();
                
                Object[] tableData = new Object[]{jsonObj.get("id"), jsonObj.get("codevento").toString(), buscaDescricaoEvento((int) jsonObj.get("codevento")),
                    jsonObj.get("codpessoa"), jsonRetorno.get("nome")};
                System.out.println(Arrays.toString(tableData));
                if (!tableData[0].equals("-1")) {
                    modelo.addRow(tableData);
                }
            }
            jTableInscricoes.setModel(modelo);
            if (jTableInscricoes.getRowCount() > 0) {
                jTableInscricoes.setRowSelectionInterval(0, 0);
            }
        }
    
    }
    
    private void RealizaCredenciamento(){
        ControllerCredenciamento C = new ControllerCredenciamento();
        JSONObject jsonfile = new JSONObject();
        DefaultTableModel modelo = (DefaultTableModel) jTableInscricoes.getModel();
        String[][] parametros = new String[1][2];
        parametros[0][0] = "inscricao_id";
        parametros[0][1] = String.valueOf( modelo.getValueAt(jTableInscricoes.getSelectedRow(),0));
        
        if(!C.RecuperarTodos(parametros).isEmpty()){
            JOptionPane.showMessageDialog(null, "O credenciamento para esse evento ja foi realizado");
        }else{
        
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

            jsonfile.put("inscricao", String.valueOf( modelo.getValueAt(jTableInscricoes.getSelectedRow(),0)));
            jsonfile.put("pessoa", String.valueOf(modelo.getValueAt(jTableInscricoes.getSelectedRow(),3)));
            //JOptionPane.showMessageDialog(null, modelo.getValueAt(jTableInscricoes.getSelectedRow(),0));
            jsonfile.put("data", formatador.format(data));
            jsonfile.put("horaatual", new Date().getHours() + ":" + new Date().getMinutes());

            if(C.Salvar(jsonfile)){
                JOptionPane.showMessageDialog(null, "Credencimanento realizado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro ao realizar o credenciamento, verifique se as informações foram preenchidas corretamente");
            }
        }
        this.LimpaTabela();
        jTextFieldNome.requestFocus();
    }
    
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
            java.util.logging.Logger.getLogger(TelaCredenciamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCredenciamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCredenciamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCredenciamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCredenciamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldRG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInscricoes;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
