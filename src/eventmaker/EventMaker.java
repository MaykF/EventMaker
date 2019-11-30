
package eventmaker;

import Controller.ControllerUsuario;
import Persistencia.FabricaJPA;
import Util.ConfigBanco;
import Visao.TelaLogin;
import java.util.Arrays;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.simple.JSONObject;

public class EventMaker {
    public static void main(String[] args) {
        String[] arquivo = new String[3];
        arquivo = ConfigBanco.Ler();
        System.out.println(Arrays.toString(arquivo));
        HashMap<String,String> propriedades = new HashMap<String, String>();
        propriedades.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        propriedades.put("javax.persistence.jdbc.url", arquivo[0]);
        propriedades.put("javax.persistence.jdbc.user", arquivo[1]);
        propriedades.put("javax.persistence.jdbc.password", arquivo[2]);
        
        FabricaJPA.propriedades = propriedades;
        
        
        //EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("eventmakerpu");
        //EntityManager undPersist = FabricaJPA.getManager();
                
        
        //RODAR PARA INSERIR USUARIO
        /*
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("nome", "Maycon");
        jsonfile.put("login", "mayk");
        jsonfile.put("senha", "a");
        jsonfile.put("isadmin", true);
        ControllerUsuario C = new ControllerUsuario();
        C.Salvar(jsonfile);
        /*
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("nome", "Rodrigo");
        jsonfile.put("login", "dahora");
        jsonfile.put("senha", "1");
        jsonfile.put("isadmin", true);
        
        ControllerUsuario C = new ControllerUsuario();
        C.Salvar(jsonfile);*/
        
        TelaLogin telalogin = new TelaLogin();
        telalogin.setVisible(true);
        
    }
    
}
