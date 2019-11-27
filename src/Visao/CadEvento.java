package Visao;

import Controller.ControllerEvento;
import Controller.ControllerUsuario;
import Modelo.Evento_;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CadEvento extends javax.swing.JFrame {

    private String UsuarioAtual;        // ARMAZENA O USUARIO QUE ACESSOU A TELA, NECESSÁRIO VALIDAR PARA VERIFICAR SE É ADMINISTRADOR
    private VisaoController visaoController = null;
    ControllerEvento evento = new ControllerEvento();
    boolean atualizando = false;

    public CadEvento(String usuarioAtual) {     // USUARIO QUE ABRIU A TELA
        initComponents();
        this.setLocationRelativeTo(null);     
        this.UsuarioAtual = usuarioAtual;
        ((JTextField) this.DataFim.getDateEditor().getUiComponent()).addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == ke.VK_ENTER) {
                    DataInicio.requestFocusInWindow();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }
        });
        Keypress_jDateChoooser();
        this.visaoController = new VisaoController(Novo, Salvar, Cancelar, Editar, Excluir);
        preencher();
        
        this.ConfereAdministrador(); // CONFERE SE O USUARIO ATUAL É ADMINISTRADOR E BLOQUEIA OS CAMPOS PARA NAO SEREM EDITADOS
    }

    private void Keypress_jDateChoooser() {
        HashSet<AWTKeyStroke> conjForward = new HashSet<AWTKeyStroke>(DataInicio.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conjForward.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        DataInicio.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conjForward);
        DataFim.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conjForward);
    }
    
    private void ConfereAdministrador(){
        if(!ControllerUsuario.ValidaAdm(UsuarioAtual)){ // SE NAO FOR ADMINISTRADOR NAO PODE ALTERAR NADA, BLOQUEIA TUDO
            NomeEvento.setEnabled(false);
            DataFim.setEnabled(false);
            DataInicio.setEnabled(false);
            Cap.setEnabled(false);
            Local.setEnabled(false);
            Desc.setEnabled(false);
            
            Novo.setEnabled(false);
            Salvar.setEnabled(false);
            Excluir.setEnabled(false);
            Cancelar.setEnabled(false);
            Editar.setEnabled(false);
            JOptionPane.showMessageDialog(null, UsuarioAtual);
        }
    
    }

    public void preencher() {
        JSONArray dados = evento.RecuperarTodos();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        while (jTable1.getModel().getRowCount() > 0) {
            modelo.removeRow(0);
        }
        System.out.println(dados.size());
        Iterator i = dados.iterator();

        while (i.hasNext()) {
            JSONObject jsonObj = (JSONObject) i.next();
            Object[] tableData = new Object[]{jsonObj.get("id"), jsonObj.get("nome").toString(), jsonObj.get("inicio"),
                jsonObj.get("termino"), jsonObj.get("capacidade"), jsonObj.get("local")};
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

    private void LimparTela() {
        Id.setText("");
        NomeEvento.setText("");
        Cap.setText("");
        Desc.setText("");
        Local.setText("");
        DataInicio.setDate(null);
        DataFim.setDate(null);
    }

    private void Editar(boolean edt) {
        NomeEvento.setEditable(edt);
        DataInicio.setEnabled(edt);
        DataFim.setEnabled(edt);
        Cap.setEditable(edt);
        Local.setEditable(edt);
        Desc.setEditable(edt);
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
            json.put("nome", NomeEvento.getText());
            json.put("inicio", ((JTextField) this.DataInicio.getDateEditor().getUiComponent()).getText());
            json.put("termino", ((JTextField) this.DataFim.getDateEditor().getUiComponent()).getText());
            json.put("capacidade", Cap.getText());
            json.put("local", Local.getText());
            json.put("descricao", Desc.getText());
            evento.Salvar(json);
        } else {
            JSONObject json = new JSONObject();
            json.put("id", 0);
            json.put("nome", NomeEvento.getText());
            json.put("inicio", ((JTextField) this.DataInicio.getDateEditor().getUiComponent()).getText());
            json.put("termino", ((JTextField) this.DataFim.getDateEditor().getUiComponent()).getText());
            json.put("capacidade", Cap.getText());
            json.put("local", Local.getText());
            json.put("descricao", Desc.getText());
            evento.Salvar(json);
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
        NomeEvento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        DataInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        DataFim = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        Cap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Local = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Novo = new javax.swing.JButton();
        Salvar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Desc = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nome do Evento");

        NomeEvento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomeEventoKeyPressed(evt);
            }
        });

        jLabel2.setText("Data Inicio");

        jLabel3.setText("Codigo");

        Id.setEditable(false);

        DataInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DataInicioKeyPressed(evt);
            }
        });

        jLabel4.setText("Data Fim");

        DataFim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DataFimKeyPressed(evt);
            }
        });

        jLabel5.setText("Capacidade");

        Cap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CapKeyPressed(evt);
            }
        });

        jLabel6.setText("Local");

        Local.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LocalKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Data Inicio", "Data Fim", "Capacidade", "Local"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
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

        jLabel7.setText("Descrição do Evento");

        Desc.setColumns(20);
        Desc.setRows(5);
        Desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DescKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(Desc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Novo)
                        .addGap(26, 26, 26)
                        .addComponent(Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(Cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(Excluir)
                        .addGap(18, 18, 18)
                        .addComponent(Editar))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(DataFim, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(Id))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Cap, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(NomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DataInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Local)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(DataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Novo)
                    .addComponent(Salvar)
                    .addComponent(Cancelar)
                    .addComponent(Excluir)
                    .addComponent(Editar))
                .addContainerGap())
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        NomeEvento.requestFocus();
        this.visaoController.trocar(true);
        Editar(false);
    }//GEN-LAST:event_formWindowOpened

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        this.visaoController.trocar(false);
        Editar(true);
    }//GEN-LAST:event_NovoActionPerformed

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
        NomeEvento.requestFocus();
        atualizando = true;
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        JSONObject dados = new JSONObject();
        dados = evento.Recuperar(Integer.parseInt(String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(), 0))));
        NomeEvento.setText(modelo.getValueAt(jTable1.getSelectedRow(), 1).toString());
        try {
            DataInicio.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(modelo.getValueAt(jTable1.getSelectedRow(), 2).toString()));
            DataFim.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(modelo.getValueAt(jTable1.getSelectedRow(), 3).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(CadEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cap.setText(modelo.getValueAt(jTable1.getSelectedRow(), 4).toString());
        Local.setText(modelo.getValueAt(jTable1.getSelectedRow(), 5).toString());
        Id.setText(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString());
        Desc.setText(dados.get("descricao").toString());
        Editar(true);
    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int codigo = Integer.parseInt(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString());
        try {
            evento.Excluir(codigo);
            modelo.removeRow(jTable1.getSelectedRow());
        } catch (RollbackException ex) {
            JOptionPane.showMessageDialog(this, "Evento selecionada não pode ser removida.");
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void NomeEventoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomeEventoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            DataInicio.requestFocusInWindow();
        }
    }//GEN-LAST:event_NomeEventoKeyPressed

    private void DataInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataInicioKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            DataFim.requestFocusInWindow();
        }
    }//GEN-LAST:event_DataInicioKeyPressed

    private void DataFimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataFimKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Cap.requestFocus();
        }
    }//GEN-LAST:event_DataFimKeyPressed

    private void CapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CapKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Local.requestFocus();
        }
    }//GEN-LAST:event_CapKeyPressed

    private void LocalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LocalKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Desc.requestFocus();
        }
    }//GEN-LAST:event_LocalKeyPressed

    private void SalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalvarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            this.Salvar();
        }
    }//GEN-LAST:event_SalvarKeyPressed

    private void DescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Salvar.requestFocus();
        }
    }//GEN-LAST:event_DescKeyPressed

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
            java.util.logging.Logger.getLogger(CadEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadEvento("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField Cap;
    private com.toedter.calendar.JDateChooser DataFim;
    private com.toedter.calendar.JDateChooser DataInicio;
    private javax.swing.JTextArea Desc;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Excluir;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField Local;
    private javax.swing.JTextField NomeEvento;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
