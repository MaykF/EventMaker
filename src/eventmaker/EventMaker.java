
package eventmaker;

import Controller.ControllerUsuario;
import Persistencia.FabricaJPA;
import Visao.TelaLogin;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.simple.JSONObject;

public class EventMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TelaLogin telalogin = new TelaLogin();
        telalogin.setVisible(true);
        
        
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("eventmakerpu");
        EntityManager undPersist = FabricaJPA.getManager();
                
        
        //RODAR PARA INSERIR USUARIO
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("nome", "Rodrigo");
        jsonfile.put("login", "dahora");
        jsonfile.put("senha", "1");
        jsonfile.put("isadmin", true);
        
        ControllerUsuario C = new ControllerUsuario();
        C.Salvar(jsonfile);
        
    }
    
}
