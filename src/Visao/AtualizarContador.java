
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
                Thread.sleep(2000);
            }  
        } catch (InterruptedException ex) {  
            System.out.println("Problema na atualização da data/hora");  
            ex.printStackTrace();  
        }  
    }  
}

