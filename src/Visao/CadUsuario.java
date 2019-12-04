package Visao;

import Controller.ControllerUsuario;
import java.util.Arrays;
import java.util.Iterator;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CadUsuario extends javax.swing.JFrame {

    private String UsuarioAtual;        // ARMAZENA O USUARIO QUE ACESSOU A TELA, NECESSÁRIO VALIDAR PARA VERIFICAR SE É ADMINISTRADOR
    ControllerUsuario usuario = new ControllerUsuario();
    private VisaoController visaoController = null;
    boolean atualizando = false;

    public CadUsuario(String usuarioAtual) {
        initComponents();
        this.UsuarioAtual = usuarioAtual;
        this.visaoController = new VisaoController(Novo, Salvar, Cancelar, Editar, Excluir);
        this.setLocationRelativeTo(null);
        this.preencher();
        this.ConfereAdministrador();
    }
    
    private void ConfereAdministrador(){
        if(!ControllerUsuario.ValidaAdm(UsuarioAtual)){ // SE NAO FOR ADMINISTRADOR NAO PODE ALTERAR NADA, BLOQUEIA TUDO
            NomeUsu.setEnabled(false);
            Login.setEnabled(false);
            Senha.setEnabled(false);
            Adm.setEnabled(false);
            
            Novo.setEnabled(false);
            Salvar.setEnabled(false);
            Excluir.setEnabled(false);
            Cancelar.setEnabled(false);
            Editar.setEnabled(false);
        }
    
    }

    public void preencher() {
        JSONArray dados = usuario.RecuperarTodos();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        while (jTable1.getModel().getRowCount() > 0) {
            modelo.removeRow(0);
        }
        System.out.println(dados.size());
        Iterator i = dados.iterator();

        while (i.hasNext()) {
            JSONObject jsonObj = (JSONObject) i.next();
            Object[] tableData = new Object[]{jsonObj.get("id"), jsonObj.get("nome").toString(), jsonObj.get("isadmin")};
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
        NomeUsu.setText("");
        Login.setText("");
        Senha.setText("");
        Adm.setSelected(false);
    }
    
    private void Editar(boolean edt) {
        NomeUsu.setEditable(edt);
        Login.setEnabled(edt);
        Senha.setEnabled(edt);
        Adm.setEnabled(edt);
        if(!ControllerUsuario.ValidaAdm(UsuarioAtual)){     // SE NAO FOR ADMINISTRADOR BLOQUEARA OS BOTOES PARA NAO PERMITIR ALTERAR
            Novo.setEnabled(false);
            Salvar.setEnabled(false);
            Excluir.setEnabled(false);
            Cancelar.setEnabled(false);
            Editar.setEnabled(false);
        }
    }
    private void Salvar(){
        if (atualizando) {
            JSONObject json = new JSONObject();
            json.put("nome", NomeUsu.getText());
            json.put("login", Login.getText());
            json.put("senha", Senha.getText());  // Linha editada pois estava criptografando a senha 2x a criptografia ja é feita no usuario
            json.put("isadmin", Adm.isSelected());
            usuario.Salvar(json);
        } else {
            JSONObject json = new JSONObject();
            json.put("id", 0);
            json.put("nome", NomeUsu.getText());
            json.put("login", Login.getText());
            json.put("senha", Senha.getText());
            json.put("isadmin", Adm.isSelected());
            usuario.Salvar(json);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NomeUsu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Login = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Senha = new javax.swing.JPasswordField();
        Adm = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Novo = new javax.swing.JButton();
        Salvar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("codigo");

        Id.setEditable(false);

        jLabel2.setText("Nome");

        NomeUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomeUsuKeyPressed(evt);
            }
        });

        jLabel3.setText("Login");

        Login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginKeyPressed(evt);
            }
        });

        jLabel4.setText("Senha");

        Senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SenhaKeyPressed(evt);
            }
        });

        Adm.setText("Administrador");
        Adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdmKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Administrador"
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

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setText("Cadastro de Usuário");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Editar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(NomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)
                            .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Adm)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Adm))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Novo)
                    .addComponent(Salvar)
                    .addComponent(Cancelar)
                    .addComponent(Excluir)
                    .addComponent(Editar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
    this.visaoController.trocar(false);
        Editar(true);
    }//GEN-LAST:event_NovoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        NomeUsu.requestFocus();
        this.visaoController.trocar(true);
        Editar(false);
    }//GEN-LAST:event_formWindowOpened

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.visaoController.trocar(true);
        LimparTela();
        Editar(false);
    }//GEN-LAST:event_CancelarActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        this.Salvar();
    }//GEN-LAST:event_SalvarActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        this.visaoController.trocar(false);
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        JSONObject dados = new JSONObject();
        dados = usuario.Recuperar(Integer.parseInt(String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0))));
        atualizando=true;
        Id.setText(modelo.getValueAt(jTable1.getSelectedRow(),0).toString());
        NomeUsu.setText(modelo.getValueAt(jTable1.getSelectedRow(),1).toString());
        Adm.setSelected(Boolean.parseBoolean(String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),2))));
        Login.setText(dados.get("login").toString());
        Senha.setText(dados.get("senha").toString());
        Editar(true);
    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int codigo = Integer.parseInt(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString());
        try {
            usuario.Excluir(codigo);
            modelo.removeRow(jTable1.getSelectedRow());
        } catch (RollbackException ex) {
            JOptionPane.showMessageDialog(this,"Usuario selecionada não pode ser removida.");
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void NomeUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomeUsuKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Login.requestFocus();
        }
    }//GEN-LAST:event_NomeUsuKeyPressed

    private void LoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Senha.requestFocus();
        }
    }//GEN-LAST:event_LoginKeyPressed

    private void SenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SenhaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Adm.requestFocus();
        }
    }//GEN-LAST:event_SenhaKeyPressed

    private void AdmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdmKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Salvar.requestFocus();
        }
    }//GEN-LAST:event_AdmKeyPressed

    private void SalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalvarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Salvar.requestFocus();
        }
    }//GEN-LAST:event_SalvarKeyPressed

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
            java.util.logging.Logger.getLogger(CadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadUsuario("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Adm;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Excluir;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Login;
    private javax.swing.JTextField NomeUsu;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Salvar;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
