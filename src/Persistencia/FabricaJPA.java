/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
    private static Map <String, String> properties = new HashMap<String, String>();
    
    public FabricaJPA() {
        
        try {
            this.ImportaJSON();            
            Fabrica = Persistence.createEntityManagerFactory(nomeUndPerstencia,properties);
            
        } catch (ParseException ex) {
            Logger.getLogger(FabricaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static EntityManager getManager() {
        
        try {
            if (Fabrica == null) {
                FabricaJPA CONEXAOABERTA = new FabricaJPA();
                System.out.println("Fabrica JPA aberta!");
            }  
                      
            return Fabrica.createEntityManager(properties);
        } catch (Exception e) {
            System.err.println("Erro ao abrir conexão JPA ou criar gerenciador: " + e.getMessage());
            return null;
        }        
    }
    
    public static void FecharFabrica(){
        Fabrica.close();
    }
    
    public void ImportaJSON() throws org.json.simple.parser.ParseException{
    
        JSONObject jsonfile;
        JSONParser parser = new JSONParser();

        //Map<integer, string=""> mapaNomes = new HashMap<integer, string="">(); 
        
        try {
            
            jsonfile = (JSONObject) parser.parse(new FileReader("configbd.json"));
            JOptionPane.showMessageDialog(null, "jdbc:mysql://" + jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            properties.put("javax.persistence.jdbc.url", "jdbc:mysql://" + jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            JOptionPane.showMessageDialog(null,(String) jsonfile.get("usuariobd"));
            properties.put("javax.persistence.jdbc.user", (String) jsonfile.get("usuariobd"));
            JOptionPane.showMessageDialog(null,(String) jsonfile.get("senhabd"));
            properties.put("javax.persistence.jdbc.password", (String) jsonfile.get("senhabd"));
//
            JOptionPane.showMessageDialog(null,"com.mysql.jdbc.Driver");
            properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            JOptionPane.showMessageDialog(null,"org.hibernate.cache.NoCacheProvider");
            properties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            JOptionPane.showMessageDialog(null,"org.hibernate.dialect.MySQL5InnoDBDialect");
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            JOptionPane.showMessageDialog(null,"update");
            properties.put("hibernate.hbm2ddl.auto", "update");
            JOptionPane.showMessageDialog(null,"true");
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
//
            //jTextFieldResultadoConexao.setText((String) jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        
        
    }

    public Map getProperties() {
        return properties;
    }

    public void setProperties(Map properties) {
        FabricaJPA.properties = properties;
    }
    
    
}
