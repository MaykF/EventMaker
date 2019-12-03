/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.ObjetoBase;
import Persistencia.PersistenciaJPA;
import Util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
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
    
    public JSONArray RecuperarTodos(){
        
        List<ObjetoBase> dados;
        //JSONObject jsonretorno = new JSONObject();
        JSONArray jsonAux = new JSONArray();
        
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        dados = DAO.recuperarTodos();
        
        for(int i = 0; i < dados.size(); i++){
            //Stringretorno[i] = dados.get(i).toStringVetor();
            jsonAux.add(dados.get(i).toJSONObject()); // i -> INDICE NUMERO DO REGISTRO RETORNO // objeto -> segundo parametro
        }
        return jsonAux;
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
    
    public int Count(){
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        return DAO.Count();       
    }
    
    public JSONArray RecuperarTodos(String[][] parametros){
        
        List<ObjetoBase> dados;
        //JSONObject jsonretorno = new JSONObject();
        JSONArray jsonAux = new JSONArray();
        
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        dados = DAO.recuperarTodos(parametros);
        
        for(int i = 0; i < dados.size(); i++){
            //Stringretorno[i] = dados.get(i).toStringVetor();
            jsonAux.add(dados.get(i).toJSONObject()); // i -> INDICE NUMERO DO REGISTRO RETORNO // objeto -> segundo parametro
        }
        return jsonAux;
    }
    
    public JSONArray RecuperarPorCodigos(String[][] parametrosCodigos){
        
        List<ObjetoBase> dados;
        //JSONObject jsonretorno = new JSONObject();
        JSONArray jsonAux = new JSONArray();
        
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        dados = DAO.recuperarPorCodigos(parametrosCodigos);
        
        for(int i = 0; i < dados.size(); i++){
            //Stringretorno[i] = dados.get(i).toStringVetor();
            jsonAux.add(dados.get(i).toJSONObject()); // i -> INDICE NUMERO DO REGISTRO RETORNO // objeto -> segundo parametro
        }
        return jsonAux;
    }
    
    public List<Integer> RecuperarTodosCodigos(String[][] parametros){      // FUNCAO RETORNA SOMENTE UM VETOR DE CODIGOS COM OS FILTROS APLICADOS
        
        List<Integer> dados;
        //Util.InicializaInt(codretorno);
        
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        dados = DAO.recuperarTodosCodigos(parametros);

        return dados;
    }
        
        
    public JSONArray RecuperarTodosEntre(int codIni, int codFim){
        
        List<ObjetoBase> dados;
        //JSONObject jsonretorno = new JSONObject();
        JSONArray jsonAux = new JSONArray();
        
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        dados = DAO.recuperarTodosEntre(codIni,codFim);
        
        for(int i = 0; i < dados.size(); i++){
            //Stringretorno[i] = dados.get(i).toStringVetor();
            jsonAux.add(dados.get(i).toJSONObject()); // i -> INDICE NUMERO DO REGISTRO RETORNO // objeto -> segundo parametro
        }
        return jsonAux;
    }
    
    
    public String[] select(){
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        ArrayList<ObjetoBase> dados = (ArrayList<ObjetoBase>) DAO.recuperarTodos();
        String[] retorno = new String[dados.size()];
        for(int i=0;i<dados.size();i++){
            retorno[i]=dados.get(i).toString();
        }
        return retorno;
    }
}
