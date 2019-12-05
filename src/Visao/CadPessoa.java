package Visao;

import Controller.ControllerPessoa;
import Util.Util;
import java.awt.Color;
import java.util.Arrays;
import java.util.Iterator;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CadPessoa extends javax.swing.JFrame {
    ControllerPessoa pessoa =  new ControllerPessoa();
    private VisaoController visaoController = null;
    boolean atualizando=false;
    
    public CadPessoa() {
        initComponents();
        this.visaoController = new VisaoController(Novo, Salvar, Cancelar, Editar, Excluir);
        this.setLocationRelativeTo(null);
        preencher();
    }
    public void preencher() {
        JSONArray dados = pessoa.RecuperarTodos();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        while (jTable1.getModel().getRowCount() > 0) {
            modelo.removeRow(0);
        }
        System.out.println(dados.size());
        Iterator i = dados.iterator();

        while (i.hasNext()) {
            JSONObject jsonObj = (JSONObject) i.next();
            Object[] tableData = new Object[]{jsonObj.get("nome"), jsonObj.get("id").toString(), jsonObj.get("CPF")};
            System.out.println(Arrays.toString(tableData));
            if (!tableData[0].equals("-1")) {
                modelo.addRow(tableData);
            }
        }
        jTable1.setModel(modelo);
        if (jTable1.getRowCount() > 0) {
            jTable1.setRowSelectionInterval(0, 0);
        }
    }
    
    
    private void LimparTela(){
        Id.setText("");
        Nome.setText("");
        CPF.setText("");
        RG.setText("");
        End.setText("");
        Cidade.setText("");
        Tel.setText("");
        Email.setText("");
        Matricula.setText("");
    }
    private void Editar(boolean edt){
        Nome.setEditable(edt);
        CPF.setEditable(edt);
        RG.setEditable(edt);
        End.setEditable(edt);
        Cidade.setEditable(edt);
        Tel.setEditable(edt);
        Email.setEditable(edt);
        Matricula.setEditable(edt);
    }
    private void Salvar(){
        String cpf = this.CPF.getText();
        if (!Util.validar(cpf)) {
            this.CPF.requestFocus();
            this.visaoController.trocar(false);
            JOptionPane.showMessageDialog(rootPane, "CPF inválido!");
            return;
        }else if(Nome.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Necessário informar o nome da pessoa");
            return;
        }
        if (atualizando) {
            JSONObject json =  new JSONObject();
            json.put("CPF", cpf);
            json.put("RG", RG.getText());
            json.put("cidade", Cidade.getText());
            json.put("email", Email.getText());
            json.put("endereco", End.getText());
            json.put("nome", Nome.getText());
            json.put("nummatricula", Matricula.getText());
            json.put("telefone", Tel.getText());
            pessoa.Salvar(json);
        }else{
            JSONObject json = new JSONObject();
            json.put("id", 0);
            json.put("CPF", CPF.getText());
            json.put("RG", RG.getText());
            json.put("cidade", Cidade.getText());
            json.put("email", Email.getText());
            json.put("endereco", End.getText());
            json.put("nome", Nome.getText());
            json.put("nummatricula", Matricula.getText());
            json.put("telefone", Tel.getText());
            pessoa.Salvar(json);
        }
        atualizando = false;
        LimparTela();
        Editar(false);
        this.visaoController.trocar(true);
        this.preencher();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        End = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Cidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Tel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Matricula = new javax.swing.JTextField();
        Novo = new javax.swing.JButton();
        Salvar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        CPF = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        RG = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Codigo");

        Id.setEditable(false);

        jLabel2.setText("Nome");

        Nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomeKeyPressed(evt);
            }
        });

        jLabel3.setText("CPF");

        jLabel4.setText("RG");

        jLabel5.setText("Endereço");

        End.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EndKeyPressed(evt);
            }
        });

        jLabel6.setText("Cidade");

        Cidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CidadeKeyPressed(evt);
            }
        });

        jLabel7.setText("Telefone");

        Tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TelKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelKeyTyped(evt);
            }
        });

        jLabel8.setText("E-mail");

        Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EmailKeyPressed(evt);
            }
        });

        jLabel9.setText("Matrícula");

        Matricula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Matricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MatriculaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MatriculaKeyTyped(evt);
            }
        });

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
        Salvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SalvarKeyPressed(evt);
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

        try {
            CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CPF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                CPFCaretUpdate(evt);
            }
        });
        CPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CPFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CPFKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Id", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        try {
            RG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        RG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RGKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setText("Cadastro de Pessoa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Novo)
                        .addGap(18, 18, 18)
                        .addComponent(Salvar)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(Excluir)
                        .addGap(18, 18, 18)
                        .addComponent(Editar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(End, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Matricula)
                            .addComponent(CPF, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Cidade))))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Novo)
                    .addComponent(Salvar)
                    .addComponent(Cancelar)
                    .addComponent(Excluir)
                    .addComponent(Editar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        this.Salvar();
    }//GEN-LAST:event_SalvarActionPerformed

    private void CPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_CPFKeyTyped

    private void NomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomeKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            CPF.requestFocus();
        }
    }//GEN-LAST:event_NomeKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Nome.requestFocus();
        this.visaoController.trocar(true);
        Editar(false);
    }//GEN-LAST:event_formWindowOpened

    private void CPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPFKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            RG.requestFocus();
        }
    }//GEN-LAST:event_CPFKeyPressed

    private void EndKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EndKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            Cidade.requestFocus();
        }
    }//GEN-LAST:event_EndKeyPressed

    private void CidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CidadeKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            Tel.requestFocus();
        }
    }//GEN-LAST:event_CidadeKeyPressed

    private void TelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            Email.requestFocus();
        }
    }//GEN-LAST:event_TelKeyPressed

    private void EmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            Matricula.requestFocus();
        }
    }//GEN-LAST:event_EmailKeyPressed

    private void MatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MatriculaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            Salvar.requestFocus();
        }
    }//GEN-LAST:event_MatriculaKeyPressed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        this.visaoController.trocar(false);
        Editar(true);
    }//GEN-LAST:event_NovoActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.visaoController.trocar(true);
        Editar(false);
        LimparTela();
    }//GEN-LAST:event_CancelarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        this.visaoController.trocar(false);
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        JSONObject dados = new JSONObject();
        dados = pessoa.Recuperar(Integer.parseInt(String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),1))));
        atualizando=true;
        Nome.setText(modelo.getValueAt(jTable1.getSelectedRow(),0).toString());
        CPF.setText(modelo.getValueAt(jTable1.getSelectedRow(),2).toString());
        Id.setText(modelo.getValueAt(jTable1.getSelectedRow(),1).toString());
        RG.setText(dados.get("RG").toString());
        End.setText(dados.get("endereco").toString());
        Cidade.setText(dados.get("cidade").toString());
        Tel.setText(dados.get("telefone").toString());
        Email.setText(dados.get("email").toString());
        Matricula.setText(dados.get("nummatricula").toString());
        Editar(true);
    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int codigo = Integer.parseInt(modelo.getValueAt(jTable1.getSelectedRow(), 1).toString());
        try {
            pessoa.Excluir(codigo);
            modelo.removeRow(jTable1.getSelectedRow());
        } catch (RollbackException ex) {
            JOptionPane.showMessageDialog(this,"Pessoa selecionada não pode ser removida.");
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void CPFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_CPFCaretUpdate
        String cpf = this.CPF.getText();
        this.CPF.setForeground(((Util.validar(cpf)) ? Color.GREEN : Color.RED));
    }//GEN-LAST:event_CPFCaretUpdate

    private void TelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_TelKeyTyped

    private void MatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MatriculaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_MatriculaKeyTyped

    private void RGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RGKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            End.requestFocus();
        }
    }//GEN-LAST:event_RGKeyPressed

    private void SalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalvarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            this.Salvar();
        }
    }//GEN-LAST:event_SalvarKeyPressed

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
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPessoa().setVisible(true);
            }
        });
    }
    
    public void focus() {
        this.Nome.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CPF;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField Cidade;
    private javax.swing.JButton Editar;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField End;
    private javax.swing.JButton Excluir;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Matricula;
    private javax.swing.JTextField Nome;
    private javax.swing.JButton Novo;
    private javax.swing.JFormattedTextField RG;
    private javax.swing.JButton Salvar;
    private javax.swing.JTextField Tel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
