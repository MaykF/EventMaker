package Visao;

import Controller.ControllerInscricao;
import Controller.ControllerPessoa;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ConsultaInscricao extends javax.swing.JFrame {

    private String usuario; // usuario logado que abriu a tela
    
    /**
     * Creates new form ConsultaInscricao
     */
    public ConsultaInscricao(String usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        ((JTextField) this.DataInscricao.getDateEditor().getUiComponent()).addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {               
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent e) {               
            }
        });
        Keypress_jDateChoooser();
        DataInscricao.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInscricoes = new javax.swing.JTable();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldValorConsulta = new javax.swing.JTextField();
        jComboBoxCampoConsulta = new javax.swing.JComboBox<>();
        jButtonConsulta = new javax.swing.JButton();
        DataInscricao = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Consulta de Inscrições");

        jTableInscricoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Inscricao", "Data Inscricao", "Codigo Evento", "Codigo Pessoa", "Codigo Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableInscricoes);

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jComboBoxCampoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo pessoa", "Codigo evento", "Data de inscrição", "Nome do participante", "CPF participante", "Matricula participante" }));
        jComboBoxCampoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCampoConsultaActionPerformed(evt);
            }
        });
        jComboBoxCampoConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxCampoConsultaKeyPressed(evt);
            }
        });

        jButtonConsulta.setText("Buscar");
        jButtonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jButtonConfirmar)
                        .addGap(72, 72, 72)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxCampoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jTextFieldValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(DataInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonConsulta)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConsulta)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxCampoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DataInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addGap(44, 44, 44))
        );

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

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaActionPerformed
        this.buscarInscricoes();
    }//GEN-LAST:event_jButtonConsultaActionPerformed

    private void jComboBoxCampoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCampoConsultaActionPerformed
        if(jComboBoxCampoConsulta.getSelectedIndex() == 2){ // DATA
            jTextFieldValorConsulta.setText("");
            jTextFieldValorConsulta.setEditable(false);
            DataInscricao.setEnabled(true);
            
        }else{
            DataInscricao.setDate(null);
            jTextFieldValorConsulta.setEditable(true);
            DataInscricao.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxCampoConsultaActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableInscricoes.getModel();
        String Aux = String.valueOf(modelo.getValueAt(jTableInscricoes.getSelectedRow(),0));       // APÓS CONFIRMADO O BOTAO SELECIONA O REGISTRO E ABRE A TELA DE INSCRICAO
        TelaInscricao T = new TelaInscricao(this.usuario, Integer.valueOf(Aux));
        this.setVisible(false);
        T.setVisible(true);
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jComboBoxCampoConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxCampoConsultaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCampoConsultaKeyPressed

    private void Keypress_jDateChoooser() {
        HashSet<AWTKeyStroke> conjForward = new HashSet<AWTKeyStroke>(DataInscricao.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conjForward.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        DataInscricao.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conjForward);
    }
    
    private JSONArray TratamentoComparaData(){                      // A COMPARAÇÃO DE DATAS NAO FUNCIONOU NEM A PORRETE NO BANCO DEPOIS DE HORAS SO CONSEGUI FAZER A COMPARAÇÃO APOS RETORNA DO BANCO O VALOR
            ControllerInscricao I = new ControllerInscricao(); 
            int dia,mes,ano;
            JSONArray jsonarraytemp = new JSONArray();
            jsonarraytemp = I.RecuperarTodos();
            JSONObject jsonfile = new JSONObject();
            dia = DataInscricao.getDate().getDate();
            mes = DataInscricao.getDate().getMonth() +1;
            ano = DataInscricao.getDate().getYear() +1900;
            String aux = String.valueOf(ano + "-" + mes + "-" + dia);
                       
            for(int i =0; i < jsonarraytemp.size(); i++){
                jsonfile = (JSONObject) jsonarraytemp.get(i);
                
                if(!(aux.equals((jsonfile.get("data").toString())))){
                    //JOptionPane.showMessageDialog(null, jsonarraytemp.size() + aux + "  " + String.valueOf(jsonfile.get("data")));
                    jsonarraytemp.remove(i);
                }
            }       
    
        return jsonarraytemp;
    }
    
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
        JSONArray arrayRetorno = new JSONArray();
 
        String parametros[][] = new String[1][2];   // PRIMEIRO PARAMETRO NOME DA TABELA NO BANCO, SEGUNDO VALOR PARA CONSULTA
         
        
        if(jComboBoxCampoConsulta.getSelectedIndex() == 0){
            parametros[0][0] = "pessoa_id";
            parametros[0][1] = jTextFieldValorConsulta.getText();
        }else if(jComboBoxCampoConsulta.getSelectedIndex() == 1){
            parametros[0][0] = "evento_id";
            parametros[0][1] = jTextFieldValorConsulta.getText();
        }else if(jComboBoxCampoConsulta.getSelectedIndex() == 2){
            return TratamentoComparaData();
        }else if(jComboBoxCampoConsulta.getSelectedIndex() == 3){
            parametros[0][0] = "nome";
            parametros[0][1] = "'" + jTextFieldValorConsulta.getText() + "'";   // Consulta as pessoas baseado nos filtros informados
            codigosfiltro = P.RecuperarTodosCodigos(parametros);                // Obtem as pessoas com o filtro solicitado
            
            return this.aplicafiltroInscricao(codigosfiltro);
        }else if(jComboBoxCampoConsulta.getSelectedIndex() == 4){
            parametros[0][0] = "CPF";
            parametros[0][1] = "'" + jTextFieldValorConsulta.getText() + "'"; 
            codigosfiltro = P.RecuperarTodosCodigos(parametros);
            
            return this.aplicafiltroInscricao(codigosfiltro);
        }else if(jComboBoxCampoConsulta.getSelectedIndex() == 5){
            parametros[0][0] = "numMatricula";
            parametros[0][1] = "'" + jTextFieldValorConsulta.getText() + "'"; 
            codigosfiltro = P.RecuperarTodosCodigos(parametros);
            
            return this.aplicafiltroInscricao(codigosfiltro);
        }
    
        return I.RecuperarTodos(parametros);
    }
    
    private void buscarInscricoes(){
                       
        JSONArray dados = this.parametrosdeconsulta();    // CHAMA A FUNÇÃO PARA VERIFICAR OS PARAMETROS ESCOLHIDOS
        
        //JOptionPane.showMessageDialog(null, dados);
        DefaultTableModel modelo = (DefaultTableModel) jTableInscricoes.getModel();
        while (jTableInscricoes.getModel().getRowCount() > 0) {             // REMOVE POSSIVEIS ITENS NA TABELA
            modelo.removeRow(0);
        }
        //System.out.println(dados.size());
        
        if(dados != null){
            Iterator i = dados.iterator();

            while (i.hasNext()) {
                JSONObject jsonObj = (JSONObject) i.next();
                Object[] tableData = new Object[]{jsonObj.get("id"), jsonObj.get("data").toString(), jsonObj.get("codevento"),
                    jsonObj.get("codpessoa"), jsonObj.get("codusuario")};
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
            java.util.logging.Logger.getLogger(ConsultaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaInscricao("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DataInscricao;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JComboBox<String> jComboBoxCampoConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInscricoes;
    private javax.swing.JTextField jTextFieldValorConsulta;
    // End of variables declaration//GEN-END:variables
}
