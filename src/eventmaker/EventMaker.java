/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker;

import Persistencia.FabricaJPA;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Maycon
 */
public class EventMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("EventMakerPU");
        EntityManager undPersist = FabricaJPA.getManager();
        
    }
    
}
