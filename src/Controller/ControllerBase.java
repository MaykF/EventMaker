/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.ObjetoBase;
import Persistencia.PersistenciaJPA;
import java.util.List;
import org.json.simple.JSONObject;

/**
 *
 * @author Maycon
 */
public abstract class ControllerBase {
    
    protected ObjetoBase objetoControle;
    protected Class classeObjetoControle;
    
    public ControllerBase(){
    
        CriarObjetoControle();
        classeObjetoControle = objetoControle.getClass();
    }
    
    public abstract void CriarObjetoControle();
    
    
    public boolean Salvar(JSONObject jsonfile){
    
        objetoControle.toObjeto(jsonfile);
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        DAO.salvar(objetoControle);
        
        return true;
    }
    
    public JSONObject Recuperar(int codigo){
        
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        objetoControle = DAO.recuperar(codigo);
        
        if(objetoControle != null)                      // TRATAMENTO NECESSARIO PARA NAO APRESENTAR ERRO NO CODIGO
            return objetoControle.toJSONObject();
        else 
            return null;
    }
    
    public JSONObject RecuperarTodos(){
        
        List<ObjetoBase> dados;
        //String[][] Stringretorno = new String[50][50];
        JSONObject jsonretorno = new JSONObject();
        
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        dados = DAO.recuperarTodos();
        
        for(int i = 0; i < dados.size(); i++){
            //Stringretorno[i] = dados.get(i).toStringVetor();
            jsonretorno.put(i, dados.get(i).toJSONObject()); // i -> INDICE NUMERO DO REGISTRO RETORNO // objeto -> segundo parametro
            
        }

        return jsonretorno;
    }
    
    public boolean Excluir(int codigo){
        
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        
        try {
            DAO.remover(codigo);
            return true;
        } catch (Exception e) {
            return false;
        }
    
    }
}
