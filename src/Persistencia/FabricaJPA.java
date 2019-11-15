/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Maycon
 */
public class FabricaJPA {

    private static EntityManagerFactory Fabrica = null;
    private static final String nomeUndPerstencia = "eventmakerpu";
    private static Map properties;
    private FabricaJPA() {
        JOptionPane.showMessageDialog(null, "");
        try {
            properties = this.ImportaJSON();
            Fabrica = Persistence.createEntityManagerFactory(nomeUndPerstencia,properties);
        } catch (ParseException ex) {
            Logger.getLogger(FabricaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static EntityManager getManager() {
        JOptionPane.showMessageDialog(null, "");
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
    
    public Map ImportaJSON() throws org.json.simple.parser.ParseException{
    
        JSONObject jsonfile;
        JSONParser parser = new JSONParser();
    
        try {

            jsonfile = (JSONObject) parser.parse(new FileReader("configbd.json"));
            JOptionPane.showMessageDialog(null, jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            properties.put("javax.persistence.jdbc.url", jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            //jdbc:mysql://localhost:3306/eventmakerbd
            properties.put("javax.persistence.jdbc.user", jsonfile.get("usuariobd"));
            properties.put("javax.persistence.jdbc.password", jsonfile.get("senhabd"));
            properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            properties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            properties.put("hibernate.hbm2ddl.auto", "update");
            properties.put("hibernate.show_sql", true);
            //jTextFieldResultadoConexao.setText((String) jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return properties;
        
    }
}
