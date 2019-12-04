
package Visao;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class AtualizarContador extends Thread{
    @Override  
    public void run() {  
        try {  
            while (true) {
                TelaPrincipal.PreencheTotalPessoas();
                TelaPrincipal.PreencheTotalEventos();
                TelaPrincipal.PreencheTotalInscricoes();
                TelaPrincipal.PreencheTotalCredenciamentos();
                TelaPrincipal.CalculaPercentualCredenciamento();
                Thread.sleep(2500);
            }  
        } catch (InterruptedException ex) {  
            System.out.println("Problema na atualização da data/hora");  
            ex.printStackTrace();  
        }  
    }  
}

