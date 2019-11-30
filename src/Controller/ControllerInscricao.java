/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Inscricao;
import Modelo.ObjetoBase;
import Persistencia.FuncoesJPA;
import Persistencia.PersistenciaJPA;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author Maycon
 */
public class ControllerInscricao extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        
        objetoControle = new Inscricao();
    }
    
    public boolean SalvaInscricao(JSONObject jsonfile){
        
        objetoControle.toObjeto(jsonfile);
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        
        String[][] parametros = new String[2][2];                               // PARAMETRIZA EVENTO E PESSOA E VERIFICA SE JA EXISTE O CADASTRO
        parametros[0][0] = "evento_id";
        parametros[0][1] = "'" + jsonfile.get("codevento") + "'";
        parametros[1][0] = "pessoa_id";
        parametros[1][1] = "'" + jsonfile.get("codpessoa") + "'";
               
        List Inscricao = null;
        Inscricao = FuncoesJPA.Selecionar(classeObjetoControle, parametros);
        
        if(!Inscricao.isEmpty()){    // RETORNA FALSE SE JA TIVER CADASTRADO
            return false;
        }else{
            DAO.salvar(objetoControle);
            return true;
        }
    }
    
}
