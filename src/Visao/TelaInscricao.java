/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controller.ControllerEvento;
import Controller.ControllerInscricao;
import Controller.ControllerPessoa;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.simple.JSONObject;

/**
 *
 * @author Maycon
 */
public class TelaInscricao extends javax.swing.JFrame {

    
    private VisaoController visaoController = null;
    boolean atualizando=false;
    
    /**
     * Creates new form TelaInscricao
     */
    public TelaInscricao(String usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.visaoController = new VisaoController(Novo, Salvar, Cancelar, Editar, Excluir);
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
        jTextFieldUsuarioInscricao.setText(usuario);
        jTextFieldUsuarioInscricao.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

        private void Keypress_jDateChoooser() {
        HashSet<AWTKeyStroke> conjForward = new HashSet<AWTKeyStroke>(DataInscricao.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conjForward.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        DataInscricao.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conjForward);
    }
    
    
    private void LimparTela(){
        jTextFieldCodInscricao.setText("");
        jTextFieldCodEvento.setText("");
        jTextFieldCodPessoa.setText("");
        jTextFieldNomeEvento.setText("");
        jTextFieldNomePessoa.setText("");
        jTextFieldUsuarioInscricao.setText("");

    }
    private void Editar(boolean edt){
        jTextFieldCodEvento.setEditable(edt);
        jTextFieldCodInscricao.setEditable(edt);
        jTextFieldCodPessoa.setEditable(edt);
        jTextFieldNomeEvento.setEditable(edt);
        jTextFieldNomePessoa.setEditable(edt);
        //jTextFieldUsuarioInscricao.setEditable(edt);

    }
    
    private void Salvar(){
    
        JSONObject json = new JSONObject();
        json.put("codpessoa", jTextFieldCodPessoa.getText());
        json.put("codevento", jTextFieldCodEvento.getText());
        json.put("usuario", jTextFieldUsuarioInscricao.getText());
        json.put("data", ((JTextField) this.DataInscricao.getDateEditor().getUiComponent()).getText());
        
        ControllerInscricao C = new ControllerInscricao();
        C.Salvar(json);
    
    }
    
    private void ConsultaInscricao(){
        ControllerInscricao I = new ControllerInscricao();
        ControllerPessoa P = new ControllerPessoa();
        JSONObject jsonInsc;
               
        jsonInsc = I.Recuperar(Integer.valueOf(jTextFieldCodInscricao.getText()));
        if(jsonInsc != null){
            jTextFieldCodPessoa.setText(String.valueOf(jsonInsc.get("codpessoa")));
            jTextFieldCodEvento.setText(String.valueOf(jsonInsc.get("codevento")));
            jTextFieldUsuarioInscricao.setText(String.valueOf(jsonInsc.get("usuario")));
            DataInscricao.setDate((Date) jsonInsc.get("data"));
        
            this.PreenchePessoa();
            this.PreencheEvento();
        }else
            JOptionPane.showMessageDialog(null, "Codigo nao encontrado");
    }
    
    private void PreenchePessoa(){
        ControllerPessoa P = new ControllerPessoa();
        JSONObject jsonPessoa;
        
        jsonPessoa = P.Recuperar(Integer.valueOf(jTextFieldCodPessoa.getText()));
        jTextFieldNomePessoa.setText((String) jsonPessoa.get("nome"));
    }
    
    private void PreencheEvento(){
        ControllerEvento E = new ControllerEvento();
        JSONObject jsonEvento;
        
        jsonEvento = E.Recuperar(Integer.valueOf(jTextFieldCodEvento.getText()));
        jTextFieldNomeEvento.setText((String) jsonEvento.get("descricao"));
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodInscricao = new javax.swing.JTextField();
        jButtonConsultaInscrição = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Novo = new javax.swing.JButton();
        Salvar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNomePessoa = new javax.swing.JTextField();
        jTextFieldCodPessoa = new javax.swing.JTextField();
        jButtonConsultaInscrito = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodEvento = new javax.swing.JTextField();
        jButtonConsultaEvento = new javax.swing.JButton();
        jTextFieldNomeEvento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldUsuarioInscricao = new javax.swing.JTextField();
        DataInscricao = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Inscrição de eventos");

        jTextFieldCodInscricao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldCodInscricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodInscricaoKeyPressed(evt);
            }
        });

        jButtonConsultaInscrição.setText("?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldCodInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConsultaInscrição)
                .addGap(223, 223, 223)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodInscricao)
                    .addComponent(jButtonConsultaInscrição)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Novo.setText("Novo");
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        jLabel2.setText("Pessoa");

        jTextFieldNomePessoa.setEditable(false);

        jTextFieldCodPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodPessoaKeyPressed(evt);
            }
        });

        jButtonConsultaInscrito.setText("?");

        jLabel3.setText("Evento");

        jTextFieldCodEvento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodEventoKeyPressed(evt);
            }
        });

        jButtonConsultaEvento.setText("?");

        jTextFieldNomeEvento.setEditable(false);

        jLabel4.setText("Data inscrição");

        jLabel5.setText("Usuario que realizou a inscrição");

        DataInscricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DataInscricaoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldCodEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCodPessoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonConsultaInscrito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonConsultaEvento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(Novo)
                        .addGap(77, 77, 77)
                        .addComponent(Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cancelar)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Excluir)
                        .addGap(85, 85, 85)
                        .addComponent(Editar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(360, 360, 360))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldUsuarioInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DataInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCodPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonConsultaInscrito))
                    .addComponent(DataInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultaEvento)
                    .addComponent(jTextFieldNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Novo)
                    .addComponent(Salvar)
                    .addComponent(Cancelar)
                    .addComponent(Excluir)
                    .addComponent(Editar))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        this.visaoController.trocar(false);
        Editar(true);        
    }//GEN-LAST:event_NovoActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        this.Salvar();
    }//GEN-LAST:event_SalvarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.visaoController.trocar(true);
        LimparTela();
        Editar(false);
    }//GEN-LAST:event_CancelarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        ControllerInscricao I = new ControllerInscricao();
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a inscrição " + jTextFieldCodInscricao.getText()) == 0){
            I.Excluir(Integer.valueOf(jTextFieldCodInscricao.getText()));
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        
    }//GEN-LAST:event_EditarActionPerformed

    private void DataInscricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataInscricaoKeyPressed

    }//GEN-LAST:event_DataInscricaoKeyPressed

    private void jTextFieldCodInscricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodInscricaoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.ConsultaInscricao();
        }
    }//GEN-LAST:event_jTextFieldCodInscricaoKeyPressed

    private void jTextFieldCodPessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodPessoaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.PreenchePessoa();
        }
    }//GEN-LAST:event_jTextFieldCodPessoaKeyPressed

    private void jTextFieldCodEventoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodEventoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.PreencheEvento();
        }
    }//GEN-LAST:event_jTextFieldCodEventoKeyPressed

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
            java.util.logging.Logger.getLogger(TelaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInscricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInscricao("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private com.toedter.calendar.JDateChooser DataInscricao;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Salvar;
    private javax.swing.JButton jButtonConsultaEvento;
    private javax.swing.JButton jButtonConsultaInscrito;
    private javax.swing.JButton jButtonConsultaInscrição;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCodEvento;
    private javax.swing.JTextField jTextFieldCodInscricao;
    private javax.swing.JTextField jTextFieldCodPessoa;
    private javax.swing.JTextField jTextFieldNomeEvento;
    private javax.swing.JTextField jTextFieldNomePessoa;
    private javax.swing.JTextField jTextFieldUsuarioInscricao;
    // End of variables declaration//GEN-END:variables
}
