package Persistencia;

import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaJPA {

    private static EntityManagerFactory Fabrica = null;
    private static final String nomeUndPerstencia = "eventmakerpu";
    private static Map<String, String> propriedades;
    
    private FabricaJPA() {
        Fabrica = Persistence.createEntityManagerFactory(nomeUndPerstencia,propriedades);
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
