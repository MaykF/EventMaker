package Controller;

import Modelo.Usuario;
import Persistencia.FuncoesJPA;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControllerUsuario extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        objetoControle = new Usuario();
    }
    public static String CriptografarSenha(String senha){
        
        String senhaCript = "";
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            try {
                byte message[] = md.digest(senha.getBytes("UTF-8"));
                
                StringBuilder sb = new StringBuilder();
                
                for(byte b : message){
                    sb.append(String.format("%02X", 0xFF & b));

                }
                senhaCript = sb.toString();
                
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        //JOptionPane.showMessageDialog(null, senhaCript);

        return senhaCript;
        
    }
    
    public static boolean EfetuarLogin(String login, String senha){  // A FUNCAO DE LOGIN PRECISOU SER DEFINIDA ESPECIFICAMENTE
               
        String[][] parametros = new String[2][2];
        parametros[0][0] = "login";
        parametros[0][1] = "'" + login + "'";
        parametros[1][0] = "senha";
        parametros[1][1] = "'" + CriptografarSenha(senha) + "'"; // Criptografa a senha para fazer login
        
        List Usuario = null;
        Usuario = FuncoesJPA.Selecionar(Usuario.class, parametros);
        return !Usuario.isEmpty();
    }
    
    public static boolean ValidaAdm(String login){
        
        String[][] parametros = new String[2][2];
        parametros[0][0] = "login";
        parametros[0][1] = "'" + login + "'";
        parametros[1][0] = "isadmin";
        parametros[1][1] = "'1'"; // Valida se o usuário é admin, 1 representa admin
        
        List Usuario = null;
        Usuario = FuncoesJPA.Selecionar(Usuario.class, parametros);
        
        return !Usuario.isEmpty();
    }
    
}
