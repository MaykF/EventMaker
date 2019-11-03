/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker;

import Visao.TelaPrincipal;
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
        
        TelaPrincipal tela = new TelaPrincipal();
        tela.show();
        
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("eventmakerpu");
        EntityManager undPersist = FabricaJPA.getManager();
        
    }
    
}
