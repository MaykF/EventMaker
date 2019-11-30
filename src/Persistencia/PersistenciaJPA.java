/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.ObjetoBase;
import java.util.List;

/**
 *
 * @author Maycon
 */
public class PersistenciaJPA<T extends ObjetoBase> {    
    private final Class<T> classePersistente;
        
    public PersistenciaJPA(Class<T> persistedClass) {
       this.classePersistente = persistedClass;
    }    
    
    public void salvar(T obj) {
         if (obj.getId() > 0)
            FuncoesJPA.Fundir(obj);
        else
            FuncoesJPA.Persistir(obj);        
    }
    
    public void remover(int i){
        FuncoesJPA.Excluir(i, classePersistente);
    }
    
    public T recuperar(int id){
        //JOptionPane.showMessageDialog(null, classePersistente.toString());
        Object obj = FuncoesJPA.recuperar(id, classePersistente); 
        
        return (T)obj;
    }
    
    public List<T> recuperarTodos(){
        return (List<T>) FuncoesJPA.Selecionar(classePersistente);  
    }
    
    public int Count(){
        return FuncoesJPA.Count(classePersistente);
    }
}