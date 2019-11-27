package Visao;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VisaoController extends JFrame{
    
    private final JButton novo, salvar, cancelar, atualizar, excluir;
    
    public VisaoController(JButton novo, JButton salvar, JButton cancelar, JButton atualizar, JButton excluir) {
        this.novo = novo;
        this.salvar = salvar;
        this.cancelar = cancelar;
        this.atualizar = atualizar;
        this.excluir = excluir;
        
        this.init();
    }
        
    public void init() {
        this.setOnClick(this.novo, false);
        this.setOnClick(this.salvar, true);
        this.setOnClick(this.cancelar, true);
        this.setOnClick(this.atualizar, false);
        this.setOnClick(this.excluir, true);
        
        this.trocar(true);
    }
    
    public void setOnClick(JButton button, boolean state) {
        button.addActionListener((ActionEvent e) -> {
            this.trocar(state);
        });
    }
    
    public void trocar(boolean state) {
        this.novo.setEnabled(state);
        this.salvar.setEnabled(!state);
        this.cancelar.setEnabled(!state);
        this.atualizar.setEnabled(state);
        this.excluir.setEnabled(state);
    }
}
