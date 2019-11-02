/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Maycon
 */
public class FabricaJPA {

    private static EntityManagerFactory Fabrica = null;
    private static final String nomeUndPerstencia = "EventMakerPU";

    private FabricaJPA() {
        Fabrica = Persistence.createEntityManagerFactory(nomeUndPerstencia);
    }

    public static EntityManager getManager() {
        try {
            if (Fabrica == null) {
                FabricaJPA CONEXAOABERTA = new FabricaJPA();
                System.out.println("Fabrica JPA aberta!");
            }  
                      
            return Fabrica.createEntityManager();
        } catch (Exception e) {
            System.err.println("Erro ao abrir conexão JPA ou criar gerenciador: " + e.getMessage());
            return null;
        }        
    }
    
    public static void FecharFabrica(){
        Fabrica.close();
    }
}
