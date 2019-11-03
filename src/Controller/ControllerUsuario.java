/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Usuario;
import Persistencia.FuncoesJPA;
import java.util.List;

/**
 *
 * @author Maycon
 */
public class ControllerUsuario extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        objetoControle = new Usuario();
    }
    
    public static boolean EfetuarLogin(String login, String senha){  // A FUNCAO DE LOGIN PRECISOU SER DEFINIDA ESPECIFICAMENTE
               
        String[][] parametros = new String[2][2];
        parametros[0][0] = "login";
        parametros[0][1] = "'" + login + "'";
        parametros[1][0] = "senha";
        parametros[1][1] = "'" + Usuario.CriptografarSenha(senha) + "'"; // Criptografa a senha para fazer login
        
        List Usuario = null;
        Usuario = FuncoesJPA.Selecionar(Usuario.class, parametros);
        return !Usuario.isEmpty();
    }
    
}
